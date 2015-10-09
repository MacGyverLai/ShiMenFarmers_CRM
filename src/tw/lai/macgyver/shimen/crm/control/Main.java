package tw.lai.macgyver.shimen.crm.control;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.lai.macgyver.shimen.crm.entity.Customer;
import tw.lai.macgyver.shimen.crm.module.ICustomerDao;
import tw.lai.macgyver.tools.PageUtil;

import com.googlecode.objectify.ObjectifyService;

@Controller
public class Main {
	
	private ICustomerDao customerDao = null;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@RequestMapping("/CustomerManage.do")
	public ModelAndView checkLogin(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = null;
		Logger mylog = Logger.getLogger(this.getClass().getName());
		int currentPage = 1;
		
		List<Customer> customerList = this.customerDao.retrieveCustomerByPage(currentPage);
		int rowAmount = this.customerDao.retreeveCustomerAmount();
		mylog.info("CustomerList size = " + customerList.size());
		
		result = new ModelAndView("customer_list");
		result.addObject("customerList", customerList.toArray());
		result.addObject("currentPage", currentPage);
		result.addObject("startPage", PageUtil.getStartPage(rowAmount, currentPage));
		result.addObject("endPage", PageUtil.getEndPage(rowAmount, currentPage));
		
		return result;
	}
	
	@RequestMapping("/CustomerDeatil.do")
	public ModelAndView showCustomerDetail(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "customer-id", required = false) String customerId)
			throws Exception {
		ModelAndView result = null;
		Logger mylog = Logger.getLogger(this.getClass().getName());
		
		Customer customer = null;
		if (customerId != null && !"".equals(customerId))
			customer = this.customerDao.retrieveCustomerById(Long.valueOf(customerId));
		
		mylog.info("customer = " + customer);
		
		result = new ModelAndView("customer_detail");
		result.addObject("customer", customer);
		
		return result;
	}
}
