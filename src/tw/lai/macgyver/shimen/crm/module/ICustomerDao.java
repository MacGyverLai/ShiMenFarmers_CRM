package tw.lai.macgyver.shimen.crm.module;

import java.util.List;
import java.util.Map;

import tw.lai.macgyver.shimen.crm.entity.Customer;

public interface ICustomerDao {

	public List<Customer> retrieveCustomerByPage(int page);
	
	public Map<String, Object> queryCustomerByPage(String keyword, int page);
	
	public Customer retrieveCustomerById(Long id);
	
	public boolean saveCustomer(Customer customer);
	
	public boolean deleteCustomer(Customer customer);
	
	public int retreeveCustomerAmount();
}
