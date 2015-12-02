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

import tw.lai.macgyver.shimen.crm.entity.Product;
import tw.lai.macgyver.shimen.crm.module.IProductDao;
import tw.lai.macgyver.tools.PageUtil;

@Controller
public class ProductControl {
	
	private IProductDao productDao = null;

	public IProductDao getProductDao() {
		return productDao;
	}

	@Autowired
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@RequestMapping("/ProductManage.do")
	public ModelAndView showProduct(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		int currentPage = 1;
		
		Map<String, Object> productMap = this.productDao.queryProductByPage(
				null, null, currentPage);
		int rowAmount = (Integer) productMap.get("amount");
		List<Product> productList = (List<Product>) productMap.get("productList");
		gLog.info("DB return size = " + productList.size());
		
		result = new ModelAndView("product_page");
		result.addObject("productList", productList.toArray());
		result.addObject("currentPage", currentPage);
		result.addObject("startPage", PageUtil.getStartPage(rowAmount, currentPage));
		result.addObject("endPage", PageUtil.getEndPage(rowAmount, currentPage));
		
		return result;
	}

	@RequestMapping("/QueryProduct.do")
	public ModelAndView queryProduct(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "page", required = false) String page)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		int currentPage = 1;
		
		Map<String, Object> productMap = this.productDao.queryProductByPage(
				keyword, category, currentPage);
		int rowAmount = (Integer) productMap.get("amount");
		List<Product> productList = (List<Product>) productMap.get("productList");
		gLog.info("DB return size = " + productList.size());
		
		result = new ModelAndView("product_list");
		result.addObject("productList", productList.toArray());
		result.addObject("currentPage", currentPage);
		result.addObject("startPage", PageUtil.getStartPage(rowAmount, currentPage));
		result.addObject("endPage", PageUtil.getEndPage(rowAmount, currentPage));
		
		return result;
	}
	
	@RequestMapping("/ProductSave.do")
	public ModelAndView saveProduct(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("product") Product product) throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		boolean dbRtn = false;
		if (product != null) {
			dbRtn = this.productDao.saveProduct(product);
			gLog.info("Save product result: " + dbRtn);
		}
		res.getWriter().print(dbRtn);
		
		return result;
	}
	
	@RequestMapping("/ProductDetail.do")
	public ModelAndView showProductDetail(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "product_id", required = false) String productId)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		Product product = null;
		if (productId != null && productId.length() > 0) {
			product = this.productDao.retrieveProductById(Long.valueOf(productId));
			gLog.info("ProductName = " + product.getName());
		}
		
		result = new ModelAndView("product_detail");
		result.addObject("product", product);
		
		return result;
	}
	
	@RequestMapping("/ProductDelete.do")
	public ModelAndView deleteProduct(HttpServletRequest req, HttpServletResponse res,
			@RequestParam("product_id") String productId)
			throws Exception {
		ModelAndView result = null;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		Product product = new Product();
		product.setId(Long.valueOf(productId));
		boolean dbRtn = this.productDao.deleteProduct(product);
		res.getWriter().print(dbRtn);
		
		return result;
	}
}
