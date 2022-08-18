package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.lang.Object;
import java.text.DecimalFormat;
import java.awt.image.BufferedImage;

public class SignupSecondScreen extends JFrame implements ActionListener{
	
	public static String educ;
	public static String interest;
	public static String fb;
	public static String twitter;
	public static String occup;
	public static String insta;
	public static String path;
	public static File f;
	private final static int VIBRATION_LENGTH = 7;
    private final static int VIBRATION_VELOCITY = 10;
	
	JButton back;
	JButton reset;
	JButton next;
	JTextField eduText;
	JTextField interText;
	JTextField fbText;
	JTextField twitterText;
	JTextField occupText;
	JTextField instaText;
	JButton upload;
	JButton uploadCover;
	
	DataBase db = new DataBase();
	Signup use = new Signup("use");
	private static final DecimalFormat df = new DecimalFormat("0.0");
	
	SignupSecondScreen(String use){}
	
	SignupSecondScreen(){
		
		AbstractBorder borderBack = new LabelBubbleBorder(new Color(0x03a9F4),0,0,0);
		AbstractBorder border = new LabelBubbleBorder(new Color(0xECECEC),2,35,0);
		AbstractBorder borderdots = new DotsBubbleBorder(new Color(0x1858ff),0,180,0);
		AbstractBorder borderReset = new TextBubbleBorder(new Color(0x041725),1,10,0);
		AbstractBorder borderNext = new TextBubbleBorder(new Color(0x179EFF),1,10,0);
		AbstractBorder borderUserText = new TextBubbleBorder(new Color(0xffffff),1,10,0);
		
		Icon bgImg = new ImageIcon("Background2.png");
		JLabel bgImage = new JLabel();
		bgImage.setIcon(bgImg);
		bgImage.setBounds(0,0,1300,768);
		
		JLabel bgLabel = new JLabel();
		bgLabel.setOpaque(true);
		bgLabel.setBackground(new Color(0xECECEC));
		bgLabel.setBounds(370,110,540,530);
		bgLabel.setBorder(border);
		
		JLabel fitocity = new JLabel();
		fitocity.setText("SkypeLite.");
		fitocity.setForeground(Color.WHITE);
		fitocity.setFont(new Font("Red Hat Display Bold", Font.BOLD, 30));
		fitocity.setBounds(551,35,300,60);
		
		JLabel signupHead = new JLabel();
		signupHead.setText("Setup Profile");
		signupHead.setForeground(Color.WHITE);
		signupHead.setFont(new Font("Red Hat Display Bold", Font.BOLD, 17));
		signupHead.setBounds(1140,35,200,50);
		
		Icon icon = new ImageIcon("Back-icon-White.png");
		back = new JButton(icon);
		back.setBackground(new Color(0x1080ff));
		back.setFocusPainted(false);
		back.setBounds(40,37,30,30);
		back.addActionListener(this);
		back.setModel(new FixedStateButtonModel());
		back.setBorder(borderBack);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel dot1 = new JLabel();
		dot1.setOpaque(true);
		dot1.setBackground(new Color(236,236,236,100));
		dot1.setBounds(610,655,15,15);
		dot1.setBorder(borderdots);
		
		JLabel dot2 = new JLabel();
		dot2.setOpaque(true);
		dot2.setBackground(new Color(236,236,236,220));
		dot2.setBounds(635,655,15,15);
		dot2.setBorder(borderdots);
		
		JLabel education = new JLabel();
		education.setText("Education");
		education.setForeground(new Color(0xa9a9a9));
		education.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		education.setBounds(430,160,100,50);
		
		eduText = new JTextField();
		eduText.setPreferredSize(new Dimension(200,40));
		eduText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		eduText.setBounds(420, 205, 210,50);
		eduText.setBorder(borderUserText);
		
		JLabel interests = new JLabel();
		interests.setText("Interests");
		interests.setForeground(new Color(0xa9a9a9));
		interests.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		interests.setBounds(430,250,100,50);
		
		interText = new JTextField();
		interText.setPreferredSize(new Dimension(200,40));
		interText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		interText.setBounds(420, 290, 210, 50);
		interText.setBorder(borderUserText);
		
		JLabel facebook = new JLabel();
		facebook.setText("Facebook");
		facebook.setForeground(new Color(0xa9a9a9));
		facebook.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		facebook.setBounds(430,330,100,50);
	
		fbText = new JTextField();
		fbText.setPreferredSize(new Dimension(200,40));
		fbText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		fbText.setBounds(420, 370, 210, 50);
		fbText.setBorder(borderUserText);
		
		JLabel twitter = new JLabel();
		twitter.setText("Twitter");
		twitter.setForeground(new Color(0xa9a9a9));
		twitter.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		twitter.setBounds(430,410,100,50);
		
		twitterText = new JTextField();
		twitterText.setPreferredSize(new Dimension(200,40));
		twitterText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		twitterText.setBounds(420, 450, 210, 50);
		twitterText.setBorder(borderUserText);
		
		//**************************************//
		
		
		JLabel occupation = new JLabel();
		occupation.setText("Occupation");
		occupation.setForeground(new Color(0xa9a9a9));
		occupation.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		occupation.setBounds(660,160,100,50);
		
		occupText = new JTextField();
		occupText.setPreferredSize(new Dimension(200,40));
		occupText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		occupText.setBounds(650, 205, 210, 50);
		occupText.setBorder(borderUserText);
		
		JLabel instagram = new JLabel();
		instagram.setText("Instagram");
		instagram.setForeground(new Color(0xa9a9a9));
		instagram.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		instagram.setBounds(660,250,100,50);
		
		instaText = new JTextField();
		instaText.setPreferredSize(new Dimension(200,40));
		instaText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		instaText.setBounds(650, 290, 210, 50);
		instaText.setBorder(borderUserText);
		
		JLabel uploadText = new JLabel();
		uploadText.setText("Choose profile picture");
		uploadText.setForeground(new Color(0xa9a9a9));
		uploadText.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		uploadText.setHorizontalAlignment(JLabel.CENTER);
		uploadText.setVerticalAlignment(JLabel.CENTER);
		uploadText.setBounds(660,363,200,50);
		
		JLabel uploadText2 = new JLabel();
		uploadText2.setText("to upload");
		uploadText2.setForeground(new Color(0xa9a9a9));
		uploadText2.setFont(new Font("Roboto Regular", Font.BOLD, 15));
		uploadText2.setHorizontalAlignment(JLabel.CENTER);
		uploadText2.setVerticalAlignment(JLabel.CENTER);
		uploadText2.setBounds(660,383,200,50);
		
		upload = new JButton();
		upload.setText("Upload Profile");
		upload.setFont(new Font("Roboto Bold", Font.BOLD, 13));
		upload.setBounds(690, 430, 140, 40);
		upload.setFocusPainted(false);
		upload.setForeground(Color.WHITE);
		upload.setBackground(new Color(0x179EFF));
		upload.addActionListener(this);
		upload.setModel(new FixedStateButtonModel());
		upload.setBorder(borderNext);
		upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		reset = new JButton();
		reset.setText("Reset Fields");
		reset.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		reset.setBounds(420, 520, 210, 50);
		reset.setFocusPainted(false);
		reset.setForeground(Color.WHITE);
		reset.setBackground(new Color(0x041725));
		reset.addActionListener(this);
		reset.setModel(new FixedStateButtonModel());
		reset.setBorder(borderReset);
		reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		next = new JButton();
		next.setText("Next");
		next.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		next.setBounds(650, 520, 210, 50);
		next.setFocusPainted(false);
		next.setForeground(Color.WHITE);
		next.setBackground(new Color(0x179EFF));
		next.addActionListener(this);
		next.setModel(new FixedStateButtonModel());
		next.setBorder(borderNext);
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.add(uploadText);
		this.add(uploadText2);
		this.add(upload);
//		this.add(uploadCover);
		this.add(signupHead);
		this.add(fitocity);
		this.add(back);
		this.add(dot1);
		this.add(dot2);
		this.add(education);
		this.add(eduText);
		this.add(interests);
		this.add(interText);
		this.add(facebook);
		this.add(fbText);
		this.add(twitter);
		this.add(twitter);
		this.add(twitterText);
		this.add(occupation);
		this.add(occupText);
		this.add(instagram);
		this.add(instaText);
		this.add(reset);
		this.add(next);
		this.add(bgLabel);
		this.add(bgImage);
		
		
		this.setLayout(null);
		this.setTitle("Setup Profile");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	public void uploadImageActionPerformed(java.awt.event.ActionEvent evt) {                                            
		JFileChooser file = new JFileChooser();
	      file.setMultiSelectionEnabled(true);
	      file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	      file.setFileHidingEnabled(false);
	      if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	         File f = file.getSelectedFile();
	         System.out.println(f.getPath());
	         path = f.toString();
	      }
	      System.out.println(path);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.dispose();
			Signup signup = new Signup();
		}
		
