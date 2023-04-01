package bizsol.model;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class SqLiteConnector {

	
	
	public Connection conn;
	boolean tableChecker = false;
	EmployeeModel fdsafdsafdsa;
	public static HashMap<String, String> verifiedData;
	public static HashMap<String, String> populateData = new HashMap<String, String>();
	public static ArrayList <String> empnumber = new ArrayList<String>();
	public static HashMap<String, String> payroll = new HashMap<String,String>();
	public static HashMap<String, Integer> count = new HashMap<String, Integer>();
	
	ResultSet rs;
	static ArrayList<String> joinedyear = new ArrayList<String>();
	
	
	public SqLiteConnector(){
		//getConnection();
	}
	
	public void getConnection() throws SQLException{
		if (conn==null) {
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:BizsolSqlite.db");
				
				initializeTable();
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (conn.isClosed()) {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:sqlite:BizsolSqlite.db");
			
		}
		
	}
	
	public void initializeTable() throws SQLException{	
			Statement statement= conn.createStatement();	
			ResultSet result;
				result = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='PersonalDetail'");
	
				if(result.next()) {
					System.out.println("Table Available");
					getCount();
					conn.close();
				}
				
				else {

//////////////// Table contribution ////////////////////////					
				Statement createContributionTable= conn.createStatement();	
				createContributionTable.execute("CREATE TABLE Contribution (contribution_id INTEGER,  Type varchar(60),"
						+ "Rate varchar(60),"
				+ "primary key(contribution_id));");
									
				System.out.println("schedule Table Created");											
//////////////// Table ID ////////////////////////					
				Statement createIdListTable= conn.createStatement();	
				createIdListTable.execute("CREATE TABLE Id_List (idList_id INTEGER, Employee_id varchar(60), sss varchar(60),"
				+ "PhilHealth varchar(60), PagIbig varchar(60), Umid varchar(60), Passport varchar(60),"
				+ "DriverLicense varchar(60), PRC varchar(60),"
				+ "primary key(idList_id)"
				+ "FOREIGN KEY (Employee_id)"
				+ "REFERENCES PersonalDetail(Employee_Number));");
										
				System.out.println("ID List Table Created");											
//////////////// Table beneficiaries ////////////////////////					
				Statement createBeneficiaryTable= conn.createStatement();	
				createBeneficiaryTable.execute("CREATE TABLE Beneficiaries (beneficiary_id INTEGER, Employee_id varchar(60), Name varchar(60),"
				+ "Address varchar(60), Contact varchar(60), Relation varchar(60),"
				+ "primary key(beneficiary_id)"
				+ "FOREIGN KEY (Employee_id)"
				+ "REFERENCES PersonalDetail(Employee_Number));");
									
				System.out.println("beneficiaries Table Created");						
//////////////// Table days per week ////////////////////////					
				Statement createDaysPerWeekTable= conn.createStatement();	
				createDaysPerWeekTable.execute("CREATE TABLE Days_per_Week (NoOfDays_id INTEGER,  No_of_days varchar(60),"
				+ "primary key(NoOfDays_id));");
								
				System.out.println("schedule Table Created");						
//////////////// Table schedule////////////////////////					
				Statement createScheduleTable= conn.createStatement();	
				createScheduleTable.execute("CREATE TABLE Schedule (schedule_id INTEGER,  Schedule varchar(60), Time varchar(60),"
				+ "primary key(schedule_id));");
							
				System.out.println("schedule Table Created");											
//////////////// Table work set up////////////////////////					
				Statement createWorkSetUpTable= conn.createStatement();	
				createWorkSetUpTable.execute("CREATE TABLE Work_SetUp (setup_id INTEGER,  Work_Setup varchar(60),"
				+ "primary key(setup_id));");
						
				System.out.println("work setup Table Created");						
//////////////// Table contract////////////////////////					
				Statement createContractTable= conn.createStatement();	
				createContractTable.execute("CREATE TABLE Contract_Type (contract_id INTEGER,  Contract_Type varchar(60), Duration varchar(60),"
				+ "primary key(contract_id));");
					
				System.out.println("contracty Table Created");					
//////////////// Table salary grade ////////////////////////					
				Statement createSalaryGradeTable= conn.createStatement();	
				createSalaryGradeTable.execute("CREATE TABLE Salary_Grade (salary_id INTEGER,  Salary_Grade varchar(60), Salary_Rate varchar(60),"
				+ "primary key(salary_id));");
				
				System.out.println("salary Table Created");
//////////////// Table manager ////////////////////////					
				Statement createManagerTable= conn.createStatement();	
				createManagerTable.execute("CREATE TABLE Manager (manager_id INTEGER,  Manager_Name varchar(60),"
				+ "primary key(manager_id));");
						
				System.out.println("manager Table Created");				
////////////////Table location ////////////////////////					
				Statement createLocationTable= conn.createStatement();	
				createLocationTable.execute("CREATE TABLE Office_Location (location_id INTEGER,  Location varchar(60),"
				+ "primary key(location_id));");
					
				System.out.println("location Table Created");
//////////////// Table position ////////////////////////					
				Statement createPositionTable= conn.createStatement();	
				createPositionTable.execute("CREATE TABLE Position (position_id INTEGER,  position varchar(60),"
				+ "primary key(position_id));");
					
				System.out.println("position Table Created");					
//////////////// Table department //// *REFERENCE* ////////////////////					
				Statement createDepartmentTable= conn.createStatement();	
				createDepartmentTable.execute("CREATE TABLE Department (department_id INTEGER,  department varchar(60),"
				+ "primary key(department_id));");
				System.out.println("department Table Created");
				
////////////////Table Group //// *REFERENCE* ////////////////////	
				Statement createGroupTable= conn.createStatement();	
				createGroupTable.execute("CREATE TABLE Grupo (grupo_id INTEGER,  grupo varchar(60),"
				+ "primary key(grupo_id));");
				System.out.println("group Table Created");
				
				
//				Statement createGroupTable= conn.createStatement();	
//				createGroupTable.execute("CREATE TABLE Group (group_id INTEGER,  group varchar(60),"
//				+ "primary key(group_id));");
//				System.out.println("group Table Created");
				
///////////////TODO system variables.. payroll batch, system version,
				Statement createSystemVar = conn.createStatement();
				createSystemVar.execute("CREATE TABLE SystemVar (system_id INTEGER, system_version varchar(60), payrollBatch varchar(60),"
						+ "primary key(system_id)"
						+ ")");
				
////////////////Table LatestUPdates ////////////////////////					
				Statement createLatestUpdatesTable= conn.createStatement();	
				createLatestUpdatesTable.execute("CREATE TABLE LatestUpdate (update_id INTEGER,  date varchar(60),"
						+ "detail varchar(60), creator varchar(60),"
						+ "primary key(update_id));");
				System.out.println("department LatestUpdateTable Created");	
				
////////////////Table JobVacancies ////////////////////////					
				Statement createVacanciesTable= conn.createStatement();	
				createVacanciesTable.execute("CREATE TABLE JobVacancies (vacancies_id INTEGER,  vacant varchar(60),"
						+ "vacantPosition varchar(60), department varchar(60), dateCreated varchar(60),createdBy varchar(60),"
				+ "primary key(vacancies_id),"
				+ "FOREIGN KEY (department) REFERENCES Department(department_id));");
				System.out.println("department Table Created");	
				
////////////////Table EmployeeSchedule ////////////////////////					
				Statement createEmployeeScheduleTable = conn.createStatement();	
				createEmployeeScheduleTable.execute("CREATE TABLE EmployeeScheduleTable (empShed_id INTEGER,  Employee_Number varchar(60),"
				+ "schedPeriod varchar(60), Day1 varchar(60), Day2 varchar(60),Day3 varchar(60),"
				+ "Day4 varchar(60), Day5 varchar(60), Day6 varchar(60),Day7 varchar(60),"
				+ "Day8 varchar(60), Day9 varchar(60), Day10 varchar(60),Day11 varchar(60),"
				+ "Day12 varchar(60), Day13 varchar(60), Day14 varchar(60),Day15 varchar(60),"
				+ "Day16 varchar(60), Day17 varchar(60), Day18 varchar(60),Day19 varchar(60),"
				+ "Day20 varchar(60), Day21 varchar(60), Day22 varchar(60),Day23 varchar(60),"
				+ "Day24 varchar(60), Day25 varchar(60), Day26 varchar(60),Day27 varchar(60),Day28 varchar(60),"
				+ "primary key(empShed_id),"
				+ "FOREIGN KEY (Employee_Number) REFERENCES PersonalDetail(Employee_Number));");
				System.out.println("department Table Created");	
				
//////////////payroll deatils ////////////////////////	
				Statement createPayrollTable= conn.createStatement();	
				createPayrollTable.execute("CREATE TABLE Payroll (payroll_id INTEGER, payroll_batch varchar(60),Employee_Number varchar(60),"
				+ "salary_id varchar(60),Hourly_Rate varchar(60),Regular_Hrs varchar(60),Regular_Pay varchar(60),"
				+ "Over_Time_Rate varchar(60),Over_Time_Hrs varchar(60),Over_Time_Pay varchar(60),"
				+ "Holdiay_Rate varchar(60),Holiday_Hour varchar(60),Holiday_Pay varchar(60),"
				+ "Ot_Holiday_Rate varchar(60),Ot_Holiday_Hour varchar(60),Ot_Holiday_Pay varchar(60),"
				+ "Allowance varchar(60),Night_Diff varchar(60),Ecola varchar(60),Other varchar(60),Bonus varchar(60),Other_Pay varchar(60),"
				+ "Sss varchar(60),PhilHealth varchar(60),PagIbig varchar(60),Insurance varchar(60),Contribution varchar(60),"
				+ "Loan varchar(60),Cash_Adv varchar(60),tax varchar(60),Deduction varchar(60),Sub_Gross varchar(60),"
				+ "Grosspay varchar(60),Netpay varchar(60),Date varchar(60),Payroll_Period varchar(60),"
				+ "primary key(payroll_id)"
				+ "FOREIGN KEY (Employee_Number) REFERENCES PersonalDetail(Employee_Number),"
				+ "FOREIGN KEY (salary_id) REFERENCES Salary_Grade(salary_id));");
				
				System.out.println("Payroll Table Created");
				
				

////////////////Table Employment deatils ////////////////////////	
				Statement createEmploymentDetailTable= conn.createStatement();	
				createEmploymentDetailTable.execute("CREATE TABLE EmploymentDetail (Employment_Id INTEGER, Employee_Number varchar(60), Position_Id INTEGER, Department_Id INTEGER,"
				+ "Manager INTEGER, Office_Location INTEGER, Salary_Id INTEGER, Joined_Month varchar(60),"
				+ "Joined_Date varchar(60),Joined_Year varchar(60),Contract_Type INTEGER, Duration varchar(60),"
				+ "Work_Set_Up INTEGER, Schedule INTEGER, Days_Per_Week INTEGER, Status varchar(60),grupo_id INTEGER,"
				+ "primary key(Employment_Id)"
				+ "FOREIGN KEY (Employment_Id) REFERENCES PersonalDetail(Employee_Number),"
				+ "FOREIGN KEY (Position_Id) REFERENCES Position(position_id),"
				+ "FOREIGN KEY (Department_Id) REFERENCES Department(department_id),"
				+ "FOREIGN KEY (Manager) REFERENCES Manager(manager_id),"
				+ "FOREIGN KEY (Office_Location) REFERENCES Office_Location(location_id),"
				+ "FOREIGN KEY (Salary_Id) REFERENCES Salary_Grade(salary_id),"
				+ "FOREIGN KEY (Contract_Type) REFERENCES Contract_Type(contract_id),"
				+ "FOREIGN KEY (Work_Set_Up) REFERENCES Work_SetUp(setup_id),"
				+ "FOREIGN KEY (Schedule) REFERENCES Schedule(schedule_id),"
				+ "FOREIGN KEY (grupo_id) REFERENCES Grupo(grupo_id),"
				+ "FOREIGN KEY (Days_Per_Week) REFERENCES Days_per_Week(NoOfDays_id));");
				
				System.out.println("employmentDetail Table Created");				
				
				
//////////////// Table personal deatils ////////////////////////	
				Statement createPersonalDetailTable= conn.createStatement();	
				createPersonalDetailTable.execute("CREATE TABLE PersonalDetail (Employee_Number varchar(60),department_id INTEGER,fName varchar(60),"
				+ "mName varchar(60),lName varchar(60),eMail varchar(60),nationality varchar(60),"
				+ "Religion varchar(60),mobileNo varchar(60),bDayMonth varchar(60), bDayDate varchar(60),"
				+ "bDayYear varchar(60),age varchar(60),gender varchar(60),civilStatus varchar(60),"
				+ "address varchar(60),region varchar(60),province varchar(60),cityMunicipality varchar(60),"
				+ "barangay varchar(60),"
				+ "primary key(Employee_Number)"
				+ "FOREIGN KEY (department_id)"
				+ "REFERENCES Department(department_id));");
				
				System.out.println("User Table Created");
				
				insertDefaultData();
				populate();
				}
				
		
				
}

	
	public HashMap<String, Integer> getCount() throws SQLException {
		getConnection();
		int dept1=0,dept2=0,dept3=0,dept4 = 0, dept5 =0,  dept6=0, dept7=0,all = 0;
		Statement statement= conn.createStatement();
		ResultSet demoRS = statement.executeQuery("SELECT department_id FROM EmploymentDetail;");
		
		while(demoRS.next()) {
			switch(demoRS.getString(1)) {
			case "1":dept1++;
			break;
			case "2":dept2++;
			break;
			case "3":dept3++;
			break;
			case "4":dept4++;
			break;
			case "5":dept5++;
			break;
			case "6":dept6++;
			break;
			case "7":dept7++;
			break;
			}
		}
		
		count.put("dept1", dept1);
		count.put("dept2", dept2);
		count.put("dept3", dept3);
		count.put("dept4", dept4);
		count.put("dept5", dept5);
		count.put("dept6", dept6);
		count.put("dept7", dept7);
		
		return count;
	}
	
	public void getData(HashMap allFields) throws SQLException {
		verifiedData = allFields;
		//fdsafdsafdsa.sqliteDb.conn.close();
		insertToPersonalDetails(verifiedData);
		insertToIdList();
		insertToBeneficiaries();
		insertToEmployentDetail(verifiedData);
	}
	
	public void insertDefaultData() throws SQLException {
	
		PreparedStatement insertToDepartment = conn.prepareStatement("INSERT INTO Department values(?,?);");
		//insertToDepartment.setString(1, "dept1");
		insertToDepartment.setString(2, "Human Resources");
		insertToDepartment.addBatch();
		//insertToDepartment.setString(1, "dept2");
		insertToDepartment.setString(2, "Information Technology");
		insertToDepartment.addBatch();
		//insertToDepartment.setString(1, "dept3");
		insertToDepartment.setString(2, "Accounting & Finance");
		insertToDepartment.addBatch();
		//insertToDepartment.setString(1, "dept4");
		insertToDepartment.setString(2, "Marketing");
		insertToDepartment.addBatch();
		insertToDepartment.setString(2, "Research and Development");
		insertToDepartment.addBatch();
		insertToDepartment.setString(2, "Production");
		insertToDepartment.addBatch();
		insertToDepartment.setString(2, "Managerial");
		insertToDepartment.addBatch();
		insertToDepartment.executeBatch();
		PreparedStatement insertToPosition = conn.prepareStatement("INSERT INTO Position values(?,?);");
		//insertToPosition.setString(1, "post1");
		insertToPosition.setString(2, "Manager");
		insertToPosition.addBatch();
		//insertToPosition.setString(1, "post1");
		insertToPosition.setString(2, "Supervisor");
		insertToPosition.addBatch();
		//insertToPosition.setString(1, "post2");
		insertToPosition.setString(2, "Assistant Supervisor");
		insertToPosition.addBatch();
		//insertToPosition.setString(1, "post3");
		insertToPosition.setString(2, "Team Leader");
		insertToPosition.addBatch();
		//insertToPosition.setString(1, "post4");
		insertToPosition.setString(2, "Member");
		insertToPosition.addBatch();
		insertToPosition.executeBatch();
		PreparedStatement insertToManager = conn.prepareStatement("INSERT INTO Manager values(?,?);");
		//insertToManager.setString(1, "mgr1");
		insertToManager.setString(2, "Manager 1");
		insertToManager.addBatch();
		//insertToManager.setString(1, "mgr2");
		insertToManager.setString(2, "Manager 2");
		insertToManager.addBatch();
		//insertToManager.setString(1, "mgr3");
		insertToManager.setString(2, "Manager 3");
		insertToManager.addBatch();
		//insertToManager.setString(1, "mgr4");
		insertToManager.setString(2, "Manager 4");
		insertToManager.addBatch();
		insertToManager.setString(2, "Manager 5");
		insertToManager.addBatch();
		insertToManager.setString(2, "Manager 6");
		insertToManager.addBatch();
		insertToManager.setString(2, "Manager 7");
		insertToManager.addBatch();
		insertToManager.setString(2, "Manager 8");
		insertToManager.addBatch();
		insertToManager.executeBatch();
		PreparedStatement insertToSalaryGrade = conn.prepareStatement("INSERT INTO Salary_Grade values(?,?,?);");
		//insertToSalaryGrade.setString(1, "slrgrd1");
		insertToSalaryGrade.setString(2, "Salary Grade 1");
		insertToSalaryGrade.setString(3, "15000");
		insertToSalaryGrade.addBatch();
		//insertToSalaryGrade.setString(1, "slrgrd2");
		insertToSalaryGrade.setString(2, "Salary Grade 2");
		insertToSalaryGrade.setString(3, "18000");
		insertToSalaryGrade.addBatch();
		//insertToSalaryGrade.setString(1, "slrgrd3");
		insertToSalaryGrade.setString(2, "Salary Grade 3");
		insertToSalaryGrade.setString(3, "21000");
		insertToSalaryGrade.addBatch();
		//insertToSalaryGrade.setString(1, "slrgrd4");	
		insertToSalaryGrade.setString(2, "Salary Grade 4");
		insertToSalaryGrade.setString(3, "24000");
		insertToSalaryGrade.addBatch();
		insertToSalaryGrade.setString(2, "Salary Grade 5");
		insertToSalaryGrade.setString(3, "28000");
		insertToSalaryGrade.addBatch();
		insertToSalaryGrade.executeBatch();
		PreparedStatement insertToWorkSetup = conn.prepareStatement("INSERT INTO Work_SetUp values(?,?);");
		//insertToWorkSetup.setString(1, "wfh");
		insertToWorkSetup.setString(2, "Work From Home");
		insertToWorkSetup.addBatch();
		//insertToWorkSetup.setString(1, "onsite");
		insertToWorkSetup.setString(2, "On-Site");
		insertToWorkSetup.addBatch();
		//insertToWorkSetup.setString(1, "hybrid");
		insertToWorkSetup.setString(2, "hybrid");
		insertToWorkSetup.addBatch();
		insertToWorkSetup.executeBatch();
		PreparedStatement insertToSchedule = conn.prepareStatement("INSERT INTO Schedule values(?,?,?);");
		//insertToSchedule.setString(1, "slrgrd1");
		insertToSchedule.setString(2, "Morning");
		insertToSchedule.addBatch();
		//insertToSchedule.setString(1, "slrgrd2");
		insertToSchedule.setString(2, "Night");
		insertToSchedule.addBatch();
		//insertToSchedule.setString(1, "slrgrd3");
		insertToSchedule.setString(2, "Graveyard");
		insertToSchedule.addBatch();
		//insertToSchedule.setString(1, "slrgrd4");	//TODO tatanggaling to switching
		insertToSchedule.setString(2, "Swithching");
		insertToSchedule.addBatch();
		insertToSchedule.executeBatch();
		
		PreparedStatement insertToContract = conn.prepareStatement("INSERT INTO Contract_Type values(?,?,?);");
		//insertToSchedule.setString(1, "slrgrd1");
		insertToContract.setString(2, "Permanent");
		insertToContract.addBatch();
		//insertToContract.setString(1, "slrgrd2");
		insertToContract.setString(2, "Term");
		insertToContract.addBatch();
		//insertToContract.setString(1, "slrgrd3");
		insertToContract.setString(2, "Project");
		insertToContract.addBatch();
		//insertToContract.setString(1, "slrgrd4");	
		insertToContract.setString(2, "Seasonal");
		insertToContract.addBatch();
		insertToContract.setString(2, "Casual");
		insertToContract.addBatch();
		insertToContract.executeBatch();
		
		PreparedStatement insertToDaysPerWeek = conn.prepareStatement("INSERT INTO Days_per_Week values(?,?);");
		//insertToSchedule.setString(1, "slrgrd1");
		insertToDaysPerWeek.setString(2, "5 Days");
		insertToDaysPerWeek.addBatch();
		//insertToDaysPerWeek.setString(1, "slrgrd2");
		insertToDaysPerWeek.setString(2, "6 Days");
		insertToDaysPerWeek.addBatch();
		insertToDaysPerWeek.executeBatch();
		
		PreparedStatement insertToLocation = conn.prepareStatement("INSERT INTO Office_Location values(?,?);");
		//insertToSchedule.setString(1, "slrgrd1");
		insertToLocation.setString(2, "Location 1");
		insertToLocation.addBatch();
		//insertToDaysPerWeek.setString(1, "slrgrd2");
		insertToLocation.setString(2, "Location 2");
		insertToLocation.addBatch();
		insertToLocation.setString(2, "Location 3");
		insertToLocation.addBatch();
		insertToLocation.setString(2, "Location 4");
		insertToLocation.addBatch();
		insertToLocation.setString(2, "Location 5");
		insertToLocation.addBatch();
		insertToLocation.executeBatch();
		
		PreparedStatement insertToSysVar = conn.prepareStatement("INSERT INTO SystemVar values(?,?,?);");

		insertToSysVar.setString(2, "V.1");
		insertToSysVar.setString(3, "1");
		insertToSysVar.execute();
		
		PreparedStatement insertToGrupo = conn.prepareStatement("INSERT INTO Grupo values(?,?);");
		insertToGrupo.setString(2, "Group 1");
		insertToGrupo.addBatch();
		insertToGrupo.setString(2, "Group 2");
		insertToGrupo.addBatch();
		insertToGrupo.setString(2, "Group 3");
		insertToGrupo.addBatch();
		insertToGrupo.setString(2, "Group 4");
		insertToGrupo.addBatch();
		insertToGrupo.setString(2, "Group 5"); //TODO tatanggling to group 5
		insertToGrupo.addBatch();
		insertToGrupo.executeBatch();
	
		conn.close();
		
	}
	
	public void insertToPersonalDetails(HashMap<String,String> data) throws SQLException {
		
		getConnection();
		
		PreparedStatement statement = conn.prepareStatement("INSERT INTO PersonalDetail values(?,?,?,?,?,?,?,"
																+ "?,?,?,?,?,?,?,?,?,?,?,?,?);");
		statement.setString(1, data.get("employeeNo"));
		statement.setString(2, data.get("department")); //FK Department
		statement.setString(3, data.get("firstName"));
		statement.setString(4, data.get("middleName"));
		statement.setString(5, data.get("lastName"));
		statement.setString(6, data.get("email"));
		statement.setString(7, data.get("nationality"));
		statement.setString(8, data.get("religion"));
		statement.setString(9, data.get("mobile"));
		statement.setString(10, data.get("bDayMonth"));
		statement.setString(11, data.get("bDayDate"));
		statement.setString(12, data.get("bDayYear"));
		statement.setString(13, data.get("age"));
		statement.setString(14, data.get("gender"));
		statement.setString(15, data.get("civilCombo"));
//		statement.setString(16, data.get("address"));
//		statement.setString(17, data.get("region"));
//		statement.setString(18, data.get("province"));
//		statement.setString(19, data.get("city"));
//		statement.setString(20, data.get("brgy"));
		statement.setString(16, "address");
		statement.setString(17, "region");
		statement.setString(18, "province");
		statement.setString(19, "city");
		statement.setString(20, "brgy");
		statement.execute();
	
		
		LocalDate dateNow = LocalDate.now();
		data.put("dateLatestUpdate", dateNow.toString());
		insertToLatestUpdates(data);
		System.out.println("personal details inserted");
	}
	
	void insertToEmployentDetail(HashMap<String,String> data) throws SQLException {
		getConnection();
		
		PreparedStatement statement = conn.prepareStatement("INSERT INTO EmploymentDetail values(?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?);");
		//statement.setString(1, verifiedData.get());
		statement.setString(2, data.get("employeeNo")); //FK Department
		statement.setString(3, data.get("position"));
		statement.setString(4, data.get("department"));
		statement.setString(5, data.get("manager"));
		statement.setString(6, data.get("location"));
		statement.setString(7, data.get("salaryGrade"));
		statement.setString(8, data.get("joinedMonth"));
		statement.setString(9, data.get("joinedDate"));
		statement.setString(10, data.get("joinedYear"));
		statement.setString(11, data.get("contract"));
		statement.setString(12, data.get("duration"));
		statement.setString(13, data.get("workSetUp"));
		statement.setString(14, data.get("schedule"));
		statement.setString(15, data.get("daysPerweek"));
		statement.setString(16, "Active");
		statement.setString(17, data.get("group"));
		statement.execute();

System.out.println("personal details inserted");
		
		
	}
	
void insertToIdList() throws SQLException {
		
		getConnection();
		
		PreparedStatement statement = conn.prepareStatement("INSERT INTO Id_List values(?,?,?,?,?,?,?,?,?);");
		//statement.setString(1, "newnewnew");
		statement.setString(2, verifiedData.get("employeeNo")); //FK employee Id
		statement.setString(3, verifiedData.get("sss"));
		statement.setString(4, verifiedData.get("philHealth"));
		statement.setString(5, verifiedData.get("pagIbig"));
		statement.setString(6, verifiedData.get("umid"));
		statement.setString(7, verifiedData.get("passPort"));
		statement.setString(8, verifiedData.get("license"));
		statement.setString(9, verifiedData.get("prc"));
		statement.execute();
		
		System.out.println("id list inserted");
	}

void insertToBeneficiaries() throws SQLException {
	getConnection();
	PreparedStatement statement = conn.prepareStatement("INSERT INTO Beneficiaries values(?,?,?,?,?,?);");
	String[] ee = {verifiedData.get("b1Name"),verifiedData.get("b1Address"),verifiedData.get("b1Contact"),verifiedData.get("b1Relation")
			,verifiedData.get("b2Name"),verifiedData.get("b2Address"),verifiedData.get("b2Contact"),verifiedData.get("b2Relation")};
	
	for (int x=1;x<=3;x++) {
		statement.setString(2, verifiedData.get("employeeNo"));
		statement.setString(3, verifiedData.get("b"+x+"Name"));
		statement.setString(4, verifiedData.get("b"+x+"Address"));
		statement.setString(5, verifiedData.get("b"+x+"Contact"));
		statement.setString(6, verifiedData.get("b"+x+"Relation"));
		statement.execute();
	}
	
}

void insertToPayroll(HashMap payrollDetails) throws SQLException {
	getConnection();
	payroll = payrollDetails;
	PreparedStatement statement = conn.prepareStatement("INSERT INTO Payroll values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

	statement.setString(2, payroll.get("payrollBatch"));
	statement.setString(3, payroll.get("employeeNumber"));
	statement.setString(4, payroll.get("salaryId")); 
	statement.setString(5, payroll.get("hourlyRate"));
	statement.setString(6, payroll.get("regularHours"));
	
	statement.setString(7, payroll.get("regularPay"));
	statement.setString(8, payroll.get("otRate"));
	statement.setString(9, payroll.get("otHours"));
	statement.setString(10, payroll.get("otPay"));
	statement.setString(11, payroll.get("holidayRate"));
	
	statement.setString(12, payroll.get("holidayHours"));
	statement.setString(13, payroll.get("holidayPay"));
	statement.setString(14, payroll.get("otHolidayRate"));
	statement.setString(15, payroll.get("otHolidayHours"));
	statement.setString(16, payroll.get("otHolidayPay"));
	
	statement.setString(17, payroll.get("allowance"));
	statement.setString(18, payroll.get("nightDiff"));

	statement.setString(19, payroll.get("ecola"));
	statement.setString(20, payroll.get("other"));
	
	statement.setString(21, payroll.get("bonus"));
	statement.setString(22, payroll.get("otherPay"));
	statement.setString(23, payroll.get("sss"));
	statement.setString(24, payroll.get("philHealth"));
	statement.setString(25, payroll.get("pagIbig"));
	
	statement.setString(26, payroll.get("insurance"));
	statement.setString(27, payroll.get("contribution"));
	statement.setString(28, payroll.get("loan"));
	statement.setString(29, payroll.get("cashAdvance"));
	statement.setString(30, payroll.get("tax"));
	
	statement.setString(31, payroll.get("deduction"));
	statement.setString(32, payroll.get("subGross"));
	statement.setString(33, payroll.get("grossPay"));
	statement.setString(34, payroll.get("netPay"));
	statement.setString(35, payroll.get("payrollPeriod"));
	statement.setString(36, ""); //TODO date
	statement.execute();
	System.out.println("added");


}
void insertToVaccancies(HashMap <String,String> data) throws SQLException {
	getConnection();
	PreparedStatement statement = conn.prepareStatement("INSERT INTO JobVacancies values(?,?,?,?,?,?);");

		statement.setString(2, data.get("no.OfVacantPos"));
		statement.setString(3, data.get("vacantPosition"));
		statement.setString(4, data.get("department"));
		statement.setString(5, data.get("dateCreated"));
		statement.setString(6, data.get("createdBy"));
		statement.execute();
}
void insertToLatestUpdates(HashMap <String,String> data) throws SQLException {
	getConnection();
	PreparedStatement statement = conn.prepareStatement("INSERT INTO LatestUpdate values(?,?,?,?);");
	String detail="";
		statement.setString(2, data.get("dateLatestUpdate"));
		detail = data.get("firstName")+" "+data.get("middleName").substring(0, 1)+". "+data.get("lastName");
		statement.setString(3, detail);
		statement.setString(4, "Angelo");
		statement.execute();
}

void insertToEmpSchedule(HashMap <String,String> data) throws SQLException {
	getConnection();
	PreparedStatement statement = conn.prepareStatement("INSERT INTO EmployeeScheduleTable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
//31
		statement.setString(2, data.get("employeeNo"));
		statement.setString(3, data.get("period"));
		for(int x=0;x<28;x++) {
			statement.setString(x+4, data.get("Day"+(x+1)));
		}
		statement.execute();
}
void insertToListOfSchedulePeriod(HashMap <String,String> data) throws SQLException { //TODO create table nito
	getConnection();
	System.out.println(data.get("period")+"peeeeeeeeeeeeriod");
	PreparedStatement statement = conn.prepareStatement("INSERT INTO ListOfSchedulePeriod values(?,?);");
		statement.setString(2, data.get("period"));	
		statement.execute();
}

public ResultSet search(String query) throws SQLException {
	getConnection();
	PreparedStatement statement = conn.prepareStatement(query);
//	statement.executeQuery();
	rs = statement.executeQuery();;
	System.out.println(query);
	
//	Statement stmt = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//	ResultSet rs = stmt.executeQuery (query);

return rs;

}

public void setSystemVar(int payrollBatch) throws SQLException {
	getConnection();
	PreparedStatement statement = conn.prepareStatement("UPDATE SystemVar SET payrollBatch =\"" +payrollBatch+ "\" WHERE system_id =\"1\"");
	statement.execute();
}

public ResultSet getSystemVar() throws Exception {
	getConnection();
	String systemQuery = "SELECT * FROM SystemVar WHERE system_id = \"1\"";
	ResultSet systemRs;
	PreparedStatement statement = conn.prepareStatement(systemQuery);
	statement.executeQuery();
	systemRs = statement.executeQuery();;
return systemRs;
	
}

public void populate() throws SQLException {
	
//	populateData.put("employeeNo","");
//	populateData.put("department",); //FK Department
//	populateData.put("firstName",);================
//	populateData.put("middleName",);============
//	populateData.put("lastName",);=============
//	populateData.put("email",);=============
//	populateData.put("nationality",);================
//	populateData.put("religion",);==========
//	populateData.put("mobile",);==========
//	populateData.put("bDayMonth",);======
//	populateData.put("bDayDate",);======
//	populateData.put("bDayYear",);=========
//	populateData.put("age",);=========
//	populateData.put("gender",);=====================================
//	populateData.put("civilCombo",);=========
//	populateData.put("address",);
//	populateData.put("region",);
//	populateData.put("province",);
//	populateData.put("city",);
//	populateData.put("brgy",);
	
	String[] nameMale= new String[] {"Jude","Adan","Mekhi","Wesley","Case","Toby","James","Ezekiel","Carsen","Edward","Ibrahim","Howard","Emmett","Dante","Coleman","Ayden","Zander","Gideon","Eliezer",
	"Jadyn","Ishaan","Nash","Titus","Curtis","Ryder","Johnathan","Kendall","Braylen","Fabian","Johnathon","Larry","Oswaldo","Uriah","Ezequiel","Richard",
	"Alexis","Barrett","Valentin","Addison","Deandre","Dale","Dangelo","Allen","Rudy","Yosef","Talon","Jefferson","Mohamed","Deven","Muhammad"};
	
	String[] nameFemale = new String[] {"Alice","Annabelle","June","Kylie","Emily","Breanna","Dalia","Jaida","Kaydence","Yaretzi","Xiomara","Braelyn","Annalise","Aaliyah",
			"Saniyah","Sydney","Adriana","Angela","Jazlynn","Mina","Jaylee","Heidi","Zara","Sienna","Tamara","Anastasia","Kimora","Sarai","Magdalena",
			"Heather","Jazmyn","Mckayla","Areli","Meadow","Kierra","Monica","Kaylie","Laylah","Mya","Tiara","Mayra","Selena","Lesly","Vanessa",
			"Jamie","Marely","Emery","Serenity","Emilie","Kara"};
	
	String[] lastName = new String[] {	"Jennings","Fernandez","Buchanan","Flowers","Welch","Briggs","Holland","Palmer","Lynch","Garner","Stephens","Blanchard","Elliott",
			"Maxwell","Alvarado","Craig","Landry","Farmer","Robles","Wilkinson","Hess","Castro","Duke","Cross","Buck","Yu","Sosa","Oneill","Dougherty",
			"Tucker","Durham","Savage","Hooper","Stafford","Frost","Morrow","Hickman","Allison","Byrd","Barton","Spears","Ramirez","Ware","Terrell",
			"Ward","Gomez","Flores","Bishop","Mcknight","Stephenson","Simon","Vaughn","Lindsey","Frey","House","Nunez","Mccoy","Marshall","Powers",
			"Jensen","Case","Mitchell","Adkins","Roberts","Rodriguez","Francis","Marks","Hurst","Farrell","David","Boyd","Lawrence","Waller","Mcclure",
			"Mathews","Payne","Pollard","Merritt","Warren","Santos","Wiggins","Roberson","Humphrey","Rich","Wall","Wong","Brock","Conway","Vincent",
			"Eaton","Hughes","Robertson","Logan","Sparks","Bailey","Barron","Hunter","Duarte","Jones","Leonard"};
	String[] nationality = new String[] {
			"Afghan","Albanian","Algerian","American","Andorra","Angolan","Antiguans","Argentinean","Armenian","Australian","Austrian","Azerbaijani",
			"Bahamian","Bahraini","Bangladeshi","Barbadian","Barbudans","Batswana","Belarusian","Belgian","Belizean","Beninese","Bhutanese",
			"Bolivian","Bosnian","Brazilian","British","Bruneian","Bulgarian","Burkinabe","Burmese","Burundian","Cambodian","Cameroonian",
			"Canadian","Cape Verdean","Central African","Chadian","Chilean","Chinese","Colombian","Comoran","Congolese","Costa Rican","Croatian",
			"Cuban","Cypriot","Czech","Danish","Djibouti","Dominican","Dutch","East Timorese","Ecuadorean","Egyptian","Emirian","Equatorial Guinean",
			"Eritrean","Estonian","Ethiopian","Fijian","Filipino","Finnish","French","Gabonese","Gambian","Georgian","German","Ghanaian",
			"Greek","Grenadian","Guatemalan","Guinea-Bissauan","Guinean","Guyanese","Haitian","Herzegovinian","Honduran","Hungarian","I-Kiribati",
			"Icelander","Indian","Indonesian","Iranian","Iraqi","Irish","Israeli","Italian","Ivorian","Jamaican","Japanese","Jordanian",
			"Kazakhstani","Kenyan","Kittian and Nevisian","Kuwaiti","Kyrgyz","Laotian","Latvian","Lebanese","Liberian","Libyan",
			"Liechtensteiner","Lithuanian","Luxembourger","Macedonian","Malagasy","Malawian","Malaysian","Maldivian","Malian","Maltese",
			"Marshallese","Mauritanian","Mauritian","Mexican","Micronesian","Moldovan","Monacan","Mongolian","Moroccan","Mosotho","Motswana",
			"Mozambican","Namibian","Nauruan","Nepalese","New Zealander","Ni-Vanuatu","Nicaraguan","Nigerian","Nigerien","North Korean",
			"Portuguese","Qatari","Romanian","Russian","Rwandan","Saint Lucian","Salvadoran","Samoan","San Marinese","Sao Tomean","Saudi",
			"Scottish","Senegalese","Serbian","Seychellois","Sierra Leonean","Singaporean","Slovakian","Slovenian","Solomon Islander",
			"Somali","South African","South Korean","Spanish","Sri Lankan","Sudanese","Surinamer","Swazi","Swedish","Swiss","Syrian","Taiwanese",
			"Tajik","Tanzanian","Thai","Togolese","Tongan","Trinidadian or Tobagonian","Tunisian","Turkish","Tuvaluan","Ugandan","Ukrainian",
			"Uruguayan","Uzbekistani","Venezuelan","Vietnamese","Welsh","Yemenite","Zambian","Zimbabwean"};
	String[] religion = new String[] {
			"Catholic","Born Again","Islam","Evangelical","Iglesia Ni Cristo","Protestant","Aglipayan","Seventh-day Adventist",
			"Baptist","Jehovah's Witness","Ang Dating Daan","Hinduism","Buddhism"};
	
	String[] mobilePrefix = new String[] {"0904","0905","0906","0907","0908","0909","0910","0911","0912","0913",
			"0914","0915","0916","0917","0918","0919","0920","0921","0922","0923","0924","0925","0926","0927","0928",
			"0929","0930","0931","0932","0933","0934","0935","0936","0937","0938","0939","0940","0941","0942","0943",
			"0944","0945","0946","0947","0948","0949","0950","0951","0953","0954","0955","0956","0961","0963","0965",
			"0966","0967","0968","0970","0973","0974","0975","0976","0977","0978","0979","0981","0989","0991","0992",
			"0993","0994","0995","0996","0997","0998","0999","0813","0817","0895","0896","0897","0898"};
	String[] month = new String[] {"January","February","March","April","May","June","July","August","September",
			"October","November","December"};
	int monthINT;
	String[] civil = new String[] {"Single","Married","Divorced","Seperated","Widowed"};
	int emp=0;
	int dpt1=0;
	int dpt2=0;
	int dpt3=0;
	int dpt4=0;
	int dpt5=0;
	//////////////////////////////////FOR LOOP populate///////////////////////////////////////
	//int loop=	(int)Math.floor(Math.random()*(100-1+1)+1);
	int loop = 252;
	int random;
	for(int x=0;x<loop;x++) {
		System.out.println("populate");
	//gender
	 random=	(int)Math.floor(Math.random()*(2-1+1)+1);
	if(random==1) {
		populateData.put("gender","Male");
	}
	else {
		populateData.put("gender","Female");
	}

	///name
	random=	(int)Math.floor(Math.random()*(49-0+1)+0);
	if(populateData.get("gender").equals("Male")) {
		
		populateData.put("firstName",nameMale[random]);
	}
	else {
		System.out.println("female");
		populateData.put("firstName",nameFemale[random]);
	}
	random=	(int)Math.floor(Math.random()*(99-0+1)+0);
	populateData.put("middleName",lastName[random]);
	random=	(int)Math.floor(Math.random()*(99-0+1)+0);
	populateData.put("lastName",lastName[random]);
	//email
	populateData.put("email",populateData.get("lastName").toLowerCase()+populateData.get("firstName").toLowerCase()+"@gmail.com");
	//nationality
	random=	(int)Math.floor(Math.random()*(183-0+1)+0);
	populateData.put("nationality",nationality[random]);
	//religion
	random=	(int)Math.floor(Math.random()*(12-0+1)+0);
	populateData.put("religion",religion[random]);
	//mobile
	String mob="";
	random=	(int)Math.floor(Math.random()*(82-0+1)+0);
	mob=mobilePrefix[random];
	random=	(int)Math.floor(Math.random()*(9999999-1000000+1)+1000000);
	mob=mob+random;
	populateData.put("mobile",mob);
	//System.out.println(populateData.get("mobile"));
	//bday
	random=	(int)Math.floor(Math.random()*(11-0+1)+0);
	populateData.put("bDayMonth", month[random]);
	monthINT = random+1;
	//System.out.println(month[random]);
	
	if(populateData.get("bDayMonth").equals("April")||
			populateData.get("bDayMonth").equals("June")||
			populateData.get("bDayMonth").equals("September")||
			populateData.get("bDayMonth").equals("November")
			) {
		random=	(int)Math.floor(Math.random()*(30-1+1)+1);
		
		}
	else if(populateData.get("bDayMonth").equals("February"))
			 {
		random=	(int)Math.floor(Math.random()*(29-1+1)+1);
		
		}
	else {
		random=	(int)Math.floor(Math.random()*(31-1+1)+1);
	}
	populateData.put("bDayDate", String.valueOf(random));
	
	random=	(int)Math.floor(Math.random()*(2004-1950+1)+1950);
	populateData.put("bDayYear", String.valueOf(random));
	//System.out.println(populateData.get("bDayYear"));
	
	//age
	LocalDate today = LocalDate.now();
	LocalDate birthday=null;
	try {
		 birthday = LocalDate.of(Integer.valueOf(populateData.get("bDayYear")), monthINT, Integer.valueOf(populateData.get("bDayDate")));	
	}
	catch(Exception e){
		birthday = LocalDate.of(Integer.valueOf(populateData.get("bDayYear"))+1, monthINT, Integer.valueOf(populateData.get("bDayDate")));	
		System.out.println("NAG LEAP YEAR");
	}
	
	
	Period period = Period.between(birthday, today);
//	System.out.println(period);
	populateData.put("age",String.valueOf(period.getYears()));
	//System.out.println(populateData.get("age"));
	//civil
	random=	(int)Math.floor(Math.random()*(4-0+1)+0);
	populateData.put("civilCombo",civil[random]);
	//System.out.println(populateData.get("civilCombo"));
	//////////////////////////////////////////employment
	//position
	//random pos
//	random=	(int)Math.floor(Math.random()*(4-0+1)+0);
//	populateData.put("position",String.valueOf(random+1));
	if (x<8) {
		//TODO managerial position 7
		populateData.put("position",String.valueOf(1));
		populateData.put("department","7");
		if(x<=1) {
			populateData.put("group","1");
		}
		else if(x>=2 && x<=3) {
			populateData.put("group","2");
		}
		else if(x>=4 && x<=5) {
			populateData.put("group","3");
		}
		else  {//6,7
			populateData.put("group","4");
		}
	}
	else if(x>=8 && x<=15) {
		populateData.put("position",String.valueOf(2));
		populateData.put("department","7");
		if(x==8 || x==9) {
			populateData.put("group","1");
		}
		else if(x==10 || x==11) {
			populateData.put("group","2");
		}
		else if(x==12 || x==13) {
			populateData.put("group","3");
		}
		else {//14,15
			populateData.put("group","4");
		}
	}
	else if(x>=16 && x<=23) {
		populateData.put("position",String.valueOf(3));
		populateData.put("department","7");
		if(x==16 || x==17) {
			populateData.put("group","1");
		}
		else if(x==18 || x==19) {
			populateData.put("group","2");
		}
		else if(x==20 || x==21) {
			populateData.put("group","3");
		}
		else {//22-23
			populateData.put("group","4");
		}
	}
	else if(x>=24 && x<=51) {//28
		populateData.put("position",String.valueOf(4));
		if (x>=24 && x<=27) { //4hr
			populateData.put("department","1");
			if(x==24) {
			populateData.put("group","1");
			}
			else if(x==25) {
			populateData.put("group","2");
			}
			else if(x==26) {
				populateData.put("group","3");
				}
			else {//27------------------->mali
			populateData.put("group","4");
			}
		}
		else if (x>=28 && x<=31) { //4it
			populateData.put("department","2");
			if(x==28) {
			populateData.put("group","1");
			}
			else if(x==29) {
			populateData.put("group","2");
			}
			else if(x==30) {
				populateData.put("group","3");
				}
			else {//31
			populateData.put("group","4");
			}
		}
		else if (x>=32 && x<=35) { //4anf
			populateData.put("department","3");
			if(x==32) {
			populateData.put("group","1");
			}
			else if(x==33) {
			populateData.put("group","2");
			}
			else if(x==34) {
				populateData.put("group","3");
				}
			else {//35
			populateData.put("group","4");
			}
		}
		else if (x>=36 && x<=39) { //4mktg
			populateData.put("department","4");
			if(x==36) {
			populateData.put("group","1");
			}
			else if(x==37) {
			populateData.put("group","2");
			}
			else if(x==38) {
				populateData.put("group","3");
				}
			else {//39
			populateData.put("group","4");
			}
		}
		else if (x>=40 && x<=43) { //4rnd
			populateData.put("department","5");
			if(x==40) {
			populateData.put("group","1");
			}
			else if(x==41) {
			populateData.put("group","2");
			}
			else if(x==42) {
				populateData.put("group","3");
				}
			else {//43
			populateData.put("group","4");
			}
		}
		else  { //prod44
			populateData.put("department","6");
			if(x==44 || x==45) {
			populateData.put("group","1");
			}
			else if(x==46 || x==47) {
			populateData.put("group","2");
			}
			else if(x==48 || x==49) {
				populateData.put("group","3");
				}
			else {
			populateData.put("group","4");
			}//ends 50-51
		}
		
	}
	else {
		populateData.put("position",String.valueOf(5));
		if (x>=52 && x<=71) { //20hr
			populateData.put("department","1");
			if(x>=52 && x<=56) {
			populateData.put("group","1");
			}
			else if(x>=57 && x<=61) {
			populateData.put("group","2");
			}
			else if(x>=62 && x<=66) {
				populateData.put("group","3");
				}
			else {//67-71
			populateData.put("group","4");
			}
		}
		else if (x>=72 && x<=111) { //40it
			populateData.put("department","2");
			if(x>=72 && x<=81) {
			populateData.put("group","1");
			}
			else if(x>=82 && x<=91) {
			populateData.put("group","2");
			}
			else if(x>=92 && x<=101) {
			populateData.put("group","3");
			}
			else {//102-111
			populateData.put("group","4");
			}
		}
		else if (x>=112 && x<=131) { //20anf
			populateData.put("department","3");
			if(x>=112 && x<=116) {
			populateData.put("group","1");
			}
			else if(x>=117 && x<=121) {
			populateData.put("group","2");
			}
			else if(x>=122 && x<=126) {
			populateData.put("group","3");
			}
			else {//127-131
			populateData.put("group","4");
			}
		}
		else if (x>=132 && x<=151) { //20mktg
			populateData.put("department","4");
			if(x>=132 && x<=136) {
			populateData.put("group","1");
			}
			else if(x>=137 && x<=141) {
			populateData.put("group","2");
			}
			else if(x>=142 && x<=146) {
			populateData.put("group","3");
			}
			else {//147-151
			populateData.put("group","4");
			}
		}
		else if (x>=152 && x<=171) { //20rnd
			populateData.put("department","5");
			if(x>=152 && x<=156) {
			populateData.put("group","1");
			}
			else if(x>=157 && x<=161) {
			populateData.put("group","2");
			}
			else if(x>=162 && x<=166) {
			populateData.put("group","3");
			}
			else {//167-171
			populateData.put("group","4");
			}
		}
		else  { //172-251
			populateData.put("department","6");
			if(x>=172 && x<=191) {
			populateData.put("group","1");
			}
			else if(x>=192 && x<=211) {
			populateData.put("group","2");
			}
			else if(x>=212 && x<=231) {
			populateData.put("group","3");
			}
			else {//232-251
			populateData.put("group","4");
			}
		}
	}
	
	//populateEmployeeSchedule();
	//department
	String dpt="";
	String empnum="";
	//random department
//	random=	(int)Math.floor(Math.random()*(6-1+1)+1);
//	populateData.put("department",String.valueOf(random));
	
	dpt=populateData.get("department");
	if (dpt.equals("1")) {
		dpt1++;
		emp=dpt1;
	}
	else if (dpt.equals("2")) {
		dpt2++;
		emp=dpt2;
	}
	else if (dpt.equals("3")) {
		dpt3++;
		emp=dpt3;
	}
	else if (dpt.equals("4")) {
		dpt4++;
		emp=dpt4;
	}
	else {
		dpt5++;
		emp=dpt5;
	}
	
	
	empnum="dpt0"+dpt+"-"+"emp0"+emp+"-0";
	//System.out.println(empnum);
	//manager
	random=	(int)Math.floor(Math.random()*(8-1+1)+1);
	populateData.put("manager",String.valueOf(random));
	//location
	random=	(int)Math.floor(Math.random()*(4-0+1)+0);
	populateData.put("location",String.valueOf(random+1));
	//salaryGrade
	random=	(int)Math.floor(Math.random()*(4-0+1)+0);
	populateData.put("salaryGrade",String.valueOf(random+1));
	//hireDate
	random=	(int)Math.floor(Math.random()*(11-0+1)+0);
	populateData.put("joinedMonth", month[random]);
	monthINT = random+1;
	if(populateData.get("joinedMonth").equals("April")||
			populateData.get("joinedMonth").equals("June")||
			populateData.get("joinedMonth").equals("September")||
			populateData.get("joinedMonth").equals("November")
			) {
		random=	(int)Math.floor(Math.random()*(30-1+1)+1);
		
		}
	else if(populateData.get("joinedMonth").equals("February"))
			 {
		random=	(int)Math.floor(Math.random()*(29-1+1)+1);
		
		}
	else {
		random=	(int)Math.floor(Math.random()*(31-1+1)+1);
	}
	populateData.put("joinedDate", String.valueOf(random));
	
	
	random=	(int)Math.floor(Math.random()*(2004-1968+1)+1968);
	System.out.println(empnumber.toString());
	System.out.println(random);
	empnum="dpt0"+dpt+"-"+"emp0"+emp+"-0"+String.valueOf(random).substring(2);
	
	while(empnumber.contains(empnum)) {
		random=	(int)Math.floor(Math.random()*(2004-1968+1)+1968);
		empnum="dpt0"+dpt+"-"+"emp0"+emp+"-0"+String.valueOf(random).substring(2);
	}
	empnumber.add(empnum);
	System.out.println(empnumber.size());
 	populateData.put("joinedYear", String.valueOf(random));
 	
	
	//System.out.println(populateData.get("joinedYear"));
//	
//	empnum="dpt0"+dpt+"-"+"emp0"+emp+"-0";
	//empnum=empnum+populateData.get("joinedYear").substring(2);
	
	//employee number
	populateData.put("employeeNo", empnum);
	//System.out.println(populateData.get("employeeNo"));
	////contract
	random=	(int)Math.floor(Math.random()*(5-1+1)+1);
	populateData.put("contract", String.valueOf(random));
	//duration //TODO lookup table for duration!!!
	random=	(int)Math.floor(Math.random()*(5-1+1)+1);
	populateData.put("duration", String.valueOf(random));
	//work set up //TODO listner for radio button
	random=	(int)Math.floor(Math.random()*(3-1+1)+1);
	populateData.put("workSetUp", String.valueOf(random));
	//schedule
	random=	(int)Math.floor(Math.random()*(4-1+1)+1);
	populateData.put("schedule", String.valueOf(random));
	//daysper week
	random=	(int)Math.floor(Math.random()*(2-1+1)+1);
	populateData.put("daysPerweek", String.valueOf(random));



	
	
	//System.out.println(religion.length);
//	System.out.println(populateData.get("gender"));
//	System.out.println(populateData.get("firstName")+" "+populateData.get("middleName")+" "+populateData.get("lastName"));
//	System.out.println(populateData.get("email"));
//	System.out.println(populateData.get("nationality"));
//	System.out.println(populateData.get("religion"));
//	System.out.println(random);
	
	//pang gawa ng prefix array :)
//	String bobo="{";
//	for(int x=904;x<=999;x++) {
//		if(x==952) {
//			continue;
//		}
//		if(x>956 && x<961) {
//			continue;
//		}
//		if(x==962 || x==964 || x==969 || x==971 || x==972 || x==980) {
//			continue;
//		}
//		if(x>981 && x<989) {
//			continue;
//		}
//		if(x==990) {
//			continue;
//		}
//		bobo = bobo+"\"0"+x+"\",";
//		
//	}
//	bobo = bobo+"}";
//	System.out.println(bobo);
	insertToPersonalDetails(populateData);
	insertToEmployentDetail(populateData);
	//populateEmployeeSchedule();
	
	// emp Schedule
} //end of loop 189
	///////////////////////////////vacancies
	
	String[] hrPosition = new String[] {"HR Recruiting Manager","HRIS","Recruiter"}; 
	String[] itPosition = new String[] {"Support Specialist","QA Tester","Programmer","Network Engineer"}; 
	String[] afPosition = new String[] {"Finance Manager","Accountant","Auditor","Financial Analyst"};
	String[] mktgPosition = new String[] {"Promotions Manager","Marketing Specialist","Consultant","Marketing Analyst"}; 
	String[] rndPosition = new String[] {"Researcher","Coordinator"}; 
	String[] prodPosition = new String[] {"Quality Manager","Staff","Super Visor","Production Manager"}; 
	
	int newrandom2=0;
	String pos="";
	
	newrandom2 =	(int)Math.floor(Math.random()*(10-1+1)+1);
	for(int xc=0;xc<newrandom2;xc++) {
		
		newrandom2 =	(int)Math.floor(Math.random()*(10-1+1)+1);
		populateData.put("no.OfVacantPos", String.valueOf(newrandom2));
		
		newrandom2 =	(int)Math.floor(Math.random()*(6-1+1)+1);
		populateData.put("department", String.valueOf(newrandom2));
		switch(populateData.get("department")) {
		case "1":newrandom2 =	(int)Math.floor(Math.random()*(2-0+1)+0);
			pos = hrPosition[newrandom2];
		break;
		case "2":newrandom2 =	(int)Math.floor(Math.random()*(3-0+1)+0);
			pos = itPosition[newrandom2];
		break;
		case "3":newrandom2 =	(int)Math.floor(Math.random()*(3-0+1)+0);
			pos = afPosition[newrandom2];
		break;
		case "4":newrandom2 =	(int)Math.floor(Math.random()*(3-0+1)+0);
			pos = mktgPosition[newrandom2];
		break;
		case "5":newrandom2 =	(int)Math.floor(Math.random()*(1-0+1)+0);
			pos = rndPosition[newrandom2];
		break;
		case "6":newrandom2 =	(int)Math.floor(Math.random()*(3-0+1)+0);
			pos = prodPosition[newrandom2];
		break;
		}
		
		populateData.put("vacantPosition", pos);
	
		LocalDate dateNow = LocalDate.now();
		populateData.put("dateCreated",String.valueOf(dateNow));
		
		populateData.put("createdBy","Angelo");
//		statement.setString(2, data.get("no.OfVacantPos"));
//		statement.setString(3, data.get("vacantPosition"));
//		statement.setString(4, data.get("department"));
//		statement.setString(5, data.get("dateCreated"));
//		statement.setString(6, data.get("createdBy"));
//		statement.execute();
	
	insertToVaccancies(populateData);
		}
	
	

	
}

void checker(int random){
	joinedyear.add("");
}








}
	

