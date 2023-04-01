package bizsol.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AddEmployeeView {
	
	JPanel personalDetail = new JPanel();
	ArrayList<JTextField> comp = new ArrayList<JTextField>();
	Iterator<JTextField> i = comp.iterator();
	
	BizSolTextfield firstNameTextfield = new BizSolTextfield(comp);
	BizSolTextfield middleNameTextfield = new BizSolTextfield(comp);
	BizSolTextfield lastNameTextfield = new BizSolTextfield(comp);
	BizSolTextfield emailTextfield = new BizSolTextfield(comp);
	BizSolTextfield nationalityTextfield = new BizSolTextfield(comp);
	BizSolTextfield religionTextfield = new BizSolTextfield(comp);
	BizSolTextfield mobileTextfield = new BizSolTextfield(comp);
	dateCombo datePersonal = new dateCombo();
	public dateCombo dateEmployee = new dateCombo();
	String gender[] = {"Male","Female"};
	JComboBox genderCombo = new JComboBox(gender);
	String civil[] = {"Single","Married","Divorced","Seperated","Widowed"};
	JComboBox civilCombo = new JComboBox(civil);
	BizSolTextfield addressTextfield = new BizSolTextfield(comp);
	String region[] = {"Region 1"};
	JComboBox regionCombo = new JComboBox(region);
	String province[] = {"Province","Zamboanga del Norte"};
	JComboBox provinceCombo = new JComboBox(province);
	String city[] = {"City/Municipality","San Jose del Monte"};
	JComboBox cityCombo = new JComboBox(city);
	String brgy[] = {"Barangay"};
	JComboBox brgyCombo = new JComboBox(brgy);
	String age;
	
	BizSolTextfield sssTextfield = new BizSolTextfield(comp);
	BizSolTextfield philHealthTextfield = new BizSolTextfield(comp);
	BizSolTextfield pagibigTextfield = new BizSolTextfield(comp);
	BizSolTextfield umidTextfield = new BizSolTextfield(comp);
	BizSolTextfield passPortTextfield = new BizSolTextfield(comp);
	BizSolTextfield licenseTextfield = new BizSolTextfield(comp);
	BizSolTextfield prcTextfield = new BizSolTextfield(comp);
	
	

	Dimension employmentDimTextfield = new Dimension(199,25);
	public BizSolTextfield employeeNoTextfield = new BizSolTextfield(comp);	
	String department[] = {"Human Resources","Information Technology","Accounting & Finance","Marketing","Research & Development","Production"};
	public JComboBox departmentCombo = new BizSolComboBox(department);	
	String postiion[] = {"Position 1","Position 2","Position 3","Position 4","Position 5"};
	JComboBox positionCombo = new BizSolComboBox(postiion);	
	String manager[] = {"Manager 1","Manager 2","Manager 3","Manager 4","Manager 5"};
	JComboBox managerCombo = new BizSolComboBox(manager);
	String location[] = {"Location 1","Location 2","Location 3","Location 4","Location 5"};
	JComboBox locationCombo = new BizSolComboBox(location);	
	String salary[] = {"Salary Grade 1","Salary Grade 2","Salary Grade 3","Salary Grade 4","Salary Grade 5"};
	JComboBox salaryCombo = new BizSolComboBox(salary);	

	String contract[] = {"Permanent","Term","Project","Seasonal","Casual"};
	JComboBox contractCombo = new JComboBox(contract);
	String duration[] = {"Duration","1 Month","3 Months","6 Months","1 Year","Indefinite"};
	JComboBox durationCombo = new JComboBox(duration);
	radioGroup employ = new radioGroup("WFH","On-site","Hybrid");
	String schedule[] = {"Morning","Night","Graveyard","Swithching"};
	JComboBox scheduleCombo = new JComboBox(schedule);
	String scheduleDays[] = {"Days / Week","5 Days","6 Days"};
	JComboBox scheduleDaysCombo = new JComboBox(scheduleDays);
	
	beneficiaryFields bf;
	
	JTextArea otherTextArea = new JTextArea();
	
	JButton uploadButton = new JButton("Browse"); //picture upload button
	public JButton addButton = new JButton("Add");
	JButton clearButton = new JButton("Clear All");
	public JButton	cancelButton = new JButton("Cancel");
	
	
	
	

	public void showAddEmployeeView(JPanel panel){
		var p1_1 = new JPanel();
	    p1_1.setLayout(new FlowLayout(FlowLayout.LEADING));
	    p1_1.setPreferredSize(new Dimension(405,655));
	    personalDetail.setLayout(new FlowLayout(FlowLayout.LEADING));
	    personalDetail.setPreferredSize(new Dimension(400,400));
	    Border etched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	    personalDetail.setBorder(BorderFactory.createTitledBorder(etched,"Personal Details"));
		((TitledBorder) personalDetail.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		var firstNameLabel = new BizSolLabel("First Name:",personalDetail);
		personalDetail.add(firstNameTextfield);
		var middleNameLabel = new BizSolLabel("Middle Name:",personalDetail);
		personalDetail.add(middleNameTextfield);
		var lastNameLabel = new BizSolLabel("Last Name:",personalDetail);
		personalDetail.add(lastNameTextfield);
		var emailLabel = new BizSolLabel("E-mail:",personalDetail);
		personalDetail.add(emailTextfield);
		var nationalityLabel = new BizSolLabel("Nationality:",personalDetail);
		personalDetail.add(nationalityTextfield);
		var religionLabel = new BizSolLabel("Religion:",personalDetail);
		personalDetail.add(religionTextfield);
		var mobileLabel = new BizSolLabel("Mobile No.:",personalDetail);
		personalDetail.add(mobileTextfield);
		var BirthdayLabel = new BizSolLabel("Birthday:",personalDetail);
		personalDetail.add(datePersonal.monthCombo);
		personalDetail.add(datePersonal.dayCombo);
		personalDetail.add(datePersonal.yearCombo);
		var ageLabel = new BizSolLabel("Age:",personalDetail,35,20,16);
		var newAgeLabel = new BizSolLabel("20",personalDetail,20,20,16);
		age = newAgeLabel.getText();
		
		var genderLabel = new BizSolLabel("Gender:",personalDetail);
		personalDetail.add(genderCombo);
		genderCombo.setBackground(Color.white);
		var civilLabel = new BizSolLabel("Civil Status:",personalDetail);
		civilCombo.setBorder(new EmptyBorder(0, 3, 0,0));
		civilCombo.setBackground(Color.white);
		civilLabel.setBorder(new EmptyBorder(0, 20, 0,-20));
		personalDetail.add(civilCombo);
		var addressLabel = new BizSolLabel("Address:",personalDetail);
		personalDetail.add(addressTextfield);
		regionCombo.setBackground(Color.white);
		personalDetail.add(Box.createHorizontalStrut(100));
		personalDetail.add(regionCombo);
		provinceCombo.setBackground(Color.white);
		provinceCombo.setPreferredSize(new Dimension(187,26));
		personalDetail.add(provinceCombo);
		cityCombo.setBackground(Color.white);
		personalDetail.add(Box.createHorizontalStrut(100));
		personalDetail.add(cityCombo);
		brgyCombo.setBackground(Color.white);
		brgyCombo.setPreferredSize(new Dimension(125,26));
		personalDetail.add(brgyCombo);
/////////////////////////////////////////////////////////////////////////////////////////////	   

///////////////// social //////////////////////////////////////////////////////////////////////////		
		
		var socialDetail = new JPanel();
	    socialDetail.setLayout(new FlowLayout(FlowLayout.LEADING));
	    socialDetail.setPreferredSize(new Dimension(400,240));
	    socialDetail.setBorder(BorderFactory.createTitledBorder(etched,"Social Welfare Services & Identification Cards"));
	    ((TitledBorder) socialDetail.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		var sssLabel = new BizSolLabel("SSS:",socialDetail);
		socialDetail.add(sssTextfield);
		var philHealthLabel = new BizSolLabel("PhilHealth:",socialDetail);
		socialDetail.add(philHealthTextfield);
		
		var pagibigLabel = new BizSolLabel("Pag-IBIG:",socialDetail);
		socialDetail.add(pagibigTextfield);
		
		var umidLabel = new BizSolLabel("UMID:",socialDetail);
		socialDetail.add(umidTextfield);
		
		var passPortLabel = new BizSolLabel("Passport:",socialDetail);
		socialDetail.add(passPortTextfield);
		
		var licenseLabel = new BizSolLabel("Driver License:",socialDetail);
		socialDetail.add(licenseTextfield);
		
		var prcLabel = new BizSolLabel("PRC:",socialDetail);
		socialDetail.add(prcTextfield);
		
		
		p1_1.add(personalDetail);
		p1_1.add(socialDetail);
		panel.add(p1_1);
		
	    var p1_2 = new JPanel();
	    p1_2.setLayout(new FlowLayout(FlowLayout.LEADING));
	    p1_2.setPreferredSize(new Dimension(570,655));
	    
/////////////////////////////////////////////////////////////////////////////////////////////	   

///////////////// employeeDetail //////////////////////////////////////////////////////////////////////////		
	    Dimension d198x26 = new Dimension(198,26);
	    
	    var employeeDetail = new JPanel();
		employeeDetail.setPreferredSize(new Dimension(335,335));
		employeeDetail.setBorder(BorderFactory.createTitledBorder(etched,"Employment Detail"));
		 ((TitledBorder) employeeDetail.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		
		
		var employeeNoLabel = new BizSolLabel("Employee No.:",employeeDetail,110,20,16);
		employeeDetail.add(employeeNoTextfield);
		employeeNoTextfield.setEditable(false);
		employeeNoTextfield.setPreferredSize(employmentDimTextfield);
		
		var positionLabel = new BizSolLabel("Position:",employeeDetail,110,20,16);
		positionCombo.setPreferredSize(d198x26);
		employeeDetail.add(positionCombo);
		var departmentLabel = new BizSolLabel("Department:",employeeDetail,110,20,16);
		departmentCombo.setPreferredSize(d198x26);;
		employeeDetail.add(departmentCombo);
		var managerLabel = new BizSolLabel("Manager:",employeeDetail,110,20,16);
		managerCombo.setPreferredSize(new Dimension(d198x26));;
		employeeDetail.add(managerCombo);
		var locationLabel = new BizSolLabel("Office Location:",employeeDetail,110,20,16);
		locationCombo.setPreferredSize(d198x26);
		employeeDetail.add(locationCombo);	
		var rateLabel = new BizSolLabel("Salary Grade:",employeeDetail,110,20,16);
		salaryCombo.setPreferredSize(d198x26);	
		employeeDetail.add(salaryCombo);
		var joinedLabel = new BizSolLabel("Joined Date:",employeeDetail,110,20,16);
		employeeDetail.add(dateEmployee.monthCombo);
		employeeDetail.add(dateEmployee.dayCombo);
		employeeDetail.add(dateEmployee.yearCombo);
		var employmentLabel = new BizSolLabel("Contract Type:",employeeDetail,110,20,16);
		contractCombo.setBackground(Color.white);
		employeeDetail.add(contractCombo);
		durationCombo.setPreferredSize(new Dimension(103,26));
		durationCombo.setBackground(Color.white);
		employeeDetail.add(durationCombo);
		var workSetupLabel = new BizSolLabel("Work Set-up:",employeeDetail,110,20,16);
		employeeDetail.add(employ.r1);
		employeeDetail.add(employ.r2);
		employeeDetail.add(employ.r3);
		System.out.println(employ.bg.getSelection().getActionCommand());
		var scheduleLabel = new BizSolLabel("Schedule:",employeeDetail,110,20,16);
		scheduleCombo.setBackground(Color.white);
		employeeDetail.add(scheduleCombo);
		scheduleDaysCombo.setBackground(Color.white);
		scheduleDaysCombo.setPreferredSize(new Dimension(103,26));
		employeeDetail.add(scheduleDaysCombo);		
/////////////////////////////////////////////////////////////////////////////////////////////

/////////////employee picture////////////////////////////////////////////////////////////
		var employeePicture = new JPanel();
		employeePicture.setPreferredSize(new Dimension(225,335));
		employeePicture.setBorder(BorderFactory.createTitledBorder(etched,"Employee Photo"));
		 ((TitledBorder) employeePicture.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		var img= new MyCanvas2("imgicon.png");
		img.setSize(new Dimension(210,220));
		
	
		uploadButton.setFocusable(false);
		employeePicture.add(img);
		employeePicture.add(Box.createHorizontalStrut(110));
		employeePicture.add(Box.createVerticalStrut(120));
		employeePicture.add(uploadButton);
/////////////////////////////////////////////////////////////////////////////////////////////

/////////////beneficiary////////////////////////////////////////////////////////////	
		
		var beneficiary = new JPanel();
		beneficiary.setLayout(new GridBagLayout());
		beneficiary.setPreferredSize(new Dimension(568,140));
		beneficiary.setBorder(BorderFactory.createTitledBorder(etched,"Beneficiaries"));
		 ((TitledBorder) beneficiary.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		var grdBeneficiary = new GridBagConstraints();
		bf = new beneficiaryFields(beneficiary);
/////////////////////////////////////////////////////////////////////////////////////////////

///////////// other ////////////////////////////////////////////////////////////			
		var other = new JPanel();
		other.setLayout(new FlowLayout());
		other.setPreferredSize(new Dimension(568,120));
		other.setBorder(BorderFactory.createTitledBorder(etched,"Other Notes"));
		 ((TitledBorder) other.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		
/////////////////////////////////////////////////////////////////////////////////////////////

/////////////other////////////////////////////////////////////////////////////	
		otherTextArea.setPreferredSize(new Dimension(510,1000));
		JScrollPane scrollPane = new JScrollPane(otherTextArea);
		scrollPane.setPreferredSize(new Dimension(540,80));
		other.add(scrollPane);
		
		var horizontalSeparator = new JSeparator();
		horizontalSeparator.setPreferredSize(new Dimension(565,1));
/////////////////////////////////////////////////////////////////////////////////////////////

/////////////button////////////////////////////////////////////////////////////		
		
	
	

		p1_2.add(employeeDetail);
		p1_2.add(employeePicture);
		p1_2.add(beneficiary);
		p1_2.add(other);
		p1_2.add(Box.createVerticalStrut(40));
//		p1_2.add(horizontalSeparator);
		p1_2.add(Box.createHorizontalStrut(335));
		p1_2.add(addButton);
		p1_2.add(clearButton);
		p1_2.add(cancelButton);
		getfields();
		panel.add(p1_2);
	}
	
	

	public HashMap getfields() {

	HashMap<String, String> getFields = new HashMap<String, String>();
		
		getFields.put("firstName", firstNameTextfield.getText());
		getFields.put("middleName", middleNameTextfield.getText());
		getFields.put("lastName", lastNameTextfield.getText());
		getFields.put("email", emailTextfield.getText());
		getFields.put("nationality", nationalityTextfield.getText());		
		getFields.put("religion", religionTextfield.getText());	
		getFields.put("mobile", mobileTextfield.getText());
		getFields.put("bDayMonth", datePersonal.getMonth());
		getFields.put("bDayDate", datePersonal.getDay());
		getFields.put("bDayYear", datePersonal.getYear());
		getFields.put("age", age);
		getFields.put("gender", genderCombo.getSelectedItem().toString());
		getFields.put("civilCombo", civilCombo.getSelectedItem().toString());
		getFields.put("address", addressTextfield.getText());
		getFields.put("region", regionCombo.getSelectedItem().toString());
		getFields.put("province", provinceCombo.getSelectedItem().toString());
		getFields.put("city", cityCombo.getSelectedItem().toString());
		getFields.put("brgy", brgyCombo.getSelectedItem().toString());
		
		getFields.put("sss", sssTextfield.getText());
		getFields.put("philHealth", philHealthTextfield.getText());
		getFields.put("pagIbig", pagibigTextfield.getText());
		getFields.put("umid", umidTextfield.getText());
		getFields.put("passPort", passPortTextfield.getText());
		getFields.put("license", licenseTextfield.getText());
		getFields.put("prc", prcTextfield.getText());
		
		getFields.put("employeeNo", employeeNoTextfield.getText());
		getFields.put("position", positionCombo.getSelectedItem().toString());
		getFields.put("department", departmentCombo.getSelectedItem().toString());
		getFields.put("manager", managerCombo.getSelectedItem().toString());
		getFields.put("location", locationCombo.getSelectedItem().toString());
		getFields.put("salaryGrade", salaryCombo.getSelectedItem().toString());
		getFields.put("joinedMonth", dateEmployee.monthCombo.getSelectedItem().toString());
		getFields.put("joinedDate", dateEmployee.dayCombo.getSelectedItem().toString());
		getFields.put("joinedYear", dateEmployee.yearCombo.getSelectedItem().toString());
		getFields.put("contract", contractCombo.getSelectedItem().toString());
		getFields.put("duration", durationCombo.getSelectedItem().toString());
		
		//TODO action command radio button/////
		getFields.put("workSetUp", employ.bg.getSelection().toString());
		getFields.put("schedule", scheduleCombo.getSelectedItem().toString());
		getFields.put("daysPerweek", scheduleDaysCombo.getSelectedItem().toString());
		
		getFields.put("b1Name", bf.b1Name.getText());
		getFields.put("b1Address", bf.b1Address.getText());
		getFields.put("b1Contact", bf.b1contact.getText());
		getFields.put("b1Relation", bf.b1relation.getText());
		getFields.put("b2Name", bf.b2Name.getText());
		getFields.put("b2Address", bf.b2Address.getText());
		getFields.put("b2Contact", bf.b2contact.getText());
		getFields.put("b2Relation", bf.b2relation.getText());
		getFields.put("b3Name", bf.b3Name.getText());
		getFields.put("b3Address", bf.b3Address.getText());
		getFields.put("b3Contact", bf.b3contact.getText());
		getFields.put("b3Relation", bf.b3relation.getText());
		
		getFields.put("otherNotes", otherTextArea.getText());
		
		return getFields;	
	}
	
	public void clearAll() {
		System.out.println(comp.size());
		for (int i=0;i<comp.size();i++) {
			comp.get(i).setText("");
		}
	}

}
