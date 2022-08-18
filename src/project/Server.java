package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Server extends JFrame {

	private JPanel contentPane;
	static JLabel img_server;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	Server(String use){}
	
	public Server(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Server Side");
//		setVisible(true);
		
		img_server = new JLabel("");
		img_server.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(img_server, BorderLayout.CENTER);
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Frame");
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Wait....");
		
		ServerSocket server = new ServerSocket(7901);
		Socket s = server.accept();
		System.out.println("Connected!!");
		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		ImageIcon ic;
		
		while(true) {
			
			ic = (ImageIcon) in.readObject();
			img_server.setIcon(ic);
		}
		
	}

	/**
	 * Create the frame.
	 */
	

}


//package project;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//
//public class Server extends JFrame {
//
//	private JPanel contentPane;
//	static JLabel img_server;
//
//	/**
//	 * Launch the application.
//	 * @throws IOException 
//	 * @throws ClassNotFoundException 
//	 */
//	
//	public Server() throws IOException, ClassNotFoundException{
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		setTitle("Server Side");
//		
//		img_server = new JLabel("");
//		img_server.setHorizontalAlignment(SwingConstants.CENTER);
//		contentPane.add(img_server, BorderLayout.CENTER);
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Server frame = new Server();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//		System.out.println("Wait....");
//		
//		ServerSocket server = new ServerSocket(7900);
//		Socket s = server.accept();
//		System.out.println("Connected!!");
//		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
//		ImageIcon ic;
//		
//		while(true) {
//			
//			ic = (ImageIcon) in.readObject();
//			img_server.setIcon(ic);
//		}
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	
//
//}
//
