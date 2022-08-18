package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class WelcomeScreen extends JFrame implements ActionListener{
	
	JButton signup;
	JButton login;
	
	WelcomeScreen(){
		
		AbstractBorder borderSignup = new WelcomeBubbleBorder(new Color(0x179EFF),2,16,0);
		AbstractBorder borderLogin = new WelcomeBubbleBorder(new Color(0x041725),2,16,0);
		
		Icon img = new ImageIcon("WelcSc1.jpg");
		JLabel welcomeImage = new JLabel();
		welcomeImage.setIcon(img);
		welcomeImage.setBounds(0,0,520,768);
		
		JLabel welcomeText = new JLabel();
		welcomeText.setText("<html>Welcome to <br></br> Skype Lite</html>");
		welcomeText.setFont(new Font("Red Hat Display Bold", Font.BOLD, 55));
		welcomeText.setBounds(625,120,400,300);
		
		JLabel line = new JLabel();
		line.setBackground(new Color(0x179EFF));
		line.setOpaque(true);
		line.setBounds(625,365,124,6);
		
		    
		JLabel descp = new JLabel();
		descp.setText("<html>Skype is software that enables the world's conversations. Millions "
				+ "of individuals and businesses use Skype to make free video and voice one-to-one"
				+ "and group calls, send instant messages and share files with other people on Skype.</html>");
		descp.setFont(new Font("Roboto Regular", Font.BOLD, 18));
		descp.setBounds(625,250,570,400);
		descp.setForeground(new Color(0xa9a9a9a));
		
		signup = new JButton();
		signup.setText("Sign Up");
		signup.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		signup.setBounds(625, 530, 130, 50);
		signup.setFocusPainted(false);
		signup.setForeground(Color.WHITE);
		signup.setBackground(new Color(0x179EFF));
		signup.addActionListener(this);
		signup.setModel(new FixedStateButtonModel());
		signup.setBorder(borderSignup);
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		login = new JButton();
		login.setText("Log In");
		login.setFont(new Font("Roboto Bold", Font.BOLD, 14));
		login.setBounds(775,530, 130, 50);
		login.setFocusPainted(false);
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(0x041725));
		login.addActionListener(this);
		login.setModel(new FixedStateButtonModel());
		login.setBorder(borderLogin);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.add(welcomeImage);
		this.add(welcomeText);
		this.add(line);
		this.add(descp);
		this.add(login);
		this.add(signup);
		
		this.setLayout(null);
		this.setTitle("Welcome to Fitocity");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(0xFFFFFF));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			this.dispose();
			Login login = new Login();
		}
		else if (e.getSource()==signup) {
			this.dispose();
			Signup register = new Signup();
		}
		// TODO Auto-generated method stub
		
	}
	
}