package tw.lai.macgyver.shimen.crm.module;

import java.util.List;

import tw.lai.macgyver.shimen.crm.entity.Customer;

public interface ICustomerDao {

	public List<Customer> retrieveCustomerByPage(int page);
	
	public Customer retrieveCustomerById(Long id);
	
	public boolean saveCustomer(Customer customer);
	
	public boolean deleteCustomer(Customer customer);
	
	public int retreeveCustomerAmount();
}
