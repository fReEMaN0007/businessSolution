package bizsol.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HomeView{
	
	
	
	
	public static JPanel homeMainPanel = new JPanel();
	public static JPanel homePanel1 = new JPanel();
	public static JPanel homePanel2 = new JPanel();
	public static JPanel homePanel2p1 = new JPanel();
	public static JPanel homePanel2p2 = new JPanel();
	public static JPanel homePanel2p3 = new JPanel();
	public static JPanel homePanel2p3a = new JPanel();
	public static JPanel homePanel3 = new JPanel();
	public static JPanel homePanel3p1 = new JPanel();
	public static JPanel homePanel3p1a = new JPanel();
	public static JPanel homePanel3p1b = new JPanel();
	public static JPanel homePanel3p1c = new JPanel();
	public static JPanel homePanel3p2 = new JPanel();
	public static JPanel homePanel3p2p1 = new JPanel();
	
	public BizSolJPanel homePanel2p2A;
	
	
	BizSolJPanel homePanel3pa;
	BizSolJPanel homePanel3pb;
	BizSolJPanel homePanel3pc;
	BizSolJPanel homePanel3pd;
	BizSolJPanel homePanel3pe;
	
	String NoOfEmp;
	String onLeave;
	String suspended;
	
	static String genderValue;
	static String departmentValue;
	static String ageValue;
	static String shiftValue;
	static String contractValue;
	
	
	JLabel history = new JLabel("Latest Updates");
	JLabel upcommingLabel = new JLabel("Upcomming Events");
	JLabel population = new JLabel("Population");
	
	JLabel day = new JLabel("WEDNESDAY");
	JLabel date = new JLabel("27 August 2023");
	JLabel time = new JLabel("03:00 PM");

	int numberOfEntry;
	int panelHeight;
	String[][] vac  = new String[100][5];
	
	
	String[] columnName = {"Date","Deatil","Creator"};
	public static DefaultTableModel model = new DefaultTableModel();
	public static DefaultTableModel upModel = new DefaultTableModel();
	public static JTable historyTable = new JTable(model);
	JScrollPane historyScrollTable = new JScrollPane(historyTable);
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	
	
	public static JPanel picPanel = new JPanel();
	
	JPanel vacanciesPanel =  new JPanel();
	JScrollPane vacanciesScroll = new JScrollPane();
	
	Font one = (new Font("Arial", Font.PLAIN, 18));
	
	
	JLabel welcome = new JLabel();
		
	 String  happeningToday;
	 int happeningSize;
	 static Integer numberOfUpcomming;
	 BizSolJPanel[] upcomming = new BizSolJPanel[15];
	 String[][] upcommingArray = new String[15][3];
	 
	 ArrayList <JLabel> bulletArray = new ArrayList<JLabel>();

	 public BizSolLabel bullet1 =new BizSolLabel("1",bulletArray,14);
	 public BizSolLabel bullet2 = new BizSolLabel("2",bulletArray,14);
	 public	BizSolLabel bullet3 = new BizSolLabel("3",bulletArray,14);
	 public BizSolLabel bullet4 = new BizSolLabel("4",bulletArray,14);
	 public	BizSolLabel bullet5 = new BizSolLabel("5",bulletArray,14);
	
	 
	public void showHome(JPanel panel) {
		
		homeMainPanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		homeMainPanel.setPreferredSize(new Dimension(1000,700));
		homeMainPanel.setBackground(Color.gray);
		
		homePanel1.setPreferredSize(new Dimension(1000,58));
		//homePanel1.setBackground(Color.green);
		homePanel1.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		JPanel homePanel1p1 = new JPanel();
		JPanel homePanel1p2 = new JPanel();
		JPanel homePanel1p2a = new JPanel();
		JPanel homePanel1p2b = new JPanel();
	
		day.setFont(new Font("Arial",Font.BOLD, 75));
		day.setForeground(Color.darkGray);
		date.setFont(new Font("Arial",Font.ITALIC, 22));
		date.setForeground(Color.white);
		time.setFont(new Font("Arial",Font.BOLD, 32));
		homePanel1p1.setLayout(new FlowLayout(FlowLayout.TRAILING,3,-10));
		homePanel1p1.setPreferredSize(new Dimension(800,58));
		homePanel1p1.setBackground(Color.LIGHT_GRAY);
		homePanel1p2.setLayout(new FlowLayout(FlowLayout.TRAILING,0,0));
		homePanel1p2.setPreferredSize(new Dimension(200,58));
		//homePanel1p2.setBackground(Color.red);
		homePanel1p2a.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		homePanel1p2a.setPreferredSize(new Dimension(200,25));
		homePanel1p2a.setBackground(Color.GRAY);
		homePanel1p2b.setLayout(new FlowLayout(FlowLayout.CENTER,0,-3));
		homePanel1p2b.setPreferredSize(new Dimension(200,33));
		homePanel1p2b.setBackground(Color.WHITE);
		
		
		homePanel1p1.add(day);
		homePanel1p2a.add(date);
		homePanel1p2b.add(time);
		homePanel1p2.add(homePanel1p2a);
		homePanel1p2.add(homePanel1p2b);
		homePanel1.add(homePanel1p1);
		homePanel1.add(homePanel1p2);
		
		
		
		
		
		homePanel2.setPreferredSize(new Dimension(1000,320));
		homePanel2p1.setPreferredSize(new Dimension(200,320));
		homePanel2.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		homePanel2p1.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		//homePanel2.setBackground(Color.red);
		welcome.setText("Welcome Admin Angelo,");
		welcome.setFont(one);
		welcome.setPreferredSize(new Dimension(1000,30));	
		picPanel.setPreferredSize(new Dimension(200,250));
		picPanel.setBackground(Color.LIGHT_GRAY);
	
		homePanel2p1.add(welcome);
		homePanel2p1.add(picPanel);
		
		homePanel2p2.setPreferredSize(new Dimension(590,320));
		homePanel2p2.setLayout(new FlowLayout(FlowLayout.LEADING,5,5));
		homePanel2p2.setBackground(Color.LIGHT_GRAY);
		
		homePanel2p2A = new BizSolJPanel(homePanel2p2,"Number of Employees",NoOfEmp,"One(1) New Employee");
		BizSolJPanel homePanel2p2B = new BizSolJPanel(homePanel2p2,"On Leave",onLeave,"Zero(0) New on Vacation");
		BizSolJPanel homePanel2p2C = new BizSolJPanel(homePanel2p2,"Suspended",suspended,"Five(3) New Suspended");
		BizSolJPanel homePanel2p2D = new BizSolJPanel(homePanel2p2,"Leave Request","5","Five(5) New Request");
		BizSolJPanel homePanel2p2E = new BizSolJPanel(homePanel2p2,"Payroll","100","One Hundred(100) Pending");
		BizSolJPanel homePanel2p2F = new BizSolJPanel(homePanel2p2,"Suspended","3","Five(5) New Suspended");

		
	
		JLabel jvacant = new JLabel("Job Vacancies");
		jvacant.setForeground(Color.white);
		homePanel2p3.setPreferredSize(new Dimension(210,320));
		homePanel2p3.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
	
		
		homePanel2p3a.setPreferredSize(new Dimension(205,30));
		homePanel2p3a.setBackground(Color.gray);
		homePanel2p3a.add(jvacant);
		
		vacanciesScroll.setPreferredSize(new Dimension(205,276));
		
		//////RECYCLER OF VACANCIES/////////
		BizSolJPanel[] vacancies = new BizSolJPanel[numberOfEntry];
	
		int y=0;
		for(int x=0;x<=numberOfEntry-1;x++) {
			
			vacancies[x] = new BizSolJPanel(vacanciesPanel,vac[x][y],vac[x][y+1],vac[x][y+2],vac[x][y+3]);
		
		}
		
		vacanciesPanel.setPreferredSize(new Dimension(185,panelHeight));
		vacanciesScroll.getViewport().add(vacanciesPanel);
		//vacanciesScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		homePanel2p3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		homePanel2p3.setBackground(Color.LIGHT_GRAY);
		homePanel2p3.add(homePanel2p3a);
		homePanel2p3.add(vacanciesScroll);
		
		homePanel2.add(homePanel2p1);
		homePanel2.add(homePanel2p2);
		homePanel2.add(homePanel2p3);

		
		
		homePanel3p1a.setPreferredSize(new Dimension(499,30));
		homePanel3p1a.setBackground(Color.gray);
		history.setForeground(Color.white);
		
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		historyTable.setDefaultRenderer(String.class, centerRenderer);
		

		historyScrollTable.setPreferredSize(new Dimension(499,140));
		historyTable.setShowVerticalLines(false);
		historyTable.setForeground(Color.black);
		
		homePanel3p1b.setPreferredSize(new Dimension(499,30));
		homePanel3p1b.setBackground(Color.gray);
		homePanel3p1b.add(upcommingLabel);
		upcommingLabel.setForeground(Color.white);
		homePanel3p1c.setPreferredSize(new Dimension(499,130));
		homePanel3p1c.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		homePanel3p1c.setBackground(Color.LIGHT_GRAY);
		
	
		
		Dimension d80x80 = new Dimension(80,80);
		Dimension d160x80 = new Dimension(210,80);
		BizSolJPanel homePanel3p1c1 = new BizSolJPanel(homePanel3p1c,"Happening Today",happeningToday,String.valueOf(happeningSize),d160x80);
//	BizSolJPanel homePanel3p1c2 = new BizSolJPanel(homePanel3p1c,"August","25","4 Events",d80x80);
//		BizSolJPanel homePanel3p1c3 = new BizSolJPanel(homePanel3p1c,"September","2","6 Events",d80x80);
//		BizSolJPanel homePanel3p1c4 = new BizSolJPanel(homePanel3p1c,"October","15","1 Event",d80x80);
		
		
		
		int t=0;
		for(int x=0;x<15;x++) {
														//////month				//// date				///no. of events
			upcomming[x] = new BizSolJPanel(homePanel3p1c,upcommingArray[x][t],upcommingArray[x][t+1],upcommingArray[x][y+2],d80x80);
			if(x>2) {
				upcomming[x].setVisible(false);
			}
			if(upcommingArray[x][t]=="") {
				upcomming[x].setVisible(false);
			}
			
		}
	
		
		
		homePanel3p1c.add(bullet1);
		bullet1.setForeground(Color.blue);
		homePanel3p1c.add(bullet2);
		homePanel3p1c.add(bullet3);
		homePanel3p1c.add(bullet4);
		homePanel3p1c.add(bullet5);
		
		
		
		homePanel3p1a.add(history);
		homePanel3p1.add(homePanel3p1a);
		homePanel3p1.add(historyScrollTable);
		homePanel3p1.add(homePanel3p1b);
		homePanel3p1.add(homePanel3p1c);
		
		homePanel3p2p1.setPreferredSize(new Dimension(499,30));
		homePanel3p2p1.setBackground(Color.gray);
		population.setForeground(Color.white);
		homePanel3p2p1.add(population);
		homePanel3p2.add(homePanel3p2p1);
		
		Dimension d160x160 = new Dimension(164,143);
		Dimension d320x160 = new Dimension(332,143);
		String gender = "<html>Male<br/>Female</html>";
		String department = "<html>Human Resources<br/>Information Technology<br/>Accounting & Fininance<br/>Marketing<br/>Research and Development<br/>Production<br/>Managerial</html>";
		String age = "<html>18-25<br/>26-33<br/>34-41<br/>42-49<br/>50-59<br/>60 & above</html>";
		String shift = "<html>Day<br/>Night<br/>Graveyard<br/>Switching</html>";
		String contract = "<html>Permanent<br/>Term<br/>Project<br/>Season<br/>Casual</html>";
		
		
		 //Human Resources, IT, Accounting and Finance, Marketing, Research and Development (R&D), and Production.
		
		
		homePanel3pa = new BizSolJPanel(homePanel3p2,"Gender",gender,genderValue,d160x160,1);
		homePanel3p2.add(Box.createHorizontalStrut(3));
		homePanel3pb = new BizSolJPanel(homePanel3p2,"Department",department,departmentValue,d320x160,2);
		homePanel3pc = new BizSolJPanel(homePanel3p2,"Age",age,ageValue,d160x160,1);
		homePanel3p2.add(Box.createVerticalStrut(149));
		homePanel3p2.add(Box.createHorizontalStrut(3));
		homePanel3pd = new BizSolJPanel(homePanel3p2,"Shift",shift,shiftValue,d160x160,1);
		homePanel3p2.add(Box.createHorizontalStrut(3));
		homePanel3pe = new BizSolJPanel(homePanel3p2,"Contract",contract,contractValue,d160x160,1);
//		BizSolJPanel homePanel3pf = new BizSolJPanel(homePanel3p2,"October","","3 Events",d160x160,1);
		
		
		
		homePanel3p1.setPreferredSize(new Dimension(499,320));
		homePanel3p1.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		homePanel3p2.setPreferredSize(new Dimension(499,320));
		homePanel3p2.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		homePanel3p2.setBackground(Color.WHITE);
		homePanel3.add(homePanel3p1);
		homePanel3.add(Box.createHorizontalStrut(2));
		homePanel3.add(homePanel3p2);
		homePanel3.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		homePanel3.setPreferredSize(new Dimension(1000,320));
		homePanel3.setBackground(Color.white);
		
		
		
		
		
		
		homeMainPanel.add(homePanel1);
		homeMainPanel.add(homePanel2);
		homeMainPanel.add(homePanel3);
		panel.add(homeMainPanel);
		
//		
//		active employee
//		on vacation employee
//		suspended employee
//		notifications
//		latest updates
//		upcoming events
//		company calendar
//		hiring
//		open positions
//		applicants, candidates, interviews
//		employee count by dept, by gender, by salary grade, 
//		date, calendar, calculator,
//		upcomming bday, anniv start date
		
		
	}
	
public void setTime(String time){
	
	this.time.setText(time);
	
	}
public void setDate(String Date){
	
	this.date.setText(Date);
	
	}
public void setDay(String Day){
	
	this.day.setText(Day);
	
	}

public void setTotalEmployee(String emp){
	NoOfEmp = emp;
	}
public void setOnLeave(String onLeave){
	this.onLeave = onLeave;
	}
public void setSuspended(String suspended){
	this.suspended = suspended;
	}

public void setNewTotalEmployee(String emp){
	
	homePanel2p2A.bodyLabel.setText(emp);
	}

public void setGenderDemo(HashMap gender){
	String male,female,malePercentage,femalePercentage;
	male = gender.get("Male").toString();
	female = gender.get("Female").toString();
	malePercentage = gender.get("MalePercentage").toString();
	femalePercentage = gender.get("FemalePercentage").toString();
	
	if(genderValue==null) {
		genderValue = "<html>"+male+" ("+malePercentage+"%)"+"<br/>"+female+" ("+femalePercentage+"%)</html>";
	}
	else {
		genderValue = "<html>"+male+" ("+malePercentage+"%)"+"<br/>"+female+" ("+femalePercentage+"%)</html>";
		homePanel3pa.value.setText(genderValue);
	}
	
	}

public void setDepartmentDemo(HashMap department){
	String hr,it,af,mktg,rd,prod,mgr,hrPer,itPer,afPer,mktgPer,rdPer,prodPer,mgrPer;
	
	hr = department.get("hr").toString();
	it = department.get("it").toString();
	af = department.get("af").toString();
	mktg = department.get("mktg").toString();
	rd = department.get("rd").toString();
	prod = department.get("prod").toString();
	mgr = department.get("mgr").toString();
	
	hrPer = department.get("hrPercentage").toString();
	itPer = department.get("itPercentage").toString();
	afPer = department.get("afPercentage").toString();
	mktgPer = department.get("mktgPercentage").toString();
	rdPer = department.get("rdPercentage").toString();
	prodPer = department.get("prodPercentage").toString();
	mgrPer = department.get("mgrPercentage").toString();


	if(departmentValue==null) {

		departmentValue = "<html>"+hr+" ("+hrPer+"%)<br/>"
				+it+" ("+itPer+"%)<br/>"
				+af+" ("+afPer+"%)<br/>"
				+mktg+" ("+mktgPer+"%)<br/>"
				+rd+" ("+rdPer+"%)<br/>"
				+prod+" ("+prodPer+"%)<br/>"
				+mgr+" ("+mgrPer+"%) </html>";
	}
	else {
		departmentValue = "<html>"+hr+" ("+hrPer+"%)<br/>"
				+it+" ("+itPer+"%)<br/>"
				+af+" ("+afPer+"%)<br/>"
				+mktg+" ("+mktgPer+"%)<br/>"
				+rd+" ("+rdPer+"%)<br/>"
				+prod+" ("+prodPer+"%)<br/>"
				+mgr+" ("+mgrPer+"%) </html>";		
		homePanel3pb.value.setText(departmentValue);
	}

	}

public void setAgeDemo(HashMap age){
	String a18to25Percentage,a26to33Percentage,a34to41Percentage,a42to49Percentage,a50to59Percentage,a60upPercentage;
	String a18to25,a26to33,a34to41,a42to49,a50to59,a60up;

	a18to25Percentage = age.get("a18to25Percentage").toString();
	a26to33Percentage = age.get("a26to33Percentage").toString();
	a34to41Percentage = age.get("a34to41Percentage").toString();
	a42to49Percentage = age.get("a42to49Percentage").toString();
	a50to59Percentage = age.get("a50to59Percentage").toString();
	a60upPercentage = age.get("a60upPercentage").toString();

	a18to25 = age.get("a18to25").toString();
	a26to33 = age.get("a26to33").toString();
	a34to41 = age.get("a34to41").toString();
	a42to49 = age.get("a42to49").toString();
	a50to59 = age.get("a50to59").toString();
	a60up = age.get("a60up").toString();
		
	
	if(ageValue==null) {

		ageValue = "<html>"+a18to25+" ("+a18to25Percentage+"%)<br/>"
				+a26to33+" ("+a26to33Percentage+"%)<br/>"
				+a34to41+" ("+a34to41Percentage+"%)<br/>"
				+a42to49+" ("+a42to49Percentage+"%)<br/>"
				+a50to59+" ("+a50to59Percentage+"%)<br/>"
				+a60up+" ("+a60upPercentage+"%)<br/></html>";
	}
	else {
		ageValue = "<html>"+a18to25+" ("+a18to25Percentage+"%)<br/>"
				+a26to33+" ("+a26to33Percentage+"%)<br/>"
				+a34to41+" ("+a34to41Percentage+"%)<br/>"
				+a42to49+" ("+a42to49Percentage+"%)<br/>"
				+a50to59+" ("+a50to59Percentage+"%)<br/>"
				+a60up+" ("+a60upPercentage+"%)<br/></html>";
		homePanel3pc.value.setText(ageValue);
	}
	
	
	}
public void setShiftDemo(HashMap shift){
	String day,night,graveyard,switching,dayPercentage,nightPercentage,graveyardPercentage,switchingPercentage;

	dayPercentage = shift.get("dayPercentage").toString();
	nightPercentage = shift.get("nightPercentage").toString();
	graveyardPercentage = shift.get("graveyardPercentage").toString();
	switchingPercentage = shift.get("switchingPercentage").toString();
	
	day = shift.get("day").toString();
	night = shift.get("night").toString();
	graveyard = shift.get("graveyard").toString();
	switching = shift.get("switching").toString();

	if(shiftValue==null) {

		shiftValue = "<html>"+day+" ("+dayPercentage+"%)<br/>"
							+night+" ("+nightPercentage+"%)<br/>"
							+graveyard+" ("+graveyardPercentage+"%)<br/>"				
							+switching+" ("+switchingPercentage+"%)<br/></html>";
	}
	else {

		shiftValue = "<html>"+day+" ("+dayPercentage+"%)<br/>"
							+night+" ("+nightPercentage+"%)<br/>"
							+graveyard+" ("+graveyardPercentage+"%)<br/>"				
							+switching+" ("+switchingPercentage+"%)<br/></html>";
		homePanel3pd.value.setText(shiftValue);
	}
	
	
	
	}
public void setContractDemo(HashMap contract){
	String permanent,term,project,seasonal,casual;
	String permanentPercentage,termPercentage,projectPercentage,seasonalPercentage,casualPercentage;

	permanentPercentage = contract.get("permanentPercentage").toString();
	termPercentage = contract.get("termPercentage").toString();
	projectPercentage = contract.get("projectPercentage").toString();
	seasonalPercentage = contract.get("seasonalPercentage").toString();
	casualPercentage = contract.get("casualPercentage").toString();
	
	permanent = contract.get("permanent").toString();
	term = contract.get("term").toString();
	project = contract.get("project").toString();
	seasonal = contract.get("seasonal").toString();
	casual = contract.get("casual").toString();



	if(contractValue==null) {

		contractValue = "<html>"+permanent+" ("+permanentPercentage+"%)<br/>"
				+term+" ("+termPercentage+"%)<br/>"
				+project+" ("+projectPercentage+"%)<br/>"	
				+seasonal+" ("+seasonalPercentage+"%)<br/>"
				+casual+" ("+casualPercentage+"%)<br/></html>";
	}
	else {

		contractValue = "<html>"+permanent+" ("+permanentPercentage+"%)<br/>"
				+term+" ("+termPercentage+"%)<br/>"
				+project+" ("+projectPercentage+"%)<br/>"	
				+seasonal+" ("+seasonalPercentage+"%)<br/>"
				+casual+" ("+casualPercentage+"%)<br/></html>";
		homePanel3pe.value.setText(contractValue);
	}
		
}


public void setVacancies(String[][] vac) {
	numberOfEntry = Integer.valueOf(vac[0][4]);
	if (numberOfEntry>4) {
		panelHeight = ((numberOfEntry-4)*70)+276;
	}
	this.vac = vac;
}

public void setHappening(ArrayList<String> happening) {
	
	happeningToday = "<html>";
	for(int x=0;x<happening.size();x++) {
		
		happeningToday = happeningToday+(x+1)+".) "+happening.get(x)+"<br/>";
	}
	happeningToday = happeningToday+"</html>";
	
	System.out.println(happening.size());
	if(happening.size()>4) {
		happeningSize = (happening.size()-4) * 20;
		System.out.println(happeningSize);
	}
	
}

public void setUpcomming(HashMap<String, ArrayList<String>> upcomming) {
	System.out.println(upcomming.get("upcommingOrder").size()+"<><><><><><");
	numberOfUpcomming = upcomming.get("upcommingOrder").size();
	int numberOfUpcommingNext = upcomming.get("upcommingNextOrder").size();
	if(numberOfUpcomming>15) {
		numberOfUpcomming =15;
	}

	String[] date ;
	for (int x=0;x<numberOfUpcomming;x++) {
	date = upcomming.get("upcommingOrder").get(x).split("-");
		
		upcommingArray[x][0] = date[0];
		upcommingArray[x][1] = date[1];
		upcommingArray[x][2] = String.valueOf(upcomming.get(upcomming.get("upcommingOrder").get(x)).size()) + " Event(s)";
	}	
	if (numberOfUpcomming<15) {
		System.out.println("less 15");
		System.out.println(upcomming.get("upcommingOrder"));
		System.out.println(upcomming.get("upcommingNextOrder")+"next");
		System.out.println(upcomming.get("upcommingNextOrder").size()+"next");
		if(numberOfUpcommingNext+numberOfUpcomming>15) {
			numberOfUpcommingNext=15;
		}
		
		for(int x =upcomming.get("upcommingOrder").size();x<numberOfUpcommingNext;x++) {
			date = upcomming.get("upcommingNextOrder").get(x-upcomming.get("upcommingOrder").size()).split("-");
			upcommingArray[x][0] = date[0];
			upcommingArray[x][1] = date[1];
			upcommingArray[x][2] = String.valueOf(upcomming.get(upcomming.get("upcommingNextOrder").get(x-upcomming.get("upcommingOrder").size())).size()) + " Event(s)";	
		}
		
	}
}
public void setBulletsToWhite() {
	bullet1.setForeground(Color.DARK_GRAY);
	bullet2.setForeground(Color.DARK_GRAY);
	bullet3.setForeground(Color.DARK_GRAY);
	bullet4.setForeground(Color.DARK_GRAY);
	bullet5.setForeground(Color.DARK_GRAY);
	
}
public void setVisibleHappening(int batch) {
	switch(batch){
	case 1: for(int x=0;x<15;x++) {
			upcomming[x].setVisible(false);
			}
			for(int x=0;x<3;x++) {
			upcomming[x].setVisible(true);
			}
	break;
	case 2: for(int x=0;x<15;x++) {
			upcomming[x].setVisible(false);
			}
			for(int x=3;x<6;x++) {
			upcomming[x].setVisible(true);
			}
	break;
	case 3: for(int x=0;x<15;x++) {
			upcomming[x].setVisible(false);
			}
			for(int x=6;x<9;x++) {
			upcomming[x].setVisible(true);
			}
	break;
	case 4: for(int x=0;x<15;x++) {
			upcomming[x].setVisible(false);
			}
			for(int x=9;x<12;x++) {
			upcomming[x].setVisible(true);
			}
	break;
	case 5: for(int x=0;x<15;x++) {
			upcomming[x].setVisible(false);
			}
			for(int x=12;x<15;x++) {
			upcomming[x].setVisible(true);
				if(upcomming[x].bodyLabel.getText()==null) {
					upcomming[x].bodyPanel.setBackground(Color.LIGHT_GRAY);
					upcomming[x].titlePanel.setBackground(Color.LIGHT_GRAY);
					upcomming[x].footerPanel.setBackground(Color.LIGHT_GRAY);
				}
			}		
	break;
	}
}
public void setLatestUpdate(ResultSet rs) throws SQLException {
	model.setColumnIdentifiers(columnName);
	LocalDate today = LocalDate.now();
	LocalDate compare;
	Period period=null;
	String periodString="";
	model.setRowCount(0); //ito ang sekreto sa pag update ng table.. hayup

	historyTable.getColumnModel().getColumn(0).setPreferredWidth(100);
	historyTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
	historyTable.getColumnModel().getColumn(1).setPreferredWidth(300);
	historyTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
	historyTable.getColumnModel().getColumn(2).setPreferredWidth(100);
	historyTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

	int x=0;
	ArrayList<String[]> result = new ArrayList<String[]> ();
	
	while (rs.next()) {
		result.add(new String[3]);
		result.get(x)[0] = rs.getString(2);
		result.get(x)[1] = rs.getString(3);
		result.get(x)[2] = rs.getString(4);
		x++;
	}	
	for(int xc=result.size()-1;xc>=0;xc--) { //reverse the result set ...  kasi  walang backward cursor ang  RS sa sqlite!
		//System.out.println(result.get(2)[0]);
		compare = LocalDate.of(Integer.valueOf(result.get(xc)[0].substring(0,4)), Integer.valueOf(result.get(xc)[0].substring(5,7)), Integer.valueOf(result.get(xc)[0].substring(8)));
		period = Period.between(compare, today);
		String added="was added";
		if(period.getDays()==0) {
		periodString="Today";
		added="is added";
		}
		else if (period.getDays()==1){
		periodString=period.getDays()+" day ago";
		}
		else {
			periodString=period.getDays()+" days ago";
		}
		//====
		if(period.getDays()<=3) { //adding updates that are 3days  ago or less
			this.model.addRow(new Object[]{periodString, "\" "+result.get(xc)[1]+" \""+"  "+added,"by "+result.get(xc)[2]});	
		}
		
		
	}
	
//	compare = LocalDate.of(Integer.valueOf(rs.getString(2).substring(0,4)), Integer.valueOf(rs.getString(2).substring(5,7)), Integer.valueOf(rs.getString(2).substring(8)));
//	period = Period.between(compare, today);
//	if(period.getDays()==0) {
//		periodString="Today";
//	}
//	else {
//		periodString=period.getDays()+" day(s) ago";
//	}
//	
//	
//	this.model.addRow(new Object[]{periodString, "\" "+rs.getString(3)+" \""+"  was added","by "+rs.getString(4)});
//	System.out.println(rs.getString(4));
//	//System.out.println(result.get(1)[0]);
//	}

}




}


