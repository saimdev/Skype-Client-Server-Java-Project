package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class CallAFriend extends JFrame implements ActionListener{
	
	JTextField userText;
	JButton callBut;
	public static String userName;
	private final static int VIBRATION_LENGTH = 7;
    private final static int VIBRATION_VELOCITY = 10;
	
	DataBase db = new DataBase();
	GeneratePassword gpd = new GeneratePassword("use");
	Login log = new Login("use");
	
	CallAFriend(String use){}
	
	CallAFriend(){
		
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
		
		callBut = new JButton();
		callBut.setText("Call Your Friend");
		callBut.setFont(new Font("Roboto Bold", Font.BOLD, 12));
		callBut.setBounds(150, 180, 180, 40);
		callBut.setFocusPainted(false);
		callBut.setForeground(Color.WHITE);
		callBut.setBackground(new Color(0x041725));
		callBut.addActionListener(this);
		callBut.setModel(new FixedStateButtonModel());
		callBut.setBorder(borderResetBut);
		callBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel bgLabel = new JLabel();
		bgLabel.setOpaque(true);
		bgLabel.setBackground(new Color(0xECECEC));
		bgLabel.setBounds(65,50,350,200);
		bgLabel.setBorder(border);
		
		this.add(callBut);
		this.add(userText);
		this.add(username);
		this.add(bgLabel);
		this.add(bgImage);
		
		this.setLayout(null);
		this.setTitle("Call A Friend");
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==callBut) {
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
				if(userName.equals(log.userName)) {
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
					JOptionPane.showMessageDialog(this, "You cannot call yourself");
				}
				else {
					db.searchUsername(userText.getText());
					if(db.check==1) {
						db.searchFriend(log.userName, userText.getText());
						if(db.checkFriend==1) {
							db.checkUserStatus(userName);
							if(db.checkStatus==1) {
								db.updateUserCallStatus(userName, log.userName,1);
//								Server server = new Server();
//								Server caller = new Server("use");
//								try {
//									caller.main(new String[0]);
//								} catch (ClassNotFoundException | IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								JOptionPane.showMessageDialog(this, "Call Sent");
								db.checkStatus=0;
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
								JOptionPane.showMessageDialog(this, "User is Offline");
							}
							db.checkFriend=0;
							this.dispose();
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
							JOptionPane.showMessageDialog(this, "Username you entered is not your friend");
						}
						db.check=0;
						
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

}
