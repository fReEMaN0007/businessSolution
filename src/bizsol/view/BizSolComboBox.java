package bizsol.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.lang.reflect.Array;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class BizSolComboBox<E> extends JComboBox{
	
	BizSolComboBox(E[] list){
		this.setBackground(Color.white);
		
		this.setModel(new DefaultComboBoxModel<E> (list));

	}
}
