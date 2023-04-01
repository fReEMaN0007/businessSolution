package bizsol.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class LogInModel {
	 HashMap<String, String> hash_map = new HashMap<String, String>();

	
	 
	 public LogInModel(){
		 hash_map.put("user", "pass");
		 hash_map.put("super", "admin");
		 
				
	}
	public boolean checkLogin(String user, char[] pass) {		
		boolean bool=false;		
		 if (hash_map.containsKey("user")) {
			 if(Arrays.equals(hash_map.get(user).toCharArray(), pass)) {
	
				 bool = true;
			 }
			 else {
				 bool=false;
			 }
		 } 
		 return bool;
	}
}


