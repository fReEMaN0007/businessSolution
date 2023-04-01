package bizsol.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImportExportView {
	
	
	public static JPanel importExportMainPanel = new JPanel();

	JLabel construct = new JLabel();
	public void showImportExport(JPanel panel) {
		importExportMainPanel.setPreferredSize(new Dimension(1000,700));
	
		construct.setText("Import / Export Under Construction");
		construct.setFont(new Font("Arial", Font.BOLD, 40));
		
		importExportMainPanel.add(construct);
		panel.add(importExportMainPanel);
	}

}
