package paul.bank.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.classfile.Field;

import paul.bank.dao.AccountDao;
import paul.bank.dao.CustomerDao;
import paul.bank.dao.DBUtil;
import paul.bank.dao.FixeddepositDao;
import paul.bank.dao.UserDao;
import paul.bank.entity.Account;
import paul.bank.entity.Customer;
import paul.bank.entity.Fixeddeposit;
import paul.bank.entity.User;
import paul.bank.tools.CommonUtils;

public class JDBCTest {

	@Test
	public void procedureTest() throws ParseException{
		DBUtil.executeProcedure("p_daily",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-27").getTime()));		
	}
	
	@Test
	public void userDaoTest(){
		UserDao userDao = UserDao.getInstance();		
//		List<User> listUser  =userDao.findAll();
//		for(User user:listUser){
//			System.out.println(String.format("%s,%s,%d,%s", user.getId(),user.getPassword(),user.getPowerid(),user.getPowername()));
//		}
//		
//		User userLogin = new User();
//		userLogin.setId("john");
//		userLogin.setPassword(CommonUtils.md5("2292"));
//		boolean loginRes = userDao.login(userLogin);
//		System.out.println("login result :" + loginRes);
////		
		
		
		
//		System.out.println();
//		User userFind = new User();
//		userFind.setId("john");
//		userFind.setPassword(CommonUtils.md5("2292"));
//		User userFound = userDao.find(userFind);
//		System.out.println(String.format("%s,%s,%d,%s", userFound.getId(),userFound.getPassword(),userFound.getPowerid(),userFound.getPowername()));
		
//		User userAdd = new User();
//		userAdd.setId("john");
//		userAdd.setPassword(CommonUtils.md5("2292"));
//		userAdd.setPowerid(0);
//		userDao.add(userAdd);
		
//		User newUser = new User();
//		newUser.setId("paul");
//		newUser.setPassword(CommonUtils.md5("2292"));
//		newUser.setPowerid(1);
//		
//		String res = userDao.alter("paul", newUser);
//		System.out.println(res);
		
		String res = userDao.delete("john");
		System.out.println(res);
		
	}
	
	
	@Test
	public void customerDaoTest() {
		CustomerDao customerDao = CustomerDao.getInstance();
		Customer cust = customerDao.find("441827199509024310");		
		System.out.println(cust);		
		List<Customer> listCust = customerDao.findAll();		
		for(Customer c : listCust){
			System.out.println(String.format("%s,%s,%s,%s",c.getId(),c.getName(),c.getAddress(),c.getPhonenumber()));
		}
	}
	
	@Test
	public void accountDaoTest(){
		AccountDao accountDao = AccountDao.getInstance();
//		Customer cust = new Customer();
//		cust.setId("441827199509024310");
//		cust.setName("paul");
//		cust.setAddress("dongshajie 24");
//		cust.setPhonenumber("15521294948");
//		Account acc = new Account();
//		acc.setId("6228481144828737911");
//		acc.setType(2);
//		acc.setPassword(CommonUtils.md5("2292"));
//		accountDao.add(cust, acc);
		
//		String res = accountDao.depositFree("6228481144828737911", 10000);
//		System.out.println(res );
		
		String res = accountDao.withdrawFree("6228481144828737911", CommonUtils.md5("2292"), 1000);
		System.out.println(res);
		
		
		//Account acc = accountDao.find("6228481144828737911");
		//System.out.println(String.format("%s\n%s\n%s", acc.getId(),acc.getCreatedate(),acc.getCust_id()));
	}
	
	@Test
	public void fixeddepositDaoTest() {
		FixeddepositDao depositDao = FixeddepositDao.getInstance();
//		Fixeddeposit deposit = new Fixeddeposit();
//		deposit.setId("100000000003");
//		deposit.setAccount_id("6228481144828737911");
//		deposit.setMoney(10000);
//		deposit.setMonths(12);
//		depositDao.add(deposit);
		
		String res = depositDao.withdrowfixed("441827199509024310", "100000000003", 1000, CommonUtils.md5("2292"));
		System.out.println(res);
	}
	
	@Test
	public void longTest(){
		long number = 999999999999l;
		System.out.println(number);
	}
	
	@Test
	public void generateidTest(){
		String id = FixeddepositDao.getInstance().generateid();
		System.out.println(id);
	}
	
	

}
