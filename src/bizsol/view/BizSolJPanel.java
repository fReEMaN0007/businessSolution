package bizsol.view;

import java.awt.Color;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.jdatepicker.JDatePanel;

import javax.swing.BorderFactory;

public class BizSolJPanel extends JPanel{
	
	
		public JPanel titlePanel = new JPanel();
		public JPanel bodyPanel = new JPanel();
		public JPanel footerPanel = new JPanel();
		JLabel titleLabel = new JLabel();
		JLabel footerLabel = new JLabel();
		public JLabel bodyLabel = new JLabel();
		public  JLabel  value = new JLabel();
		//=====
		JLabel body = new JLabel();
		JLabel shift = new JLabel();
		JLabel month = new JLabel();
		JLabel date = new JLabel();
		
		
		JPanel datePanel = new JPanel();
		JPanel dayPanel = new JPanel();
		JPanel monthPanel = new JPanel();
		JPanel dayNmonthPanel = new JPanel();
		String text;
		BizSolJPanel[] day = new BizSolJPanel[29];
		String week;
	
	
	
	BizSolJPanel(JPanel panel,String title,String body,String footer){
		
		titleLabel.setText(title);
		bodyLabel.setText(body);
		footerLabel.setText(footer);
		Dimension d190x150 = new Dimension(190,150);
		setPreferredSize(d190x150);
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		titlePanel.setPreferredSize(new Dimension(190,30));
		titlePanel.setBackground(Color.GRAY);
		bodyPanel.setPreferredSize(new Dimension(190,95));
		bodyPanel.setBackground(Color.white);
		footerPanel.setPreferredSize(new Dimension(190,30));
		//footer.setBackground(Color.GRAY);
		titleLabel.setForeground(Color.white);
		titlePanel.add(titleLabel);
		footerLabel.setFont((new Font("Arial", Font.ITALIC, 14)));
		bodyLabel.setFont((new Font("Arial", Font.PLAIN, 90)));
		bodyPanel.add(bodyLabel);
		footerPanel.add(footerLabel);
		add(titlePanel);
		add(bodyPanel);
		add(footerPanel);
		panel.add(this);
		
	}



	public BizSolJPanel(JPanel panel, String title, String body, String footer, Dimension d80x80) {
		
		titleLabel.setText(title);
		bodyLabel.setText(body);
		footerLabel.setText(footer);
		JScrollPane happeningScroll = new JScrollPane(); 
	
		
		setPreferredSize(d80x80);
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		titlePanel.setPreferredSize(new Dimension(80,20));
		titlePanel.setBackground(Color.GRAY);
		bodyPanel.setPreferredSize(new Dimension(80,40));
		bodyPanel.setBackground(Color.white);
		footerPanel.setPreferredSize(new Dimension(80,20));
		//footer.setBackground(Color.GRAY);
		titleLabel.setForeground(Color.white);
		titlePanel.add(titleLabel);
		footerLabel.setFont((new Font("Arial", Font.ITALIC, 12)));
		bodyLabel.setFont((new Font("Arial", Font.PLAIN, 30)));
		bodyPanel.add(bodyLabel);
		footerPanel.add(footerLabel);
		
		add(titlePanel);
		
		if(210 == d80x80.getWidth()) {
			
			
			titlePanel.setPreferredSize(new Dimension(210,20));
			bodyPanel.setPreferredSize(new Dimension(180,60+Integer.valueOf(footer)));
			bodyPanel.setLayout(new FlowLayout(FlowLayout.LEADING,5,3));
			bodyLabel.setFont(new Font("Arial",Font.ITALIC,12));
	
			//bodyPanel.setBackground(Color.red);
			footerPanel.setVisible(false);
			
			happeningScroll.getViewport().add(bodyPanel);
			happeningScroll.setPreferredSize(new Dimension(210,60));
			happeningScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			add(happeningScroll);
		}
		else {
			add(bodyPanel);
		}
	

		add(footerPanel);
		panel.add(this);
	}
	
