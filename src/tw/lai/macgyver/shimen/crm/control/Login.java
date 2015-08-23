package tw.lai.macgyver.shimen.crm.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.lai.macgyver.shimen.crm.entity.Customer;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@Controller
public class Login {

	@RequestMapping("/login.do")
	public ModelAndView checkLogin(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("into lgonin.do....");
		ModelAndView result = null;
		
		User user = UserServiceFactory.getUserService().getCurrentUser();
		
		if (user != null) {
			System.out.println("Nick name = " + user.getNickname());
			System.out.println("UserId = " + user.getUserId());
			System.out.println("Email = " + user.getEmail());
		} else {
			result = new ModelAndView("login");
		}
		
		Customer customer = new Customer();
		customer.setName("MacGyver");
		customer.setCellPhone("0939-873125");
		
		Objectify ofy = ObjectifyService.ofy();
		
		// async without the now()
		ofy.save().entity(customer).now();
		
		System.out.println("Customer Id = " + customer.getId());
		
		return result;
	}
}
