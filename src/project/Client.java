package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Client extends JFrame {

	private JPanel contentPane;
	static JLabel img_client;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Socket s = new Socket("127.0.0.1",7901);
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		ImageIcon ic;
		BufferedImage br;
		Webcam cam = Webcam.getDefault();
		cam.open();
		
		while(true) {
		br = cam.getImage();
		ic = new ImageIcon(br);
		
		out.writeObject(ic);
		out.flush();
		img_client.setIcon(ic);
			
		}
		
		
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Client Side");
		
		img_client = new JLabel("");
		img_client.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(img_client, BorderLayout.CENTER);
	}

}
