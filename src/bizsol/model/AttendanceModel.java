package bizsol.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.sqlite.core.CoreDatabaseMetaData;

public class AttendanceModel {
	
	public EmployeeModel empSql = new EmployeeModel();
	
	public HashMap<String,ArrayList<String>> getScheduleList(String date) throws SQLException {
		String query = "SELECT * FROM ListOfSchedulePeriod;";
		HashMap<String,ArrayList<String>> data = new HashMap<String,ArrayList<String>>();
		
		ResultSet rs = empSql.sqliteDb.search(query);
		ArrayList<String> periodArray = new ArrayList<String>();
		periodArray.add(0,"empty");
		String period;
		String startDate;
		ArrayList<String> week =new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>(); 
		ArrayList<String> availability = new ArrayList<String>(); 
		
		week.add(0, "No List");
		availability.add(0,"No Schedule Found");

	
		while (rs.next()) {
			period = rs.getString(2);
			list.add(rs.getString(2));
			System.out.println(period);
			
			startDate = period.substring(0,period.indexOf("t")-1);
			System.out.println(period.substring(0,period.indexOf("t")-1));
			LocalDate startDateDate = LocalDate.parse(startDate);
	//TODO creat table list of schedule period
			if(LocalDate.parse(date).isAfter(startDateDate.minusDays(1)) && LocalDate.parse(date).isBefore(startDateDate.plusDays(28))) {	
				if(Period.between(startDateDate,LocalDate.parse(date)).getDays() <= 6 ) {
					System.out.println("firstWeek");
					week.set(0, "1");
				}
				else if(Period.between(startDateDate,LocalDate.parse(date)).getDays() >= 7 && Period.between(startDateDate,LocalDate.parse(date)).getDays()<=13 ) {
					System.out.println("secondWeek");
					week.set(0, "2");
				}
				else if(Period.between(startDateDate,LocalDate.parse(date)).getDays() >= 14 && Period.between(startDateDate,LocalDate.parse(date)).getDays()<=20 ) {
					System.out.println("thirddWeek");
					week.set(0, "3");
				}
				else {
					System.out.println("fourthWeek");
					week.set(0, "4");
				}
			System.out.println("break - meron");
			periodArray.set(0,period);
			availability.set(0, "Already Exist");
			break;
			}
			else {
				availability.set(0, "No Schedule Found");
				System.out.println("wala");
				System.out.println(date);
			}
			
			
		}
		data.put("period", periodArray);	
		data.put("week", week);
		data.put("list",list); //lilst of period TODO attendance view listof period available
		data.put("availability", availability);
	
		System.out.println(data.get("period")+"<<PERIOD");
		System.out.println(data.get("week")+"<<WEEK");
		System.out.println(data.get("list")+"<<LIST");
		System.out.println(data.get("availability")+"<<AVAILABILITY");
		
		return data;
	}
	
	
	