		else if (e.getSource()==next) {
			if (eduText.getText().isEmpty() || interText.getText().isEmpty() || fbText.getText().isEmpty() || twitterText.getText().isEmpty() ||  occupText.getText().isEmpty() || instaText.getText().isEmpty()) {
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
				JOptionPane.showMessageDialog(this, "Some Fields are Empty");
			}
			else {
				educ = eduText.getText();
				interest = interText.getText();
				fb = fbText.getText();
				twitter = twitterText.getText();
				occup = occupText.getText();
				insta = instaText.getText();
				db.Registration1(use.name, use.user, use.pass, use.weight, use.height, use.last, use.confirm, use.email);
				db.Registration2(educ, interest, fb, twitter, occup, insta, use.user, use.pass);
				db.newDB(use.user);
				db.newDbRequests(use.user);
				db.newDBForStatus(use.user);
				db.newDBForCalls(use.user);
				JOptionPane.showMessageDialog(this, "Successfully Registered");
				this.dispose();
				Login signin = new Login();
			}
		}
		else if(e.getSource()==upload) {
			uploadImageActionPerformed(e);
			MyImage image = new MyImage();
		}
		else if(e.getSource()==reset) {
			eduText.setText("");
			interText.setText("");
			fbText.setText("");
			twitterText.setText("");
			occupText.setText("");
			instaText.setText("");
		}
		
	}


}
