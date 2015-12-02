package tw.lai.macgyver.shimen.crm.module.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import tw.lai.macgyver.shimen.crm.entity.Customer;
import tw.lai.macgyver.shimen.crm.module.ICustomerDao;
import tw.lai.macgyver.tools.PageUtil;

@Repository("customerService")
@Transactional(readOnly = true)
public class CustomerObjDao implements ICustomerDao {

	@Override
	public List<Customer> retrieveCustomerByPage(int page) {
		// TODO Auto-generated method stub
		List<Customer> result = null;
		
		int startRow = (page - 1) * 20;
		result = ObjectifyService.ofy().load().type(Customer.class).order("company")
				.offset(startRow).limit(20).list();
//		result = ObjectifyService.ofy().load().type(Customer.class).offset(startRow)
//				.limit(20).list();
		
		// https://github.com/objectify/objectify/wiki/Transactions
		
		return result;
	}

	@Override
	public Map<String, Object> queryCustomerByPage(String keyword, int page) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		List<Customer> customerList = new ArrayList<Customer>();
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		int startRow = (page - 1) * PageUtil.PRE_PAGE_COUNT;
		int endRow = startRow + PageUtil.PRE_PAGE_COUNT;
		
		List<Customer> rtnList = ObjectifyService.ofy().load().type(Customer.class)
				.order("company").list();
//				.filter("company >=", keyword)
//				.filter("company <", keyword + "\ufffd")
//				.offset(startRow).limit(20).list();
		gLog.info("Customer return amount = " + rtnList.size());
		
		Integer amount = 0;
		if (keyword != null && keyword.length() > 0) {
			for (int i = 0; i < rtnList.size(); i++) {
				boolean isTarget = false;
				if (rtnList.get(i).getAddress().indexOf(keyword) > -1)
					isTarget = true;
				if (rtnList.get(i).getCellPhone().indexOf(keyword) > -1)
					isTarget = true;
				if (rtnList.get(i).getCompany().indexOf(keyword) > -1)
					isTarget = true;
				if (rtnList.get(i).getName().indexOf(keyword) > -1)
					isTarget = true;
				if (rtnList.get(i).getTelPhone().indexOf(keyword) > -1)
					isTarget = true;
				
				if (isTarget) {
					if (amount >= startRow && amount < endRow)
						customerList.add(rtnList.get(i));
					amount++;
				}
			}			
		} else {
			customerList = rtnList;
			amount = customerList.size();
		}
		result.put("amount", amount);
		result.put("customerList", customerList);
		
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
		Logger gLog = Logger.getLogger(this.getClass().getName());
		
		long rtnId = ObjectifyService.ofy().save().entity(customer).now().getId();
		gLog.info("Save Customer Id = " + rtnId);
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
