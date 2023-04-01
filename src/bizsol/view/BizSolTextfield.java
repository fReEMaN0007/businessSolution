package bizsol.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class BizSolTextfield extends JTextField {
	Border border = (BorderFactory.createCompoundBorder(
			BorderFactory.createEtchedBorder(), 
	        BorderFactory.createEmptyBorder(0, 5, 0, 0)));
	
	
	BizSolTextfield(JPanel obj) {
		 this.setBorder(BorderFactory.createEtchedBorder());
		 this.setFont(new Font("Arial", Font.PLAIN, 14));
		 this.setPreferredSize(new Dimension(270,25));
		 this.setHorizontalAlignment(SwingConstants.RIGHT);
		 obj.add(this);
		
	 }
	BizSolTextfield(Dimension dim) {
		 this.setBorder(BorderFactory.createEtchedBorder());
		 this.setFont(new Font("Arial", Font.PLAIN, 14));
		 this.setHorizontalAlignment(SwingConstants.RIGHT);
		 this.setPreferredSize(dim);
	
	 }
	 
	BizSolTextfield(Dimension dim,GridBagConstraints grd, int x, int y) {
		 this.setBorder(BorderFactory.createEtchedBorder());
		 this.setFont(new Font("Arial", Font.PLAIN, 14));
		 this.setHorizontalAlignment(SwingConstants.RIGHT);
		 this.setPreferredSize(dim);
		 grd.gridx=x;
		 grd.gridy=y;
		 grd.insets = new Insets(0,3,3,3);
		 grd.anchor = GridBagConstraints.NORTHWEST;
		
	 }
	BizSolTextfield(JPanel panel,Dimension dim,GridBagConstraints grd, int x, int y) {
		 this.setBorder(BorderFactory.createEtchedBorder());
		 this.setFont(new Font("Arial", Font.PLAIN, 14));
		 this.setHorizontalAlignment(SwingConstants.RIGHT);
		 this.setPreferredSize(dim);
		 grd.gridx=x;
		 grd.gridy=y;
		 grd.insets = new Insets(0,3,3,3);
		 grd.anchor = GridBagConstraints.NORTHWEST;
		 panel.add(this,grd);
		
	 }
	
	//improved improved improved
	BizSolTextfield(ArrayList<JTextField> textFields, Dimension dim,String text,int editable) {
		
		switch(editable) {
		case 1: this.setEditable(true);
		this.setPreferredSize(dim);
		break;
		case 0: this.setEditable(false);
		this.setPreferredSize(new Dimension(55,20));
		break;
		}
		
	
		 this.setBorder(BorderFactory.createEtchedBorder());
		 
		 this.setHorizontalAlignment(SwingConstants.RIGHT);
		 this.setText(text);
		 textFields.add(this);	
	 }
	
	BizSolTextfield(ArrayList<JTextField> textFields,int w, int h) {
		 this.setBorder(border);
		 this.setPreferredSize(new Dimension(w,h));
		 this.setEditable(false);
		 textFields.add(this);
	
	 }
	BizSolTextfield(ArrayList<JTextField> comp) {
		 this.setBorder(BorderFactory.createEtchedBorder());
		 this.setFont(new Font("Arial", Font.PLAIN, 14));
		 this.setPreferredSize(new Dimension(270,25));
		 comp.add(this);	
	 }
	
	
}
