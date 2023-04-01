package bizsol.model;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class HomeModel {
	
	public EmployeeModel empSql = new EmployeeModel();
	Calendar calendar;
	SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss a");
	SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMM yyyy");
	SimpleDateFormat dayformat = new SimpleDateFormat("EEEE");
	String time;
	static String emp;
	DecimalFormat df = new DecimalFormat("0.0");
	public HomeModel(){
		df.setRoundingMode(RoundingMode.HALF_EVEN);
	};

	
	
	public String getTime() throws InterruptedException{
		time= timeformat.format(calendar.getInstance().getTime()).toString();	

		return time;	
	}
	public String getDate() throws InterruptedException{
		time= dateformat.format(calendar.getInstance().getTime());

		return time;	
	}
	public String getDay() throws InterruptedException{
		time= dayformat.format(calendar.getInstance().getTime()).toUpperCase();

		return time;	
	}
	
	public String getTotalEmployee() throws SQLException{
		int x = 0;
		
		String query = "Select * from PersonalDetail";
		ResultSet rs;	
		rs=empSql.sqliteDb.search(query);
		while(rs.next()){
			x++;
		}
		emp= String.valueOf(x);
		return emp;	
	}
	
	public String getOnLeave() throws SQLException{
		int x = 0;
		
		String query = "Select * from EmploymentDetail WHERE Status = \"On Leave\";";
		ResultSet rs;	
		rs=empSql.sqliteDb.search(query);
		while(rs.next()){
			x++;
		}
		String onleave= String.valueOf(x);
		return onleave;	
	}
	
	public String getSuspended() throws SQLException{
		int x = 0;
		
		String query = "Select * from EmploymentDetail WHERE Status = \"Suspended\";";
		ResultSet rs;	
		rs=empSql.sqliteDb.search(query);
		while(rs.next()){
			x++;
		}
		String suspended= String.valueOf(x);
		return suspended;	
	}
	
	public HashMap <String, String> getGenderDemo() throws SQLException{
		HashMap <String, String> genderDemo =  new HashMap <String, String>();
		int male = 0;
		
		String query = "Select * from PersonalDetail WHERE gender = \"Male\";";
		ResultSet rs;	
		rs=empSql.sqliteDb.search(query);
		while(rs.next()){
			male++;
		}	
		
		int female = Integer.valueOf(emp) - male;	
		double malePercentage  = (male/Double.valueOf(emp))*100;
		double femalePercentage = 100-malePercentage;	
		
		genderDemo.put("Male", String.valueOf(male));
		genderDemo.put("Female",String.valueOf(female));
		
		genderDemo.put("MalePercentage", String.valueOf(df.format(malePercentage)));
		genderDemo.put("FemalePercentage",String.valueOf(df.format(femalePercentage)));
	
		return genderDemo;
	}
	
	public HashMap <String, String> getDepartmentDemo() throws SQLException{
		HashMap <String, String> departmentDemo =  new HashMap <String, String>();
		int hr = 0;
		int it = 0;
		int af = 0;
		int mktg = 0;
		int rd = 0;
		int prod = 0;
		int mgr = 0;
	
		hr= (int) empSql.getCount().get("dept1");
		it= (int) empSql.getCount().get("dept2");
		af= (int) empSql.getCount().get("dept3");
		mktg= (int) empSql.getCount().get("dept4");
		rd= (int) empSql.getCount().get("dept5");
		prod= (int) empSql.getCount().get("dept6");
		mgr= (int) empSql.getCount().get("dept7");
		
		double hrPercentage  = (hr/Double.valueOf(emp))*100;
		double itPercentage  = (it/Double.valueOf(emp))*100;
		double afPercentage  = (af/Double.valueOf(emp))*100;
		double mktgPercentage  = (mktg/Double.valueOf(emp))*100;
		double rdPercentage  = (rd/Double.valueOf(emp))*100;
		double prodPercentage  = (prod/Double.valueOf(emp))*100;
		double mgrPercentage  = (mgr/Double.valueOf(emp))*100;
		
		departmentDemo.put("hr", String.valueOf(hr));
		departmentDemo.put("it",String.valueOf(it));
		departmentDemo.put("af", String.valueOf(af));
		departmentDemo.put("mktg",String.valueOf(mktg));
		departmentDemo.put("rd", String.valueOf(rd));
		departmentDemo.put("prod",String.valueOf(prod));
		departmentDemo.put("mgr",String.valueOf(mgr));

		departmentDemo.put("hrPercentage", String.valueOf(df.format(hrPercentage)));
		departmentDemo.put("itPercentage",String.valueOf(df.format(itPercentage)));
		departmentDemo.put("afPercentage", String.valueOf(df.format(afPercentage)));
		departmentDemo.put("mktgPercentage",String.valueOf(df.format(mktgPercentage)));
		departmentDemo.put("rdPercentage", String.valueOf(df.format(rdPercentage)));
		departmentDemo.put("prodPercentage",String.valueOf(df.format(prodPercentage)));
		departmentDemo.put("mgrPercentage",String.valueOf(df.format(mgrPercentage)));
	
		return departmentDemo;
	}
	public HashMap <String, String> getAgeDemo() throws SQLException{
		HashMap <String, String> ageDemo =  new HashMap <String, String>();
		int a18to25 = 0;
		int a26to33 = 0;
		int a34to41 = 0;
		int a42to49 = 0;
		int a50to59 = 0;
		int a60up = 0;
		
		String query1 = "Select * from PersonalDetail WHERE age >=18 AND age <=25;";
		ResultSet rs1;	
		rs1=empSql.sqliteDb.search(query1);
		while(rs1.next()){
			a18to25++;
		}	
		String query2 = "Select * from PersonalDetail WHERE age >=26 AND age <=33;";
		ResultSet rs2;	
		rs2=empSql.sqliteDb.search(query2);
		while(rs2.next()){
			a26to33++;
		}
		String query3 = "Select * from PersonalDetail WHERE age >=34 AND age <=41;";
		ResultSet rs3;	
		rs3=empSql.sqliteDb.search(query3);
		while(rs3.next()){
			a34to41++;
		}
		String query4 = "Select * from PersonalDetail WHERE age >=42 AND age <=49;";
		ResultSet rs4;	
		rs4=empSql.sqliteDb.search(query4);
		while(rs4.next()){
			a42to49++;
		}
		String query5 = "Select * from PersonalDetail WHERE age >=50 AND age <=59;";
		ResultSet rs5;	
		rs5=empSql.sqliteDb.search(query5);
		while(rs5.next()){
			a50to59++;
		}
		String query6 = "Select * from PersonalDetail WHERE age >=60;";
		ResultSet rs6;	
		rs6=empSql.sqliteDb.search(query6);
		while(rs6.next()){
			a60up++;
		}
	
		double a18to25Percentage  = (a18to25/Double.valueOf(emp))*100;
		double a26to33Percentage  = (a26to33/Double.valueOf(emp))*100;
		double a34to41Percentage  = (a34to41/Double.valueOf(emp))*100;
		double a42to49Percentage  = (a42to49/Double.valueOf(emp))*100;
		double a50to59Percentage  = (a50to59/Double.valueOf(emp))*100;
		double a60upPercentage  = (a60up/Double.valueOf(emp))*100;
			
		ageDemo.put("a18to25", String.valueOf(a18to25));
		ageDemo.put("a26to33",String.valueOf(a26to33));
		ageDemo.put("a34to41", String.valueOf(a34to41));
		ageDemo.put("a42to49",String.valueOf(a42to49));
		ageDemo.put("a50to59", String.valueOf(a50to59));
		ageDemo.put("a60up",String.valueOf(a60up));
		
		ageDemo.put("a18to25Percentage", String.valueOf(df.format(a18to25Percentage)));
		ageDemo.put("a26to33Percentage",String.valueOf(df.format(a26to33Percentage)));
		ageDemo.put("a34to41Percentage", String.valueOf(df.format(a34to41Percentage)));
		ageDemo.put("a42to49Percentage",String.valueOf(df.format(a42to49Percentage)));
		ageDemo.put("a50to59Percentage", String.valueOf(df.format(a50to59Percentage)));
		ageDemo.put("a60upPercentage",String.valueOf(df.format(a60upPercentage)));
	
		return ageDemo;
	}
	
	public HashMap <String, String> getShiftDemo() throws SQLException{
		HashMap <String, String> shiftDemo =  new HashMap <String, String>();
		int day = 0;
		int night = 0;
		int graveyard = 0;
		int switching = 0;

		
		String query1 = "Select * from EmploymentDetail WHERE Schedule=1";
		ResultSet rs1;	
		rs1=empSql.sqliteDb.search(query1);
		while(rs1.next()){
			day++;
		}	
		String query2 = "Select * from EmploymentDetail WHERE Schedule=2;";
		ResultSet rs2;	
		rs2=empSql.sqliteDb.search(query2);
		while(rs2.next()){
			night++;
		}
		String query3 = "Select * from EmploymentDetail WHERE Schedule=3;";
		ResultSet rs3;	
		rs3=empSql.sqliteDb.search(query3);
		while(rs3.next()){
			graveyard++;
		}
		String query4 = "Select * from EmploymentDetail WHERE Schedule=4;";
		ResultSet rs4;	
		rs4=empSql.sqliteDb.search(query4);
		while(rs4.next()){
			switching++;
		}

	
		double dayPercentage  = (day/Double.valueOf(emp))*100;
		double nightPercentage  = (night/Double.valueOf(emp))*100;
		double graveyardPercentage  = (graveyard/Double.valueOf(emp))*100;
		double switchingPercentage  = (switching/Double.valueOf(emp))*100;
	
			
		shiftDemo.put("day", String.valueOf(day));
		shiftDemo.put("night",String.valueOf(night));
		shiftDemo.put("graveyard", String.valueOf(graveyard));
		shiftDemo.put("switching",String.valueOf(switching));

		
		shiftDemo.put("dayPercentage", String.valueOf(df.format(dayPercentage)));
		shiftDemo.put("nightPercentage",String.valueOf(df.format(nightPercentage)));
		shiftDemo.put("graveyardPercentage", String.valueOf(df.format(graveyardPercentage)));
		shiftDemo.put("switchingPercentage",String.valueOf(df.format(switchingPercentage)));

	
		return shiftDemo;
	}
	public HashMap <String, String> getContractDemo() throws SQLException{
		HashMap <String, String> contractDemo =  new HashMap <String, String>();
		int permanent = 0;
		int term = 0;
		int project = 0;
		int seasonal = 0;
		int casual = 0;

		
		String query1 = "Select * from EmploymentDetail WHERE Contract_Type=1";
		ResultSet rs1;	
		rs1=empSql.sqliteDb.search(query1);
		while(rs1.next()){
			permanent++;
		}	
		String query2 = "Select * from EmploymentDetail WHERE Contract_Type=2;";
		ResultSet rs2;	
		rs2=empSql.sqliteDb.search(query2);
		while(rs2.next()){
			term++;
		}
		String query3 = "Select * from EmploymentDetail WHERE Contract_Type=3;";
		ResultSet rs3;	
		rs3=empSql.sqliteDb.search(query3);
		while(rs3.next()){
			project++;
		}
		String query4 = "Select * from EmploymentDetail WHERE Contract_Type=4;";
		ResultSet rs4;	
		rs4=empSql.sqliteDb.search(query4);
		while(rs4.next()){
			seasonal++;
		}
		String query5 = "Select * from EmploymentDetail WHERE Contract_Type=5;";
		ResultSet rs5;	
		rs5=empSql.sqliteDb.search(query5);
		while(rs5.next()){
			casual++;
		}
		
		double permanentPercentage  = (permanent/Double.valueOf(emp))*100;
		double termPercentage  = (term/Double.valueOf(emp))*100;
		double projectPercentage  = (project/Double.valueOf(emp))*100;
		double seasonalPercentage  = (seasonal/Double.valueOf(emp))*100;
		double casualPercentage  = (casual/Double.valueOf(emp))*100;
	
			
		contractDemo.put("permanent", String.valueOf(permanent));
		contractDemo.put("term",String.valueOf(term));
		contractDemo.put("project", String.valueOf(project));
		contractDemo.put("seasonal",String.valueOf(seasonal));
		contractDemo.put("casual",String.valueOf(casual));

		
		contractDemo.put("permanentPercentage", String.valueOf(df.format(permanentPercentage)));
		contractDemo.put("termPercentage",String.valueOf(df.format(termPercentage)));
		contractDemo.put("projectPercentage", String.valueOf(df.format(projectPercentage)));
		contractDemo.put("seasonalPercentage",String.valueOf(df.format(seasonalPercentage)));
		contractDemo.put("casualPercentage",String.valueOf(df.format(casualPercentage)));

	
		return contractDemo;
	}
	
	public String[][] getVaccancies() throws SQLException{
		String[][] vac= new String[100][5];
		int vacSize =0;
		String dept="";
		
		String queryVac = "Select * from JobVacancies";
		ResultSet rsVac;	
		rsVac=empSql.sqliteDb.search(queryVac);
		int x = 0, y= 0;
		while(rsVac.next()){
			
			switch(rsVac.getString(4)){
			case "1": dept="HR Department";
			break;
			case "2": dept="IT Department";
			break;
			case "3": dept="A&F Department";
			break;
			case "4": dept="Mktg Department";
			break;
			case "5": dept="RnD Department";
			break;
			case "6": dept="Prod Department";
			break;
			}
			vac[x][y]=dept;
			vac[x][y+1]=rsVac.getString(2);
			
			vac[x][y+2]=rsVac.getString(3);
			
			vac[x][y+3]=rsVac.getString(5);
			x++;
			vacSize++;
			
		}
		vac[0][4] = String.valueOf(vacSize);
		System.out.println(vacSize);
		return vac; 
	}
	
	public ArrayList<String> getHappening() throws SQLException {
		ArrayList<String> happening = new ArrayList<String>();
		ResultSet rsHappening;
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		
		String month= monthFormat.format(calendar.getInstance().getTime());
		String day = dayFormat.format(calendar.getInstance().getTime());
		String year = yearFormat.format(calendar.getInstance().getTime());
				
		String queryBday = "Select fName,lName from PersonalDetail WHERE bDayMonth = \""+month+"\" AND bDayDate = \""+day+"\";";
		rsHappening=empSql.sqliteDb.search(queryBday);
		int x = 0;
		while(rsHappening.next()) {
			happening.add(rsHappening.getString("fName")+" "+rsHappening.getString("lName")+"\'s"+" Birthday");
			x++;
		}
		
		System.out.println("happening"+x);
		return happening;
	}
	
	
	
	public HashMap<String, ArrayList<String>> getUpcomming() throws SQLException, ParseException {
		ArrayList <String> upcommingOrder = new ArrayList<String>();
		ArrayList <String> upcommingNextOrder = new ArrayList<String>();
		
		HashMap<String, ArrayList<String>> upcomming = new HashMap<String,ArrayList<String>>();	
		SimpleDateFormat dfinput = new SimpleDateFormat("MMMM-dd");
		Date dateToCompare = new Date();
		Date dateNow = new Date();
		Date xb = new Date();
		String dateNowString;	
		String queryHappening = "SELECT fName,lName,bDayMonth,bDayDate,bDayYear from PersonalDetail;";
		ResultSet rsHappening;
		rsHappening = empSql.sqliteDb.search(queryHappening);
		int x=0;
		while(rsHappening.next()) {
			dateToCompare = dfinput.parse(rsHappening.getString("bDayMonth")+"-"+rsHappening.getString("bDayDate"));
			dateNowString = dfinput.format(calendar.getInstance().getTime());
			dateNow = dfinput.parse(dateNowString);	
			
			if(dateNow.before(dateToCompare)) {
				if (!upcommingOrder.contains(dfinput.format(dateToCompare))) {
					upcommingOrder.add(dfinput.format(dateToCompare));
					upcomming.put(dfinput.format(dateToCompare), new ArrayList<String>());
				}
			
			}
			else {
				if (!upcommingNextOrder.contains(dfinput.format(dateToCompare))) {
					upcommingNextOrder.add(dfinput.format(dateToCompare));
					upcomming.put(dfinput.format(dateToCompare), new ArrayList<String>());
					//System.out.println("LABASSSSSSSSS");
				}
				
			}
	
			upcomming.get(dfinput.format(dateToCompare)).add(rsHappening.getString("fName"));
			
			//System.out.println(upcomming.get("August-23").size()+"<<<<<<<<<-");
			//System.out.println(dfinput.format(dateToCompare)+upcomming.get(dfinput.format(dateToCompare)));
		}
		
		String temp;
		//System.out.println(upcommingOrder.indexOf("August-15"));
		//System.out.println(upcommingOrder+"<<<<<");
		for (int i=0;i<upcommingOrder.size();i++) {
			for(int y=0;y<upcommingOrder.size();y++) {
				if(dfinput.parse(upcommingOrder.get(i)).before(dfinput.parse(upcommingOrder.get(y)))) {
					 temp = upcommingOrder.get(y);
					 upcommingOrder.set(y, upcommingOrder.get(i));
					 upcommingOrder.set(i, temp);
				}	
			}
		}
		for (int i=0;i<upcommingNextOrder.size();i++) {
			for(int y=0;y<upcommingNextOrder.size();y++) {
				if(dfinput.parse(upcommingNextOrder.get(i)).before(dfinput.parse(upcommingNextOrder.get(y)))) {
					 temp = upcommingNextOrder.get(y);
					 upcommingNextOrder.set(y, upcommingNextOrder.get(i));
					 upcommingNextOrder.set(i, temp);
				}	
			}
		}
		upcomming.put("upcommingOrder", upcommingOrder);
		upcomming.put("upcommingNextOrder", upcommingNextOrder);
		System.out.println(upcomming.get("August-23")+"<<<<<<<<<-");
		System.out.println(upcommingOrder+"<<<<<");
		//System.out.println(upcommingOrder.get(1)+" "+upcomming.get(upcommingOrder.get(1))+" "+upcomming.get(upcommingOrder.get(1)).size());
		System.out.println(upcomming.get("upcommingOrder"));
		System.out.println(upcomming.get("upcommingNextOrder"));
		
		return upcomming;
	}
	
	public ResultSet getLatestUpdate() throws SQLException {
		int latestCount=0;
		String latestQuery = "Select * from LatestUPdate";
		ResultSet rs1;	
		rs1=empSql.sqliteDb.search(latestQuery);		
		return rs1;
	}
	
	
}
