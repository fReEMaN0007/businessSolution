package bizsol.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import bizsol.model.BizsolDates;

public class PayrollView {
		  Border etched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		  public ArrayList <JTextField> textFields = new ArrayList<>();;
		  
		  BizsolDates date = new BizsolDates();
		  BizSolTextfield nameDetailTextfield = new BizSolTextfield(textFields,170, 20);
		  BizSolTextfield managerNameTextfield = new BizSolTextfield(textFields,170, 20);
		  BizSolTextfield salaryGradeTextfield = new BizSolTextfield(textFields,170, 20);
		  BizSolTextfield employeeNoTextfield = new BizSolTextfield(textFields,170, 20);
		  BizSolTextfield departmentTextfield = new BizSolTextfield(textFields,170, 20);
		  BizSolTextfield positionTextfield = new BizSolTextfield(textFields,170, 20);
		  BizSolTextfield payrollStatusTextfield = new BizSolTextfield(textFields,170, 20);
		  
	  
	  
		Dimension d40x20 = new Dimension(40,20);
		Dimension d60x20 = new Dimension(60,20);
		Dimension d80x20 = new Dimension(80,20);
		Dimension d180x25 = new Dimension(180,25);
		
		BizSolTextfield ratePerHourTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield regularHoursTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield regularPayTextfield = new BizSolTextfield(textFields,d60x20, "", 0);
		BizSolTextfield otPerHourTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield otHoursTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield otPayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield holidayRatePerHourTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield holidayHoursTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield holidayPayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield otholidayRatePerHourTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield otholidayHoursTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield otholidayPayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield allowanceTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield nighDiffTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield ecolaTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield otherTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield bonusTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield otherPayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield sssTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield philHealthTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield pagIbigTextfield = new BizSolTextfield(textFields,d40x20, "",0);
		BizSolTextfield insuranceTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield contributionTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield loanTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield cashAdvanceTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield taxTextfield = new BizSolTextfield(textFields,d40x20, "",1);
		BizSolTextfield deductionTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield regularfield = new BizSolTextfield(textFields,d60x20, " ",0);
		BizSolTextfield otTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield holidayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield otholidayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield otherpayTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield subgrossTextfield = new BizSolTextfield(textFields,d80x20, "",0);
		BizSolTextfield deductionNetTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield grossTextfield = new BizSolTextfield(textFields,d80x20, "",0);
		BizSolTextfield contributionNetTextfield = new BizSolTextfield(textFields,d60x20, "",0);
		BizSolTextfield netTextfield = new BizSolTextfield(textFields,d80x20, "",0);
		
		BizSolTextfield searchTextfield =  new BizSolTextfield(textFields,d180x25, "Payroll",1);
		String position[] = {"by Position","Position 1","Position 2","Position 3","Position 4","Position 5"};
		String dept[] = {"by Department","Department 1","Department 2","Department 3","Department 4","Department 5"};
		String site[] = {"by Site","Location 1","Location 2","Location 3","Location 4","Location 5"};
		String manager[] = {"by Manager","Manager 1","Manager 2","Manager 3","Manager 4","Manager 5"};
		BizSolComboBox comboPositionSearch = new BizSolComboBox(position);
		BizSolComboBox comboDepartmentSearch = new BizSolComboBox(dept);
		BizSolComboBox comboOfficeSearch = new BizSolComboBox(site);
		BizSolComboBox comboManagerSearch = new BizSolComboBox(manager);
		public JButton searchButton = new JButton("Search");
		String positionSearch;
		String departmentSearch;
		String locationSearch;
		String managerSearch;
		String textSearch;
		HashMap<String, String> searchParameters = new HashMap<String, String>();
		HashMap<String, String> payrollDetails = new HashMap<String, String>();
		
		
		String[] cm = {"Employee No.","Name","Position","Department","Site","Manager"};
		Object [][] dm = {};
		public JTable table = new JTable() ;
		 
		DefaultTableModel model = new DefaultTableModel();
		
		
		
		BizSolLabel valueNamePaySlipLabel = new BizSolLabel("",130,15,12);
		BizSolLabel valueEmployeeNoPaySlipLabel = new BizSolLabel("",130,15,12);
		BizSolLabel valuePayrollPeriodPaySlipLabel = new BizSolLabel("",155,15,12);
		BizSolLabel valuePayrollBatchPaySlipLabel = new BizSolLabel("",130,15,12);
		BizSolLabel valueRegularPayPaySlipLabel = new BizSolLabel("",155,15,12);
		BizSolLabel valueOtPayPaySlipLabel = new BizSolLabel("",155,15,12);
		BizSolLabel valueholidayPayPaySlipLabel = new BizSolLabel("",158,15,12);
		BizSolLabel valueOtHolidayPayPaySlipLabel = new BizSolLabel("",158,15,12);
		BizSolLabel valueotherPayPaySlipLabel = new BizSolLabel("",158,15,12);
		BizSolLabel valueGrossPayPaySlipLabel = new BizSolLabel("",158,15,12);
		BizSolLabel valueContributionLabel = new BizSolLabel(""+"(sss,pag-ibig,etc.)",158,15,12);
		BizSolLabel valueDeductionLabel = new BizSolLabel(""+"(Loan,tax,etc.)",158,15,12);
		BizSolLabel valueNetPaySlipLabel = new BizSolLabel("",158,15,12);
		public JPanel mainPayrollPanel = new JPanel();
		
