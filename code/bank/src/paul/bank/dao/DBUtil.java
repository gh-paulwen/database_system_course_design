package paul.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
	
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private DBUtil(){}
	
	public static String execute(String sql,Object... params){
		String res = "操作成功";
		Connection conn = null;
		PreparedStatement ps = null;		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length ; i++){
				ps.setObject(i + 1,	params[i]);
			}
			ps.execute();
		} catch (SQLException e) {
			res = "操作失败 : " + e.getMessage();
		} finally {
			try{
				if(ps != null){
					ps.close();
				}					
				if(conn != null){
					conn.close();
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
		}		
		return res;
	}
	
	public static String executeProcedure(String sql,Object... params){
		Connection conn = null;
		CallableStatement cs = null;
		String res = "操作成功";
		try {
			conn = getConnection();
			cs = conn.prepareCall(sql);
			for(int i = 1;i <= params.length;i++){
				cs.setObject(i, params[i-1]);
			}
			cs.execute();			
		} catch (SQLException e) {
			res = e.getMessage();
		} finally {
			try{
				if(cs != null){
					cs.close();
				}					
				if(conn != null){
					conn.close();
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
		}			
		return res;
	}
	
	public static List<Map<String,Object>> executeQuery(String sql,Object... params){
		List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length ; i++){
				ps.setObject(i + 1,	params[i]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String,Object> row = new HashMap<String,Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int count = rsmd.getColumnCount();
				for(int i = 1;i <= count ;i++){					
					String key = rsmd.getColumnName(i);
					Object value = rs.getObject(i);
					row.put(key, value);
				}
				results.add(row);
			}
			
		} catch(SQLException e){
			throw new RuntimeException(e);
		} finally {
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}					
				if(conn != null){
					conn.close();
				}
			} catch(SQLException e){
				throw new RuntimeException(e);
			}
		}			
		
		return results ;
	}
	
	private static Connection getConnection() throws SQLException{
		String url = "jdbc:sqlserver://localhost:1433;DataBaseName=bank";
		String username = "sa";
		String password = "2292";
		return DriverManager.getConnection(url,username,password);
	}
	
}
