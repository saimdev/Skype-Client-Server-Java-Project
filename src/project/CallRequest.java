package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class CallRequest extends JFrame implements ActionListener{

	JTextField userText;
	JButton decline;
	JButton accept;
	public static String userName;
	private final static int VIBRATION_LENGTH = 7;
    private final static int VIBRATION_VELOCITY = 10;
	
	DataBase db = new DataBase();
	GeneratePassword gpd = new GeneratePassword("use");
	Login log = new Login("use");
	DashBoard dash = new DashBoard("use");
	
	CallRequest(String use){}
	
	CallRequest(){
		
		AbstractBorder borderSignup = new WelcomeBubbleBorder(new Color(0x179EFF),2,16,0);
		AbstractBorder borderLogin = new WelcomeBubbleBorder(new Color(0x041725),2,16,0);
		AbstractBorder imgBorder = new WelcomeBubbleBorder(new Color(23, 158, 255,150),3,360,0);
		
//		db.userSearch(dash.friendName);
		
		JLabel username = new JLabel();
		System.out.println("DB USER CALL: "+db.userCall);
		username.setText("Call From "+db.userCall);
		username.setFont(new Font("Roboto Regular", Font.BOLD, 16));
		username.setBounds(80,30,150,50);
		
		accept = new JButton();
		accept.setText("Accept");
		accept.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		accept.setBounds(40,95, 90, 40);
		accept.setFocusPainted(false);
		accept.setForeground(Color.WHITE);
		accept.setBackground(new Color(0x179EFF));
		accept.addActionListener(this);
		accept.setModel(new FixedStateButtonModel());
		accept.setBorder(borderSignup);
		accept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		decline = new JButton();
		decline.setText("Decline");
		decline.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		decline.setBounds(150, 95, 90, 40);
		decline.setFocusPainted(false);
		decline.setForeground(Color.WHITE);
		decline.setBackground(new Color(0x041725));
		decline.addActionListener(this);
		decline.setModel(new FixedStateButtonModel());
		decline.setBorder(borderLogin);
		decline.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		System.out.println(db.userCall);
		
		if(db.userCall!=null) {
			this.add(decline);
			this.add(accept);
		}
		this.add(username);
		
		this.setLayout(null);
		this.setTitle("Call Request");
		this.setSize(300,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==accept) {
			db.updateUserCallStatus(log.userName, null, 0);
			this.dispose();
		}
		else if(e.getSource()==decline) {
			db.updateUserCallStatus(log.userName, null, 0);
			this.dispose();
		}
		
	}


}
