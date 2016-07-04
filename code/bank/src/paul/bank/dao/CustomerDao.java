package paul.bank.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import paul.bank.entity.Customer;

public class CustomerDao implements BaseDao<Customer> {

	/**
	 * for singleton
	 * */
	private CustomerDao(){}	
	private static CustomerDao instance = null;	
	public static CustomerDao getInstance(){
		if(instance == null){
			synchronized(CustomerDao.class){
				if(instance == null){
					instance = new CustomerDao();
				}
			}
		}
		return instance;
	}
	
	@Deprecated
	@Override
	public String add(Customer cust) {
//		String sql = "insert into customer values(?,?,?,)";
//		Object[] params = new Object[]{
//			cust.getId(),
//			cust.getName(),
//			cust.getAddress(),
//			cust.getPhonenumber()
//		};
//		DBUtil.execute(sql, params);
		
		return null;
	}

	@Override
	public Customer find(String custid) {
		Customer custFromDB = null;
		String sql = "select * from customer where id=?";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql, custid);
		if(listResults.size() >0 )
			custFromDB = Customer.of(listResults.get(0));
		return custFromDB;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> listCustomer = new ArrayList<Customer>();		
		String sql = "select * from customer";		
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql);		
		for(Map<String,Object> row : listResults){
			Customer cust = Customer.of(row);
			listCustomer.add(cust);
		}
		return listCustomer;
	}
	
	
	public String alter(Customer cust) {
		String sql = "update customer set name=?,address=?,phonenumber=? where id=?";		
		Object[] params = new Object[]{
			cust.getName(),cust.getAddress(),
			cust.getPhonenumber(),cust.getId()			
		};		
		return DBUtil.execute(sql, params);
	}
	
	
	public List<Customer> vaguefind(String way,String content){
		String sql = String.format("select * from customer where %s like ?", way);		
		List<Customer> listCustomer = new ArrayList<Customer>();
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql, content+"%");		
		for(Map<String,Object> row :  listResults){
			Customer c = Customer.of(row);
			listCustomer.add(c);
		}
		return listCustomer;
	}
	
	
}
