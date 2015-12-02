package tw.lai.macgyver.shimen.crm.module;

import java.util.Map;

import tw.lai.macgyver.shimen.crm.entity.Product;

public interface IProductDao {

	public boolean saveProduct(Product product);
	
	public Map<String, Object> queryProductByPage(String keyword, String category, int page);
	
	public Product retrieveProductById(Long id);
	
	public boolean deleteProduct(Product product);
}
