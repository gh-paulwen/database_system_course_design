package paul.bank.dao;

public class DailyDao {
	
	/**
	 * for singleton
	 * */
	private DailyDao(){}	
	private static DailyDao instance = null;	
	public static DailyDao getInstance(){
		if(instance == null){
			synchronized(DailyDao.class){
				if(instance == null){
					instance = new DailyDao();
				}
			}
		}
		return instance;
	}
	
	public String daily(String lastupdatetime){
		String sql = "exec p_daily ?";
		String result = DBUtil.executeProcedure(sql, lastupdatetime);
		return result;		
	}
}