	public BizSolJPanel(JPanel panel, String title, String body, String value2, Dimension d80x80,int type) {
		
		
		titleLabel.setText(title);
		titleLabel.setFont((new Font("Arial", Font.BOLD, 16)));
		
		bodyLabel.setText(body);
		bodyLabel.setFont((new Font("Arial", Font.ITALIC, 13)));
		this.value.setText(value2);
		System.out.println(bodyLabel.getPreferredSize().getHeight());
		//bodyLabel.setPreferredSize();
		
		
		setPreferredSize(d80x80);
//		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.add(titleLabel);
		titleLabel.setPreferredSize(new Dimension(160,20));
		this.add(Box.createVerticalStrut(60));
		this.add(bodyLabel);
		bodyLabel.setPreferredSize(new Dimension(80,(int) (bodyLabel.getPreferredSize().getHeight())));
		this.add(value);
		if(type == 2) {
			titleLabel.setPreferredSize(new Dimension(320,15));
			bodyLabel.setPreferredSize(new Dimension(200,(int) (bodyLabel.getPreferredSize().getHeight())));
			
		}
		
		
		panel.add(this);
	}
	
	public BizSolJPanel(JPanel panel, String title, String body, String value, String type) {
		
		JPanel testa = new JPanel();
		JPanel testb = new JPanel();
		JPanel testb1 = new JPanel();
		JPanel testb2 = new JPanel();
		
		JLabel dept = new JLabel(title);
		JLabel val = new JLabel(body);
		JLabel role = new JLabel("<html>"+value+"<br/>"+type+"</html>");
	
		//this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.setPreferredSize(new Dimension(180,60));
		this.setBackground(Color.white);
		this.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		testa.setPreferredSize(new Dimension(60,60));
		testa.setBackground(Color.gray);
		testa.add(val);
		testa.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		val.setFont(new Font("Arial", Font.BOLD,38));
		val.setForeground(Color.white);
		testb.setPreferredSize(new Dimension(120,60));
		testb.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		testb.setBackground(Color.white);
		testb1.add(role);
		role.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));
		role.setFont((new Font("Arial", Font.ITALIC, 14)));
		testb1.setLayout(new FlowLayout(FlowLayout.LEADING,2,0));
		testb1.setPreferredSize(new Dimension(120,40));
		testb1.setBackground(Color.white);
		
		testb2.setPreferredSize(new Dimension(120,20));
		testb2.setBackground(Color.LIGHT_GRAY);
		testb2.setLayout(new FlowLayout(FlowLayout.CENTER,2,2));
		testb2.add(dept);
		
	
		testb.add(testb2);
		testb.add(testb1);
		
		
		this.add(testa);
		this.add(testb);
		testb.add(testb1);
		
		panel.add(this);
	}
	
	public BizSolJPanel(JPanel panel, String text,Dimension dim,int fontSize) {
		this.text = text;
		Color lightgray  =new Color(230,230,230);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		
//		String ee = text.substring("");
	
		this.setPreferredSize(dim);
		body.setText(this.text);
		body.setFont(new Font("Arial",Font.BOLD,fontSize));
		this.setBackground(lightgray);

		this.add(body);
		this.setBorder(new MatteBorder(0,1,0,0,Color.gray));
		
		if(fontSize==12 && dim.getWidth()!=(180)) {
			this.setLayout(new FlowLayout(FlowLayout.CENTER,0,3));
			body.setBorder(new EmptyBorder(4,0,0,0));
			body.setFont(new Font("Arial",Font.ITALIC,fontSize));
			//body.setPreferredSize(new Dimension(115,25));
//			shift.setText(ee);

			body.setText(text.substring(0,text.lastIndexOf('.')+1));
			shift.setText(text.substring(text.lastIndexOf('.')+1,text.lastIndexOf('/')));
			date.setText(text.substring(text.lastIndexOf('/')+1));
			
			this.add(shift);
//			this.add(date);  //remove the date, but didn't remove the code :)
		}
		if(fontSize==16) {
			datePanel.setPreferredSize(new Dimension(18,25));
			datePanel.setBackground(Color.DARK_GRAY);
			body.setForeground(Color.white);
			body.setFont(new Font("Arial",Font.BOLD,13));
			body.setText(this.text.substring(0,this.text.lastIndexOf("Y")+1));
			
			this.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
			this.add(datePanel);
			this.remove(body);
			dayPanel.setBackground(Color.DARK_GRAY);
			dayPanel.setLayout(new FlowLayout(FlowLayout.LEFT,2,0));
			dayPanel.setPreferredSize(new Dimension(92,14));
			monthPanel.setPreferredSize(new Dimension(92,12));
			monthPanel.setLayout(new FlowLayout(FlowLayout.LEFT,2,0));
			monthPanel.setBackground(Color.white);
			dayNmonthPanel.setPreferredSize(new Dimension(92,25));
			dayNmonthPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
			month.setText(this.text.substring(this.text.indexOf("-")+1,this.text.lastIndexOf("-")).toUpperCase());
			month.setFont(new Font("Arial",Font.ITALIC,11));
			date.setText(this.text.substring(this.text.indexOf("Y")+1,this.text.indexOf("Y")+3));
			date.setFont(new Font("Arial",Font.BOLD,14));
			date.setForeground(Color.white);
		
			datePanel.add(date);
			
			monthPanel.add(month);
			dayNmonthPanel.add(dayPanel);
			dayNmonthPanel.add(monthPanel);
			this.add(dayNmonthPanel);
			dayPanel.add(body);
			
		}
	
		
		panel.add(this);
	}
	
	public BizSolJPanel(JPanel panel,LinkedHashMap<String,HashMap<String,String>> data, int fontSize,String empNum) {
		String emp = empNum;
		int panelhHeight=0;
		Color lightgray  =new Color(230,230,230);
		this.setPreferredSize(new Dimension(1000,50));
		this.setLayout(new FlowLayout(FlowLayout.LEADING,0,1));
		Font font = new Font("Arial",Font.BOLD,fontSize);
		JPanel namePanel = new JPanel();
		JPanel numberPanel = new JPanel();
		numberPanel.setPreferredSize(new Dimension(30,48));
		numberPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,2,0));
		numberPanel.setBackground(Color.LIGHT_GRAY);
		namePanel.setPreferredSize(new Dimension(175,48));
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		namePanel.setBackground(Color.white);
		JLabel nameLabel = new JLabel();
		JLabel positionLabel = new JLabel();
		JLabel empLabel = new JLabel();
		JLabel number = new JLabel();
		number.setFont(new Font("Arial",Font.BOLD,12));
