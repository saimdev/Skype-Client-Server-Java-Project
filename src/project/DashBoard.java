package project;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.Timer;
import java.awt.Window;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.TableModel;

import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DashBoard extends JFrame implements ActionListener{
	
	JButton homeIcon;
	JButton profileIcon;
	JButton gameIcon;
	JButton settingsIcon;
	JButton gameText;
	JButton settingsText;
	JButton profileText;
	JButton homeText;
	JButton addFriends;
	JButton checkCalls;
	JButton totalButton;
	JButton chat;
	JButton callButton;
	JButton addButton;
	JTextField enterUsername;
	public static JTable jt;
	public static JTable jt2;
	
	Login log = new Login("use");
	DataBase db = new DataBase();
	private static final DecimalFormat df = new DecimalFormat("0.0");
	private static final DecimalFormat df2 = new DecimalFormat("0");
	public static String bmiFinal;
	public static String weightFinal;
	public static String heightFinal;
	private final static int VIBRATION_LENGTH = 7;
    private final static int VIBRATION_VELOCITY = 10;
    private static final int TIMER_DELAY = 500;
    public static String friendName;
    public Timer blinkTimer;
    public static Thread t;
    private int count = 0;
    private int maxCount = 10;
    private boolean on = false;
//    JLabel totalFriends;
	
    DashBoard(String use){}
    
	DashBoard(){
		
		db.userSearch(db.userName, db.passCode);
		
		AbstractBorder borderCalls = new WelcomeBubbleBorder(new Color(0x179EFF),0,16,0);
		AbstractBorder imgBorder = new WelcomeBubbleBorder(new Color(23, 158, 255,150),3,360,0);
		AbstractBorder border = new WelcomeBubbleBorder(new Color(0xECECEC),2,0,0);
		AbstractBorder rightBorder = new RightMenuBubbleBorder(new Color(0x041725),0,15,0);
		AbstractBorder menuBorder = new LeftMenuBubbleBorder(new Color(0xB8E2F2),0,15,0);
		AbstractBorder rightMenuBorder = new WelcomeBubbleBorder(new Color(0xB8E2F2),0,20,0);
		AbstractBorder homeBorder = new MenuBubbleBorder(new Color(0xB8E2F2),0,0,0);
		AbstractBorder otherBorder = new WelcomeBubbleBorder(new Color(0xFFFFFF),0,0,0);
		
//		totalFriends = new JLabel();
//		totalFriends.setText("10");
//		totalFriends.setBounds(320,200,180,50);
//		totalFriends.setFont(new Font("Roboto Bold", Font.BOLD, 16));
//		totalFriends.setVisible(false);
		
		checkCalls = new JButton();
		checkCalls.setText("Check Call");
		checkCalls.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		checkCalls.setBounds(830, 130, 130, 30);
		checkCalls.setFocusPainted(false);
		checkCalls.setForeground(Color.WHITE);
		checkCalls.setBackground(new Color(0x179EFF));
		checkCalls.addActionListener(this);
		checkCalls.setModel(new FixedStateButtonModel());
		checkCalls.setBorder(borderCalls);
		checkCalls.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		

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
		dateDisplay.setBounds(845,58,150,30);
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
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(log.userName+".jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel profileImg = new JLabel();
		profileImg.setIcon(imageIcon);
		profileImg.setBounds(300, 40, 100,100);
		profileImg.setBorder(imgBorder);
		profileImg.setHorizontalAlignment(JLabel.CENTER);
		profileImg.setVerticalAlignment(JLabel.CENTER);
		
		Icon top = new ImageIcon("Group video-amico (1) 2.png");
		JLabel TopLogo = new JLabel();
		TopLogo.setIcon(top);
		TopLogo.setBounds(490, 140, 288,288);
		
		JLabel signedIn = new JLabel();
		signedIn.setText("You are signed in as");
		signedIn.setForeground(new Color(0xa9a9a9a));
		signedIn.setFont(new Font("Red Hat Display Bold", Font.BOLD, 12));
		signedIn.setBounds(570,450,180,50);
		
		JLabel emailDetails = new JLabel();
		db.searchUsername(log.userName);
		emailDetails.setText(db.emailId);
		emailDetails.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		emailDetails.setBounds(570,470,300,50);
		
		JLabel switching = new JLabel();
		switching.setText("Try switching account if you do not see conversation history");
		switching.setForeground(new Color(0xa9a9a9a));
		switching.setFont(new Font("Red Hat Display Bold", Font.BOLD, 12));
		switching.setBounds(570,490,400,50);
		
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
		nameText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 25));
		nameText.setBounds(410,55,220,50);
		
		JLabel msg = new JLabel();
		msg.setText("Good Morning");
		msg.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		msg.setBounds(410,88,120,30);
		msg.setForeground(new Color(0xa9a9a9a));
		
		JLabel line = new JLabel();
		line.setBackground(new Color(0x179EFF));
		line.setOpaque(true);
		line.setBounds(520,102,18,4);
		
		JLabel home = new JLabel();
		home.setOpaque(true);
		home.setBackground(new Color(0xB8E2F2));
		home.setBounds(25,135,210,50);
		home.setBorder(menuBorder);
		
		Icon icon = new ImageIcon("Homeblue.png");
		homeIcon = new JButton(icon);
		homeIcon.setBackground(new Color(0xB8E2F2));
		homeIcon.setFocusPainted(false);
		homeIcon.setBounds(40,145,30,30);
		homeIcon.addActionListener(this);
		homeIcon.setModel(new FixedStateButtonModel());
		homeIcon.setBorder(homeBorder);
		
		homeText = new JButton();
		homeText.setText("Home");
		homeText.setForeground(new Color(0x179EFF));
		homeText.setBackground(new Color(0xB8E2F2));
		homeText.setFocusPainted(false);
		homeText.addActionListener(this);
		homeText.setModel(new FixedStateButtonModel());
		homeText.setBorder(homeBorder);
		homeText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 15));
		homeText.setBounds(40,145,140,30);
		
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
		
		JLabel help = new JLabel();
		help.setText("Need Help?");
		help.setForeground(new Color(0xa9a9a9a));
		help.setFont(new Font("Red Hat Display Bold", Font.BOLD, 14));
		help.setBounds(300, 455, 100,30);
		
		Icon imgTotal = new ImageIcon("Group 9-3.png");
		totalButton = new JButton();
		totalButton.setIcon(imgTotal);
		totalButton.addActionListener(this);
		totalButton.setFocusPainted(false);
		totalButton.setModel(new FixedStateButtonModel());
		totalButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		totalButton.setBorder(borderCalls);
		totalButton.setBounds(300, 495, 50,50);
		
		Icon imgChat = new ImageIcon("Group 9-1.png");
		chat = new JButton();
		chat.setIcon(imgChat);
		chat.setBounds(300, 550, 50,50);
		chat.addActionListener(this);
		chat.setFocusPainted(false);
		chat.setModel(new FixedStateButtonModel());
		chat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chat.setBorder(borderCalls);
		
		Icon imgCall = new ImageIcon("Group 9.png");
		callButton = new JButton();
		callButton.setIcon(imgCall);
		callButton.addActionListener(this);
		callButton.setFocusPainted(false);
		callButton.setModel(new FixedStateButtonModel());
		callButton.setBorder(borderCalls);
		callButton.setBounds(300, 605, 50,50);
		callButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Icon imgAdd = new ImageIcon("Group 9-2.png");
		addButton = new JButton();
		addButton.setIcon(imgAdd);
		addButton.addActionListener(this);
		addButton.setFocusPainted(false);
		addButton.setModel(new FixedStateButtonModel());
		addButton.setBorder(borderCalls);
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setBounds(300, 660, 50,50);
		
		JLabel help1 = new JLabel();
		help1.setText("Total Friends");
		help1.setFont(new Font("Roboto Regular", Font.BOLD, 13));
		help1.setBounds(370,510,150,20);
		help1.setForeground(new Color(0xa9a9a9a));
		
		JLabel help2 = new JLabel();
		help2.setText("Chat");
		help2.setFont(new Font("Roboto Regular", Font.BOLD, 13));
		help2.setBounds(370,565,150,20);
		help2.setForeground(new Color(0xa9a9a9a));
		
		JLabel help3 = new JLabel();
		help3.setText("Call");
		help3.setFont(new Font("Roboto Regular", Font.BOLD, 13));
		help3.setBounds(370,620,150,20);
		help3.setForeground(new Color(0xa9a9a9a));
		
		JLabel help4 = new JLabel();
		help4.setText("Add Friends");
		help4.setFont(new Font("Roboto Regular", Font.BOLD, 13));
		help4.setBounds(370,675,150,20);
		help4.setForeground(new Color(0xa9a9a9a));
		
		Icon imgGame = new ImageIcon("Frame14.png");
		JLabel gameImg = new JLabel();
		gameImg.setIcon(imgGame);
		gameImg.setBounds(550, 575,410,130);
		
