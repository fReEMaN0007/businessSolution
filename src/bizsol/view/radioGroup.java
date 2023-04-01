package bizsol.view;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class radioGroup   {
	 
	 JRadioButton r1=new JRadioButton("WFH");    
	 JRadioButton r2=new JRadioButton("On-site"); 
	 JRadioButton r3=new JRadioButton("Hybrid");
	 ButtonGroup bg=new ButtonGroup(); 
	 
	 radioGroup(String one, String two, String three){
		   
		 
		 	r1.setActionCommand(one);
		 	r2.setActionCommand(two);
		 	r3.setActionCommand(three);
			bg.add(r1);
			bg.add(r2);
			bg.add(r3);    

			r2.setSelected(true);
			r1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,18));
			r1.setFocusable(false);
			r2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,13));
			r2.setFocusable(false);
			r3.setFocusable(false);
	 }
}