		public JButton save = new JButton("Save");
		public JButton calculate = new JButton("Calculate");
		public JButton cancel = new JButton("Cancel");
		

		void showPayrollView(JPanel panel){
			model.setColumnIdentifiers(cm);
			table.setModel(model);
			
			mainPayrollPanel.setPreferredSize(new Dimension(1000,700));
			
			panel.add(mainPayrollPanel);
			var detailPanel = new PayrollPanels(mainPayrollPanel,"Employee Details",188,350);
			detailPanel.setLayout(new FlowLayout(FlowLayout.LEADING,5,3));
			var employeeNoDetail = new BizSolLabel("Employee No.: ",  detailPanel,100,20,14);		
			detailPanel.add(employeeNoTextfield);		
			var fullNameDetail = new BizSolLabel("Full Name: ",  detailPanel,100,20,14);	
			detailPanel.add(nameDetailTextfield);
			var positionDetail = new BizSolLabel("Position: ",  detailPanel,100,20,14);
			detailPanel.add(positionTextfield);	
			var departmentDetail = new BizSolLabel("Department: ",  detailPanel,100,20,14);	
			detailPanel.add(departmentTextfield);
			var managerNameDetail = new BizSolLabel("Manager Name: ",  detailPanel,  120,  20,14);
			detailPanel.add(managerNameTextfield);
			var salaryGradeDetail = new BizSolLabel("Salary Grade: ",  detailPanel,  120,  20,14);
			detailPanel.add(salaryGradeTextfield);
			var payrollStatusDetail = new BizSolLabel("Payroll Status: ",  detailPanel,  120,  20,14);
			detailPanel.add(payrollStatusTextfield);
			
					
					
/////////////////////////////////////////////////////////////////////////////////////////
			
///////////// calculation //////////////////////////////////////////////////////////////		
			var calculationPanel = new PayrollPanels(mainPayrollPanel,"Calculation",792,350);
			calculationPanel.setLayout(new FlowLayout(FlowLayout.LEADING));		
			var calculationOne = new PayrollPanels(calculationPanel,180,320);
			var regularPanel = new PayrollPanels(calculationOne,170,100,"Regular");
			
			//regularPanel.add(Box.createHorizontalStrut(15));
			regularPanel.add(ratePerHourTextfield);
			var ratePerHourLabel = new BizSolLabel("Hourly Rate", regularPanel,80,20,14);
			var xLabel = new BizSolLabel("X",regularPanel,10,20,14);
			regularPanel.add(regularHoursTextfield);
			var regularHoursLabel = new BizSolLabel("Regular Hrs", regularPanel,80,20,14);			
			var verticalLine = new JSeparator();
			verticalLine.setPreferredSize(new Dimension(60,1));
			regularPanel.add(verticalLine);
			regularPanel.add(Box.createHorizontalStrut(200));
			//regularPanel.add(Box.createHorizontalStrut(15));
			regularPanel.add(regularPayTextfield);
			var regularPayLabel = new BizSolLabel("Regular Pay", regularPanel,80,20,14);
			regularPayLabel.setForeground(Color.blue);
			var overTimebox = new PayrollPanels(calculationOne,170,100,"Over-time");
			//overTimebox.add(Box.createHorizontalStrut(15));
			overTimebox.add(otPerHourTextfield);
			var otratePerHourLabel = new BizSolLabel("O.Time Rate", overTimebox,80,20,14);
			var otxLabel2 = new BizSolLabel("X",overTimebox,10,20,14);
			overTimebox.add(otHoursTextfield);						
			var otHoursLabel = new BizSolLabel("O.Time Hrs", overTimebox,80,20,14);
			var otverticalLine2 = new JSeparator();
			otverticalLine2.setPreferredSize(new Dimension(60,1));
			overTimebox.add(otverticalLine2);
			overTimebox.add(Box.createHorizontalStrut(200));
			//overTimebox.add(Box.createHorizontalStrut(15));
			overTimebox.add(otPayTextfield);			
			var otPayLabel= new BizSolLabel("O.Time Pay", overTimebox,80,20,14);
			otPayLabel.setForeground(Color.blue);	
			var holidayPanel = new PayrollPanels(calculationOne,170,100,"Holiday");
			//holidayPanel.add(Box.createHorizontalStrut(15));
			holidayPanel.add(holidayRatePerHourTextfield);						
			var holidayRatePerHourLabel = new BizSolLabel("Holiday Rate", holidayPanel,80,20,14);
			var holidayxLabel23 = new BizSolLabel("X",holidayPanel,10,20,14);
			holidayPanel.add(holidayHoursTextfield);
			var holidayHoursLabel = new BizSolLabel("Holiday Hrs", holidayPanel,80,20,14);
			holidayHoursTextfield.setEditable(true);
			var holidayverticalLine = new JSeparator();
			holidayverticalLine.setPreferredSize(new Dimension(60,1));
			holidayPanel.add(holidayverticalLine);
			holidayPanel.add(Box.createHorizontalStrut(200));
			//holidayPanel.add(Box.createHorizontalStrut(15));
			holidayPanel.add(holidayPayTextfield);
			var holidayPayLabel= new BizSolLabel("Holiday Pay", holidayPanel,80,20,14);
			holidayPayLabel.setForeground(Color.blue);
			var calculationTwo = new PayrollPanels(calculationPanel,180,320);			
			var otholidayPanel = new PayrollPanels(calculationTwo,170,100,"O.T. Holiday");
			//otholidayPanel.add(Box.createHorizontalStrut(15));
			otholidayPanel.add(otholidayRatePerHourTextfield);						
			var otholidayRatePerHourLabel = new BizSolLabel("OTHday Rate", otholidayPanel,80,20,14);
			var otholidayxLabel23 = new BizSolLabel("X",otholidayPanel,10,20,14);
			otholidayPanel.add(otholidayHoursTextfield);						
			var otholidayHoursLabel = new BizSolLabel("OTHday Hrs", otholidayPanel,80,20,14);
			otholidayHoursTextfield.setEditable(true);
			var otholidayverticalLine = new JSeparator();
			otholidayverticalLine.setPreferredSize(new Dimension(60,1));
			otholidayPanel.add(otholidayverticalLine);
			otholidayPanel.add(Box.createHorizontalStrut(200));
			//otholidayPanel.add(Box.createHorizontalStrut(15));
			otholidayPanel.add(otholidayPayTextfield);						
			var otholidayPayLabel= new BizSolLabel("OTHday Pay", otholidayPanel,80,20,14);
			otholidayPayLabel.setForeground(Color.blue);						
			var otherPanel = new PayrollPanels(calculationTwo,170,203,"Other");
			otherPanel.add(Box.createHorizontalStrut(10));
			otherPanel.add(allowanceTextfield);
			allowanceTextfield.setPreferredSize(new Dimension(60,20));
			var allowanceLabel = new BizSolLabel("Allowance", otherPanel,70,20,14);
			otherPanel.add(Box.createHorizontalStrut(10));
			otherPanel.add(nighDiffTextfield);
			nighDiffTextfield.setPreferredSize(new Dimension(60,20));
			var nighDiffLabel = new BizSolLabel("Night Diff.", otherPanel,70,20,14);
			otherPanel.add(Box.createHorizontalStrut(10));
			otherPanel.add(ecolaTextfield);
			ecolaTextfield.setPreferredSize(new Dimension(60,20));
			var ecolaDiffLabel = new BizSolLabel("ECOLA", otherPanel,70,20,14);
			otherPanel.add(Box.createHorizontalStrut(10));
			otherPanel.add(otherTextfield);
			otherTextfield.setPreferredSize(new Dimension(60,20));
			var otherDiffLabel = new BizSolLabel("other", otherPanel,70,20,14);
			var otherxLabel23 = new BizSolLabel("+",otherPanel,10,20,14);
			otherPanel.add(bonusTextfield);	
			bonusTextfield.setPreferredSize(new Dimension(60,20));
			var bonusLabel = new BizSolLabel("Bonus", otherPanel,70,20,14);
			otholidayHoursTextfield.setEditable(true);
			var otherverticalLine = new JSeparator();
			otherverticalLine.setPreferredSize(new Dimension(75,1));
			otherPanel.add(otherverticalLine);
			otherPanel.add(Box.createHorizontalStrut(200));
			otherPanel.add(Box.createHorizontalStrut(10));
			otherPanel.add(otherPayTextfield);
			otherPayTextfield.setPreferredSize(new Dimension(60,20));
			var otherPayLabel= new BizSolLabel("Other Pay", otherPanel,65,20,14);
			otherPayLabel.setForeground(Color.blue);		
			var calculationThree = new PayrollPanels(calculationPanel,180,320);			
			var contributionPanel = new PayrollPanels(calculationThree,170,150,"Contribution");
			contributionPanel.add(Box.createHorizontalStrut(10));
			contributionPanel.add(sssTextfield);			
			var sssLabel = new BizSolLabel("SSS", contributionPanel,65,20,14);
			contributionPanel.add(Box.createHorizontalStrut(10));
			contributionPanel.add(philHealthTextfield);			
			var philHealthDiffLabel = new BizSolLabel("PhilHealth", contributionPanel,65,20,14);
			contributionPanel.add(Box.createHorizontalStrut(10));
			contributionPanel.add(pagIbigTextfield);	
			var pagIbigDiffLabel = new BizSolLabel("Pag-IBIG", contributionPanel,65,20,14);	
			var contritbutionxLabel23 = new BizSolLabel("+",contributionPanel,10,20,14);
			contributionPanel.add(insuranceTextfield);						
			var insuranceLabel = new BizSolLabel("Insurance", contributionPanel,65,20,14);
			var insuranceverticalLine = new JSeparator();
			insuranceverticalLine.setPreferredSize(new Dimension(75,1));
			contributionPanel.add(insuranceverticalLine);
			contributionPanel.add(Box.createHorizontalStrut(200));
			contributionPanel.add(Box.createHorizontalStrut(10));
			contributionPanel.add(contributionTextfield);			
			var contributionPayLabel= new BizSolLabel("Contribution", contributionPanel,78,20,14);
			contributionPayLabel.setForeground(Color.magenta);
			var deductionPanel = new PayrollPanels(calculationThree,170,127,"Deduction");
			calculationThree.add(calculate);
			calculate.setFocusable(false);
			calculate.setPreferredSize(new Dimension(165,26));
			calculationThree.setLayout(new FlowLayout(FlowLayout.CENTER,5,3));
			System.out.println(calculate.getPreferredSize());
			deductionPanel.add(Box.createHorizontalStrut(10));
			deductionPanel.add(loanTextfield);
			loanTextfield.setPreferredSize(new Dimension(55,20));
			var loanLabel = new BizSolLabel("Loan", deductionPanel,70,20,14);
			deductionPanel.add(Box.createHorizontalStrut(10));
			deductionPanel.add(cashAdvanceTextfield);
			cashAdvanceTextfield.setPreferredSize(new Dimension(55,20));
			var cashAdvanceDiffLabel = new BizSolLabel("Cash Advance", deductionPanel,75,20,14);		
			var deductionxLabel23 = new BizSolLabel("+",deductionPanel,10,20,14);
			deductionPanel.add(taxTextfield);		
			taxTextfield.setPreferredSize(new Dimension(55,20));
			var taxLabel = new BizSolLabel("Tax", deductionPanel,70,20,14);
			otholidayHoursTextfield.setEditable(true);
			var deductionverticalLine = new JSeparator();
			deductionverticalLine.setPreferredSize(new Dimension(70,1));
			deductionPanel.add(deductionverticalLine);
			deductionPanel.add(Box.createHorizontalStrut(200));
			deductionPanel.add(Box.createHorizontalStrut(10));
			deductionPanel.add(deductionTextfield);
			var deductionPayLabel= new BizSolLabel("Deduction", deductionPanel,70,20,14);
			deductionPayLabel.setForeground(Color.MAGENTA);
			var calculationFour = new PayrollPanels(calculationPanel,220,320);	
			//payPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
			var payPanel = new PayrollPanels(calculationFour,200,280,"Net Pay");
			payPanel.add(Box.createHorizontalStrut(10));
			payPanel.add(regularfield);
			regularfield.setPreferredSize(new Dimension(65,20));
			var regularLabel = new BizSolLabel("Regular Pay", payPanel,90,20,14);
			payPanel.add(Box.createHorizontalStrut(10));
			payPanel.add(otTextfield);
			otTextfield.setPreferredSize(new Dimension(65,20));
			var otLabel = new BizSolLabel("Overtime Pay", payPanel,90,20,14);
			payPanel.add(Box.createHorizontalStrut(10));
			payPanel.add(holidayTextfield);
			holidayTextfield.setPreferredSize(new Dimension(65,20));
			var holidayLabel = new BizSolLabel("Holiday Pay", payPanel,90,20,14);
			payPanel.add(Box.createHorizontalStrut(10));
			payPanel.add(otholidayTextfield);
			otholidayTextfield.setPreferredSize(new Dimension(65,20));
			var otholidayLabel = new BizSolLabel("Otholiday Pay", payPanel,90,20,14);
			var grossPayLabel23 = new BizSolLabel("+",payPanel,10,20,14);
			payPanel.add(otherpayTextfield);
			otherpayTextfield.setPreferredSize(new Dimension(65,20));
			var otherpayLabel = new BizSolLabel("Other Pay", payPanel,90,20,14);
			var grossPayverticalLine = new JSeparator();
			grossPayverticalLine.setPreferredSize(new Dimension(100,1));
			payPanel.add(grossPayverticalLine);
			payPanel.add(Box.createHorizontalStrut(200));
			payPanel.add(Box.createHorizontalStrut(10));
			payPanel.add(grossTextfield);	
			subgrossTextfield.setPreferredSize(new Dimension(65,20));
			var grossPayLabel= new BizSolLabel("Gross Pay", payPanel,90,20,14);
			grossPayLabel.setForeground(Color.blue);		
			var deductionNetLabel23 = new BizSolLabel("-",payPanel,10,20,14);
			payPanel.add(deductionNetTextfield);
			deductionNetTextfield.setPreferredSize(new Dimension(65,20));
			var deductionNetLabel = new BizSolLabel("Deduction", payPanel,90,20,14);
			deductionNetLabel.setForeground(Color.MAGENTA);
			var contributionPayverticalLine = new JSeparator();
			contributionPayverticalLine.setPreferredSize(new Dimension(100,1));
			payPanel.add(contributionPayverticalLine);
			payPanel.add(Box.createHorizontalStrut(200));
			payPanel.add(Box.createHorizontalStrut(10));
			payPanel.add(subgrossTextfield);	
			grossTextfield.setPreferredSize(new Dimension(65,20));
			var subgrossPayLabel= new BizSolLabel("", payPanel,90,20,14);		
			var contributionNetLabel23 = new BizSolLabel("-",payPanel,10,20,14);
			payPanel.add(contributionNetTextfield);
			contributionNetTextfield.setPreferredSize(new Dimension(65,20));
			var contributionNetLabel = new BizSolLabel("Contribution", payPanel,90,20,14);
			contributionNetLabel.setForeground(Color.MAGENTA);
			var netPayverticalLine = new JSeparator();
			netPayverticalLine.setPreferredSize(new Dimension(100,1));
			payPanel.add(netPayverticalLine);
			payPanel.add(Box.createHorizontalStrut(200));
			//payPanel.add(Box.createHorizontalStrut(10));
			
			payPanel.add(netTextfield);	
			netTextfield.setPreferredSize(new Dimension(80,20));
			netTextfield.setFont(new Font("Arial", Font.BOLD, 14));
			netTextfield.setForeground(Color.red);
			var netPayLabel= new BizSolLabel("Net Pay", payPanel,80,20,14);
			netPayLabel.setForeground(Color.red);
			netPayLabel.setFont(new Font("Arial", Font.BOLD, 14));
			
			
			calculationFour.setLayout(new FlowLayout(FlowLayout.CENTER,5,3));
			//calculationThree.add(calculate);
			save.setPreferredSize(new Dimension(95,26));
			save.setFocusable(false);
			cancel.setPreferredSize(new Dimension(95,26));
			cancel.setFocusable(false);
			calculationFour.add(save);
			calculationFour.add(cancel);
			
			
/////////////////////////////////////////////////////////////////////////////////////////
			
///////////// search /////////////////////////////////////////////////////////////			
			var searchPanel = new PayrollPanels(mainPayrollPanel,"Look Up",680,330);
			searchPanel.add(searchTextfield);
			searchTextfield.setText("");
			searchPanel.add(comboPositionSearch);
			searchPanel.add(comboDepartmentSearch);
			searchPanel.add(comboOfficeSearch);
			searchPanel.add(comboManagerSearch);
			searchButton.setFocusable(false);
			searchPanel.add(searchButton);
			
		
			
		
		
			var scrollTable = new JScrollPane(table);
			table.setDefaultEditor(Object.class, null);
			//TODO babalikan ko to 
			for(int x=0;x<6;x++) {
			table.getColumnModel().getColumn(x).setHeaderValue(cm[x]);
			}
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			scrollTable.setPreferredSize(new Dimension(650,260));
			searchPanel.add(scrollTable);
////////////////////////////////////////////////////////////////////////
////// PAYSLIP //////////////////////////////////////////////////////////////////
			
			var paySlipPanel = new PayrollPanels(mainPayrollPanel,"Payslip",300,330);
			var slipPanel = new PayrollPanels(paySlipPanel,"",280,295);
			slipPanel.setBackground(Color.white);
			slipPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			slipPanel.add(Box.createHorizontalStrut(100));
			var paySlipLabel = new BizSolLabel("Pay Slip",slipPanel,140,15,14);
			var namePaySlipLabel = new BizSolLabel("Full Name:",slipPanel,100,15,12);
			slipPanel.add(valueNamePaySlipLabel);			
			var employeeNoPaySlipLabel = new BizSolLabel("Employee No.:",slipPanel,100,15,12);
			slipPanel.add(valueEmployeeNoPaySlipLabel);						
			var payrollPeriodPaySlipLabel = new BizSolLabel("Payroll Period:",slipPanel,100,15,12);
			slipPanel.add(valuePayrollPeriodPaySlipLabel);
			var payrollBatchDaysPaySlipLabel = new BizSolLabel("Payroll Batch:",slipPanel,100,15,12);
			slipPanel.add(valuePayrollBatchPaySlipLabel);		
			var regularPayPaySlipLabel = new BizSolLabel("Regular Pay:",slipPanel,100,15,12);
			slipPanel.add(valueRegularPayPaySlipLabel);
			var otPayPaySlipLabel = new BizSolLabel("Overtime Pay:",slipPanel,100,15,12);
			slipPanel.add(valueOtPayPaySlipLabel);					
			var holidayPayPaySlipLabel = new BizSolLabel("Holiday Pay:",slipPanel,100,15,12);
			slipPanel.add(valueholidayPayPaySlipLabel);
			var otHolidayPayPaySlipLabel = new BizSolLabel("OT Holiday Pay:",slipPanel,100,15,12);
			slipPanel.add(valueOtHolidayPayPaySlipLabel);	
			var otherPayPaySlipLabel = new BizSolLabel("Other Pay:",slipPanel,100,15,12);
			slipPanel.add(valueotherPayPaySlipLabel);
			var grossPayPaySlipLabel = new BizSolLabel("Gross Pay:",slipPanel,100,15,12);
			grossPayPaySlipLabel.setForeground(Color.blue);
			slipPanel.add(valueGrossPayPaySlipLabel);
			valueGrossPayPaySlipLabel.setForeground(Color.blue);
			var contributionLabel = new BizSolLabel("Contribution:",slipPanel,100,15,12);
			slipPanel.add(valueContributionLabel);
			var deductionLabel = new BizSolLabel("Deduction:",slipPanel,100,15,14);
			slipPanel.add(valueDeductionLabel);
			var netPaySlipLabel = new BizSolLabel("Net Pay:",slipPanel,100,15,12);
			slipPanel.add(valueNetPaySlipLabel);
			netPaySlipLabel.setFont(new Font("Arial", Font.BOLD, 12));
			netPaySlipLabel.setForeground(Color.red);
			valueNetPaySlipLabel.setFont(new Font("Arial", Font.BOLD, 12));
			valueNetPaySlipLabel.setForeground(Color.red);		
		}
		
		
		public HashMap<String, String> getSearchParameters() {
			 positionSearch = comboPositionSearch.getSelectedItem().toString();
			 departmentSearch = comboDepartmentSearch.getSelectedItem().toString();
			 locationSearch = comboOfficeSearch.getSelectedItem().toString();
			 managerSearch = comboManagerSearch.getSelectedItem().toString();
			 textSearch = searchTextfield.getText();
			 searchParameters.put("position", positionSearch);
			 searchParameters.put("department", departmentSearch);
			 searchParameters.put("location", locationSearch);
			 searchParameters.put("manager", managerSearch);
			 searchParameters.put("text", textSearch);
			 return searchParameters;
			 }
		
