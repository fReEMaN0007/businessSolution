package bizsol.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScheduleView {
	public static JPanel scheduleMainPanel = new JPanel();

	JLabel construct = new JLabel();
	public void showSchedule(JPanel panel) {
		scheduleMainPanel.setPreferredSize(new Dimension(1000,700));
	
		construct.setText("Schedule Under Construction");
		construct.setFont(new Font("Arial", Font.BOLD, 40));
		
		scheduleMainPanel.add(construct);
		panel.add(scheduleMainPanel);
	}

}
