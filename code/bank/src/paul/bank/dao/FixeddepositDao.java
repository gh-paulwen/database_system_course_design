package paul.bank.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import paul.bank.entity.Fixeddeposit;

public class FixeddepositDao implements BaseDao<Fixeddeposit> {

	/**
	 * for singleton
	 * */
	private FixeddepositDao(){}	
	private static FixeddepositDao instance = null;	
	public static FixeddepositDao getInstance(){
		if(instance == null){
			synchronized(FixeddepositDao.class){
				if(instance == null){
					instance = new FixeddepositDao();
				}
			}
		}
		return instance;
	}
	
	@Override
	public String add(Fixeddeposit deposit) {
		String sql = "insert into fixeddeposit (id,account_id,[money],months) values(?,?,?,?)";
		Object[] params = new Object[]{
			deposit.getId(),
			deposit.getAccount_id(),
			deposit.getMoney(),
			deposit.getMonths()
		};		
		return DBUtil.execute(sql, params);
	}

	@Override
	public Fixeddeposit find(String depositid) {
		Fixeddeposit deposit = null;
		String sql = "select fixeddeposit.*,bonusrate.bonusrate as bonusrate_value,deposit_status.name as status_name from fixeddeposit,deposit_status,bonusrate where fixeddeposit.[status]=deposit_status.id and fixeddeposit.bonusrate=bonusrate.id and fixeddeposit.id=?";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql, depositid);
		try{
			if(listResults.size() > 0)
				deposit = Fixeddeposit.of(listResults.get(0));
		}catch(ParseException e){
			e.printStackTrace();
		}
		return deposit;
	}

	@Override
	public List<Fixeddeposit> findAll() {
		List<Fixeddeposit> listDeposit = new ArrayList<Fixeddeposit>();
		String sql = "select fixeddeposit.*,bonusrate.bonusrate as bonusrate_value,deposit_status.name as status_name from fixeddeposit,deposit_status,bonusrate where fixeddeposit.[status]=deposit_status.id and fixeddeposit.bonusrate=bonusrate.id";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql);
		try{
			for(Map<String,Object> row : listResults){
				Fixeddeposit deposit = Fixeddeposit.of(row);
				listDeposit.add(deposit);
			}
		}catch(ParseException e){
			e.printStackTrace();
		}		
		return listDeposit;
	}
	
	public String withdrowfixed(String cust_id,String fixeddeposit_id,double money,String password){
		String sql = "exec p_withdrawnotintime ?,?,?,?";
		Object[] params = new Object[]{
			cust_id,
			fixeddeposit_id,
			money,
			password
		};		
		String res = DBUtil.executeProcedure(sql, params);
		return res;		
	}
	
	public String generateid(){
		long idnumber = 100000000000l;
		String id = null;
		for(;idnumber <= 999999999999l;idnumber++){
			id = String.valueOf(idnumber);
			Fixeddeposit d = find(id);
			if(d == null)
				break;
		}
		return id;
	}
	
	public Map<String,Integer> getMonths(){
		String sql = "select months from bonusrate where months > 0";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql);
		Map<String,Integer> months = new HashMap<String,Integer>();
		for(Map<String,Object> row : listResults){
			int month = Integer.parseInt(row.get("months").toString());
			months.put(String.valueOf(month), month);
		}
		
		return months;
	}
}