		public boolean setResult(ResultSet rs) throws SQLException {
			
			model.setRowCount(0);
			while (rs.next()) {
				
				model.addRow(new Object[]{rs.getString("Employee_Number"), rs.getString("fName")+" "+ rs.getString("lName"), rs.getString("position"),rs.getString("department"), rs.getString("Location"), rs.getString("Manager_Name")});
				System.out.println("wala na");
			}
			return true;
			
		}
		public void getSelected(HashMap selected) {
			clearTextFields();
			nameDetailTextfield.setText(selected.get("name").toString());
			employeeNoTextfield.setText(selected.get("empNo").toString());
			departmentTextfield.setText(selected.get("department").toString());
			positionTextfield.setText(selected.get("position").toString());
			managerNameTextfield.setText(selected.get("manager").toString());
			

		}
		
		public void setRateLabel(HashMap rates) {
			
			ratePerHourTextfield.setText(rates.get("regularRate").toString());
			otPerHourTextfield.setText(rates.get("otRate").toString());
			holidayRatePerHourTextfield.setText(rates.get("hldRate").toString());
			otholidayRatePerHourTextfield.setText(rates.get("otHldRate").toString());
			sssTextfield.setText(rates.get("sssRate").toString());
			philHealthTextfield.setText(rates.get("philHealthRate").toString());
			pagIbigTextfield.setText(rates.get("pagIbigRate").toString());
			salaryGradeTextfield.setText(rates.get("salaryRate").toString());

		}
		
