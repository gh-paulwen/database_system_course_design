package paul.bank.entity;

import java.util.Map;

public class User {	
	
	private String id;
	private String password;
	private int powerid;
	private String powername;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.trim();
	}
	public int getPowerid() {
		return powerid;
	}
	public void setPowerid(int powerid) {
		this.powerid = powerid;
	}
	public String getPowername() {
		return powername;
	}
	public void setPowername(String powername) {
		this.powername = powername.trim();
	}
	
	@Override
	public String toString() {
		return id;
	}	
	
	public static User of(Map<String,Object> row){
		User user = new User();
		user.setId(row.get("id").toString());
		user.setPassword(row.get("password").toString());
		user.setPowerid(Integer.parseInt(row.get("power").toString()));
		user.setPowername(row.get("name").toString());		
		return user;
	}
	
}
