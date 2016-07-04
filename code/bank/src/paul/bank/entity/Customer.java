package paul.bank.entity;

import java.util.Map;

public class Customer {
	private String id;
	private String name;
	private String address;
	private String phonenumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id.trim();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address.trim();
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber.trim();
	}
	
	@Override
	public String toString() {
		return id + " ; " + name;
	}
	
	public static Customer of(Map<String,Object> row){
		Customer cust = new Customer();
		cust.setId(row.get("id").toString());
		cust.setName(row.get("name").toString());
		cust.setAddress(row.get("address").toString());
		cust.setPhonenumber(row.get("phonenumber").toString());	
		return cust;
	}
}
