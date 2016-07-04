package paul.bank.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import paul.bank.entity.History;

public class HistoryDao implements BaseDao<History> {

	/**
	 * for singleton
	 * */
	private HistoryDao(){}	
	private static HistoryDao instance = null;	
	public static HistoryDao getInstance(){
		if(instance == null){
			synchronized(HistoryDao.class){
				if(instance == null){
					instance = new HistoryDao();
				}
			}
		}
		return instance;
	}
	
	
	@Deprecated
	@Override
	public String add(History t) {
		return null;
	}

	@Deprecated
	@Override
	public History find(String id) {
		return null;
	}

	@Override
	public List<History> findAll() {
		List<History> listHistory = new ArrayList<History>();
		String sql = "select * from history";
		List<Map<String,Object>> listResults = DBUtil.executeQuery(sql);
		
		try{
			for(Map<String,Object> row : listResults){
				History his = History.of(row);
				listHistory.add(his);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listHistory;
	}

}
