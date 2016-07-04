package paul.bank.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class History {
	private int id;
	private String account_id;
	private int fixed;
	private double money;
	private String description;
	private Date his_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id.trim();
	}
	public int getFixed() {
		return fixed;
	}
	public void setFixed(int fixed) {
		this.fixed = fixed;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description.trim();
	}
	public Date getHis_time() {
		return his_time;
	}
	public void setHis_time(long time) {
		this.his_time = new Date(time);
	}
	
	
	
	public static History of(Map<String,Object> row) throws ParseException {
		History his = new History();		
		his.setId(Integer.parseInt(row.get("id").toString()));
		his.setAccount_id(row.get("account_id").toString());
		his.setFixed(Integer.parseInt(row.get("isfixed").toString()));
		his.setMoney(Double.parseDouble(row.get("money").toString()));
		his.setDescription(row.get("description").toString());
		his.setHis_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(row.get("his_time").toString()).getTime());
		return his;
	}
	
	
}
