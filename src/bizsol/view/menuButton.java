package bizsol.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class menuButton extends JButton{
	
		

	
	public menuButton(String name, JPanel panel) {
		this.setText(name);
		this.setPreferredSize(new Dimension(300,40));
		this.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.setFocusable(false);
		panel.add(this);
	
	}
	
	public menuButton(String name) {
		this.setText(name);
		this.setPreferredSize(new Dimension(300,40));
		this.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.setFocusable(false);
	}
	
	
	

}
