package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
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

public class Profile extends JFrame implements ActionListener{
	
	JButton homeIcon;
	JButton profileIcon;
	JButton gameIcon;
	JButton settingsIcon;
	JButton gameText;
	JButton settingsText;
	JButton profileText;
	JButton homeText;
	JTable jt;
	JTable jt2;
	JTextField enterUsername;
	JButton addFriends;
	
	private static final DecimalFormat df2 = new DecimalFormat("0");
	private static String heightFinal;
	private static String weightFinal;
	
	Login log = new Login("use");
	DataBase db = new DataBase();
	
	Profile(){
		
		db.userSearch(log.userName);
		db.userSearchReg2(log.userName);
		
		AbstractBorder border = new WelcomeBubbleBorder(new Color(0xECECEC),2,0,0);
		AbstractBorder imgBorder = new WelcomeBubbleBorder(new Color(23, 158, 255,150),3,360,0);
		AbstractBorder coverBorder = new WelcomeBubbleBorder(new Color(23, 158, 255,150),3,100,0);
		AbstractBorder rightBorder = new RightMenuBubbleBorder(new Color(0x041725),0,15,0);
		AbstractBorder menuBorder = new LeftMenuBubbleBorder(new Color(0xB8E2F2),0,15,0);
		AbstractBorder rightMenuBorder = new WelcomeBubbleBorder(new Color(0xB8E2F2),0,20,0);
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
	    
	    jt2=new JTable();
	    db.showAllFriends(jt2, log.userName);
	    JScrollPane sp2=new JScrollPane(jt2);  
	    sp2.setBounds(1025,100,200,450);
	    jt2.setEnabled(false);
	    jt2.setForeground(Color.WHITE);
	    jt2.setBackground(new Color(81, 120, 184, 100));
	    jt2.setFont(new Font("Roboto Regular", Font.BOLD, 16));
	    jt2.setBorder(rightBorder);
	    sp2.getViewport().setBackground(new Color(0x041725));
	    sp2.setBorder(null);
		
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
		
		Icon logoImg = new ImageIcon("dashlogo.png");
		JLabel logo = new JLabel();
		logo.setIcon(logoImg);
		logo.setBounds(45,30,153,64);
		
		JLabel rightMenu = new JLabel();
		rightMenu.setOpaque(true);
		rightMenu.setBackground(new Color(0x041725));
		rightMenu.setBounds(1000,27,250,680);
		rightMenu.setBorder(rightMenuBorder);
		
		enterUsername = new JTextField();
		enterUsername.setPreferredSize(new Dimension(150,50));
		enterUsername.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		enterUsername.setBounds(1030, 590, 190, 50);
		enterUsername.setBorder(rightBorder);
		
		addFriends = new JButton();
		addFriends.setText("Add Friend");
		addFriends.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		addFriends.setBounds(1030, 645, 190, 40);
		addFriends.setFocusPainted(false);
		addFriends.setForeground(Color.WHITE);
		addFriends.setBackground(new Color(0x179EFF));
		addFriends.addActionListener(this);
		addFriends.setModel(new FixedStateButtonModel());
		addFriends.setBorder(rightBorder);
		addFriends.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel diet = new JLabel();
		diet.setText("Friends List");
		diet.setForeground(Color.WHITE);
		diet.setFont(new Font("Red Hat Display Bold", Font.BOLD, 19));
		diet.setBounds(1010,45,180,50);
		diet.setBorder(rightBorder);
		
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
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(log.userName+".jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		JLabel profileImg = new JLabel();
		profileImg.setIcon(imageIcon);
		profileImg.setBounds(520, 120, 200,200);
		profileImg.setBorder(imgBorder);
		profileImg.setHorizontalAlignment(JLabel.CENTER);
		profileImg.setVerticalAlignment(JLabel.CENTER);
		
		ImageIcon image = new ImageIcon(new ImageIcon(log.userName+"1.jpg").getImage().getScaledInstance(630, 300, Image.SCALE_SMOOTH));
		JLabel coverImg = new JLabel();
		coverImg.setIcon(image);
		coverImg.setBounds(300, 100, 630,300);
		coverImg.setBorder(coverBorder);
		coverImg.setHorizontalAlignment(JLabel.CENTER);
		coverImg.setVerticalAlignment(JLabel.CENTER);
		
		JLabel fullName = new JLabel();
		fullName.setText(db.name+" "+db.lastName);
		fullName.setFont(new Font("Roboto Regular", Font.BOLD, 24));
		fullName.setForeground(Color.BLACK);
		fullName.setBounds(495,330,250,30);
		fullName.setHorizontalAlignment(JLabel.CENTER);
		fullName.setVerticalAlignment(JLabel.CENTER);
		
		JLabel user = new JLabel();
		user.setText("@"+log.userName);
		user.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		user.setBounds(545,355,150,30);
		user.setForeground(new Color(0xa9a9a9a));
		user.setHorizontalAlignment(JLabel.CENTER);
		user.setVerticalAlignment(JLabel.CENTER);
		
		JLabel profile = new JLabel();
		profile.setOpaque(true);
		profile.setBackground(new Color(0xB8E2F2));
		profile.setBounds(25,195,210,50);
		profile.setBorder(menuBorder);
		
		
		Icon icon = new ImageIcon("Homegrey.png");
		homeIcon = new JButton(icon);
		homeIcon.setBackground(new Color(0xFFFFFF));
		homeIcon.setFocusPainted(false);
		homeIcon.setBounds(40,145,30,30);
		homeIcon.addActionListener(this);
		homeIcon.setModel(new FixedStateButtonModel());
		homeIcon.setBorder(otherBorder);
		
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
		
		Icon iconP = new ImageIcon("Userblue.png");
		profileIcon = new JButton(iconP);
		profileIcon.setBackground(new Color(0xB8E2F2));
		profileIcon.setFocusPainted(false);
		profileIcon.setBounds(40,205,30,30);
		profileIcon.addActionListener(this);
		profileIcon.setModel(new FixedStateButtonModel());
		profileIcon.setBorder(homeBorder);
		
		profileText = new JButton();
		profileText.setText("Profile");
		profileText.setForeground(new Color(0x179EFF));
		profileText.setBackground(new Color(0xB8E2F2));
		profileText.setFocusPainted(false);
		profileText.addActionListener(this);
		profileText.setModel(new FixedStateButtonModel());
		profileText.setBorder(homeBorder);
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
		
		Icon iconS = new ImageIcon("Settings-altgrey.png");
		settingsIcon = new JButton(iconS);
		settingsIcon.setBackground(new Color(0xFFFFFF));
		settingsIcon.setFocusPainted(false);
		settingsIcon.setBounds(40,325,30,30);
		settingsIcon.addActionListener(this);
		settingsIcon.setModel(new FixedStateButtonModel());
		settingsIcon.setBorder(otherBorder);
		
		settingsText = new JButton();
		settingsText.setText("Settings");
		settingsText.setForeground(new Color(0xa9a9a9a));
		settingsText.setBackground(new Color(0xFFFFFF));
		settingsText.setFocusPainted(false);
		settingsText.addActionListener(this);
		settingsText.setModel(new FixedStateButtonModel());
		settingsText.setBorder(otherBorder);
		settingsText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		settingsText.setBounds(45,325,140,30);
		
		JLabel requests = new JLabel();
		requests.setText("Friend Requests");
		requests.setForeground(new Color(0xa9a9a9a));
		requests.setFont(new Font("Red Hat Display Bold", Font.BOLD, 16));
		requests.setBounds(25, 385, 200,40);
		
		Icon fb = new ImageIcon("fb.png");
		JLabel facebook = new JLabel();
		facebook.setIcon(fb);
		facebook.setBounds(300,610,197,100);
		
		Icon tw = new ImageIcon("twitter.png");
		JLabel twitter = new JLabel();
		twitter.setIcon(tw);
		twitter.setBounds(532,610,197,100);
		
		Icon insta = new ImageIcon("insta.png");
		JLabel instagram = new JLabel();
		instagram.setIcon(insta);
		instagram.setBounds(760,610,197,100);
		
		Icon h = new ImageIcon("heightweight.png");
		JLabel height = new JLabel();
		height.setIcon(h);
		height.setBounds(760,420,197,153);
		
		Icon u = new ImageIcon("usern.png");
		JLabel usern = new JLabel();
		usern.setIcon(u);
		usern.setBounds(300,420,431,153);
		
		JLabel userName = new JLabel();
		userName.setText("Email Address");
		userName.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		userName.setForeground(new Color(0xa9a9a9a));
		userName.setBounds(320,430,100,30);
		
		JLabel userText = new JLabel();
		userText.setText(db.emailId);
		userText.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		userText.setForeground(Color.BLACK);
		userText.setBounds(320,455,200,30);
		userText.setHorizontalAlignment(JLabel.LEFT);
		userText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel education = new JLabel();
		education.setText("Education");
		education.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		education.setForeground(new Color(0xa9a9a9a));
		education.setBounds(532,430,100,30);
		
		JLabel eduText = new JLabel();
		eduText.setText(db.educate);
		eduText.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		eduText.setForeground(Color.BLACK);
		eduText.setBounds(532,455,130,30);
		eduText.setHorizontalAlignment(JLabel.LEFT);
		eduText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel heightText = new JLabel();
		heightText.setText("Height");
		heightText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		heightText.setForeground(new Color(0xFFFFFF));
		heightText.setBounds(780,430,100,30);
		
		heightFinal = df2.format(db.heightCm);
		JLabel hText = new JLabel();
		hText.setText(heightFinal);
		hText.setFont(new Font("Roboto Regular", Font.BOLD, 25));
		hText.setForeground(Color.WHITE);
		hText.setBounds(780,460,150,30);
		hText.setHorizontalAlignment(JLabel.LEFT);
		hText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel cm = new JLabel();
		cm.setText("CM");
		cm.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		cm.setForeground(Color.WHITE);
		cm.setBounds(860,462,80,30);
		
		JLabel inter = new JLabel();
		inter.setText("Interests");
		inter.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		inter.setForeground(new Color(0xa9a9a9a));
		inter.setBounds(320,495,100,30);
		
		JLabel interText = new JLabel();
		interText.setText(db.inter);
		interText.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		interText.setForeground(Color.BLACK);
		interText.setBounds(320,520,130,30);
		interText.setHorizontalAlignment(JLabel.LEFT);
		interText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel occupation = new JLabel();
		occupation.setText("Occupation");
		occupation.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		occupation.setForeground(new Color(0xa9a9a9a));
		occupation.setBounds(532,495,100,30);
		
		JLabel occupText = new JLabel();
		occupText.setText(db.occupate);
		occupText.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		occupText.setForeground(Color.BLACK);
		occupText.setBounds(532,520,130,30);
		occupText.setHorizontalAlignment(JLabel.LEFT);
		occupText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel weight = new JLabel();
		weight.setText("Weight");
		weight.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		weight.setForeground(new Color(0xFFFFFF));
		weight.setBounds(780,495,100,30);
		
		JLabel wText = new JLabel();
		weightFinal = df2.format(db.weightKg);
		wText.setText(weightFinal);
		wText.setFont(new Font("Roboto Regular", Font.BOLD, 25));
		wText.setForeground(Color.WHITE);
		wText.setBounds(780,525,150,30);
		wText.setHorizontalAlignment(JLabel.LEFT);
		wText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel kg = new JLabel();
		kg.setText("KG");
		kg.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		kg.setForeground(Color.WHITE);
		kg.setBounds(860,527,80,30);
		
		JLabel fbText = new JLabel();
		fbText.setText("Facebook");
		fbText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		fbText.setForeground(Color.WHITE);
		fbText.setBounds(320,620,100,30);
		
		JLabel fText = new JLabel();
		fText.setText(db.faceBook);
		fText.setFont(new Font("Roboto Regular", Font.BOLD, 16));
		fText.setForeground(Color.WHITE);
		fText.setBounds(320,645,130,30);
		fText.setHorizontalAlignment(JLabel.LEFT);
		fText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel twText = new JLabel();
		twText.setText("Twitter");
		twText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		twText.setForeground(Color.WHITE);
		twText.setBounds(552,620,100,30);
		
		JLabel tText = new JLabel();
		tText.setText(db.tw);
		tText.setFont(new Font("Roboto Regular", Font.BOLD, 16));
		tText.setForeground(Color.WHITE);
		tText.setBounds(552,645,130,30);
		tText.setHorizontalAlignment(JLabel.LEFT);
		tText.setVerticalAlignment(JLabel.CENTER);
		
		JLabel instaText = new JLabel();
		instaText.setText("Instagram");
		instaText.setFont(new Font("Roboto Regular", Font.BOLD, 12));
		instaText.setForeground(Color.WHITE);
		instaText.setBounds(780,620,100,30);
		
		JLabel iText = new JLabel();
		iText.setText(db.insta);
		iText.setFont(new Font("Roboto Regular", Font.BOLD, 16));
		iText.setForeground(Color.WHITE);
		iText.setBounds(780,645,130,30);
		iText.setHorizontalAlignment(JLabel.LEFT);
		iText.setVerticalAlignment(JLabel.CENTER);
		
		this.add(enterUsername);
		this.add(addFriends);
		this.add(requests);
		this.add(sp);
		this.add(sp2);
		this.add(cm);
		this.add(kg);
		this.add(iText);
		this.add(fText);
		this.add(tText);
		this.add(wText);
		this.add(occupText);
		this.add(interText);
		this.add(hText);
		this.add(eduText);
		this.add(userText);
		this.add(user);
		this.add(profileImg);
		this.add(fullName);
		this.add(userName);
		this.add(education);
		this.add(heightText);
		this.add(inter);
		this.add(occupation);
		this.add(weight);
		this.add(instaText);
		this.add(twText);
		this.add(fbText);
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
		this.add(profile);
		this.add(diet);
		this.add(leftMenu);
		this.add(rightMenu);
		this.add(usern);
		this.add(height);
		this.add(instagram);
		this.add(twitter);
		this.add(facebook);
		
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
