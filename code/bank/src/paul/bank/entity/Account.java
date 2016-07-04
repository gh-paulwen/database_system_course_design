package paul.bank.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Account {

	private String id;
	private String cust_id;
	private int type;
	private Date createdate;
	private double fixed;
	private double free;
	private int freedays;
	private String password;
	private String typename;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id.trim();
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id.trim();
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(long createdatetime) {
		this.createdate = new Date(createdatetime);
	}
	public double getFixed() {
		return fixed;
	}
	public void setFixed(double fixed) {
		this.fixed = fixed;
	}
	public double getFree() {
		return free;
	}
	public void setFree(double free) {
		this.free = free;
	}
	public int getFreedays() {
		return freedays;
	}
	public void setFreedays(int freedays) {
		this.freedays = freedays;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.trim();
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename.trim();
	}
	
	@Override
	public String toString() {
		return id + " , " + cust_id;
	}
	
	public static Account of(Map<String,Object> row) throws ParseException {		
		Account account = new Account();
		account.setId(row.get("id").toString());
		account.setCust_id(row.get("cust_id").toString());
		account.setType(Integer.parseInt(row.get("type").toString()));
		account.setCreatedate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(row.get("createdate").toString()).getTime());
		account.setFixed(Double.parseDouble(row.get("fixed").toString()));
		account.setFree(Double.parseDouble(row.get("free").toString()));
		account.setFreedays(Integer.parseInt(row.get("freedays").toString()));
		account.setPassword(row.get("password").toString());
		account.setTypename(row.get("typename").toString());
		return account;
	}
}
