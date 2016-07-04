package paul.bank.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import paul.bank.entity.Account;
import paul.bank.entity.Customer;

public class AccountDao implements BaseDao<Account> {

	/**
	 * for singleton
	 * */
	private AccountDao(){}	
	private static AccountDao instance = null;	
	public static AccountDao getInstance(){
		if(instance == null){
			synchronized(AccountDao.class){
				if(instance == null){
					instance = new AccountDao();
				}
			}
		}
		return instance;
	}
	
	
	@Deprecated
	@Override
	public String add(Account account) {
		//empty
		return null;
	}
	
	/**
	 * use the procedure p_createaccount in database
	 * @param Customer
	 * @param Account
	 * @return the result
	 * 
	 * */
	public String add(Customer cust,Account acc){
		String sql = "exec p_createaccount ?,?,?,?,?,?,? ";
		Object[] params = new Object[]{
			cust.getId(),
			cust.getName(),
			cust.getAddress(),
			cust.getPhonenumber(),
			acc.getId(),
			acc.getType(),
			acc.getPassword()
		};		
		String res = DBUtil.executeProcedure(sql, params);		
		return res;
	}	

	
	@Override
	public Account find(String accountid) {
		Account account = null;
		String sql = "select account.* ,account_type.name as typename from account,account_type where account.[type]=account_type.id and account.id=?";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql, accountid);
		
		try{
			if(listResults.size() > 0)
				account = Account.of(listResults.get(0));
		}catch(ParseException e){
			e.printStackTrace();
		}
		return account;		
	}

	@Override
	public List<Account> findAll() {
		List<Account> listAccount = new ArrayList<Account>();
		String sql = "select account.* ,account_type.name as typename from account,account_type where account.[type]=account_type.id";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql);
		try{
			for(Map<String,Object> row:listResults){
				Account account = Account.of(row);
				listAccount.add(account);
			}
		}catch(ParseException e){
			e.printStackTrace();
		}
		return listAccount;
	}
	
	
	public String withdrawFree(String account_id,String password,double money){
		String res = null;
		String sql = "exec p_withdrawfree ?,?,?";
		Object[] params = new Object[]{
			account_id,
			password,
			money
		};
		res = DBUtil.executeProcedure(sql, params);
		return res;
	}
	
	public String depositFree(String account_id,double money){
		String res = null;				
		String sql = "exec p_depositfree ?,?";
		Object[] params = new Object[]{
			account_id,
			money
		};
		res = DBUtil.executeProcedure(sql, params);
		return res;
	}
	
	
	public String generateid(){
		StringBuilder sb = new StringBuilder();
		String id = null;
		long idnumber = 1000000000000l;
		for(;idnumber <= 9999999999999l;idnumber++){
			sb.append("622848");
			sb.append(String.valueOf(idnumber));
			id = sb.toString();
			sb.delete(0, sb.length());
			Account acc = find(id);
			if(acc == null)
				break;
		}
		return id;
	}

}
