package tw.lai.macgyver.shimen.crm.control;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.lai.macgyver.shimen.crm.entity.Customer;
import tw.lai.macgyver.tools.PowerVoDisplay;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@Controller
public class Login {

	@RequestMapping("/login.do")
	public ModelAndView checkLogin(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = null;
		Logger mylog = Logger.getLogger(this.getClass().getName());
		mylog.log(Level.INFO, "into lgonin.do....");
		
		User user = UserServiceFactory.getUserService().getCurrentUser();
		
		if (user != null) {
			mylog.info("Nick name = " + user.getNickname());
			mylog.info("UserId = " + user.getUserId());
			mylog.info("Email = " + user.getEmail());
		} else {
			result = new ModelAndView("main");
		}
		
		/* for data store testing
		Customer customer = new Customer();
		customer.setName("MacGyver");
		customer.setCellPhone("0939-873125");
		
		Objectify ofy = ObjectifyService.ofy();
		
		// async without the now()
		ofy.save().entity(customer).now();
		
		mylog.info("Customer Id = " + customer.getId());
		 */
		
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
}