		public HashMap getOperands() {
			//.put("employeeNumber", employeeNoTextfield.getText());
			payrollDetails.put("hourlyRate", ratePerHourTextfield.getText());
			payrollDetails.put("regularHours", regularHoursTextfield.getText());
			//payrollDetails.put("regularPay", regularPayTextfield.getText());
			payrollDetails.put("otRate", otPerHourTextfield.getText());
			payrollDetails.put("otHours", otHoursTextfield.getText());
			//payrollDetails.put("otPay", otPayTextfield.getText());
			payrollDetails.put("holidayRate", holidayRatePerHourTextfield.getText());
			payrollDetails.put("holidayHours", holidayHoursTextfield.getText());
			//payrollDetails.put("holidayPay", holidayPayTextfield.getText());
			payrollDetails.put("otHolidayRate", otholidayRatePerHourTextfield.getText());
			payrollDetails.put("otHolidayHours", otholidayHoursTextfield.getText());
			//payrollDetails.put("otHolidayPay", otholidayPayTextfield.getText());
			payrollDetails.put("allowance", allowanceTextfield.getText());
			payrollDetails.put("nightDiff", nighDiffTextfield.getText());
			payrollDetails.put("ecola", ecolaTextfield.getText());
			payrollDetails.put("other", otherTextfield.getText());
			payrollDetails.put("bonus", bonusTextfield.getText());
			//payrollDetails.put("otherPay", otherPayTextfield.getText());
			payrollDetails.put("sss", sssTextfield.getText());
			payrollDetails.put("philHealth", philHealthTextfield.getText());
			payrollDetails.put("pagIbig", pagIbigTextfield.getText());
			payrollDetails.put("insurance", insuranceTextfield.getText());
			//payrollDetails.put("contribution", contributionTextfield.getText());
			payrollDetails.put("loan", loanTextfield.getText());
			payrollDetails.put("cashAdvance", cashAdvanceTextfield.getText());
			payrollDetails.put("tax", taxTextfield.getText());
			//payrollDetails.put("deduction", deductionTextfield.getText());
			//payrollDetails.put("grossPay", grossTextfield.getText());
			//payrollDetails.put("netPay", netTextfield.getText());
			
			
			return payrollDetails;
		}
		
		
		public HashMap getPayrollDetails() {
			//TODO get payrollbatch, salary id
			payrollDetails.put("employeeNumber", employeeNoTextfield.getText());
			payrollDetails.put("salaryGrade", salaryGradeTextfield.getText());
			payrollDetails.put("regularPay", regularPayTextfield.getText());
			
			payrollDetails.put("otPay", otPayTextfield.getText());
			
			payrollDetails.put("holidayPay", holidayPayTextfield.getText());
			
			payrollDetails.put("otHolidayPay", otholidayPayTextfield.getText());
			
			payrollDetails.put("otherPay", otherPayTextfield.getText());
			
			payrollDetails.put("contribution", contributionTextfield.getText());
			
			payrollDetails.put("deduction", deductionTextfield.getText());
			payrollDetails.put("subGross", subgrossTextfield.getText());
			payrollDetails.put("grossPay", grossTextfield.getText());
			payrollDetails.put("netPay", netTextfield.getText());
			payrollDetails.put("payrollPeriod", valuePayrollPeriodPaySlipLabel.getText());
//
//			  BizSolTextfield salaryGradeTextfield = new BizSolTextfield(170, 20);
//			  BizSolTextfield employeeNoTextfield = new BizSolTextfield(170, 20);
		
			return payrollDetails;
		}
		
