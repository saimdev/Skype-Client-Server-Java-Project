package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class FriendRequest extends JFrame implements ActionListener{

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
	
	FriendRequest(String use){}
	
	FriendRequest(){
		
		AbstractBorder borderSignup = new WelcomeBubbleBorder(new Color(0x179EFF),2,16,0);
		AbstractBorder borderLogin = new WelcomeBubbleBorder(new Color(0x041725),2,16,0);
		AbstractBorder imgBorder = new WelcomeBubbleBorder(new Color(23, 158, 255,150),3,360,0);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(dash.friendName+".jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel profileImg = new JLabel();
		profileImg.setIcon(imageIcon);
		profileImg.setBounds(80, 40, 100,100);
		profileImg.setBorder(imgBorder);
		profileImg.setHorizontalAlignment(JLabel.CENTER);
		profileImg.setVerticalAlignment(JLabel.CENTER);
		
		db.userSearch(dash.friendName);
		
		JLabel username = new JLabel();
		username.setText(db.name+" "+db.lastName);
		username.setFont(new Font("Roboto Regular", Font.BOLD, 16));
		username.setBounds(190,55,150,50);
		
		JLabel email = new JLabel();
		email.setText(db.emailId);
		email.setFont(new Font("Roboto Regular", Font.BOLD, 13));
		email.setForeground(new Color(0xa9a9a9a));
		email.setBounds(192,75,180,50);
		
		accept = new JButton();
		accept.setText("Accept");
		accept.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		accept.setBounds(210, 180, 120, 40);
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
		decline.setBounds(60, 180, 120, 40);
		decline.setFocusPainted(false);
		decline.setForeground(Color.WHITE);
		decline.setBackground(new Color(0x041725));
		decline.addActionListener(this);
		decline.setModel(new FixedStateButtonModel());
		decline.setBorder(borderLogin);
		decline.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.add(email);
		this.add(profileImg);
		this.add(decline);
		this.add(accept);
		this.add(username);
		
		this.setLayout(null);
		this.setTitle("Friend Request");
		this.setSize(400,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==accept) {
			System.out.println(dash.friendName);
			System.out.println(log.userName);
			db.addFriend(dash.friendName, log.userName);
			db.addFriend(log.userName, dash.friendName);
			db.deleteReq(log.userName, dash.friendName);
			this.dispose();
		}
		else if(e.getSource()==decline) {
			db.deleteReq(log.userName, dash.friendName);
			this.dispose();
		}
		
	}


}
