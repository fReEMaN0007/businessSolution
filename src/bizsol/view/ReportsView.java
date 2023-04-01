package bizsol.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReportsView {
	public static JPanel reportsMainPanel = new JPanel();

	JLabel construct = new JLabel();
	public void showReports(JPanel panel) {
		reportsMainPanel.setPreferredSize(new Dimension(1000,700));
	
		construct.setText("Reports Under Construction");
		construct.setFont(new Font("Arial", Font.BOLD, 40));
		
		reportsMainPanel.add(construct);
		panel.add(reportsMainPanel);
	}
}