//		number.setForeground(Color.white);
		
		number.setText(data.get(emp).get("counter")+".)");
		nameLabel.setText(data.get(emp).get("fullName"));
		nameLabel.setPreferredSize(new Dimension(180,(int) nameLabel.getPreferredSize().getHeight()));
		positionLabel.setText("Group "+data.get(emp).get("group")+" - "+data.get(emp).get("position"));
		empLabel.setText("["+emp+"]");
		positionLabel.setFont(new Font("Arial",Font.ITALIC,12));
		
//		//"Orale, Angelo J." format name
//		BizSolJPanel namePanelTop = new BizSolJPanel(namePanel,data.get(emp).get("fullName"),new Dimension(180,20),14);
//		//"T.L. [dpt03-emp01-086]" format position
//		BizSolJPanel namePanelBottom = new BizSolJPanel(namePanel,data.get(emp).get("position")+ " ["+emp+"]",new Dimension(180,15),12);
//		namePanelTop.setLayout(new FlowLayout(FlowLayout.LEADING,5,0));
//		namePanelBottom.setLayout(new FlowLayout(FlowLayout.LEADING,5,0));
		
		namePanel.add(nameLabel);
		namePanel.add(positionLabel);
		namePanel.add(empLabel);
		numberPanel.add(number);
		this.add(numberPanel);
		this.add(namePanel);
		
		//<html>8 a.m. - 5 p.m.<br/><b>Morning Shift</b></html> format string

		LocalDate dayLocal = LocalDate.parse(data.get(emp).get("schedPeriod"));
		String dayDate = dayLocal.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		
		this.week  = data.get(emp).get("week");
		
	
		
		
		for(int x=1;x<=28;x++) {
			day[x] = new BizSolJPanel(this,data.get(emp).get("Day"+x)+"/"+dayDate,new Dimension(111,48),12); 
			dayLocal=dayLocal.plusDays(1);
			dayDate = dayLocal.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
			day[x].setVisible(false);
			
			if(data.get(emp).get("Day"+x).equals("Rest Day") || data.get(emp).get("Day"+x).equals(null)) {
				day[x].setBackground(Color.white);
				day[x].setLayout(new FlowLayout(FlowLayout.CENTER,0,10));	
			}
		}
		
		setEntry(week);

		
		
		