		public void setResults(HashMap results) {
			//clearTextFields();
			regularPayTextfield.setText(results.get("regularPay").toString());
			otPayTextfield.setText(results.get("otPay").toString());
			holidayPayTextfield.setText(results.get("holidayPay").toString());
			otholidayPayTextfield.setText(results.get("otHolidayPay").toString());
			otherPayTextfield.setText(results.get("otherPay").toString());
			contributionTextfield.setText(results.get("contribution").toString());
			deductionTextfield.setText(results.get("deduction").toString());
			regularfield.setText(results.get("regularPay").toString());
			otTextfield.setText(results.get("otPay").toString());
			holidayTextfield.setText(results.get("holidayPay").toString());
			otholidayTextfield.setText(results.get("otHolidayPay").toString());
			otherpayTextfield.setText(results.get("otherPay").toString());
			subgrossTextfield.setText(results.get("subGross").toString());
			deductionNetTextfield.setText(results.get("deduction").toString());
			grossTextfield.setText(results.get("grossPay").toString());
			contributionNetTextfield.setText(results.get("contribution").toString());
			netTextfield.setText(results.get("netPay").toString());


			
		}


		public void setPayslipValue(String[] ee) {
			valueEmployeeNoPaySlipLabel.setText(employeeNoTextfield.getText());
			valueNamePaySlipLabel.setText(nameDetailTextfield.getText());
			valueRegularPayPaySlipLabel.setText(regularPayTextfield.getText());
			valueOtPayPaySlipLabel.setText(otPayTextfield.getText());
			valueholidayPayPaySlipLabel.setText(holidayPayTextfield.getText());
			valueOtHolidayPayPaySlipLabel.setText(otholidayPayTextfield.getText());
			valueotherPayPaySlipLabel.setText(otherPayTextfield.getText());
			valueGrossPayPaySlipLabel.setText(grossTextfield.getText());
			valueContributionLabel.setText(contributionTextfield.getText());
			valueDeductionLabel.setText(deductionNetTextfield.getText());
			valueNetPaySlipLabel.setText(netTextfield.getText());
			valuePayrollPeriodPaySlipLabel.setText(ee[0]);
			valuePayrollBatchPaySlipLabel.setText(ee[1]);
		
			//TODO no. of days, payroll period
			
			//BizSolLabel valuePayrollPeriodPaySlipLabel = new BizSolLabel("01 July - 01 August",130,15,12);
			//BizSolLabel valueTotalDaysPaySlipLabel = new BizSolLabel("24",130,15,12);

//			departmentTextfield.setText(selected.get("department").toString());
//			positionTextfield.setText(selected.get("position").toString());			
		}
		public void clearPayslip() {
			valueEmployeeNoPaySlipLabel.setText("");
			valueNamePaySlipLabel.setText("");
			valueRegularPayPaySlipLabel.setText("");
			valueOtPayPaySlipLabel.setText("");
			valueholidayPayPaySlipLabel.setText("");
			valueOtHolidayPayPaySlipLabel.setText("");
			valueotherPayPaySlipLabel.setText("");
			valueGrossPayPaySlipLabel.setText("");
			valueContributionLabel.setText("");
			valueDeductionLabel.setText("");
			valueNetPaySlipLabel.setText("");
			valuePayrollPeriodPaySlipLabel.setText("");
			valuePayrollBatchPaySlipLabel.setText("");
		
		}
		


