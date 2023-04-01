package bizsol.model;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class PayrollModel {
	
	 SimpleDateFormat dfoutput = new SimpleDateFormat("MM-dd-yyy");
	public EmployeeModel empSql = new EmployeeModel();
	String query,searchText,searchPosition,searchDepartment,searchLocation,searchManager;
	public ResultSet rs;
	public ResultSet rateResult;
	public HashMap <String,Double> rates = new HashMap<>();
	
	HashMap <String,String> computationResults = new HashMap <String,String>();
	double hourlyRate,regularHours,regularPay,otRate,otHours,otPay,
	holidayRate,holidayHours,holidayPay,otHolidayRate,otHolidayHours,otHolidayPay,
	allowance,nightDiff,ecola,others,bonus,otherPay,sss,philHealth,pagIbig,insurance,contribution,
	loan,cashAdvance,tax,deduction,subGross,grossPay,netPay;

	DecimalFormat df = new DecimalFormat("0.00");

	public BizsolDates dates = new BizsolDates();
	public int payrollBatch;
	Date cutOff;
	ResultSet systemResult;
	public PayrollModel()  {
		df.setRoundingMode(RoundingMode.UP);
		
		cutOff=dates.setCutoff();
		System.out.println(dfoutput.format(cutOff));
		
		try {
			systemResult=empSql.sqliteDb.getSystemVar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(systemResult.next()) {
				payrollBatch = Integer.valueOf(systemResult.getString("payrollBatch"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
			
		if (cutOff.before(dates.dateparse)) {
			payrollBatch++;
			try {
				empSql.sqliteDb.setSystemVar(payrollBatch);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				empSql.sqliteDb.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	
	public void setSearchParameters(HashMap<String, String> searchParam) throws SQLException {
		
//		System.out.println(searchParam.toString());
		searchText = searchParam.get("text");
		searchPosition = searchParam.get("position");
			switch (searchPosition) {
			case "Position 1": searchPosition = "1";
			break;
			case "Position 2": searchPosition = "2";
			break;
			case "Position 3": searchPosition = "3";
			break;
			case "Position 4": searchPosition = "4";
			break;
			case "Position 5": searchPosition = "5";
			break;
			}
		searchDepartment = searchParam.get("department");
			switch (searchDepartment) {
			case "Department 1": searchDepartment = "1";
			break;
			case "Department 2": searchDepartment = "2";
			break;
			case "Department 3": searchDepartment = "3";
			break;
			case "Department 4": searchDepartment = "4";
			break;
			case "Department 5": searchDepartment = "5";
			break;
			case "Department 6": searchDepartment = "6";
			break;
			}
		searchLocation = searchParam.get("location");
			switch (searchLocation) {
			case "Location 1": searchLocation = "1";
			break;
			case "Location 2": searchLocation = "2";
			break;
			case "Location 3": searchLocation = "3";
			break;
			case "Location 4": searchLocation = "4";
			break;
			case "Location 5": searchLocation = "5";
			break;
			}
		searchManager = searchParam.get("manager");
			switch (searchManager) {
			case "Manager 1": searchManager = "1";
			break;
			case "Manager 2": searchManager = "2";
			break;
			case "Manager 3": searchManager = "3";
			break;
			case "Manager 4": searchManager = "4";
			break;
			case "Manager 5": searchManager = "5";
			break;
			}
		query =	"SELECT PersonalDetail.Employee_Number,fName,mName,lName,Position.position,Department.department, Office_Location.Location,Manager.Manager_Name, Salary_Grade.Salary_Rate"
				+" FROM PersonalDetail" 
				+" LEFT JOIN EmploymentDetail on EmploymentDetail.Employee_Number = PersonalDetail.Employee_Number"
				+" LEFT JOIN Department on EmploymentDetail.Department_Id = department.department_id"
				+" LEFT JOIN Position on EmploymentDetail.Position_Id = Position.position_id"
				+" LEFT JOIN Office_Location on EmploymentDetail.Office_Location = Office_Location.location_id"
				+" LEFT JOIN Manager on EmploymentDetail.Manager = Manager.manager_id"
				+" LEFT JOIN Salary_Grade on EmploymentDetail.Salary_Id = Salary_Grade.salary_id";
		//System.out.println(query);
//1 0 0 0 0		
		if(!searchText.equals("") && searchPosition=="by Position" && searchDepartment == "by Department"
				&& searchLocation == "by Site" && searchManager=="by Manager"){			
			query = query + " WHERE PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\"";
			System.out.println(query);	
		}
//1 1 0 0 0			
		else if(!searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment == "by Department"
				&& searchLocation == "by Site" && searchManager=="by Manager") {			
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\"";			
			System.out.println(query);	
		}
//1 1 1 0 0			
		else if(!searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation == "by Site" && searchManager=="by Manager") {			
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Department_Id = \""+searchDepartment+"\"";			
			System.out.println(query);			
		}
//1 1 1 1 0			
		else if(!searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager=="by Manager") {					
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\"";					
			System.out.println(query);			
		}
		
//1 1 1 1 1			
		else if(!searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {							
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\" AND EmploymentDetail.Manager = \""+searchManager+"\"";							
			System.out.println(query);			
		}
		
//0 1 0 0 0		
		else if(searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && searchManager.equals("by Manager")) {									
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\"";									
			System.out.println(query);			
		}
//0 1 1 0 0		
		else if(searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && searchManager.equals("by Manager")) {											
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Department_Id= \""+searchDepartment+"\"";										
			System.out.println(query);			
		}		
//0 1 1 1 0		
		else if(searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {													
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Department_Id= \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\"";													
			System.out.println(query);			
		}			
//0 1 1 1 1		
		else if(searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {															
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Department_Id= \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\" AND EmploymentDetail.Manager = \""+searchManager+"\"";															
			System.out.println(query);			
		}
//0 0 1 0 0		
		else if(searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																	
			query = query + " WHERE EmploymentDetail.Department_Id= \""+searchDepartment+"\"";			
			System.out.println(query);			
		}
//0 0 1 1 0		
		else if(searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																			
			query = query + " WHERE EmploymentDetail.Department_Id= \""+searchDepartment+"\" AND EmploymentDetail.Office_Location = \""+searchLocation+"\"";					
			System.out.println(query);			
		}
//0 0 1 1 1		
		else if(searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {			
			query = query + " WHERE EmploymentDetail.Department_Id= \""+searchDepartment+"\" AND EmploymentDetail.Office_Location = \""+searchLocation+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";				
			System.out.println(query);			
		}
//0 0 0 1 0		
		else if(searchText.equals("") && searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																												
			query = query + " WHERE EmploymentDetail.Office_Location = \""+searchLocation+"\"";						
			System.out.println(query);			
		}
//0 0 0 1 1		
		else if(searchText.equals("") && searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																									
			query = query + " WHERE EmploymentDetail.Office_Location = \""+searchLocation+"\" AND"
				+ " EmploymentDetail.Manager = \""+searchManager+"\"";							
			System.out.println(query);			
		}
//0 0 0 0 1		
		else if(searchText.equals("") && searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																			
			query = query + " WHERE EmploymentDetail.Manager = \""+searchManager+"\"";										
			System.out.println(query);			
		}
//1 0 1 0 0		
		else if(!searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																																								
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Department_Id = \""+searchDepartment+"\"";												
			System.out.println(query);			
		}
//1 0 1 1 0		
		else if(!searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																																											
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND EmploymentDetail.Office_Location = \""+searchLocation+"\"";														
			System.out.println(query);			
		}
//1 0 1 1 1		
		else if(!searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND EmploymentDetail.Office_Location = \""+searchLocation+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																
			System.out.println(query);			
		}
//1 0 0 1 0		
		else if(!searchText.equals("") && searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																																																				
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\"";																		
			System.out.println(query);			
		}
//1 0 0 1 1		
		else if(!searchText.equals("") && searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																								
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\" AND EmploymentDetail.Manager = \""+searchManager+"\"";																				
			System.out.println(query);			
		}
//1 0 0 0 1		
		else if(!searchText.equals("") && searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																												
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																						
			System.out.println(query);			
		}
//0 1 0 1 0		
		else if(searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																																																																
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Office_Location = \""+searchLocation+"\"";																								
			System.out.println(query);			
		}		
//0 1 0 1 1		
		else if(searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																				
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND EmploymentDetail.Office_Location = \""+searchLocation+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																										
			System.out.println(query);					
		}
		
//0 0 1 0 1		
		else if(searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																								
			query = query + " WHERE EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																												
			System.out.println(query);							
		}
//1 1 0 1 0 		
	 	else if(!searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\"";																														
			System.out.println(query);									
		}		
//1 1 0 1 1 		
	 	else if(!searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& !searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND"
					+ " EmploymentDetail.Office_Location = \""+searchLocation+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																														
			System.out.println(query);									
		}
//1 1 1 0 1 		
	 	else if(!searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND"
					+ " EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																														
			System.out.println(query);									
		}		
//0 1 1 0 1 		
	 	else if(searchText.equals("") && !searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND"
					+ " EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																														
			System.out.println(query);									
		}
//0 1 0 0 1 		
	 	else if(searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE EmploymentDetail.Position_Id= \""+searchPosition+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																														
			System.out.println(query);									
		}
//1 1 0 0 1 		
	 	else if(!searchText.equals("") && !searchPosition.equals("by Position") && searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Position_Id= \""+searchPosition+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																														
			System.out.println(query);									
		}
//1 0 1 0 1 		
	 	else if(!searchText.equals("") && searchPosition.equals("by Position") && !searchDepartment.equals("by Department")
				&& searchLocation.equals("by Site") && !searchManager.equals("by Manager")) {																																																																												
			query = query + " WHERE (PersonalDetail.Employee_Number = \""+searchText+"\" OR fName = \""+searchText+"\" OR lName = \""+searchText+"\") AND"
					+ " EmploymentDetail.Department_Id = \""+searchDepartment+"\" AND"
					+ " EmploymentDetail.Manager = \""+searchManager+"\"";																														
			System.out.println(query);									
		
			
	 	}
		else {
			
		}
		rs = empSql.sqliteDb.search(query);
	
	}
	

	public HashMap getRate(HashMap<String, String> result) throws SQLException {
		double salaryRate,regularRate=0,otRate,hldRate,otHldRate,sssRate,pagIbigRate,philHealthRate;
		System.out.println(result.get("empNo"));
		String rateQuery = result.get("empNo");
		rateQuery = "SELECT Salary_Rate FROM EmploymentDetail LEFT JOIN Salary_Grade on EmploymentDetail.Salary_Id = Salary_Grade.salary_id WHERE EmploymentDetail.Employee_Number =\""+rateQuery+"\"";
		rateResult = empSql.sqliteDb.search(rateQuery);
		
		
	
		
		
		salaryRate = Double.valueOf(rateResult.getString("Salary_Rate"));

		regularRate = (salaryRate / 20)/8;
		otRate = regularRate * 1.25;
		hldRate = regularRate * 2;
		otHldRate = hldRate * 1.3;
		sssRate = salaryRate * .045;
		philHealthRate = salaryRate * .04;

		rates.put("regularRate", Double.valueOf(df.format(regularRate)));
		rates.put("otRate", Double.valueOf(df.format(otRate)));
		rates.put("hldRate", Double.valueOf(df.format(hldRate)));
		rates.put("otHldRate", Double.valueOf(df.format(otHldRate)));
		rates.put("sssRate", Double.valueOf(df.format(sssRate)));
		rates.put("philHealthRate", Double.valueOf(df.format(philHealthRate)));
		rates.put("pagIbigRate", 100.0);
		rates.put("salaryRate", salaryRate);
		
		empSql.sqliteDb.conn.close();
		
		return rates;
	}
	public ResultSet checkStatus(String empNo) throws SQLException {		
		String payrollQuery = "SELECT * FROM Payroll WHERE Employee_Number = \"" +empNo+ "\" AND payroll_batch= \""+ payrollBatch +"\"";
		ResultSet payrollStatusRS = empSql.sqliteDb.search(payrollQuery);
		
		
		
		return payrollStatusRS;
	}
	
	
	
	public void payrollSendtoDb(HashMap <String,String>payroll) throws SQLException {
		payroll.put("payrollBatch", String.valueOf(payrollBatch));
		
		switch (payroll.get("salaryGrade")){
		
		case "15000.0": payroll.put("salaryId", "1");
		break;
		
		case "18000.0": payroll.put("salaryId", "2");
		break;

		case "21000.0": payroll.put("salaryId", "3");
		break;
		
		case "24000.0": payroll.put("salaryId", "4");
		break;
		
		case "28000.0": payroll.put("salaryId", "5");
		break;
		
		}
		
		System.out.println(payroll.get("salaryGrade"));
		empSql.sqliteDb.insertToPayroll(payroll);
		
		empSql.sqliteDb.conn.close();
	}


	public void setOperands(HashMap operands) {
		
		
		hourlyRate = Double.valueOf(operands.get("hourlyRate").toString());
		regularHours = Double.valueOf(operands.get("regularHours").toString());
		otRate = Double.valueOf(operands.get("otRate").toString());
		otHours = Double.valueOf(operands.get("otHours").toString());
		holidayRate = Double.valueOf(operands.get("holidayRate").toString());
		holidayHours = Double.valueOf(operands.get("holidayHours").toString());
		otHolidayRate = Double.valueOf(operands.get("otHolidayRate").toString());
		otHolidayHours = Double.valueOf(operands.get("otHolidayHours").toString());		
		
		allowance = Double.valueOf(operands.get("allowance").toString());
		nightDiff = Double.valueOf(operands.get("nightDiff").toString());
		ecola = Double.valueOf(operands.get("ecola").toString());
		
		others = Double.valueOf(operands.get("other").toString());		
		bonus = Double.valueOf(operands.get("bonus").toString());
	
		sss = Double.valueOf(operands.get("sss").toString());
		philHealth = Double.valueOf(operands.get("philHealth").toString());	
		pagIbig = Double.valueOf(operands.get("pagIbig").toString());
		insurance = Double.valueOf(operands.get("insurance").toString());
		
		loan = Double.valueOf(operands.get("loan").toString());
		cashAdvance = Double.valueOf(operands.get("cashAdvance").toString());
		tax = Double.valueOf(operands.get("tax").toString());

	}
	
	public HashMap compute() {
		
		regularPay = hourlyRate * regularHours;
		otPay = otRate * otHours;
		holidayPay = holidayRate * holidayHours;
		otHolidayPay = otHolidayRate * otHolidayHours;
		otherPay = allowance+nightDiff+ecola+others+bonus;
		contribution = sss+philHealth+pagIbig+insurance;
		deduction = loan+cashAdvance+tax;
		grossPay = regularPay+otPay+holidayPay+otHolidayPay+otherPay;
		subGross = grossPay - deduction;
		netPay = subGross - contribution;
		
		
		computationResults.put("netPay", df.format(netPay));
		computationResults.put("grossPay", df.format(grossPay));
		computationResults.put("subGross", df.format(subGross));
		computationResults.put("deduction", df.format(deduction));
		computationResults.put("contribution", df.format(contribution));
		computationResults.put("otherPay", df.format(otherPay));
		computationResults.put("otHolidayPay", df.format(otHolidayPay));
		computationResults.put("holidayPay", df.format(holidayPay));
		computationResults.put("otPay", df.format(otPay));
		computationResults.put("regularPay", df.format(regularPay));
	
		return computationResults;
	}
	
	
	
	
}

