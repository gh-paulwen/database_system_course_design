package paul.bank.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import paul.bank.entity.User;

public class UserDao implements BaseDao<User> {	
	/**
	 * for singleton
	 * */
	private UserDao(){}	
	private static UserDao instance = null;	
	public static UserDao getInstance(){
		if(instance == null){
			synchronized(UserDao.class){
				if(instance == null){
					instance = new UserDao();
				}
			}
		}
		return instance;
	}
	
	
	@Override
	public User find(String userid){
		User userRes = null;		
		String sql = "select [user].*,[power].name from [user],[power] where [user].[power]=[power].id and [user].id=?";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql, userid);
		if(listResults.size() > 0)			
			userRes = User.of(listResults.get(0));		
		return userRes;		
	}
	
	@Override
	public String add(User user){
		String sql = "insert into [user] values(?,?,?)";
		Object[] params = new Object[]{
			user.getId(),
			user.getPassword(),
			user.getPowerid()
		};
		return DBUtil.execute(sql, params);
	}

	@Override
	public List<User> findAll() {		
		List<User> listUser = new ArrayList<User>();
		String sql = "select [user].*,[power].name from [user],[power] where [user].[power]=[power].id";		
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql);		
		for(Map<String,Object> row : listResults){
			User user = User.of(row);
			listUser.add(user);
		}
		return listUser;
	}
	
	/**
	 * get the user from database and verify the password
	 * @param User
	 * @return true means login success while false indicates login failure
	 * */
	public User login(User user){
		User userFromDB = find(user.getId());
		if(userFromDB == null)
			return null;
		if(userFromDB.getId().equals(user.getId()) && userFromDB.getPassword().equals(user.getPassword()))
			return userFromDB;
		return null;		
	}	
	
	public String alter(String userid,User newUser) {
		String res = null;		
		String sql = "exec p_alterbankuser ?,?,?";
		Object[] params = new Object[]{
			userid,
			newUser.getPassword(),
			newUser.getPowerid()
		};
		res = DBUtil.executeProcedure(sql, params);
		return res;
	}
	
	public String delete(String userid){
		String res = null;
		String sql = "exec p_deletebankuser ?";
		res = DBUtil.executeProcedure(sql, userid);
		return res;
	}
}
