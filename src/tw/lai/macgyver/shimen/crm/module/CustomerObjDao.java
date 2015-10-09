package tw.lai.macgyver.shimen.crm.module;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import tw.lai.macgyver.shimen.crm.entity.Customer;

@Repository("customerService")
@Transactional(readOnly = true)
public class CustomerObjDao implements ICustomerDao {

	@Override
	public List<Customer> retrieveCustomerByPage(int page) {
		// TODO Auto-generated method stub
		List<Customer> result = null;
		
		int startRow = (page - 1) * 20;
//		result = ObjectifyService.ofy().load().type(Customer.class).order("company")
//				.offset(startRow).limit(20).list();
		result = ObjectifyService.ofy().load().type(Customer.class).offset(startRow)
				.limit(20).list();
		
		// https://github.com/objectify/objectify/wiki/Transactions
		
		return result;
	}

	@Override
	public int retreeveCustomerAmount() {
		// TODO Auto-generated method stub
		return ObjectifyService.ofy().load().type(Customer.class).count();
	}

	@Override
	public Customer retrieveCustomerById(Long id) {
		// TODO Auto-generated method stub
		return ObjectifyService.ofy().load().type(Customer.class).id(id).now();
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		long rtnId = ObjectifyService.ofy().save().entity(customer).now().getId();
		if (rtnId != 0)
			result = true;
		
		return result;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean result = true;
		
		// async without the now()
		ObjectifyService.ofy().delete().entity(customer).now();
		
		return result;
	}

}
