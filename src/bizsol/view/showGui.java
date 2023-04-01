package bizsol.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class showGui extends JFrame{
	
	
		GridBagConstraints grd = new GridBagConstraints();
		JPanel mainPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		public JPanel rightPanel = new JPanel();
		
		public menuButton homeButton = new menuButton("HOME");
		public menuButton emplyoeeButton = new menuButton("EMPLOYEE");
		public menuButton payrollButton = new menuButton("PAYROLL");
		public menuButton attendanceButton = new menuButton("ATTENDANCE");
		public menuButton scheduleButton = new menuButton("SCHEDULE");
		public menuButton reportsButton = new menuButton("REPORTS");
		public menuButton ieButton = new menuButton("IMPORT/EXPORT");
		public menuButton settingsButton = new menuButton("SETTINGS");
		public menuButton logoutButton = new menuButton("LOGOUT");
		
		public JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		public AddEmployeeView addEmployeeView = new AddEmployeeView();
		public JTabbedPane tp=new JTabbedPane();
		public PayrollView payroll = new PayrollView();
		public HomeView homeView = new HomeView();
		public AttendanceView attendanceView = new AttendanceView();
		public ScheduleView scheduleView = new ScheduleView();
		public ReportsView reportsView = new ReportsView();
		public ImportExportView importExportView = new ImportExportView();
		public SettingsView settingsView = new SettingsView();
		public LogOutView logoutView = new LogOutView();
		String empId;
		
	//	hide this after
//		public showGui() {
//			showGuiNow();
//		}
	public void showGuiNow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		mainPanel.setPreferredSize(new Dimension(1310,710));
	
		mainPanel.setLayout(new GridBagLayout());
	
		leftPanel.setPreferredSize(new Dimension(300,710));
		leftPanel.setLayout(new FlowLayout(0,0,0));
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		MyCanvas m=new MyCanvas("business.png");
		m.setSize(new Dimension(300,200));
		leftPanel.add(m);
		
		leftPanel.add(homeButton);
		leftPanel.add(emplyoeeButton);
		leftPanel.add(payrollButton);
		leftPanel.add(attendanceButton);
		leftPanel.add(scheduleButton);
		leftPanel.add(reportsButton);
		leftPanel.add(ieButton);
		leftPanel.add(settingsButton);
		leftPanel.add(logoutButton);

		rightPanel.setPreferredSize(new Dimension(1010,710));
		rightPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//rightPanel.setBackground(Color.red);
		
		addEmployeeView.showAddEmployeeView(p1);
		//////////////////////////uncomment dito
		homeView.showHome(rightPanel);
		attendanceView.showAttendance(rightPanel);
		/////set to false after
		attendanceView.attendanceMainPanel.setVisible(false);
		scheduleView.showSchedule(rightPanel);
		scheduleView.scheduleMainPanel.setVisible(false);
		reportsView.showReports(rightPanel);
		reportsView.reportsMainPanel.setVisible(false);
		importExportView.showImportExport(rightPanel);
		importExportView.importExportMainPanel.setVisible(false);
		settingsView.showSettings(rightPanel);
		settingsView.settingsMainPanel.setVisible(false);
		logoutView.showLogout(rightPanel);
		logoutView.logoutMainPanel.setVisible(false);
	    tp.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    tp.setBounds(0,0,1000,720);  
	    tp.add("Add Employee",p1);  
	    tp.add("Delete Employee",p2);  
	    tp.add("Edit Employee",p3);
	    
	;
	    		    
	  
	   	payroll.showPayrollView(rightPanel);
	   	payroll.mainPayrollPanel.setVisible(false);
		tp.setVisible(false);	
	    rightPanel.add(tp);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		add(mainPanel);
		pack();
		setLocationRelativeTo(null); 
		setResizable(false);
		setVisible(true);	
	}
	
	
	
	
	public void addlisten(ActionListener listen) {
		homeButton.addActionListener(listen);
		emplyoeeButton.addActionListener(listen);
		payrollButton.addActionListener(listen);
		attendanceButton.addActionListener(listen);
		scheduleButton.addActionListener(listen);
		reportsButton.addActionListener(listen);
		ieButton.addActionListener(listen);
		settingsButton.addActionListener(listen);
		logoutButton.addActionListener(listen);
		
		addEmployeeView.addButton.addActionListener(listen);
		addEmployeeView.cancelButton.addActionListener(listen);
		addEmployeeView.departmentCombo.addActionListener(listen);
		addEmployeeView.dateEmployee.yearCombo.addActionListener(listen);
		
		payroll.searchButton.addActionListener(listen);
		payroll.calculate.addActionListener(listen);
		payroll.save.addActionListener(listen);
		payroll.calculate.addActionListener(listen);
		payroll.cancel.addActionListener(listen);
		
		attendanceView.sortingCombo.addActionListener(listen);
		attendanceView.next.addActionListener(listen);
		attendanceView.prev.addActionListener(listen);
		
		
	}
	public void addRat(MouseListener rat) {
		payroll.table.addMouseListener(rat);
		homeView.bullet1.addMouseListener(rat);
		homeView.bullet2.addMouseListener(rat);	
		homeView.bullet3.addMouseListener(rat);	
		homeView.bullet4.addMouseListener(rat);	
		homeView.bullet5.addMouseListener(rat);	
	}
	
	public void setDept(HashMap count) {
		String dept = addEmployeeView.departmentCombo.getSelectedItem().toString();
		String year= addEmployeeView.dateEmployee.yearCombo.getSelectedItem().toString().substring(2);
		System.out.println(addEmployeeView.dateEmployee.yearCombo.getSelectedItem().toString().substring(2));
		
		switch (dept) {
		case "Human Resources" : empId = "dpt01-"+"emp0"+(Integer.valueOf(count.get("dept1").toString())+1)+"-0";
		break;
		case "Information Technology" : empId = "dpt02-"+"emp0"+(Integer.valueOf(count.get("dept2").toString())+1)+"-0";
		break;
		case "Accounting & Finance" : empId = "dpt03-"+"emp0"+(Integer.valueOf(count.get("dept3").toString())+1)+"-0";
		break;
		case "Marketing" : empId = "dpt04-"+"emp0"+(Integer.valueOf(count.get("dept4").toString())+1)+"-0";
		break;
		case "Research & Development" : empId = "dpt05-"+"emp0"+(Integer.valueOf(count.get("dept5").toString())+1)+"-0";
		break;
		case "Production" : empId = "dpt05-"+"emp0"+(Integer.valueOf(count.get("dept6").toString())+1)+"-0";
		break;
		}
		
		addEmployeeView.employeeNoTextfield.setText(empId);

	}
	
	public void setYear() {
	
		String year= addEmployeeView.dateEmployee.yearCombo.getSelectedItem().toString().substring(2);
		addEmployeeView.employeeNoTextfield.setText(empId+year);
	}
	
	
	
}








