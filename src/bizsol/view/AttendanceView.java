package bizsol.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;



public class AttendanceView {
	
	public static JPanel attendanceMainPanel = new JPanel();
	
	JPanel topPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	JPanel midPanelTop = new JPanel();
	JPanel midPanelTopA = new JPanel();
	JPanel midPanelTopB = new JPanel();
	JPanel midPanelTopB1 = new JPanel();
	JPanel midPanelTopB2 = new JPanel();
	JPanel midPanelMid = new JPanel();
	public JPanel midPanelBottom = new JPanel();
	JPanel midSortingPanel = new JPanel();
	JPanel midEntryPanelb = new JPanel();
	BizSolJPanel midEntryPanel1;
	BizSolJPanel midEntryPanel2;
	BizSolJPanel midEntryPanel3;
	BizSolJPanel midEntryPanel4;
	BizSolJPanel midEntryPanel5;
	BizSolJPanel midEntryPanel6;
	BizSolJPanel midEntryPanel7;
	ArrayList <BizSolJPanel> midEntryPanelx = new ArrayList <BizSolJPanel>();
	
	public JButton prev = new JButton();
	public JButton next = new JButton();
	JLabel period = new JLabel("period - period");
	JLabel topSchedule = new JLabel("Schedule Maker");
	static String week ="1";
	boolean toggle = true;
	
	
	
	String[] sort = {"All","All Group","Group 1","Group 2", "Group 3","Group 4"};
	public JComboBox sortingCombo = new JComboBox(sort);
	JScrollPane scroll = new JScrollPane(midPanelBottom);
	
	static LinkedHashMap<String,HashMap<String,String>> scheduleData = new LinkedHashMap <String,HashMap<String,String>>();
	static int numberOfScheduleEntry=0;
	FlowLayout flowC = new FlowLayout(FlowLayout.CENTER,0,0);
	FlowLayout flowL = new FlowLayout(FlowLayout.LEADING,0,0);
	FlowLayout flowR = new FlowLayout(FlowLayout.RIGHT,0,0);
	
	

