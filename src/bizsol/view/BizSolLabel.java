package bizsol.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BizSolLabel extends JLabel{

	
	 BizSolLabel(String name, JPanel obj){
		 this.setText(name);
		 this.setFont(new Font("Arial", Font.PLAIN, 16));
		 this.setPreferredSize(new Dimension(100,20));
		 obj.add(this);
	 }
	 BizSolLabel(String name, JPanel obj, int w, int h, int FontSize){
		 this.setFont(new Font("Arial", Font.PLAIN, FontSize));
		 this.setText(name);
		 this.setPreferredSize(new Dimension(w,h));
		 obj.add(this);
	 }
	 BizSolLabel(String name, JPanel obj, int w, int h,GridBagConstraints grd,int x,int y){
		 this.setText(name);
		 this.setFont(new Font("Arial", Font.PLAIN, 16));
		 this.setPreferredSize(new Dimension(w,h));
		 grd.gridx=x;
		 grd.gridy=y;
		 grd.insets = new Insets(0,3,0,3);
		 grd.anchor = GridBagConstraints.NORTHWEST;
		 obj.add(this,grd);
	 }
	 
	 BizSolLabel(String name, ArrayList<JLabel> arr, int size){
		 this.setText(name);
		 this.setFont(new Font("Arial", Font.PLAIN, size));
		
		 arr.add(this); 
	 }
	 BizSolLabel(String name,int w, int h, int FontSize){
		 this.setFont(new Font("Arial", Font.PLAIN, FontSize));
		 this.setText(name);
		 this.setPreferredSize(new Dimension(w,h));
		
	 }
	public BizSolLabel() {
		// TODO Auto-generated constructor stub
	}
	
}
