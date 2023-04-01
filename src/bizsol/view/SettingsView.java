package bizsol.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsView {

	public static JPanel settingsMainPanel = new JPanel();

	JLabel construct = new JLabel();
	public void showSettings(JPanel panel) {
		settingsMainPanel.setPreferredSize(new Dimension(1000,700));
	
		construct.setText("Settings Under Construction");
		construct.setFont(new Font("Arial", Font.BOLD, 40));
		
		settingsMainPanel.add(construct);
		panel.add(settingsMainPanel);
	}
}