	JLabel construct = new JLabel();

	
	public void showAttendance(JPanel panel) {
		attendanceMainPanel.setPreferredSize(new Dimension(1000,700));
		attendanceMainPanel.setLayout(new FlowLayout(FlowLayout.LEADING ,0,0));
		
		topPanel.setPreferredSize(new Dimension(1000,100));
		topPanel.setBackground(Color.gray);
		topSchedule.setFont(new Font("Arial",Font.BOLD, 95));
		topSchedule.setForeground(Color.WHITE);
		topPanel.add(topSchedule);
		
		midPanel.setPreferredSize(new Dimension(1000,550));
		midPanel.setLayout(new FlowLayout(FlowLayout.LEADING ,0,0));
		midPanel.setBackground(Color.white);
		
		midPanelTop.setPreferredSize(new Dimension(1000,50));
		midPanelTop.setBackground(Color.white);
		midPanelTop.setLayout(flowL);
		midPanelTopA.setPreferredSize(new Dimension(205,50));
		midPanelTopA.setBackground(Color.white);
		midPanelTopB.setPreferredSize(new Dimension(334,50));
		midPanelTopB.setBackground(Color.white);
		midPanelTopB.setLayout(flowC);
		midPanelTopB1.setPreferredSize(new Dimension(334,25));
		midPanelTopB1.setBackground(Color.white);
		midPanelTopB2.setPreferredSize(new Dimension(334,25));	
		midPanelTopB2.setBackground(Color.white);
		midPanelTopB2.setLayout(flowL);

		
		prev.setPreferredSize(new Dimension(50,25));
		prev.setText("<<");
		prev.setFocusable(false);
		prev.setFont(new Font("Arial",Font.BOLD,14));
		period.setPreferredSize(new Dimension(234,25) );
		period.setHorizontalAlignment(SwingConstants.CENTER);
		LocalDate monday = LocalDate.now();
	
		while(!monday.getDayOfWeek().toString().equals("MONDAY")) {
			monday = monday.minusDays(1);
		
		}
		
		String monDate = monday.format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		String tueDate = monday.plusDays(1).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		String wedDate = monday.plusDays(2).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		String thurDate = monday.plusDays(3).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		String friDate = monday.plusDays(4).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		String satDate = monday.plusDays(5).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		String sunDate = monday.plusDays(6).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		
		
		period.setText(monday.format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString() +"  To  "+monday.plusDays(6).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString());
		
		//period.setText(this.scheduleData.get("schedPeriod").toString());
	
		
		next.setPreferredSize(new Dimension(50,25));
		next.setText(">>");
		next.setFocusable(false);

		
		
		
		midPanelMid.setPreferredSize(new Dimension(1000,25));
		midPanelMid.setLayout(new FlowLayout(FlowLayout.LEADING ,0,0));
		midPanelMid.setBackground(Color.DARK_GRAY);
		
//		midPanelBottom.setPreferredSize(new Dimension(1000,1000));s
		midPanelBottom.setLayout(new FlowLayout(FlowLayout.LEADING ,0,0));
		
		midSortingPanel.setPreferredSize(new Dimension(205,25));
		midSortingPanel.setBackground(Color.gray);
		midSortingPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		
		
		midPanelTopB2.add(prev);
		midPanelTopB2.add(period);
		midPanelTopB2.add(next);
		midPanelTopB.add(midPanelTopB1);
		midPanelTopB.add(midPanelTopB2);
		midPanelTop.add(midPanelTopA);
		midPanelTop.add(midPanelTopB);
	
		
		midPanel.add(midPanelTop);
		midPanel.add(midPanelMid);
		
		scroll.setPreferredSize(new Dimension(1000,490));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
	
		
		sortingCombo.setPreferredSize(new Dimension(205,(int)sortingCombo.getPreferredSize().getHeight()));
		sortingCombo.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
		((JLabel)sortingCombo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		sortingCombo.setFocusable(false);
		

		
	
	
		midPanel.add(scroll);
		midSortingPanel.add(sortingCombo);
		midPanelMid.add(midSortingPanel);
		
		Dimension dim115x25 = new Dimension(111,25);
		midEntryPanel1 = new BizSolJPanel(midPanelMid,"MONDAY"+monDate,dim115x25,16);
		midEntryPanel2 = new BizSolJPanel(midPanelMid,"TUESDAY"+tueDate,dim115x25,16);
		midEntryPanel3 = new BizSolJPanel(midPanelMid,"WEDNESDAY"+wedDate,dim115x25,16);
		midEntryPanel4 = new BizSolJPanel(midPanelMid,"THURSDAY"+thurDate,dim115x25,16);
		midEntryPanel5 = new BizSolJPanel(midPanelMid,"FRIDAY"+friDate,dim115x25,16);
		midEntryPanel6 = new BizSolJPanel(midPanelMid,"SATURDAY"+satDate,dim115x25,16);
		midEntryPanel7 = new BizSolJPanel(midPanelMid,"SUNDAY"+sunDate,dim115x25,16);
		
		
	
		
		bottomPanel.setPreferredSize(new Dimension(1000,50));
		bottomPanel.setBackground(Color.yellow);
		


		attendanceMainPanel.add(topPanel);
		attendanceMainPanel.add(midPanel);
		attendanceMainPanel.add(bottomPanel);
		panel.add(attendanceMainPanel);
	
	
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public HashMap<String,HashMap<String,String>> setSchedule(HashMap<String,HashMap<String,String>> scheduleData) {
		
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMinimum()); //put the scroll bar always on 0 position
		AttendanceView.scheduleData.putAll(scheduleData);
		numberOfScheduleEntry = scheduleData.size();
		Set<String> a = scheduleData.keySet();
		Object[] b ;
		b = a.toArray();
	
		System.out.println(AttendanceView.scheduleData.get("info")+"INFOOOOOOOOOO");
		if(AttendanceView.scheduleData.get("info").get("availability").equals("No Schedule Found")) {
			System.out.println("setSchedule BREAK not availble");	
			return scheduleData;
		}
		else { 
			System.out.println("ITO?");
					if (toggle) { // if true the panels will get this week, if false the panel will get the week outside
					week = scheduleData.get(b[1]).get("week");
					toggle = false;	
					}
				
			midPanelBottom.removeAll();
			String sort="group";
			int counter=0;
			String selected = "";
	
			ArrayList<String> g1 = new ArrayList<String>();
			ArrayList<String> g2 = new ArrayList<String>();
			ArrayList<String> g3 = new ArrayList<String>();
			ArrayList<String> g4 = new ArrayList<String>();
			while(g1.size()<10) {
				g1.add("");
			}
			while(g2.size()<10) {
				g2.add("");
			}
			while(g3.size()<10) {
				g3.add("");
			}
			while(g4.size()<10) {
				g4.add("");
			}
			
			 System.out.println(this.scheduleData.size());
			 
			this.scheduleData.remove("info");
			System.out.println(this.scheduleData.size());
		  for (Entry<String, HashMap<String, String>> entry : this.scheduleData.entrySet()) {
			  
			
	          if(this.scheduleData.get(entry.getKey()).get("group").toString().equals("1")) {
	        	  if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Manager")){
	        		  if(g1.get(0)=="") {
	        			  g1.set(0, entry.getKey());
	        		  }
	        		  else {
	        			  g1.set(1, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Supervisor")) {
	        		  if(g1.get(2)=="") {
	        			  g1.set(2, entry.getKey());
	        		  }
	        		  else {
	        			  g1.set(3, entry.getKey());
	        		  }        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Assistant Supervisor")) {
	        		  if(g1.get(4)=="") {
	        			  g1.set(4, entry.getKey());
	        		  }
	        		  else {
	        			  g1.set(5, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Team Leader")) {
	        		  if(g1.get(6)=="") {
	        			  g1.set(6, entry.getKey());
	        		  }
	        		  else {
	        			  g1.add(6, entry.getKey());
	        		  }  ;
	        	  }
	        	  else {
	        		  g1.add(entry.getKey());
	        	  }
	          }
	          
	          else if(this.scheduleData.get(entry.getKey()).get("group").toString().equals("2")) {
	        	  if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Manager")){
	        		  if(g2.get(0)=="") {
	        			  g2.set(0, entry.getKey());
	        		  }
	        		  else {
	        			  g2.set(1, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Supervisor")) {
	        		  if(g2.get(2)=="") {
	        			  g2.set(2, entry.getKey());
	        		  }
	        		  else {
	        			  g2.set(3, entry.getKey());
	        		  }        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Assistant Supervisor")) {
	        		  if(g2.get(4)=="") {
	        			  g2.set(4, entry.getKey());
	        		  }
	        		  else {
	        			  g2.set(5, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Team Leader")) {
	        		  if(g2.get(6)=="") {
	        			  g2.set(6, entry.getKey());
	        		  }
	        		  else {
	        			  g2.add(6, entry.getKey());
	        		  }  ;
	        	  }
	        	  else {
	        		  g2.add(entry.getKey());
	        	  }
	          }	          
	          else if(this.scheduleData.get(entry.getKey()).get("group").toString().equals("3")) {
	        	  if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Manager")){
	        		  if(g3.get(0)=="") {
	        			  g3.set(0, entry.getKey());
	        		  }
	        		  else {
	        			  g3.set(1, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Supervisor")) {
	        		  if(g3.get(2)=="") {
	        			  g3.set(2, entry.getKey());
	        		  }
	        		  else {
	        			  g3.set(3, entry.getKey());
	        		  }        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Assistant Supervisor")) {
	        		  if(g3.get(4)=="") {
	        			  g3.set(4, entry.getKey());
	        		  }
	        		  else {
	        			  g3.set(5, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Team Leader")) {
	        		  if(g3.get(6)=="") {
	        			  g3.set(6, entry.getKey());
	        		  }
	        		  else {
	        			  g3.add(6, entry.getKey());
	        		  }  ;
	        	  }
	        	  else {
	        		  g3.add(entry.getKey());
	        	  }
	          }
	          
	          else {//4
	        	  if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Manager")){
	        		  if(g4.get(0)=="") {
	        			  g4.set(0, entry.getKey());
	        		  }
	        		  else {
	        			  g4.set(1, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Supervisor")) {
	        		  if(g4.get(2)=="") {
	        			  g4.set(2, entry.getKey());
	        		  }
	        		  else {
	        			  g4.set(3, entry.getKey());
	        		  }        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Assistant Supervisor")) {
	        		  if(g4.get(4)=="") {
	        			  g4.set(4, entry.getKey());
	        		  }
	        		  else {
	        			  g4.set(5, entry.getKey());
	        		  }  
	        	  }
	        	  else if(this.scheduleData.get(entry.getKey()).get("position").toString().equals("Team Leader")) {
	        		  if(g4.get(6)=="") {
	        			  g4.set(6, entry.getKey());
	        		  }
	        		  else {
	        			  g4.add(6, entry.getKey());
	        		  }  ;
	        	  }
	        	  else {
	        		  g4.add(entry.getKey());
	        	  }
	          }
	          
	        
		  }
		  while(g1.contains("")&&g2.contains("")&&g3.contains("")&&g4.contains("")) {
			  g1.remove("");
			  g2.remove("");
			  g3.remove("");
			  g4.remove("");
			  
		  }
		    
		  int iterator = 0;
			
				if(sortingCombo.getSelectedItem()=="Group 1") {
					midPanelBottom.removeAll();
					 while(g1.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g1.get(iterator)).replace("counter", String.valueOf(counter));
						scheduleData.get(g1.get(iterator)).replace("week",week); //use to chane the week when use sorting
						
						 midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g1.get(iterator)));	
						  iterator++;				
					  }
				}
				else if(sortingCombo.getSelectedItem()=="Group 2") {
					midPanelBottom.removeAll();
					 while(g2.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g2.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g2.get(iterator)).replace("week",week);
						 
						 midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g2.get(iterator)));	
						  iterator++;		
	
					  }
			
				
				}
				else if(sortingCombo.getSelectedItem()=="Group 3") {
					midPanelBottom.removeAll();
					 while(g3.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g3.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g3.get(iterator)).replace("week",week);
						 
						 midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g3.get(iterator)));	
						  iterator++;
						  
					  }
				}
				else if(sortingCombo.getSelectedItem()=="Group 4") {
					midPanelBottom.removeAll();
					 while(g4.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g4.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g4.get(iterator)).replace("week",week);
						 
						  midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g4.get(iterator)));	
						  iterator++;
						  
					  }
				}
				else if(sortingCombo.getSelectedItem()=="All Group") {
					midPanelBottom.removeAll();
					 while(g1.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g1.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g1.get(iterator)).replace("week",week);
						 
						  midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g1.get(iterator)));	
						  iterator++;
						
					  }
					 iterator=0;
					 while(g2.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g2.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g2.get(iterator)).replace("week",week);
						 
						  midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g2.get(iterator)));	
						  iterator++;
						 
					  }
					 iterator=0;
					 while(g3.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g3.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g3.get(iterator)).replace("week",week);
						 
						 midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g3.get(iterator)));	
						  iterator++;
						
					  }
					 iterator=0;
					 while(g4.size() > iterator) {
						 counter++;
						 this.scheduleData.get(g4.get(iterator)).replace("counter", String.valueOf(counter));
						 scheduleData.get(g4.get(iterator)).replace("week",week);
						 
						 midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,g4.get(iterator)));	
						  iterator++;
						 
					  }
									
				}
				else {
					this.scheduleData.remove("info");
					midPanelBottom.removeAll();
					System.out.println(week+"ALL <<<<<<<<<<<<<<<<<<<<<<<<<");
					  for (Entry<String, HashMap<String, String>> entry : this.scheduleData.entrySet()) {
						  scheduleData.get(entry.getKey()).replace("week",week);
						  
						  midEntryPanelx.add(new BizSolJPanel(midPanelBottom,this.scheduleData,12,entry.getKey()));				
						  counter++;
						  System.out.print(toggle);
						  System.out.println(scheduleData.get(b[1]).get("Day1")+"DAAAAAAAAAAAAAAAAAY");
						
					  }
				}
			
			System.out.println(counter + "counter");
	//		System.out.println(LocalDate.now());
	//		System.out.println(LocalDate.now().getDayOfWeek());		
			System.out.println(midPanelBottom.getPreferredSize());
			int panelHeight= (counter*52) + (counter*2);
			midPanelBottom.setPreferredSize(new Dimension(1000,panelHeight));	
		//JOptionPane.showMessageDialog(midPanelBottom,"Done!");  
		//	midPanelBottom.repaint();
			//midPanelBottom.revalidate();
			
			}
		return scheduleData;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public HashMap<String,String> createOption(HashMap<String,HashMap<String,String>> dataInfo) {
		System.out.println("createOption");
		HashMap <String,String> data = new HashMap<String,String>();
		String ans = "";
		String[] choices;
		LocalDate date = LocalDate.parse(dataInfo.get("info").get("date"),(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println(date);
		
		
		
		while(!date.getDayOfWeek().toString().equals("MONDAY")) {
			date = date.minusDays(1);
		}
		
		
		String startDate= date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")).toString();
		String endDate = date.plusDays(27).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")).toString();
		
		String nextStartDate= date.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")).toString();
		String nextEndDate = date.plusDays(34).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")).toString();
		if(dataInfo.get("info").get("from").equals("1")) {
			choices = new String[]{"<html>1.) I want to auto create a schedule for this week, starting from <br/>["+startDate+" to "+endDate+"]</html>",
					"2.) Show the schedule of the upcomming week, if available.","3.) Manually Creat Schedule","4.) Do Nothing."};				
			JComboBox option = new JComboBox(choices) ;		

			
		    if(toggle==true) {
			       String  n = (String)JOptionPane.showInputDialog(null, "Select below what you want to do.", 
			    		   "No, Schedule Found.", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);    
		       
					if (n==choices[0]) {
						toggle= false;
						 	ans = "current";}
					 else if (n== choices[1]) {
						 toggle= false;
						 ans = "showNext";
						 }
					 else if (n == choices[2]) {
						 ans = "manual";	
					 	}
					 else {
					 }
		       }
		}
		
		
		else {
		choices = new String[]{"<html>1.) I want to auto create a schedule for this week, starting from <br/>["+startDate+" to "+endDate+"]</html>",
				"<html>2.) I want to auto create a schedule, starting on the upcomming week, starting from <br/>["+nextStartDate+" to "+nextEndDate+"]</html>","3.) Show the schedule of the upcomming week, if available.","4.) Manually Creat Schedule","5.) Do Nothing."};			
		JComboBox option = new JComboBox(choices) ;		
		
		if(toggle==true) {
	       String  n = (String)JOptionPane.showInputDialog(null, "Select below what you want to do.", 
	    		   "No, Schedule Found.", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		 
				 if (n==choices[0]) {
					 toggle= false;
					 	ans = "current";}
				 else if (n== choices[1]) {
					 toggle= false;
						ans = "next";	
					 }
				 else if (n == choices[2]) {
					 toggle= false;
						ans = "showNext";	
				 	}
				 else if (n == choices[3]) {
						ans = "manual";	
				 	}
				 else {
				 }
			}
		}	 
		
		data.put("ans", ans);
		data.put("date", dataInfo.get("info").get("date"));			
			return data;
	}	
	public String setWeek(int choice) {
		String date="";
		String start = midEntryPanel1.setDate(choice);
		midEntryPanel2.setDate(choice);
		midEntryPanel3.setDate(choice);
		midEntryPanel4.setDate(choice);
		midEntryPanel5.setDate(choice);
		midEntryPanel6.setDate(choice);
		String end = midEntryPanel7.setDate(choice);	
		
		
		System.out.println(midEntryPanelx.size());
		for(int x=0;x<midEntryPanelx.size();x++) {
			if(choice==2) {//plus		
			midEntryPanelx.get(x).setEntry(String.valueOf(midEntryPanelx.get(x).getWeek(2)));		
			}
			else if (choice==1){//minus
				midEntryPanelx.get(x).setEntry(String.valueOf(midEntryPanelx.get(x).getWeek(1)));
	
			}
			else midEntryPanelx.get(x).setEntry("1");
			//System.out.println(x+"<<");
		}
		
		
		System.out.println(week);
		
		if(choice ==2) {
			week = String.valueOf(Integer.valueOf(week) + 1);
			
			if (Integer.valueOf(week)>4) {
				int io=0;
				midPanelBottom.removeAll();;
				midPanelBottom.repaint();
				System.out.println("remove<<");
				// int ee = JOptionPane.showConfirmDialog(null, "Show over parent?");
				date=end;
				System.out.println(date);
				date =  LocalDate.parse(date,(DateTimeFormatter.ofPattern("dd-MMMM-yy"))).plusDays(0).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
				week="1";
				scheduleData.clear();
				midEntryPanelx.clear();
				toggle = true;
			}
		}
		else if(choice == 1){
			week = String.valueOf(Integer.valueOf(week) - 1);

			if (Integer.valueOf(week)<1) {
				int io=0;
				midPanelBottom.removeAll();;
				midPanelBottom.repaint();
				System.out.println("remove<<");
				// int ee = JOptionPane.showConfirmDialog(null, "Show over parent?");
				date=end;
				week="4";
				scheduleData.clear();
				midEntryPanelx.clear();
			}
	
		}
		else {
			week="1";
		
		}
				
		period.setText(start +"  To  "+end);

		System.out.println(week+"<<<<<<<ito?");
		
		return date;
	}
	
	public String sortingGetDate() {
		
		return midEntryPanel1.getText();
	}
	

}






