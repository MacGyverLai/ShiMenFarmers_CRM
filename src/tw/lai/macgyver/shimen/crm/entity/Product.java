package tw.lai.macgyver.shimen.crm.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Product implements Base<Product> {
	
	@Id
	public Long id = null;
	
	public String category = null;
	
	public String name = null;
	
	public Integer price = null;
	
	public String description = null;
	
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
