package bizsol.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogOutView {

	public static JPanel logoutMainPanel = new JPanel();

	JLabel construct = new JLabel();
	public void showLogout(JPanel panel) {
		logoutMainPanel.setPreferredSize(new Dimension(1000,700));
	
		construct.setText("Log-out Under Construction");
		construct.setFont(new Font("Arial", Font.BOLD, 40));
		
		logoutMainPanel.add(construct);
		panel.add(logoutMainPanel);
	}
}
