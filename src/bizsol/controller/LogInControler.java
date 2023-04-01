package bizsol.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.java.accessibility.util.GUIInitializedListener;

import bizsol.model.AttendanceModel;
import bizsol.model.EmployeeModel;
import bizsol.model.HomeModel;
import bizsol.model.LogInModel;
import bizsol.model.PayrollModel;
import bizsol.view.AddEmployeeView;
import bizsol.view.HomeView;
import bizsol.view.LogInView;
import bizsol.view.showGui;

public class LogInControler {

	showGui gui = new showGui();
	EmployeeModel empModel = new EmployeeModel();
	PayrollModel payRollMod = new PayrollModel();
	HomeModel homeMod = new HomeModel();
	AttendanceModel attendanceMod = new AttendanceModel();
	
	
	
	LogInModel model;
	LogInView view;
	Component comp;
	boolean done;
	
	HashMap details;;
	HashMap <String, String> selectedResult  = new HashMap();
	HashMap <String, Double> rates = new HashMap();
	
	
	public LogInControler(LogInModel model, LogInView view) throws InterruptedException, SQLException, ParseException{
		
		
		this.model = model;
		this.view = view;
		
		view.addlisten(new Lister());
		gui.addlisten(new Lister());
		gui.addRat(new rat());
	
		
		comp = gui.homeView.homeMainPanel;
		
		gui.homeView.setDate(homeMod.getDate());
		gui.homeView.setDay(homeMod.getDay());
		gui.homeView.setTotalEmployee(homeMod.getTotalEmployee());
		gui.homeView.setOnLeave(homeMod.getOnLeave());
		gui.homeView.setSuspended(homeMod.getSuspended());
		gui.homeView.setGenderDemo(homeMod.getGenderDemo());
		gui.homeView.setDepartmentDemo(homeMod.getDepartmentDemo());
		gui.homeView.setAgeDemo(homeMod.getAgeDemo());
		gui.homeView.setShiftDemo(homeMod.getShiftDemo());
		gui.homeView.setContractDemo(homeMod.getContractDemo());
		gui.homeView.setVacancies(homeMod.getVaccancies());
		gui.homeView.setHappening(homeMod.getHappening());
		gui.homeView.setUpcomming(homeMod.getUpcomming());
		gui.homeView.setLatestUpdate(homeMod.getLatestUpdate());
		
	
		//empModel.sqliteDb.populate();
		
		
		
		
		empModel.sqliteDb.conn.close();
		while(true) {
		gui.homeView.setTime(homeMod.getTime());
		Thread.sleep(1000);
		}
		

	}
	
	class Lister implements ActionListener{
		boolean toggleSwitch = true;;

