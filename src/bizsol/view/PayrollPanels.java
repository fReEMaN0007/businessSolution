package bizsol.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PayrollPanels extends JPanel{
	Border etched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	PayrollPanels(JPanel panel,String text,int width,int height){
		
		this.setPreferredSize(new Dimension(width,height));
		this.setBorder(BorderFactory.createTitledBorder(etched,text));
		((TitledBorder) this.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(this);
		}
	
		PayrollPanels(JPanel panel,int width,int height, String text){
			this.setBorder(BorderFactory.createTitledBorder(etched,text));
			((TitledBorder) this.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 11));
			this.setLayout(new FlowLayout(FlowLayout.LEADING,5,3));
			this.setPreferredSize(new Dimension(width,height));
			panel.add(this);
			}
		PayrollPanels(JPanel panel,int width,int height){
			this.setLayout(new FlowLayout(FlowLayout.LEADING,5,3));
			this.setPreferredSize(new Dimension(width,height));
			panel.add(this);
			}
}