		public void clearTextFields() {
			for(int i = 0;i<textFields.size();i++) {
				textFields.get(i).setText("");
			}
			
		}

		public void setEditableFields(ArrayList<Object> objects) throws SQLException {
			
			ResultSet values = (ResultSet) objects.get(0);
			String[] ee = (String[]) objects.get(1);
			ArrayList <JTextField> editableFields = new ArrayList<JTextField>();
			editableFields.add(regularHoursTextfield);
			editableFields.add(otHoursTextfield);
			editableFields.add(holidayHoursTextfield);			
			editableFields.add(otholidayHoursTextfield);			
			editableFields.add(allowanceTextfield);	
			editableFields.add(nighDiffTextfield);			
			editableFields.add(ecolaTextfield);			
			editableFields.add(otherTextfield);		
			editableFields.add(bonusTextfield);
			editableFields.add(insuranceTextfield);		
			editableFields.add(loanTextfield);
			editableFields.add(cashAdvanceTextfield);	
			editableFields.add(taxTextfield);
		
			if (values.next()) {
				setPayslipValue(ee);
				payrollStatusTextfield.setText("Complete");
				editableFields.forEach((n) -> n.setEditable(false));
				regularHoursTextfield.setText(values.getString("Regular_Hrs"));
				otHoursTextfield.setText(values.getString("Over_Time_hrs"));
				holidayHoursTextfield.setText(values.getString("Holiday_Hour"));
				otholidayHoursTextfield.setText(values.getString("Ot_Holiday_Hour"));
				allowanceTextfield.setText(values.getString("Allowance"));
				nighDiffTextfield.setText(values.getString("Night_Diff"));
				ecolaTextfield.setText(values.getString("Ecola"));
				otherTextfield.setText(values.getString("Other"));
				bonusTextfield.setText(values.getString("Bonus"));
				insuranceTextfield.setText(values.getString("Insurance"));
				loanTextfield.setText(values.getString("Loan"));
				cashAdvanceTextfield.setText(values.getString("Cash_Adv"));
				taxTextfield.setText(values.getString("tax"));
				
				regularPayTextfield.setText(values.getString("Regular_Pay"));
				otPayTextfield.setText(values.getString("Over_Time_Pay"));
				holidayPayTextfield.setText(values.getString("Holiday_Pay"));
				otholidayPayTextfield.setText(values.getString("Ot_Holiday_Pay"));
				otherPayTextfield.setText(values.getString("Other_Pay"));				
				contributionTextfield.setText(values.getString("Contribution"));				
				deductionTextfield.setText(values.getString("Deduction"));				
				regularfield.setText(values.getString("Regular_Pay"));
				otTextfield.setText(values.getString("Over_Time_Pay"));				
				holidayTextfield.setText(values.getString("Holiday_Pay"));	
				
				otholidayTextfield.setText(values.getString("Ot_Holiday_Pay"));				
				otherpayTextfield.setText(values.getString("Other_Pay"));				
				subgrossTextfield.setText(values.getString("Sub_Gross"));
				deductionNetTextfield.setText(values.getString("Deduction"));				
				grossTextfield.setText(values.getString("Grosspay"));
				contributionNetTextfield.setText(values.getString("Contribution"));
				netTextfield.setText(values.getString("Netpay"));
				
				payrollStatusTextfield.setForeground(Color.GREEN);
				
				setPayslipValue(ee);
				
				
				
				//valueRegularPayPaySlipLabel.setText(textSearch);
				//valueNamePaySlipLabel.setText(textSearch);		
//				BizSolLabel valueNamePaySlipLabel = new BizSolLabel("",130,15,12);
//				BizSolLabel valueEmployeeNoPaySlipLabel = new BizSolLabel("",130,15,12);
//				BizSolLabel valuePayrollPeriodPaySlipLabel = new BizSolLabel("",155,15,12);
//				BizSolLabel valuePayrollBatchPaySlipLabel = new BizSolLabel("",130,15,12);
//				BizSolLabel valueRegularPayPaySlipLabel = new BizSolLabel("",155,15,12);
//				BizSolLabel valueOtPayPaySlipLabel = new BizSolLabel("",155,15,12);
//				BizSolLabel valueholidayPayPaySlipLabel = new BizSolLabel("",158,15,12);
//				BizSolLabel valueOtHolidayPayPaySlipLabel = new BizSolLabel("",158,15,12);
//				BizSolLabel valueotherPayPaySlipLabel = new BizSolLabel("",158,15,12);
//				BizSolLabel valueGrossPayPaySlipLabel = new BizSolLabel("",158,15,12);
//				BizSolLabel valueContributionLabel = new BizSolLabel(""+"(sss,pag-ibig,etc.)",158,15,12);
//				BizSolLabel valueDeductionLabel = new BizSolLabel(""+"(Loan,tax,etc.)",158,15,12);
//				BizSolLabel valueNetPaySlipLabel = new BizSolLabel("",158,15,12);
				
			}
			else {
				editableFields.forEach((n) -> {n.setEditable(true);
												n.setText("");});				
				payrollStatusTextfield.setText("Incomplete");
				payrollStatusTextfield.setForeground(Color.red);
				clearPayslip();

			}
			
			
			

		
		}
		
		
	
		
}
			
			


		