//		for(int x=1;x<=7;x++) {
//			if(data.get(emp).get("Day"+x).equals("Rest Day") || data.get(emp).get("Day"+x).equals(null)) {
//				day[x].setBackground(Color.white);
//				day[x].setLayout(new FlowLayout(FlowLayout.CENTER,0,10));	
//			}
//		}
		
		this.setBackground(Color.gray);
		panel.add(this);
	}

	  String setDate(int choice) {
		System.out.println(getText());
		String period;
		String oldText = getText();
		oldText.substring(oldText.indexOf("Y")+1);
		String oldDateString = oldText.substring(oldText.indexOf("Y")+1);
		LocalDate oldDate = LocalDate.parse(oldDateString,(DateTimeFormatter
			    .ofPattern("dd-MMMM-yy")));
		
		
		String newDate = oldText.substring(oldText.indexOf("Y")+1).toString();

		this.text = oldText.substring(0,oldText.indexOf("Y")+1) + oldDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		period = oldDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		
		if(choice==1) {
			this.text = oldText.substring(0,oldText.indexOf("Y")+1) + oldDate.minusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
			period = oldDate.minusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		}
		else if (choice== 2) {
			this.text = oldText.substring(0,oldText.indexOf("Y")+1) + oldDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
			period = oldDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		}
		else {
			this.text = oldText.substring(0,oldText.indexOf("Y")+1) + oldDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
			period = oldDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd-MMMM-yy")).toString();
		}
		
		body.setText(this.text.substring(0,this.text.lastIndexOf("Y")+1));
		month.setText(this.text.substring(this.text.indexOf("-")+1,this.text.lastIndexOf("-")).toUpperCase());
		date.setText(this.text.substring(this.text.indexOf("Y")+1,this.text.indexOf("Y")+3));
	 
	
		return period;
		
	 }
	 String getText() {
		 return this.text;
		 
	 }
	 
	 void setEntry(String week) {

			switch (week){
			case	"1":
								for(int x=1;x<=7;x++) {
								day[x].setVisible(true);
								day[x+7].setVisible(false);
								day[x+14].setVisible(false);
								day[x+21].setVisible(false);}
			break;
			
				
			case	"2":
								for(int x=8;x<=14;x++) {
								day[x].setVisible(true);
								day[x-7].setVisible(false);}
			break;
			case	"3":		
								for(int x=15;x<=21;x++) {
								day[x].setVisible(true);
								day[x-7].setVisible(false);
								day[x-14].setVisible(false);}
			break;

			case	"4":	
								for(int x=22;x<=28;x++) {
								day[x].setVisible(true);
								day[x-7].setVisible(false);
								day[x-14].setVisible(false);
								day[x-21].setVisible(false);}
			break;

			}
		 
		 
	 }
	 
	 int getWeek(int choice) {
		 
		 if(choice==2) {
			 week= String.valueOf(Integer.valueOf(week)+1);
			 
			 if (Integer.valueOf(week)>4) {
				 week = "1";
			
			 }
		 }
		 else {
			 week= String.valueOf(Integer.valueOf(week)-1);
			 if (Integer.valueOf(week)<1) {
			 week = "4";
			 }
		 }
		
		 return Integer.valueOf(week);
		 
	 }
	 
}
