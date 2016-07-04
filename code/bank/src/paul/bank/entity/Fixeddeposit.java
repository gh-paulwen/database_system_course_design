package paul.bank.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Fixeddeposit {
	
	private String id;
	private String account_id;
	private double money;
	private Date begindate;
	private int months ;
	private int bonusrate_id;
	private double bonusrate;
	private int status;
	private String status_name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id.trim();
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id.trim();
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(long begindatetime) {
		this.begindate = new Date(begindatetime);
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public int getBonusrate_id() {
		return bonusrate_id;
	}
	public void setBonusrate_id(int bonusrate_id) {
		this.bonusrate_id = bonusrate_id;
	}
	public double getBonusrate() {
		return bonusrate;
	}
	public void setBonusrate(double bonusrate) {
		this.bonusrate = bonusrate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name.trim();
	}
	
	@Override
	public String toString() {
		return id + " , " + account_id + " , " + money;
	}
	
	public static Fixeddeposit of(Map<String,Object> row) throws ParseException {

		Fixeddeposit fixeddeposit = new Fixeddeposit();
		fixeddeposit.setId(row.get("id").toString());
		fixeddeposit.setAccount_id(row.get("account_id").toString());
		fixeddeposit.setMoney(Double.parseDouble(row.get("money").toString()));
		fixeddeposit.setBegindate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(row.get("begindate").toString()).getTime());
		fixeddeposit.setMonths(Integer.parseInt(row.get("months").toString()));
		fixeddeposit.setBonusrate_id(Integer.parseInt(row.get("bonusrate").toString()));
		fixeddeposit.setStatus(Integer.parseInt(row.get("status").toString()));
		fixeddeposit.setBonusrate(Double.parseDouble(row.get("bonusrate_value").toString()));
		fixeddeposit.setStatus_name(row.get("status_name").toString());
		return fixeddeposit;
	}
}
