package bizsol.view;

import java.awt.Color;

import javax.swing.JComboBox;

public class dateCombo {
	
	 arrayCombo combo = new arrayCombo();
	 public JComboBox monthCombo = new JComboBox(combo.getArrayMonth());
	 public JComboBox dayCombo = new JComboBox(combo.getArrayDay());
	 public JComboBox yearCombo = new JComboBox(combo.getArrayYear());
	 dateCombo(){
		monthCombo.setBackground(Color.white);
		dayCombo.setBackground(Color.white);
		yearCombo.setBackground(Color.white);		
	 }
	 
	 String getMonth(){
		return (String) monthCombo.getSelectedItem();
	 }
	 String getDay(){
		 return (String) dayCombo.getSelectedItem();
	 }
	 String getYear(){
		 return (String) yearCombo.getSelectedItem();
	 }
}
