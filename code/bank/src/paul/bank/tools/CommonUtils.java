package paul.bank.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CommonUtils {
	
	private CommonUtils(){}
	
	/**
	 * get uuid
	 * @return String uuid
	 * */
	public static String uuid(){
		String result = UUID.randomUUID().toString().replace("-","");		
		return result;				
	}
	
	/**
	 * get md5 from a string
	 * @param src string to get md5	  
	 * @return String result
	 * */
	public static String md5(String src){
		String res = null;	
		try{
			MessageDigest md =MessageDigest.getInstance("md5");
			byte[] buffer = md.digest(src.getBytes());
			res = bytesToHexString(buffer);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * transform byte[] to HexString
	 * @param byte[] 
	 * @return String result 
	 * */
	private static String bytesToHexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }   
	    return stringBuilder.toString();   
	}   
	
	private static boolean notnull(String key,String value, Map<String,String> errors) {			
		if(value == null || value.length() == 0){
			errors.put(key , "该字段不能为空 : " + key);
			return false;
		}
		return true;			
	}
	
	public static boolean multinotnull(Map<String,String> entrys,Map<String,String> errors){
		Set<String> keys = entrys.keySet();
		boolean result = true;
		for(String key : keys){
			boolean tmp = notnull(key,entrys.get(key),errors);
			if(!tmp)
				result = false;
		}
		return result;
	}
}
