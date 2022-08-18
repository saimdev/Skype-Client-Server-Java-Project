package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.ColorUIResource;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Settings extends JFrame implements ActionListener{
	
	JButton homeIcon;
	JButton profileIcon;
	JButton gameIcon;
	JButton settingsIcon;
	JButton gameText;
	JButton settingsText;
	JButton profileText;
	JButton homeText;
	JButton signin;
	JTextField interests;
	JTextField fb;
	JTextField twitter;
	JTextField insta;
	JTextField first;
	JTextField username;
	JPasswordField password;
	JTextField education;
	JTextField weight;
	JTextField height;
	JTextField last;
	JTextField email;
	JTextField confirm;
	JTextField occupation;
	JButton signout;
	JTable jt;
	
	DataBase db = new DataBase();
	Login log = new Login("use");
	
	Settings(){
		
		AbstractBorder border = new WelcomeBubbleBorder(new Color(0xECECEC),2,35,0);
		AbstractBorder rightBorder = new RightMenuBubbleBorder(new Color(0x041725),0,15,0);
		AbstractBorder menuBorder = new LeftMenuBubbleBorder(new Color(0xB8E2F2),0,15,0);
		AbstractBorder borderUserText = new TextBubbleBorder(new Color(0xf2f0f0),1,10,0);
		AbstractBorder rightMenuBorder = new WelcomeBubbleBorder(new Color(0xB8E2F2),0,20,0);
		AbstractBorder borderLogin = new WelcomeBubbleBorder(new Color(0x041725),2,16,0);
		AbstractBorder borderSignIn = new TextBubbleBorder(new Color(0x179EFF),1,10,0);
		AbstractBorder homeBorder = new MenuBubbleBorder(new Color(0xB8E2F2),0,0,0);
		AbstractBorder otherBorder = new WelcomeBubbleBorder(new Color(0xFFFFFF),0,0,0);
		
		jt=new JTable();
	    db.showFriendRequests(jt, log.userName);
	    JScrollPane sp=new JScrollPane(jt);  
	    sp.setBounds(25,430,200, 250);
	    jt.setForeground(Color.BLACK);
	    jt.setBackground(Color.WHITE);
	    jt.setFont(new Font("Roboto Regular", Font.BOLD, 16));
	    jt.setBorder(otherBorder);
	    sp.getViewport().setBackground(Color.WHITE);
	    sp.setBorder(null);
		
		JLabel dateDisplay = new JLabel();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(() -> {
            LocalDateTime now = LocalDateTime.now();
            String nowFormatted = dateTimeFormatter.format(now);
            SwingUtilities.invokeLater(() -> dateDisplay.setText(nowFormatted));
        }, 0, 1, TimeUnit.SECONDS);
		dateDisplay.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		dateDisplay.setBounds(845,48,150,30);
		dateDisplay.setForeground(new Color(0xa9a9a9a));
		

		JLabel leftMenu = new JLabel();
		leftMenu.setOpaque(true);
		leftMenu.setBackground(Color.WHITE);
		leftMenu.setBounds(0,-1,260,768);
		leftMenu.setBorder(border);
		
		Icon logoImg = new ImageIcon("logoDASHBOARD.png");
		JLabel logo = new JLabel();
		logo.setIcon(logoImg);
		logo.setBounds(45,30,153,64);
		
		signin = new JButton();
		signin.setText("Update Settings");
		signin.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		signin.setBounds(965, 530, 250, 50);
		signin.setFocusPainted(false);
		signin.setForeground(Color.WHITE);
		signin.setBackground(new Color(0x179EFF));
		signin.addActionListener(this);
		signin.setModel(new FixedStateButtonModel());
		signin.setBorder(borderSignIn);
		signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel interestsText = new JLabel();
		interestsText.setText("Interests");
		interestsText.setForeground(new Color(0xa9a9a9));
		interestsText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		interestsText.setBounds(975,160,100,50);
		
		interests = new JTextField();
		interests.setBackground(new Color(0xf2f0f0));
		interests.setPreferredSize(new Dimension(200,40));
		interests.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		interests.setBounds(965, 200, 250, 50);
		interests.setBorder(borderUserText);
		
		JLabel fbText = new JLabel();
		fbText.setText("Facebook");
		fbText.setForeground(new Color(0xa9a9a9));
		fbText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		fbText.setBounds(975,245,100,50);
		
		fb = new JTextField();
		fb.setBackground(new Color(0xf2f0f0));
		fb.setPreferredSize(new Dimension(200,40));
		fb.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		fb.setBounds(965, 285, 250, 50);
		fb.setBorder(borderUserText);
		
		JLabel twitterText = new JLabel();
		twitterText.setText("Twitter");
		twitterText.setForeground(new Color(0xa9a9a9));
		twitterText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		twitterText.setBounds(975,330,100,50);
		
		twitter = new JTextField();
		twitter.setBackground(new Color(0xf2f0f0));
		twitter.setPreferredSize(new Dimension(200,40));
		twitter.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		twitter.setBounds(965,370, 250, 50);
		twitter.setBorder(borderUserText);
		
		JLabel instaText = new JLabel();
		instaText.setText("Instagram");
		instaText.setForeground(new Color(0xa9a9a9));
		instaText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		instaText.setBounds(975,410,100,50);
		
		insta = new JTextField();
		insta.setBackground(new Color(0xf2f0f0));
		insta.setPreferredSize(new Dimension(200,40));
		insta.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		insta.setBounds(965, 450, 250, 50);
		insta.setBorder(borderUserText);
		
		JLabel firstText = new JLabel();
		firstText.setText("First Name");
		firstText.setForeground(new Color(0xa9a9a9));
		firstText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		firstText.setBounds(360,160,100,50);
		
		first = new JTextField();
		first.setBackground(new Color(0xf2f0f0));
		first.setPreferredSize(new Dimension(200,40));
		first.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		first.setBounds(350, 200, 250, 50);
		first.setBorder(borderUserText);
		
		JLabel userText = new JLabel();
		userText.setText("Username");
		userText.setForeground(new Color(0xa9a9a9));
		userText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		userText.setBounds(360,245,100,50);
		
		username = new JTextField();
		username.setBackground(new Color(0xf2f0f0));
		username.setPreferredSize(new Dimension(200,40));
		username.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		username.setBounds(350, 285, 220, 50);
		username.setBorder(borderUserText);
		
		JLabel passText = new JLabel();
		passText.setText("Password");
		passText.setForeground(new Color(0xa9a9a9));
		passText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		passText.setBounds(360,330,100,50);
		
		password = new JPasswordField();
		password.setBackground(new Color(0xf2f0f0));
		password.setPreferredSize(new Dimension(200,40));
		password.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		password.setBounds(350,370, 250, 50);
		password.setBorder(borderUserText);
		
		JLabel weightText = new JLabel();
		weightText.setText("Weight (KGs)");
		weightText.setForeground(new Color(0xa9a9a9));
		weightText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		weightText.setBounds(360,410,100,50);
		
		weight = new JTextField();
		weight.setBackground(new Color(0xf2f0f0));
		weight.setPreferredSize(new Dimension(200,40));
		weight.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		weight.setBounds(350, 450, 250, 50);
		weight.setBorder(borderUserText);
		
		JLabel eduText = new JLabel();
		eduText.setText("Education");
		eduText.setForeground(new Color(0xa9a9a9));
		eduText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		eduText.setBounds(360,490,100,50);
		
		education = new JTextField();
		education.setBackground(new Color(0xf2f0f0));
		education.setPreferredSize(new Dimension(200,40));
		education.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		education.setBounds(350, 530, 250, 50);
		education.setBorder(borderUserText);
		
		JLabel lastText = new JLabel();
		lastText.setText("Last Name");
		lastText.setForeground(new Color(0xa9a9a9));
		lastText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		lastText.setBounds(670,160,100,50);
		
		last = new JTextField();
		last.setBackground(new Color(0xf2f0f0));
		last.setPreferredSize(new Dimension(200,40));
		last.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		last.setBounds(660, 200, 250, 50);
		last.setBorder(borderUserText);
		
		JLabel emailText = new JLabel();
		emailText.setText("Email Address");
		emailText.setForeground(new Color(0xa9a9a9));
		emailText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		emailText.setBounds(630,245,130,50);
		
		email = new JTextField();
		email.setBackground(new Color(0xf2f0f0));
		email.setPreferredSize(new Dimension(200,40));
		email.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		email.setBounds(620, 285, 290, 50);
		email.setBorder(borderUserText);
		
		JLabel confirmText = new JLabel();
		confirmText.setText("Confirm Password");
		confirmText.setForeground(new Color(0xa9a9a9));
		confirmText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		confirmText.setBounds(670,330,120	,50);
		
		confirm = new JPasswordField();
		confirm.setBackground(new Color(0xf2f0f0));
		confirm.setPreferredSize(new Dimension(200,40));
		confirm.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		confirm.setBounds(660,370, 250, 50);
		confirm.setBorder(borderUserText);
		
		JLabel heightText = new JLabel();
		heightText.setText("Height (CM)");
		heightText.setForeground(new Color(0xa9a9a9));
		heightText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		heightText.setBounds(670,410,100,50);
		
		height = new JTextField();
		height.setBackground(new Color(0xf2f0f0));
		height.setPreferredSize(new Dimension(200,40));
		height.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		height.setBounds(660, 450, 250, 50);
		height.setBorder(borderUserText);
		
		JLabel occupText = new JLabel();
		occupText.setText("Occupation");
		occupText.setForeground(new Color(0xa9a9a9));
		occupText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		occupText.setBounds(670,490,100,50);
		
		occupation = new JTextField();
		occupation.setBackground(new Color(0xf2f0f0));
		occupation.setPreferredSize(new Dimension(200,40));
		occupation.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		occupation.setBounds(660, 530, 250, 50);
		occupation.setBorder(borderUserText);
		
		JLabel bgLabel = new JLabel();
		bgLabel.setOpaque(true);
		bgLabel.setBackground(new Color(0xECECEC));
		bgLabel.setBounds(300,100,940,510);
		bgLabel.setBorder(border);

		JLabel nameText = new JLabel();
		nameText.setText("Hello "+db.name);
		nameText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 20));
		nameText.setBounds(300,20,180,50);
		
		JLabel msg = new JLabel();
		msg.setText("Good Morning");
		msg.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		msg.setBounds(300,48,80,30);
		msg.setForeground(new Color(0xa9a9a9a));
		
		JLabel line = new JLabel();
		line.setBackground(new Color(0x179EFF));
		line.setOpaque(true);
		line.setBounds(390,63,15,3);
		
		JLabel settings = new JLabel();
		settings.setOpaque(true);
		settings.setBackground(new Color(0xB8E2F2));
		settings.setBounds(25,315,210,50);
		settings.setBorder(menuBorder);
		settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Icon icon = new ImageIcon("Homegrey.png");
		homeIcon = new JButton(icon);
		homeIcon.setBackground(new Color(0xFFFFFF));
		homeIcon.setFocusPainted(false);
		homeIcon.setBounds(40,145,30,30);
		homeIcon.addActionListener(this);
		homeIcon.setModel(new FixedStateButtonModel());
		homeIcon.setBorder(otherBorder);
		homeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		homeText = new JButton();
		homeText.setText("Home");
		homeText.setForeground(new Color(0xa9a9a9a));
		homeText.setBackground(new Color(0xFFFFFF));
		homeText.setFocusPainted(false);
		homeText.addActionListener(this);
		homeText.setModel(new FixedStateButtonModel());
		homeText.setBorder(otherBorder);
		homeText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		homeText.setBounds(40,145,140,30);
		homeText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Icon iconP = new ImageIcon("Usergrey.png");
		profileIcon = new JButton(iconP);
		profileIcon.setBackground(new Color(0xFFFFFF));
		profileIcon.setFocusPainted(false);
		profileIcon.setBounds(40,205,30,30);
		profileIcon.addActionListener(this);
		profileIcon.setModel(new FixedStateButtonModel());
		profileIcon.setBorder(otherBorder);
		
		profileText = new JButton();
		profileText.setText("Profile");
		profileText.setForeground(new Color(0xa9a9a9a));
		profileText.setBackground(new Color(0xFFFFFF));
		profileText.setFocusPainted(false);
		profileText.addActionListener(this);
		profileText.setModel(new FixedStateButtonModel());
		profileText.setBorder(otherBorder);
		profileText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		profileText.setBounds(40,205,140,30);
		
		Icon iconG = new ImageIcon("Phone.png");
		gameIcon = new JButton(iconG);
		gameIcon.setBackground(new Color(0xFFFFFF));
		gameIcon.setFocusPainted(false);
		gameIcon.setBounds(40,265,30,30);
		gameIcon.addActionListener(this);
		gameIcon.setModel(new FixedStateButtonModel());
		gameIcon.setBorder(otherBorder);
		
		gameText = new JButton();
		gameText.setText("Calls");
		gameText.setForeground(new Color(0xa9a9a9a));
		gameText.setBackground(new Color(0xFFFFFF));
		gameText.setFocusPainted(false);
		gameText.addActionListener(this);
		gameText.setModel(new FixedStateButtonModel());
		gameText.setBorder(otherBorder);
		gameText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		gameText.setBounds(35,265,140,30);
		
		Icon iconS = new ImageIcon("Settings-altblue.png");
		settingsIcon = new JButton(iconS);
		settingsIcon.setBackground(new Color(0xB8E2F2));
		settingsIcon.setFocusPainted(false);
		settingsIcon.setBounds(40,325,30,30);
		settingsIcon.addActionListener(this);
		settingsIcon.setModel(new FixedStateButtonModel());
		settingsIcon.setBorder(homeBorder);
		settingsIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		settingsText = new JButton();
		settingsText.setText("Settings");
		settingsText.setForeground(new Color(0x179EFF));
		settingsText.setBackground(new Color(0xB8E2F2));
		settingsText.setFocusPainted(false);
		settingsText.addActionListener(this);
		settingsText.setModel(new FixedStateButtonModel());
		settingsText.setBorder(homeBorder);
		settingsText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		settingsText.setBounds(45,325,140,30);
		settingsText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel requests = new JLabel();
		requests.setText("Friend Requests");
		requests.setForeground(new Color(0xa9a9a9a));
		requests.setFont(new Font("Red Hat Display Bold", Font.BOLD, 16));
		requests.setBounds(25, 385, 200,40);
		
		signout = new JButton();
		signout.setText("Sign Out");
		signout.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		signout.setBounds(1113, 640, 100, 30);
		signout.setFocusPainted(false);
		signout.setForeground(Color.WHITE);
		signout.setBackground(new Color(0x041725));
		signout.addActionListener(this);
		signout.setModel(new FixedStateButtonModel());
		signout.setBorder(borderLogin);
		signout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.add(requests);
		this.add(sp);
		this.add(signout);
		this.add(interestsText);
		this.add(fbText);
		this.add(instaText);
		this.add(twitterText);
		this.add(firstText);
		this.add(userText);
		this.add(passText);
		this.add(weightText);
		this.add(eduText);
		this.add(lastText);
		this.add(emailText);
		this.add(confirmText);
		this.add(heightText);
		this.add(occupText);
		this.add(interests);
		this.add(first);
		this.add(last);
		this.add(email);
		this.add(confirm);
		this.add(height);
		this.add(occupation);
		this.add(username);
		this.add(password);
		this.add(education);
		this.add(weight);	
		this.add(fb);
		this.add(insta);
		this.add(twitter);
		this.add(signin);
		this.add(dateDisplay);
		this.add(logo);
		this.add(homeIcon);
		this.add(homeText);
		this.add(settingsIcon);
		this.add(settingsText);
		this.add(gameIcon);
		this.add(gameText);
		this.add(profileIcon);
		this.add(profileText);
		this.add(nameText);
		this.add(msg);
		this.add(line);
		this.add(settings);
		this.add(leftMenu);
		this.add(bgLabel);
		
		
		this.setLayout(null);
		this.setTitle("DashBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(0xd6ecf3));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==homeText) {
			this.dispose();
			DashBoard db = new DashBoard();
		}
		else if(e.getSource()==homeIcon) {
			this.dispose();
			DashBoard db = new DashBoard();
		}
		else if(e.getSource()==settingsIcon) {
			this.dispose();
			Settings db = new Settings();
		}
		else if(e.getSource()==settingsText) {
			this.dispose();
			Settings db = new Settings();
		}
		if(e.getSource()==profileText) {
			this.dispose();
			Profile profile = new Profile();
		}
		else if(e.getSource()==profileIcon) {
			this.dispose();
			Profile profile = new Profile();
		}
		else if(e.getSource()==signout) {
			db.updateUserStatus(log.userName, 0);
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if(e.getSource()==gameText) {
			this.dispose();
			DashBoard db = new DashBoard();
			CallAFriend call = new CallAFriend();
		}
		else if(e.getSource()==gameIcon) {
			this.dispose();
			DashBoard db = new DashBoard();
			CallAFriend call = new CallAFriend();
		}
		
	}

}
