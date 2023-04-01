package bizsol.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class LogInView extends JFrame {
	
	String userName;
	JTextField	 textFieldUser = new JTextField();
	JPasswordField	passwordFieldPass = new JPasswordField("");
	public JButton buttonLogIn = new JButton("Log In");

	public LogInView(){
		System.out.println("Frame Created");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		var leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		leftPanel.setPreferredSize(new Dimension(450,500));
		
		MyCanvas m=new MyCanvas("business.png");
		m.setSize(new Dimension(300,300));
		
		
		var rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(450,500));
		rightPanel.setLayout(new GridBagLayout());
		var grd = new GridBagConstraints();
		
		var logInPanel = new JPanel();
		logInPanel.setLayout(new GridBagLayout());
			
		
		var LabelUser = new JLabel("Username");
		grd.gridx=0;
		grd.gridy=1;
		grd.anchor = GridBagConstraints.FIRST_LINE_START;
		grd.insets = new Insets(25,10,0,0);
		logInPanel.add(LabelUser, grd);
		
		
		textFieldUser.setText("");
		textFieldUser.setPreferredSize(new Dimension(300,30));
		textFieldUser.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textFieldUser.setHorizontalAlignment(JTextField.CENTER);
		
		grd.gridy=2;
		grd.insets = new Insets(0,10,0,0);
		logInPanel.add(textFieldUser, grd);
		
		var LabelPass = new JLabel("Password");
		
		grd.gridy=3;
		grd.anchor = GridBagConstraints.FIRST_LINE_START;
		grd.insets = new Insets(10,10,0,0);
		logInPanel.add(LabelPass, grd);
		
		passwordFieldPass.setText("");
		passwordFieldPass.setPreferredSize(new Dimension(300,30));
		passwordFieldPass.setFont(new Font("SansSerif", Font.PLAIN, 20));
		passwordFieldPass.setHorizontalAlignment(JTextField.CENTER);
		
		grd.gridy=4;
		grd.insets = new Insets(0,10,0,10);
		logInPanel.add(passwordFieldPass, grd);
		

		buttonLogIn.setPreferredSize(new Dimension(300,30));
	
	
		grd.gridy=5;
		grd.insets = new Insets(5,10,5,10);
		logInPanel.add(buttonLogIn, grd);
		
		var labelForgot = new JLabel("Forgot Password?");
		labelForgot.setFont(new Font("SansSerif", Font.ITALIC, 12));
		labelForgot.setForeground(Color.red);
		
		grd.gridy=6;
		grd.insets = new Insets(0,10,25,10);
		logInPanel.add(labelForgot, grd);
		

		var sep = new JSeparator(SwingConstants.VERTICAL);
		sep.setPreferredSize(new Dimension(1,350));
		
	//	leftPanel.add(ee);
		leftPanel.add(m);
		logInPanel.setBorder(BorderFactory.createTitledBorder("Log In"));
		((TitledBorder) logInPanel.getBorder()).setTitleFont(new Font("Arial", Font.PLAIN, 20));
		rightPanel.add(logInPanel);
		add(leftPanel);
		add(sep);
		add(rightPanel);
		pack();
		setLocationRelativeTo(null); 
		setResizable(false);
		setVisible(true);
	}
	
	
	public String getUsername(){
		return textFieldUser.getText();
	}
	

	public char[] getPassword(){
		return passwordFieldPass.getPassword();
	}

	
	
	public void addlisten(ActionListener listen) {
		buttonLogIn.addActionListener(listen);
		
	}


	
	
	
	
	
	
}

  class MyCanvas extends Canvas{  
    static String img;
	MyCanvas(String img){
		this.img=img;
	}
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage(img);
        g.drawImage(i, 0,0,this);  
          
    } 
   
 }
  
  class MyCanvas2 extends Canvas{  
	    static String img;
		MyCanvas2(String img){
			this.img=img;
		}
	    public void paint(Graphics g) {  
	  
	        Toolkit t=Toolkit.getDefaultToolkit();  
	        Image i=t.getImage(img);
	        g.drawImage(i, 0,0,this);  
	          
	    } 
	   
	 }
