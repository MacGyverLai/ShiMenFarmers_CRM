package tw.lai.macgyver.shimen.crm.entity;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class OrderDetail implements Base<OrderDetail> {

	@Id
	private Long id = null;
	
	private Integer count = null;
	
	private Key<Product> item = null;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Key<Product> getItem() {
		return item;
	}

	public void setItem(Key<Product> item) {
		this.item = item;
	}

	@Override
	public int compareTo(OrderDetail o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
