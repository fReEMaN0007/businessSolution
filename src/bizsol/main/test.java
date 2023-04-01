package bizsol.main;

import java.util.Arrays;
import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashMap<String, String> hash_map = new HashMap<String, String>();
		 
		 char[] password = {'p','a','s','s'};
		 hash_map.put("user", "pass");
		 
		 if (hash_map.containsKey("user")) {
//			 if (hash_map.get("user").equals(new String(password))){
//					System.out.println("goods");
//			 }
			 if(Arrays.equals(hash_map.get("user").toCharArray(), password)) {
				 System.out.println("goods");
			 }
				 
				 
			 else {
				 System.out.println("bads");
			 }
		 }

	}

}
