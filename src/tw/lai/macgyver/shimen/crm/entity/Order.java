package tw.lai.macgyver.shimen.crm.entity;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Order implements Base<Order> {
	
	@Id
	private Long id = null;
	
	private String contactPhone = null;
	
	private String contactAddress = null;
	
	private Integer totalPrice = null;
	
	private Date createTime = null;
	
	private Date updateTime = null;
	
	private String memo = null;
	
	private String payment = null;
	
	private String operator = null;
	
	private Key<Customer> customer = null;
	
	private List<Ref<OrderDetail>> itemList = null;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<Ref<OrderDetail>> getItemList() {
		return itemList;
	}

	public void setItemList(List<Ref<OrderDetail>> itemList) {
		this.itemList = itemList;
	}
	
	public void setCustomer(Key<Customer> customer) {
		this.customer = customer;
	}

	public Key<Customer> getCustomer() {
		return customer;
	}


	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
