package tw.lai.macgyver.shimen.crm.entity;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Order implements Base<Order> {
	
	@Id
	public Long id = null;
	
	public String contactPhone = null;
	
	public String contactAddress = null;
	
	public Integer totalPrice = null;
	
	public Date createTime = null;
	
	public Date updateTime = null;
	
	public String memo = null;
	
	Key<Customer> customer = null;
	
	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