//		this.add(totalFriends);
		this.add(checkCalls);
		this.add(sp);
		this.add(sp2);
		this.add(requests);
		this.add(enterUsername);
		this.add(addFriends);
		this.add(profileImg);
		this.add(switching);
		this.add(emailDetails);
		this.add(signedIn);
		this.add(TopLogo);
		this.add(dateDisplay);
		this.add(totalButton);
		this.add(addButton);
		this.add(chat);
		this.add(callButton);
		this.add(help1);
		this.add(help2);
		this.add(help3);
		this.add(help4);
		this.add(help);
		this.add(logo);
		this.add(gameImg);
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
		this.add(home);
		this.add(diet);
		this.add(leftMenu);
		this.add(rightMenu);
		
		this.setLayout(null);
		this.setTitle("DashBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(0xd6ecf3));
		
		jt.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jtMouseClicked(evt);
			}
		});	
		
		blinkTimer = new Timer(300, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (count >= maxCount) {
		            addFriends.setBackground(new Color(0x179EFF));
		            ((Timer) e.getSource()).stop();
		        } else {
		        	addFriends.setBackground( on ? Color.YELLOW : new Color(0x179EFF));
		            on = !on;
		            count++;
		        }
		    }
		});
	}
	
	private void jtMouseClicked(java.awt.event.MouseEvent evt) {
		int index = jt.getSelectedRow();
		System.out.println("Index: "+index);
		TableModel model = jt.getModel();
		
		friendName =  model.getValueAt(index, 0).toString();
		
		FriendRequest fr = new FriendRequest();
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
		else if(e.getSource()==profileText) {
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
		else if(e.getSource()==checkCalls) {
			db.checkUserCallStatus(log.userName);
			CallRequest calls = new CallRequest();
		}
		else if(e.getSource()==addButton) {
			count = 0;
		    maxCount = 10;
		    on = false;
			blinkTimer.start();
		}
		else if(e.getSource()==totalButton) {
			JOptionPane.showMessageDialog(this, "You have total "+db.checkNoOfFriends(log.userName)+" Friends");
		}
		else if(e.getSource()==callButton) {
			CallAFriend callnow = new CallAFriend();
		}
		else if(e.getSource()==chat) {
			ChatServer chatting = new ChatServer();
		}
		
		else if(e.getSource()==addFriends) {
			if(enterUsername.getText().isEmpty()) {
				try {
		            final int originalX = this.getLocationOnScreen().x;
		            final int originalY = this.getLocationOnScreen().y;
		            for (int i = 0; i < VIBRATION_LENGTH; i++) {
		                Thread.sleep(10);
		                this.setLocation(originalX, originalY + VIBRATION_VELOCITY);
		                Thread.sleep(10);
		                this.setLocation(originalX, originalY - VIBRATION_VELOCITY);
		                Thread.sleep(10);
		                this.setLocation(originalX + VIBRATION_VELOCITY, originalY);
		                Thread.sleep(10);
		                this.setLocation(originalX, originalY);
		            }
		        } catch (Exception err) {
		            err.printStackTrace();
		        }
				JOptionPane.showMessageDialog(this, "Please Enter Username");
			}
			else {
				if(enterUsername.getText().equals(log.userName)) {
					try {
			            final int originalX = this.getLocationOnScreen().x;
			            final int originalY = this.getLocationOnScreen().y;
			            for (int i = 0; i < VIBRATION_LENGTH; i++) {
			                Thread.sleep(10);
			                this.setLocation(originalX, originalY + VIBRATION_VELOCITY);
			                Thread.sleep(10);
			                this.setLocation(originalX, originalY - VIBRATION_VELOCITY);
			                Thread.sleep(10);
			                this.setLocation(originalX + VIBRATION_VELOCITY, originalY);
			                Thread.sleep(10);
			                this.setLocation(originalX, originalY);
			            }
			        } catch (Exception err) {
			            err.printStackTrace();
			        }
					JOptionPane.showMessageDialog(this, "You cannot send request to yourself");
				}
				else {
					db.searchUsername(enterUsername.getText());
					if(db.check==1) {
						db.searchFriend(log.userName, enterUsername.getText());
						db.searchFriendList(log.userName, enterUsername.getText());
						if(db.checkFriend==1 || db.checkFriendReq==1) {
							try {
					            final int originalX = this.getLocationOnScreen().x;
					            final int originalY = this.getLocationOnScreen().y;
					            for (int i = 0; i < VIBRATION_LENGTH; i++) {
					                Thread.sleep(10);
					                this.setLocation(originalX, originalY + VIBRATION_VELOCITY);
					                Thread.sleep(10);
					                this.setLocation(originalX, originalY - VIBRATION_VELOCITY);
					                Thread.sleep(10);
					                this.setLocation(originalX + VIBRATION_VELOCITY, originalY);
					                Thread.sleep(10);
					                this.setLocation(originalX, originalY);
					            }
					        } catch (Exception err) {
					            err.printStackTrace();
					        }
							JOptionPane.showMessageDialog(this, "This Person is already added or you have friend Request");
							db.checkFriend=0;
							db.checkFriendReq=0;
						}
						else {
							db.sendRequest(enterUsername.getText(), log.userName);
							JOptionPane.showMessageDialog(this, "Friend Request Sent");
							enterUsername.setText("");
							db.check=0;
						}
					}
					else {
						try {
				            final int originalX = this.getLocationOnScreen().x;
				            final int originalY = this.getLocationOnScreen().y;
				            for (int i = 0; i < VIBRATION_LENGTH; i++) {
				                Thread.sleep(10);
				                this.setLocation(originalX, originalY + VIBRATION_VELOCITY);
				                Thread.sleep(10);
				                this.setLocation(originalX, originalY - VIBRATION_VELOCITY);
				                Thread.sleep(10);
				                this.setLocation(originalX + VIBRATION_VELOCITY, originalY);
				                Thread.sleep(10);
				                this.setLocation(originalX, originalY);
				            }
				        } catch (Exception err) {
				            err.printStackTrace();
				        }
						JOptionPane.showMessageDialog(this, "Username doesn't exists");
					}
				}
			}
	
		}
	}
}
