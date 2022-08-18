package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

public class NewPassword extends JFrame implements ActionListener{
	
	JButton copy;
	
	ResetPassword resetP = new ResetPassword("use");
	GeneratePassword gp = new GeneratePassword("use");
	Login log = new Login("use");
	
	NewPassword(){
		AbstractBorder borderSignIn = new TextBubbleBorder(new Color(0x179EFF),1,10,0);
		
		JLabel newPass = new JLabel();
		newPass.setText("Your New Password");
		newPass.setForeground(new Color(0xa9a9a9));
		newPass.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		newPass.setBounds(65,20,200,50);
		
		JLabel passText = new JLabel();
		passText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		passText.setBounds(110, 60, 250, 40);
		passText.setText(gp.newPassword);
		passText.setHorizontalAlignment(JLabel.LEFT);
		passText.setVerticalAlignment(JLabel.CENTER);
		
		copy = new JButton();
		copy.setText("Copy");
		copy.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		copy.setBounds(100, 105, 70, 30);
		copy.setFocusPainted(false);
		copy.setForeground(Color.WHITE);
		copy.setBackground(new Color(0x179EFF));
		copy.addActionListener(this);
		copy.setModel(new FixedStateButtonModel());
		copy.setBorder(borderSignIn);
		copy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.add(copy);
		this.add(newPass);
		this.add(passText);
		
		this.setLayout(null);
		this.setTitle("New Password");
		this.setSize(300,250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0xECECEC));
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==copy) {
			String myString = gp.newPassword;
			StringSelection stringSelection = new StringSelection(myString);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			this.dispose();
		}
		
	}

}
