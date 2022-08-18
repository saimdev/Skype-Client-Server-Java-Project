package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class Signup extends JFrame implements ActionListener{
	
	public static String user;
	public static String name;
	public static String pass;
	public static Double weight;
	public static Double height;
	public static String last;
	public static String confirm;
	public static String email;
	public static Double bmi;
	public static Double heightFormula;
	private final static int VIBRATION_LENGTH = 7;
    private final static int VIBRATION_VELOCITY = 10;
	
	JButton back;
	JButton reset;
	JButton next;
	JTextField userText;
	JTextField nameText;
	JPasswordField passText;
	JTextField weightText;
	JTextField heightText;
	JTextField lastText;
	JPasswordField confirmText;
	JTextField emailText;
	
	DataBase db = new DataBase();
	
	Signup(String use){}
	
	Signup(){
		
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
		signupHead.setText("Signup");
		signupHead.setForeground(Color.WHITE);
		signupHead.setFont(new Font("Red Hat Display Bold", Font.BOLD, 17));
		signupHead.setBounds(1180,35,200,50);
		
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
		dot1.setBackground(new Color(236,236,236,220));
		dot1.setBounds(610,655,15,15);
		dot1.setBorder(borderdots);
		
		JLabel dot2 = new JLabel();
		dot2.setOpaque(true);
		dot2.setBackground(new Color(236,236,236,100));
		dot2.setBounds(635,655,15,15);
		dot2.setBorder(borderdots);
		
		JLabel firstname = new JLabel();
		firstname.setText("First Name");
		firstname.setForeground(new Color(0xa9a9a9));
		firstname.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		firstname.setBounds(430,160,100,50);
		
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(200,40));
		nameText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		nameText.setBounds(420, 205, 210,50);
		nameText.setBorder(borderUserText);
		
		JLabel username = new JLabel();
		username.setText("Username");
		username.setForeground(new Color(0xa9a9a9));
		username.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		username.setBounds(430,250,100,50);
		
		userText = new JTextField();
		userText.setPreferredSize(new Dimension(200,40));
		userText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		userText.setBounds(420, 290, 170, 50);
		userText.setBorder(borderUserText);
		
		JLabel password = new JLabel();
		password.setText("Password");
		password.setForeground(new Color(0xa9a9a9));
		password.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		password.setBounds(430,330,100,50);
	
		passText = new JPasswordField();
		passText.setPreferredSize(new Dimension(200,40));
		passText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		passText.setBounds(420, 370, 210, 50);
		passText.setBorder(borderUserText);
		
		JLabel weight = new JLabel();
		weight.setText("Weight (KGs)");
		weight.setForeground(new Color(0xa9a9a9));
		weight.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		weight.setBounds(430,410,100,50);
		
		weightText = new JTextField();
		weightText.setPreferredSize(new Dimension(200,40));
		weightText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		weightText.setBounds(420, 450, 210, 50);
		weightText.setBorder(borderUserText);
		
		//**************************************//
		
		
		JLabel lastname = new JLabel();
		lastname.setText("Last Name");
		lastname.setForeground(new Color(0xa9a9a9));
		lastname.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		lastname.setBounds(660,160,100,50);
		
		lastText = new JTextField();
		lastText.setPreferredSize(new Dimension(200,40));
		lastText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		lastText.setBounds(650, 205, 210, 50);
		lastText.setBorder(borderUserText);
		
		JLabel email = new JLabel();
		email.setText("Email Address");
		email.setForeground(new Color(0xa9a9a9));
		email.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		email.setBounds(620,250,100,50);
		
		emailText = new JTextField();
		emailText.setPreferredSize(new Dimension(200,40));
		emailText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		emailText.setBounds(610, 290, 250, 50);
		emailText.setBorder(borderUserText);
		
		JLabel confirmPassword = new JLabel();
		confirmPassword.setText("Confirm Password");
		confirmPassword.setForeground(new Color(0xa9a9a9));
		confirmPassword.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		confirmPassword.setBounds(660,330,150,50);
		
		confirmText = new JPasswordField();
		confirmText.setPreferredSize(new Dimension(200,40));
		confirmText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		confirmText.setBounds(650, 370, 210, 50);
		confirmText.setBorder(borderUserText);
		
		JLabel height = new JLabel();
		height.setText("Height (CM)");
		height.setForeground(new Color(0xa9a9a9));
		height.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		height.setBounds(660,410,100,50);
		
		heightText = new JTextField();
		heightText.setPreferredSize(new Dimension(200,40));
		heightText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		heightText.setBounds(650, 450, 210, 50);
		heightText.setBorder(borderUserText);
		
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
		
		this.add(signupHead);
		this.add(fitocity);
		this.add(back);
		this.add(dot1);
		this.add(dot2);
		this.add(username);
		this.add(userText);
		this.add(firstname);
		this.add(nameText);
		this.add(password);
		this.add(passText);
		this.add(weight);
		this.add(weightText);
		this.add(lastname);
		this.add(lastText);
		this.add(confirmPassword);
		this.add(confirmText);
		this.add(email);
		this.add(emailText);
		this.add(height);
		this.add(heightText);
		this.add(reset);
		this.add(next);
		this.add(bgLabel);
		this.add(bgImage);
		
		
		this.setLayout(null);
		this.setTitle("Signup");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
//		this.getContentPane().setBackground(new Color(0x03a9F4));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if (e.getSource()==next) {
			if (userText.getText().isEmpty() || nameText.getText().isEmpty() || passText.getText().isEmpty() || weightText.getText().isEmpty() ||  heightText.getText().isEmpty() || lastText.getText().isEmpty() || confirmText.getText().isEmpty() || emailText.getText().isEmpty()) {
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
				db.searchUsername(userText.getText());
				if(db.check==1) {
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
					JOptionPane.showMessageDialog(this, "Username already exists");
					db.check=0;
				}
				else {
					user = userText.getText();
					name = nameText.getText();
					pass = passText.getText();
					weight = Double.valueOf(weightText. getText());
					height = Double.valueOf(heightText. getText());
					last = lastText.getText();
					confirm = confirmText.getText();
					email = emailText.getText();
					if(pass.equals(confirm)) {
						heightFormula = height*0.01;
						heightFormula = heightFormula*heightFormula;
						bmi=(weight/heightFormula);
						this.dispose();
						SignupSecondScreen setup = new SignupSecondScreen();
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
						JOptionPane.showMessageDialog(this, "Passwords are not matched");
					}
				}
			}
		}
		else if(e.getSource()==reset) {
			userText.setText("");
			nameText.setText("");
			passText.setText("");
			weightText.setText("");
			heightText.setText("");
			lastText.setText("");
			confirmText.setText("");
			emailText.setText("");
		}
	}
}