	public LinkedHashMap<String,HashMap<String,String>>  getSchedule(String date) throws SQLException {
		
		LinkedHashMap<String,HashMap<String,String>> scheduleData = new LinkedHashMap <String,HashMap<String,String>>();
		String period="";
		String week="";
		String availability="";
		HashMap <String,ArrayList> data = new HashMap <String,ArrayList>();
		HashMap <String,String> info = new HashMap<String,String>();
		
		data.putAll( getScheduleList(date)); //return a hashmap of list of schedule period and in what week;
		
		period = data.get("period").get(0).toString();
		week = data.get("week").get(0).toString();
		availability= data.get("availability").get(0).toString();
		System.out.println();
		
		info.put("from", "0");
		if (availability.equals("No Schedule Found")) {
			System.out.println("Not Available====");
			info.put("availability", availability);
			info.put("date", date);
			scheduleData.put("info", info);
		}
		else {
			System.out.println("ELSE");
			System.out.println(scheduleData.size());
			info.put("availability", availability);
			info.put("date", date);
			scheduleData.put("info", info);
			
				String schedQuery = "SELECT EmployeeScheduleTable.*,lName|| ', ' || fName|| ' .' || substr(mName, 1, 1) as Fullname,position,grupo_id as grupo  FROM EmployeeScheduleTable  LEFT JOIN PersonalDetail on PersonalDetail.Employee_Number=EmployeeScheduleTable.Employee_Number \r\n"
						+ "				LEFT JOIN EmploymentDetail on EmployeeScheduleTable.Employee_Number=EmploymentDetail.Employee_Number\r\n"
						+ "				LEFT JOIN Position on Position.position_id = EmploymentDetail.position_id  "
						+ " WHERE EmployeeScheduleTable.schedPeriod = \""+period+"\""
						+ "ORDER by Fullname ASC;";
				
				ResultSet schedQueryRS = empSql.sqliteDb.search(schedQuery);
				System.out.println(schedQueryRS.getString("Day1")+"DEEEEEEEEEEEEEEEEEYYY");
				System.out.println(schedQueryRS.getString("schedPeriod")+"DEEEEEEEEEEEEEEEEEYYY");
				System.out.println("QUERY");
				int counter=0;
				while(schedQueryRS.next()) {    
					HashMap<String,String> datadata = new HashMap<String,String>(); //to reset the hashmap, everytime the loop begin // can also be outside change put to set
					datadata.put("fullName", schedQueryRS.getString("Fullname").toString());
					datadata.put("position", schedQueryRS.getString("position").toString());
					datadata.put("group", schedQueryRS.getString("grupo").toString());
					counter++;
					datadata.put("counter", String.valueOf(counter));
					//9
					String dayDate = schedQueryRS.getString("schedPeriod").toString();
						dayDate = dayDate.substring(0,10);	
					datadata.put("schedPeriod", dayDate);
					for (int x=1;x<=28;x++) {
						datadata.put("Day"+x, schedQueryRS.getString("Day"+x).toString());
					}
					
					datadata.put("week", week);
					scheduleData.put(schedQueryRS.getString("Employee_Number"), datadata);
					
				}
				
				//Test
			
				System.out.println(period);
				//System.out.println(scheduleData.get(1).get("fullName"));
				
				
			}
	
		return scheduleData;
		}
			
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			public boolean  createSchedule(HashMap<String,String> info) throws SQLException {
				HashMap<String, ArrayList<String>> checkIfNextAlreadyExist = getScheduleList(LocalDate.parse(info.get("date"),(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).plusDays(7).toString());
				boolean done=true;
				LocalDate sourceDate  = LocalDate.parse(info.get("date"));
				
				System.out.println(checkIfNextAlreadyExist.get("availability").get(0)+"AVAILABILITY NEXT");
				
				if(info.get("ans").equals("next")) {
				
					sourceDate = sourceDate.plusDays(7);
					System.out.println("NEXT<<<<<<<<");
					
				}
				else {
					
				}
				
				
				if(checkIfNextAlreadyExist.get("availability").get(0).equals("No Schedule Found")) {
							done=true;
							HashMap <String,String>  data = new HashMap<String,String>();
							HashMap <String,String>  thisInfo = new HashMap<String,String>();
							thisInfo.putAll(info);
							String skedQuery="SELECT PersonalDetail.Employee_Number,lName|| ', ' || fName|| ' .' || substr(mName, 1, 1) as Fullname,position,grupo_id  FROM PersonalDetail LEFT JOIN EmploymentDetail on PersonalDetail.Employee_Number=EmploymentDetail.Employee_Number "
									+ "LEFT JOIN Position on Position.position_id = EmploymentDetail.position_id  ORDER by grupo_id ASC;";	
							ResultSet rs = empSql.sqliteDb.search(skedQuery);
							String[] skedule = new String[28];
							//int rps=0;
							String schedule="";
							LocalDate startDate = sourceDate;
							String period = "";				
			//				if (info.get("ans").equals("current")) {
								while(!startDate.getDayOfWeek().toString().equals("MONDAY")) {
									startDate=startDate.minusDays(1);
									System.out.println(startDate.getDayOfWeek());
			//					}
			//				}
			//				else{
			//					while(!startDate.getDayOfWeek().toString().equals("MONDAY")) {
			//						startDate=startDate.plusDays(1);
			//						System.out.println(startDate.getDayOfWeek());
			//					}	
							}
							
							period = startDate.toString() +" to "+ startDate.plusDays(27).toString();
							data.put("period", period);
							
							while(rs.next()) {
								System.out.println(rs.getString(1)+"<<<<RS");
						
								schedule =	rs.getString(4);
								switch (schedule){
								case "1": for(int x=0;x<28;x++) {
										if (x<7) {
											skedule[x]= "8 a.m. - 5 p.m. Morning Shift";
										}
										else if(x>=9 && x<=15) {
											skedule[x] = "4 p.m. - 1 a.m. Night Shift";
										}
										else if(x>=18 && x<=24) {
											skedule[x] = "12 a.m. - 9 a.m. Graveyard Shift";
										}
										else{skedule[x]="Rest Day";}
										}
								break;
								case "2": for(int x=0;x<28;x++) {
										if (x>=2 && x<=8) {
											skedule[x]= "4 p.m. - 1 a.m. Night Shift";
										}
										else if(x>=11 && x<=17) {
											skedule[x] = "12 a.m. - 9 a.m. Graveyard Shift";
										}
										else if(x>=21 && x<=27) {
											skedule[x] = "8 a.m. - 5 p.m. Morning Shift";
										}
										else{skedule[x]="Rest Day";}
										}
								break;
								case "3": for(int x=0;x<28;x++) {
										if (x<2) {
											skedule[x]= "4 p.m. - 1 a.m. Night Shift";
										}
										else if(x>=4 && x<=10) {
											skedule[x] = "12 a.m. - 9 a.m. Graveyard Shift";
										}
										else if(x>=14 && x<=20) {
											skedule[x] = "8 a.m. - 5 p.m. Morning Shift";
										}
										else if(x>=23 && x<=27) {
											skedule[x] = "4 p.m. - 1 a.m. Night Shift";
										}
										else{skedule[x]="Rest Day";}
										}
								break;
								case "4": for(int x=0;x<28;x++) {
										if (x<4) {
											skedule[x] = "12 a.m. - 9 a.m. Graveyard Shift";
										}
										else if(x>=7 && x<=13) {
											skedule[x] = "8 a.m. - 5 p.m. Morning Shift";
										}
										else if(x>=16 && x<=22) {
											skedule[x] = "4 p.m. - 1 a.m. Night Shift";
										}
										else if(x>=25 && x<=27) {
											skedule[x] = "12 a.m. - 9 a.m. Graveyard Shift";
										}
										else{skedule[x]="Rest Day";}
										}
								break;
							}
					
								data.put("schedPeriod", "schedPeriod");
								for(int x=0;x<28;x++) {
									data.put("Day"+(x+1), skedule[x]);
								}
						
							
							System.out.println("<<<< SCHEDULE");
							data.put("employeeNo", rs.getString(1));
							empSql.sqliteDb.insertToEmpSchedule(data);
							
						}
							empSql.sqliteDb.insertToListOfSchedulePeriod(data);			
				}
				
				else {
					done = false;
					
				}
				
				
				return done;
		}
	
}
