package tw.lai.macgyver.shimen.crm.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.lai.macgyver.shimen.crm.entity.Customer;
import tw.lai.macgyver.shimen.crm.entity.User;
import tw.lai.macgyver.shimen.crm.module.IUserDao;
import tw.lai.macgyver.tools.PowerVoDisplay;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@Controller
public class Login {

	public static final String tokenEndpointUrl = "https://www.googleapis.com/oauth2/v3/token";

	public static final String clientId = "750099995851-osh54a6sv38evrhvha4bvsluvgodc8t2.apps.googleusercontent.com";

	public static final String clientSecret = "W3oqzS8B_MCSHeRimwTFIYKb";

	public static final String redirectUri = "https://shimen-farmers-crm.appspot.com/aouth2callback.do";
	
	private IUserDao userDao = null;

	public IUserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping("/login.do")
	public ModelAndView checkLogin(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = null;
		Logger mylog = Logger.getLogger(this.getClass().getName());
		mylog.log(Level.INFO, "into lgonin.do....");

		com.google.appengine.api.users.User user = UserServiceFactory.getUserService().getCurrentUser();

		if (user != null) {
			mylog.info("Nick name = " + user.getNickname());
			mylog.info("UserId = " + user.getUserId());
			mylog.info("Email = " + user.getEmail());
		} else {
			result = new ModelAndView("main");
		}
		
		result = new ModelAndView("login");

		/*
		 * for data store testing Customer customer = new Customer();
		 * customer.setName("MacGyver"); customer.setCellPhone("0939-873125");
		 * 
		 * Objectify ofy = ObjectifyService.ofy();
		 * 
		 * // async without the now() ofy.save().entity(customer).now();
		 * 
		 * mylog.info("Customer Id = " + customer.getId());
		 */

		return result;
	}

	@RequestMapping("/aouth2callback.do")
	public ModelAndView aouthHandle(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = new ModelAndView("fail");
		Logger gLog = Logger.getLogger(this.getClass().getName());
		gLog.log(Level.INFO, "into aouthHandle.do....");

		String code = req.getParameter("code");
		gLog.info("Code = " + code);

		String state = req.getParameter("state");
		gLog.info("State = " + state);

		URL tonkenUrl = new URL(tokenEndpointUrl);
		HttpURLConnection connection = (HttpURLConnection) tonkenUrl.openConnection();

		// 設定此connection使用POST
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		
		OutputStreamWriter output  = new OutputStreamWriter(connection.getOutputStream());
		output.write("code=" + code);
		output.write("&client_id=" + clientId);
		output.write("&client_secret=" + clientSecret);
		output.write("&redirect_uri=" + redirectUri);
		output.write("&grant_type=authorization_code");
		output.flush();

		// 如果認證成功
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			StringBuilder sbLines = new StringBuilder("");

			// 取得Google回傳的資料(JSON格式)
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			String strLine = "";
			while ((strLine = reader.readLine()) != null) {
				sbLines.append(strLine);
			}
			
			gLog.info("sbLines = " + sbLines.toString());
			Map<String, String> tokenMap = new Gson().fromJson(sbLines.toString(), Map.class);
			
			String accessToken = tokenMap.get("access_token");
			String idToken = tokenMap.get("id_token");
			gLog.info("accessToken = " + accessToken);
			gLog.config("idToken = " + idToken);
			
			String[] idTokenArray = idToken.split("\\.");
			
			String idTokenPart01 = new String((byte[]) new Base64().decode(
					idTokenArray[0]), "UTF-8");
			String idTokenPart02 = new String((byte[]) new Base64().decode(
					idTokenArray[1]), "UTF-8");
			String idTokenPart03 = new String((byte[]) new Base64().decode(
					idTokenArray[2]), "UTF-8");
			gLog.config("idTokenPart01 = " + idTokenPart01);
			gLog.config("idTokenPart02 = " + idTokenPart02);
			gLog.config("idTokenPart03 = " + idTokenPart03);
			
			Map<String, String> idTokenMap = new Gson().fromJson(idTokenPart02, Map.class);
			
			// check id token
			String aud = idTokenMap.get("aud");
			String iss = idTokenMap.get("iss");
			Object exp = idTokenMap.get("exp");
			gLog.info("aud = " + aud);
			gLog.info("iss = " + iss);
			gLog.info("exp = " + exp);
			if (clientId.equals(aud) && iss != null && 
					iss.indexOf("accounts.google.com") > -1) {				
				String email = idTokenMap.get("email");
				gLog.info("Email = " + email);
				
				User loginUser = this.userDao.queryUserByEmail(email);
				if (loginUser != null) {
					gLog.fine("UserName = " + loginUser.getName());
					req.getSession().setAttribute("loginUser", loginUser);
					result = new ModelAndView("main");
				} else {
					result.addObject("alertMessage", "您的身份無權限使用");
				}
			} else {
				result.addObject("alertMessage", "認證資料有問題");
			}
		} else {
			gLog.info("ResponseCode = " + connection.getResponseCode());
		}

		return result;
	}

	@RequestMapping("/test.do")
	public ModelAndView testDo(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = null;
		Logger mylog = Logger.getLogger(this.getClass().getName());

		List<Customer> customerList = ObjectifyService.ofy().load().type(Customer.class)
				.order("company").list();
		mylog.info("Customer size = " + customerList.size());
		mylog.info(new PowerVoDisplay().diplayToString(customerList.toArray()));

		return result;
	}
	
	@RequestMapping("/addUser.do")
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("user") User user) throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		Objectify ofy = ObjectifyService.ofy();
		ofy.save().entity(user).now();
		
		gLog.info("User Id = " + user.getId());
		
		return result;
	}
	
	@RequestMapping("/showMain.do")
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse res)
			 throws Exception {
		Logger gLog = Logger.getLogger(this.getClass().getName());
		User loginUser = (User) ((HttpServletRequest) req)
				.getSession().getAttribute("loginUser");
		
		if (loginUser == null) {
			gLog.info("Forward to login page....");
			req.getRequestDispatcher("login.do").forward(req, res);
		}
		
		return new ModelAndView("main");
	}
}