		HashMap<String,HashMap<String,String>> availability = new HashMap<String,HashMap<String,String>>();
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource().equals(view.buttonLogIn)) {
				if(model.checkLogin(view.getUsername(), view.getPassword())) {
					view.setVisible(false);
					gui.showGuiNow();
				}
			}
			//
			else if(e.getSource().equals(gui.homeButton)) {
				
				System.out.println("home");
				comp.setVisible(false);
				
				gui.homeView.homeMainPanel.setVisible(true);
			
				try {
					gui.homeView.setNewTotalEmployee(homeMod.getTotalEmployee());
					gui.homeView.setLatestUpdate(homeMod.getLatestUpdate());
					gui.homeView.setGenderDemo(homeMod.getGenderDemo());
					gui.homeView.setDepartmentDemo(homeMod.getDepartmentDemo());
					gui.homeView.setAgeDemo(homeMod.getAgeDemo());
					gui.homeView.setShiftDemo(homeMod.getShiftDemo());
					gui.homeView.setContractDemo(homeMod.getContractDemo());
	
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				comp = gui.homeView.homeMainPanel;
			}
			//
			else if(e.getSource().equals(gui.emplyoeeButton)) {
				System.out.println("employee");	
				comp.setVisible(false);
				gui.tp.setVisible(true);
				comp = gui.tp;
			}
			//
			else if(e.getSource().equals(gui.payrollButton)) {
				System.out.println("payroll");
				comp.setVisible(false);
				gui.payroll.mainPayrollPanel.setVisible(true);
				comp = gui.payroll.mainPayrollPanel;		
			}
			//
			else if(e.getSource().equals(gui.attendanceButton)) {
				System.out.println("attendace");
				comp.setVisible(false);
				gui.attendanceView.attendanceMainPanel.setVisible(true);
				String ans;
				HashMap<String,String> data = new HashMap<String,String>();
				if(toggleSwitch) {
						try {
							System.out.println("get schedule loginController");
							availability.putAll(gui.attendanceView.setSchedule(attendanceMod.getSchedule(LocalDate.now().toString())));
							System.out.println("get schedule loginController<<<<<end");
		//					HashMap<String, ArrayList<String>> checkNext = attendanceMod.getScheduleList(LocalDate.now().plusDays(7).toString());
		//					checkNext.get("week").get(0);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
				}		
				System.out.println(availability.get("info").get("availability")+"<<<<<<<<<<<<");
				
				if (availability.get("info").get("availability").equals("No Schedule Found")) {
					System.out.println(availability.get("info").get("availability"));
					System.out.println("Call createOption");
					System.out.println(availability.get("info").get("date"));
					
					data.putAll(gui.attendanceView.createOption(availability));	
					
					
					if (data.get("ans").equals("current") || data.get("ans").equals("next")) {
						System.out.println(data.get("ans"));
						boolean done;
						System.out.println("Call createSchedule");
							try {
								done = attendanceMod.createSchedule(data);
								if (done==true&&data.get("ans").equals("current")) {
									gui.attendanceView.setSchedule(attendanceMod.getSchedule(LocalDate.now().plusDays(0).toString()));
									System.out.println("TRUUUUUUUUUUUUUUUUUUUUUUUUUE");
								}
								else if (done==true&&data.get("ans").equals("next")) {
									gui.attendanceView.setSchedule(attendanceMod.getSchedule(LocalDate.now().plusDays(7).toString()));
									System.out.println("TRUUUUUUUUUUUUUUUUUUUUUUUUUE");
									gui.attendanceView.setWeek(0);
								}
	
								else{
									System.out.println("FAAAAAAAAAAAALLLLLLLLSE");
									System.out.println("nextweek already available");
									JOptionPane.showMessageDialog(null,"<html>Unable to create schedule, because the schedule<br/> of the upcomming week is already created.<br/>The schedule next week will be displayed."); 
									gui.attendanceView.setWeek(0);
									gui.attendanceView.setSchedule(attendanceMod.getSchedule(LocalDate.now().plusDays(7).toString()));
									
									
								}
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							}
					 }
					
					
					else if (data.get("ans").equals("showNext")){
						
						LocalDate startDate =LocalDate.parse(data.get("date").toString());
						while(!startDate.getDayOfWeek().toString().equals("MONDAY")) {
							startDate=startDate.plusDays(1);
						}
						
						try {
							gui.attendanceView.setSchedule(attendanceMod.getSchedule(startDate.toString()));
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			

				
				 
				
				
				comp = gui.attendanceView.attendanceMainPanel;
			}
			//
			else if(e.getSource().equals(gui.scheduleButton)) {
				System.out.println("schedule");
				comp.setVisible(false);
				gui.scheduleView.scheduleMainPanel.setVisible(true);
				comp = gui.scheduleView.scheduleMainPanel;	
			}
			//
			else if(e.getSource().equals(gui.reportsButton)) {
				System.out.println("reports");
				comp.setVisible(false);
				gui.reportsView.reportsMainPanel.setVisible(true);
				comp = gui.reportsView.reportsMainPanel;	
			}
			//
			else if(e.getSource().equals(gui.ieButton)) {
				System.out.println("ie");
				comp.setVisible(false);
				gui.importExportView.importExportMainPanel.setVisible(true);
				comp = gui.importExportView.importExportMainPanel;
			}
			//
			else if(e.getSource().equals(gui.settingsButton)) {
				System.out.println("settings");
				comp.setVisible(false);
				gui.settingsView.settingsMainPanel.setVisible(true);
				comp = gui.settingsView.settingsMainPanel;
			}
			//
			else if(e.getSource().equals(gui.logoutButton)) {
				System.out.println("logout");
				comp.setVisible(false);
				gui.logoutView.logoutMainPanel.setVisible(true);
				comp = gui.logoutView.logoutMainPanel;
			}
			//////////////////////////////////////////////////////////////
			//////////////// ADD EMPLOYEE LISTENER //////////////////////
			else if(e.getSource().equals(gui.addEmployeeView.addButton)) {
				System.out.println("ADD");
				
				details = gui.addEmployeeView.getfields();
				empModel.setFields(details);
			}
			else if(e.getSource().equals(gui.addEmployeeView.cancelButton)) {
				System.out.println("cancel");
				gui.addEmployeeView.clearAll();
			
			}
			///////////// dept ////
			else if(e.getSource().equals(gui.addEmployeeView.departmentCombo)) {
								
				try {
					gui.setDept(empModel.getCount());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				}
			else if(e.getSource().equals(gui.addEmployeeView.dateEmployee.yearCombo)) {
				
				gui.setYear();				
			}
			
			else if(e.getSource().equals(gui.payroll.searchButton)) {
				System.out.println("search");
				HashMap<String, String> searchParam = gui.payroll.getSearchParameters();
				
				try {
					payRollMod.setSearchParameters(searchParam);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(searchParam);
				
				
				try {
					gui.payroll.setResult(payRollMod.rs);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
			
			else if(e.getSource().equals(gui.payroll.save)) {
				System.out.println("save");
				HashMap hashmap = gui.payroll.getPayrollDetails(); // this return a hashmap
				try {
					payRollMod.payrollSendtoDb(hashmap);
					System.out.println("to model");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String[] ee = {payRollMod.dates.payrollPeriod(),String.valueOf(payRollMod.payrollBatch)};
				
				gui.payroll.setPayslipValue(ee);
				
			}
			else if(e.getSource().equals(gui.payroll.calculate)) {
				System.out.println("caalculate");
				HashMap operands = gui.payroll.getOperands(); //returns a hashmap
				payRollMod.setOperands(operands);
				HashMap results = payRollMod.compute(); //returns hashmap of resultsf	
				gui.payroll.setResults(results);
				
				
	
				
			}
			
			else if(e.getSource().equals(gui.payroll.cancel)) {
				System.out.println("cancel");
		
				gui.payroll.table.clearSelection();
				gui.payroll.clearTextFields();	
			
				
			}
			else if(e.getSource().equals(gui.attendanceView.sortingCombo)) {
				
				System.out.println(gui.attendanceView.sortingCombo.getSelectedItem());
			
				gui.attendanceView.sortingGetDate();
				
				String sortingDate = gui.attendanceView.sortingGetDate().substring(gui.attendanceView.sortingGetDate().indexOf("Y")+1);
				System.out.println(gui.attendanceView.sortingGetDate().substring(gui.attendanceView.sortingGetDate().indexOf("Y")+1));
				
			System.out.println("sorting");
				try {
					gui.attendanceView.setSchedule(attendanceMod.getSchedule(LocalDate.parse(sortingDate, DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString()));
					System.out.println("call");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	
			}
			else if(e.getSource().equals(gui.attendanceView.next)) {
				String ans = gui.attendanceView.setWeek(2);
				
				
				if(!ans.equals("")) {
					LocalDate newDate = LocalDate.parse(ans,(DateTimeFormatter
						    .ofPattern("dd-MMMM-yy")));
					
					System.out.println(newDate+"<<<<<<<<<<<<<<<<<<<<new date");
					String ans2;
					HashMap<String,String> data = new HashMap<String,String>();
					HashMap<String,HashMap<String,String>> info =  new  HashMap<String,HashMap<String,String>>();
					
					
					try {
						info.putAll(gui.attendanceView.setSchedule(attendanceMod.getSchedule(newDate.toString())));
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					info.get("info").replace("from", "1");
					data.putAll(gui.attendanceView.createOption(info));
					
					if (data.get("ans").equals("current") || data.get("ans").equals("next")) {
						boolean done;
						try {
							done = attendanceMod.createSchedule(data);
							System.out.println("bobo");
							if (done =true) {
								gui.attendanceView.setSchedule(attendanceMod.getSchedule(newDate.toString()));
							}
							
					
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				}	
			}
			else if(e.getSource().equals(gui.attendanceView.prev)) {
				String ans =gui.attendanceView.setWeek(1);
				System.out.println(ans);
				System.out.println("prev");
				if(!ans.equals("")) {
					LocalDate newDate = LocalDate.parse(ans,(DateTimeFormatter
						    .ofPattern("dd-MMMM-yy")));
					newDate=newDate.minusDays(27);
					
					System.out.println(newDate+"<<<<<<<<<<<<<<<<<<<<new date");
					String ans2;
					HashMap<String,String> data = new HashMap<String,String>();
					
					
					try {
						gui.attendanceView.setSchedule(attendanceMod.getSchedule(newDate.toString()));
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					
//					data.putAll(gui.attendanceView.checkerIfNoSchedule(newDate.toString()));
//					
//					if (data.get("ans").equals("current") || data.get("ans").equals("next")) {
//						boolean done;
//						try {
//							done = attendanceMod.createSchedule(data);
//							System.out.println("bobo");
//							if (done =true) {
//								gui.attendanceView.setSchedule(attendanceMod.getSchedule(newDate.toString()));
//							}
//							
//					
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}}
				}
				
			}
				
		}
				
	
	}
	class rat implements MouseListener	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == gui.payroll.table) {
				int row = gui.payroll.table.getSelectedRow();
				selectedResult.put("empNo", gui.payroll.table.getValueAt(row, 0).toString());
				selectedResult.put("name", gui.payroll.table.getValueAt(row, 1).toString());
				selectedResult.put("position", gui.payroll.table.getValueAt(row, 2).toString());
				selectedResult.put("department", gui.payroll.table.getValueAt(row, 3).toString());
				selectedResult.put("rate", gui.payroll.table.getValueAt(row, 4).toString());
				selectedResult.put("manager", gui.payroll.table.getValueAt(row, 5).toString());
				gui.payroll.getSelected(selectedResult);
				System.out.println("gui table");
				try {
					
					rates = payRollMod.getRate(selectedResult);
					 gui.payroll.setRateLabel(rates);
					 ResultSet values = payRollMod.checkStatus(selectedResult.get("empNo"));
					 ArrayList<Object> kk = new ArrayList<Object>(); 
					 String[] ee = {payRollMod.dates.payrollPeriod(),String.valueOf(payRollMod.payrollBatch)};	
					 kk.add(values);
					 kk.add(ee);
					 gui.payroll.setEditableFields(kk);
					 empModel.sqliteDb.conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			else if(e.getSource() == gui.homeView.bullet1){
				//System.out.println("1");
				gui.homeView.setBulletsToWhite();
				((JLabel) e.getSource()).setForeground(Color.BLUE);
				gui.homeView.setVisibleHappening(1);
			}
			else if(e.getSource() == gui.homeView.bullet2){
				//System.out.println("2");
				gui.homeView.setBulletsToWhite();
				((JLabel) e.getSource()).setForeground(Color.BLUE);
				gui.homeView.setVisibleHappening(2);
			}
			else if(e.getSource() == gui.homeView.bullet3){
				//System.out.println("3");
				gui.homeView.setBulletsToWhite();
				((JLabel) e.getSource()).setForeground(Color.BLUE);
				gui.homeView.setVisibleHappening(3);
			}
			else if(e.getSource() == gui.homeView.bullet4){
				//System.out.println("4");
				gui.homeView.setBulletsToWhite();
				((JLabel) e.getSource()).setForeground(Color.BLUE);
				gui.homeView.setVisibleHappening(4);
			}
			else if(e.getSource() == gui.homeView.bullet5){
				//System.out.println("5");
				gui.homeView.setBulletsToWhite();
				((JLabel) e.getSource()).setForeground(Color.BLUE);
				gui.homeView.setVisibleHappening(5);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == gui.homeView.bullet1){
				//System.out.println("1");
				((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			else if(e.getSource() == gui.homeView.bullet2){
				//System.out.println("2");
				((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			else if(e.getSource() == gui.homeView.bullet3){
				//System.out.println("3");
				((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			else if(e.getSource() == gui.homeView.bullet4){
				//System.out.println("4");
				((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			else if(e.getSource() == gui.homeView.bullet5){
				//System.out.println("5");
				((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}	
			
			
				
		}	
		


