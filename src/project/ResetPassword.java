package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class ResetPassword extends JFrame implements ActionListener{
	
	JTextField userText;
	JButton resetBut;
	public static String userName;
	private final static int VIBRATION_LENGTH = 7;
    private final static int VIBRATION_VELOCITY = 10;
	
	DataBase db = new DataBase();
	GeneratePassword gpd = new GeneratePassword("use");
	Login log = new Login("use");
	
	ResetPassword(String use){}
	
	ResetPassword(){
		
		AbstractBorder border = new LabelBubbleBorder(new Color(0xECECEC),0,35,0);
		AbstractBorder borderUserText = new TextBubbleBorder(new Color(0xffffff),1,10,0);
		AbstractBorder borderResetBut = new TextBubbleBorder(new Color(0x041725),1,10,0);
		
		Icon bgImg = new ImageIcon("Background2.png");
		JLabel bgImage = new JLabel();
		bgImage.setIcon(bgImg);
		bgImage.setBounds(0,0,1300,768);
		
		JLabel username = new JLabel();
		username.setText("Enter Username");
		username.setForeground(new Color(0xa9a9a9));
		username.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		username.setBounds(125,80,150,50);
		
		userText = new JTextField();
		userText.setPreferredSize(new Dimension(200,40));
		userText.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		userText.setBounds(115, 125, 250, 40);
		userText.setBorder(borderUserText);
		
		resetBut = new JButton();
		resetBut.setText("Reset Password");
		resetBut.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		resetBut.setBounds(150, 180, 180, 40);
		resetBut.setFocusPainted(false);
		resetBut.setForeground(Color.WHITE);
		resetBut.setBackground(new Color(0x041725));
		resetBut.addActionListener(this);
		resetBut.setModel(new FixedStateButtonModel());
		resetBut.setBorder(borderResetBut);
		resetBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel bgLabel = new JLabel();
		bgLabel.setOpaque(true);
		bgLabel.setBackground(new Color(0xECECEC));
		bgLabel.setBounds(65,50,350,200);
		bgLabel.setBorder(border);
		
		this.add(resetBut);
		this.add(userText);
		this.add(username);
		this.add(bgLabel);
		this.add(bgImage);
		
		this.setLayout(null);
		this.setTitle("Reset Password");
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetBut) {
			if(userText.getText().isEmpty()) {
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
				userName = userText.getText();
				db.searchUsername(userText.getText());
				if(db.check==1) {
					GeneratePassword gp = new GeneratePassword();
					db.updatePassword(userText.getText(), gpd.newPassword);
					db.check=0;
					this.dispose();
					NewPassword pass = new NewPassword();
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
					JOptionPane.showMessageDialog(this, "Username not Found");
				}
			}
		}
		
	}

}
