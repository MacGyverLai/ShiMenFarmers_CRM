package tw.lai.macgyver.shimen.crm.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Customer implements Base<Customer> {

	@Id
	public Long id = null;
	
	public String name = null;
	
	public String address = null;
	
	public String telPhone = null;
	
	public String cellPhone = null;
	
	@Index
	public String company = null;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getTelPhone() {
		return telPhone;
	}



	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}



	public String getCellPhone() {
		return cellPhone;
	}



	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
