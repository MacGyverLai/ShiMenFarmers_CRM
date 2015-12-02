package tw.lai.macgyver.shimen.crm.module.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.objectify.ObjectifyService;

import tw.lai.macgyver.shimen.crm.entity.Product;
import tw.lai.macgyver.shimen.crm.module.IProductDao;
import tw.lai.macgyver.tools.PageUtil;

@Repository("productService")
@Transactional(readOnly = true)
public class ProductObjDao implements IProductDao {

	public ProductObjDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Object> queryProductByPage(String keyword, String category, int page) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		List<Product> productList = new ArrayList<Product>();
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		int startRow = (page - 1) * PageUtil.PRE_PAGE_COUNT;
		int endRow = startRow + PageUtil.PRE_PAGE_COUNT;
		
		List<Product> rtnList = null;
		if (category != null && category.length() > 0)
			rtnList = ObjectifyService.ofy().load().type(Product.class)
					.filter("category", category).list();
		else
			rtnList = ObjectifyService.ofy().load().type(Product.class)
					.order("category").list();
		gLog.info("Product return amount = " + rtnList.size());
		
		Integer amount = 0;
		if (keyword != null && keyword.length() > 0) {
			for (int i = 0; i < rtnList.size(); i++) {
				boolean isTarget = false;
				if (rtnList.get(i).getName().indexOf(keyword) > -1)
					isTarget = true;
				if (rtnList.get(i).getPrice().toString().indexOf(keyword) > -1)
					isTarget = true;
				if (rtnList.get(i).getDescription().indexOf(keyword) > -1)
					isTarget = true;
				
				if (isTarget) {
					if (amount >= startRow && amount < endRow)
						productList.add(rtnList.get(i));
					amount++;
				}
			}
		} else {
			productList = rtnList;
			amount = productList.size();
		}
		result.put("amount", amount);
		result.put("productList", productList);
		
		return result;
	}

	@Override
	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		boolean result = false;
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		long rtnId = ObjectifyService.ofy().save().entity(product).now().getId();
		gLog.info("Save Product Id = " + rtnId);
		if (rtnId != 0)
			result = true;
		
		return result;
	}

	@Override
	public Product retrieveProductById(Long id) {
		// TODO Auto-generated method stub
		return ObjectifyService.ofy().load().type(Product.class).id(id).now();
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		boolean result = true;
		
		ObjectifyService.ofy().delete().entity(product).now();
		
		return result;
	}

}
