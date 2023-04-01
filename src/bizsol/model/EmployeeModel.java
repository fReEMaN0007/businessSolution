package bizsol.model;

import java.sql.SQLException;
import java.util.HashMap;

public class EmployeeModel {
	
	public SqLiteConnector sqliteDb = new SqLiteConnector();
	
	//personal details
	String firstName,middleName,lastName,email,nationality,religion,mobileNo,bDayMonth,bDayDate,
	bDayYear,age,gender,civilStatus,address,region,province,city,barangay;

	//employment details
	String employeeNo,position,department,officeLocation,salaryGrade,manager,joinedMonth,joinedDate,joinedYear,
			contractType,duration,workSetUp,schedule,noOfDays;
	// 
	int monthlyRate;
	//sws id
	String sss,philHealth,pagIbig,umid,passport,driverLicense,prc;
	//beneficiaries
	String b1Name,b1Address,b1Contact,b1Relation,
			b2Name,b2Address,b2Contact,b2Relation,
			b3Name,b3Address,b3Contact,b3Relation;
	// picture loc / other
	String picture,otherNotes;
	
	public EmployeeModel(){
		try {
			sqliteDb.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static HashMap<String, String> allFields =  new HashMap<String, String>();
	public static HashMap count;
	
	public void setFields(HashMap details) {
		//TODO
		//formatting and data verification before adding to allfields,
		//example making all first letters Capital,
		//making sure all integers are positive,
		 firstName = details.get("firstName").toString();
		 middleName = details.get("middleName").toString();
		 lastName = details.get("lastName").toString();
		 email = details.get("email").toString();
		 nationality = details.get("nationality").toString();
		 religion = details.get("religion").toString();
		 mobileNo = details.get("mobile").toString();
		 bDayMonth = details.get("bDayMonth").toString();
		 bDayDate = details.get("bDayDate").toString();
		 bDayYear = details.get("bDayYear").toString();
		 age = details.get("age").toString();
		 gender = details.get("gender").toString();
		 civilStatus = details.get("civilCombo").toString();
		 address = details.get("address").toString();
		 region = details.get("region").toString();
		 province = details.get("province").toString();
		 city = details.get("city").toString();
		 barangay = details.get("brgy").toString();
	
		 employeeNo = details.get("employeeNo").toString();
		 position = details.get("position").toString();
			 	switch (position){
		 		case "Position 1": position = "1";
		 		break;
		 		case "Position 2": position = "2";
		 		break;
		 		case "Position 3": position = "3";
		 		break;
		 		case "Position 4": position = "4";
		 		break;
		 		case "Position 5": position = "5";
		 		break;
		 		}
		 
		 department = details.get("department").toString();
		 		switch (department){
		 		case "Human Resources": department = "1";
		 		break;
		 		case "Information Technology": department = "2";
		 		break;
		 		case "Accounting & Finance": department = "3";
		 		break;
		 		case "Marketing": department = "4";
		 		break;
		 		case "Research & Development": department = "5";
		 		break;
		 		case "Production": department = "6";
		 		break;
		 		}
		 
		 officeLocation =details.get("location").toString();
			 	switch (officeLocation){
		 		case "Location 1": officeLocation = "1";
		 		break;
		 		case "Location 2": officeLocation = "2";
		 		break;
		 		case "Location 3": officeLocation = "3";
		 		break;
		 		case "Location 4": officeLocation = "4";
		 		break;
		 		case "Location 5": officeLocation = "5";
		 		break;
		 		}
		 
		 salaryGrade = details.get("salaryGrade").toString();
				switch (salaryGrade){
		 		case "Salary Grade 1": salaryGrade = "1";
		 		break;
		 		case "Salary Grade 2": salaryGrade = "2";
		 		break;
		 		case "Salary Grade 3": salaryGrade = "3";
		 		break;
		 		case "Salary Grade 4": salaryGrade = "4";
		 		break;
		 		case "Salary Grade 5": salaryGrade = "5";
		 		break;
		 		}
		 
		 manager = details.get("manager").toString();
				switch (manager){
		 		case "Manager 1": manager = "1";
		 		break;
		 		case "Manager 2": manager = "2";
		 		break;
		 		case "Manager 3": manager = "3";
		 		break;
		 		case "Manager 4": manager = "4";
		 		break;
		 		case "Manager 5": manager = "5";
		 		break;
		 		}
		 		
		 joinedMonth = details.get("joinedMonth").toString();
		 joinedDate = details.get("joinedDate").toString();
		 joinedYear = details.get("joinedYear").toString();
		 contractType = details.get("contract").toString();
				switch (contractType){
		 		case "Permanent": contractType = "1";
		 		break;
		 		case "Term": contractType = "2";
		 		break;
		 		case "Project": contractType = "3";
		 		break;
		 		case "Seasonal": contractType = "4";
		 		break;
		 		case "Casual": contractType = "5";
		 		break;
		 		}
		 
		 duration = details.get("duration").toString();
		 workSetUp = details.get("workSetUp").toString();
			 	switch (workSetUp){
		 		case "WFH": workSetUp = "1";
		 		break;
		 		case "On-site": workSetUp = "2";
		 		break;
		 		case "Hybrid": workSetUp = "3";
		 		break;
		 		}
		 		
		 schedule = details.get("schedule").toString();
				switch (schedule){
		 		case "Morning": schedule = "1";
		 		break;
		 		case "Night": schedule = "2";
		 		break;
		 		case "Graveyard": schedule = "3";
		 		break;
		 		case "Swithching": schedule = "4";
		 		break;
		 		}
		 
		 noOfDays = details.get("daysPerweek").toString();
				switch (noOfDays){
		 		case "5 Days": schedule = "1";
		 		break;
		 		case "6 Days": schedule = "2";
		 		}
		 
				
		 sss = details.get("sss").toString();
		 philHealth = details.get("philHealth").toString();
		 pagIbig = details.get("pagIbig").toString();
		 umid = details.get("umid").toString();
		 passport = details.get("passPort").toString();
		 driverLicense = details.get("license").toString();
		 prc = details.get("prc").toString();
		
		 b1Name = details.get("b1Name").toString();
		 b1Address = details.get("b1Address").toString();
		 b1Contact = details.get("b1Contact").toString();
		 b1Relation = details.get("b1Relation").toString();
		 b2Name = details.get("b2Name").toString();
		 b2Address = details.get("b2Address").toString();
		 b2Contact = details.get("b2Contact").toString();
		 b2Relation = details.get("b2Relation").toString();
		 b3Name = details.get("b3Name").toString();
		 b3Address = details.get("b3Address").toString();
		 b3Contact = details.get("b3Contact").toString();
		 b3Relation = details.get("b3Relation").toString();
		 
		 dataFormattingVerification();
		
	}
	
	
	void dataFormattingVerification() {
		
		allFields.put("firstName", firstName);
		allFields.put("middleName", middleName);
		allFields.put("lastName", lastName);
		allFields.put("email", email);
		allFields.put("nationality", nationality);		
		allFields.put("religion", religion);	
		allFields.put("mobile", mobileNo);
		allFields.put("bDayMonth", bDayMonth);
		allFields.put("bDayDate", bDayDate);
		allFields.put("bDayYear", bDayYear);
		allFields.put("age", age);
		allFields.put("gender", gender);
		allFields.put("civilCombo", civilStatus);
		allFields.put("address",address);
		allFields.put("region", region);
		allFields.put("province", province);
		allFields.put("city", city);
		allFields.put("brgy", barangay);
		
		allFields.put("sss", sss);
		allFields.put("philHealth", philHealth);
		allFields.put("pagIbig", pagIbig);
		allFields.put("umid", umid);
		allFields.put("passPort", passport);
		allFields.put("license", driverLicense);
		allFields.put("prc", prc);
		
		allFields.put("employeeNo",employeeNo);
		allFields.put("position", position);
		allFields.put("department", department);
		allFields.put("manager", manager);
		allFields.put("location", officeLocation);
		allFields.put("salaryGrade", salaryGrade);
		allFields.put("joinedMonth", joinedMonth);
		allFields.put("joinedDate", joinedDate);
		allFields.put("joinedYear", joinedYear);
		allFields.put("contract", contractType);
		allFields.put("duration", duration);
		allFields.put("workSetUp", workSetUp);
		allFields.put("schedule", schedule);
		allFields.put("daysPerweek", noOfDays);
	
		
		allFields.put("b1Name", b1Name);
		allFields.put("b1Address", b1Address);
		allFields.put("b1Contact", b1Contact);
		allFields.put("b1Relation", b1Relation);
		allFields.put("b2Name", b2Name);
		allFields.put("b2Address", b2Address);
		allFields.put("b2Contact", b2Contact);
		allFields.put("b2Relation", b2Relation);
		allFields.put("b3Name", b3Name);
		allFields.put("b3Address", b3Address);
		allFields.put("b3Contact", b3Contact);
		allFields.put("b3Relation", b3Relation);
		
		allFields.put("otherNotes", otherNotes);
		
		sendToDb();
	}
	
	
	
	void sendToDb(){
		
		 try {
			 sqliteDb.getData(allFields);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public HashMap getCount() throws SQLException {
		return count = sqliteDb.getCount();
	}
	
	

}
