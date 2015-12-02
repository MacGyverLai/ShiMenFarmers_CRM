package tw.lai.macgyver.shimen.crm.control;

import java.util.List;
import java.util.Map;
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

@Controller
public class CustomerControl {
	
	private ICustomerDao customerDao = null;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@RequestMapping("/CustomerManage.do")
	public ModelAndView showCustomer(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		int currentPage = 1;
		
		List<Customer> customerList = this.customerDao.retrieveCustomerByPage(currentPage);
		int rowAmount = this.customerDao.retreeveCustomerAmount();
		gLog.info("CustomerList size = " + customerList.size());
		
		result = new ModelAndView("customer_page");
		result.addObject("customerList", customerList.toArray());
		result.addObject("currentPage", currentPage);
		result.addObject("startPage", PageUtil.getStartPage(rowAmount, currentPage));
		result.addObject("endPage", PageUtil.getEndPage(rowAmount, currentPage));
		
		return result;
	}
	
	@RequestMapping("/QueryCustomer.do")
	public ModelAndView queryCustomer(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) String page)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		int currentPage = 1;
		
		if (page != null && page.length() > 0)
			currentPage = Integer.parseInt(page);
		Map<String, Object> customerMap = this.customerDao.queryCustomerByPage(
				keyword, currentPage);
		int rowAmount = (Integer) customerMap.get("amount");
		List<Customer> customerList = (List<Customer>) customerMap.get("customerList");
		gLog.info("DB return size = " + customerList.size());
		
		result = new ModelAndView("customer_list");
		result.addObject("customerList", customerList.toArray());
		result.addObject("currentPage", currentPage);
		result.addObject("startPage", PageUtil.getStartPage(rowAmount, currentPage));
		result.addObject("endPage", PageUtil.getEndPage(rowAmount, currentPage));
		
		return result;
	}
	
	@RequestMapping("/CustomerDetail.do")
	public ModelAndView showCustomerDetail(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "customer_id", required = false) String customerId)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		Customer customer = null;
		if (customerId != null && !"".equals(customerId))
			customer = this.customerDao.retrieveCustomerById(Long.valueOf(customerId));
		
		gLog.info("customer = " + customer);
		
		result = new ModelAndView("customer_detail");
		result.addObject("customer", customer);
		
		return result;
	}
	
	@RequestMapping("/CustomerSave.do")
	public ModelAndView saveCustomer(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("customer") Customer customer) throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		boolean dbRtn = false;
		if (customer != null) {
			dbRtn = this.customerDao.saveCustomer(customer);
			gLog.info("Save customer result: " + dbRtn);
		}
		res.getWriter().print(dbRtn);
		
		return result;
	}
	
	@RequestMapping("/CustomerDelete.do")
	public ModelAndView deleteCustomer(HttpServletRequest req, HttpServletResponse res,
			@RequestParam("customer_id") String customerId)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		Customer customer = new Customer();
		customer.setId(Long.valueOf(customerId));
		boolean dbRtn = this.customerDao.deleteCustomer(customer);
		res.getWriter().print(dbRtn);
		
		return result;
	}
}
