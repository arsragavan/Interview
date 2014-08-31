package networking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame {
	
	private JTextArea textArea;
	private JTextField textField;
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	
	public Server() {
		super("SERVER");
		addComponents();
		try {
			
			serverSocket = new ServerSocket(9000);
			clientSocket = serverSocket.accept();
			while(true) {
				//System.out.println("Client connected:"+clientSocket.getInetAddress().getHostName());
				oos = new ObjectOutputStream(clientSocket.getOutputStream());
				oos.flush();
				ois = new ObjectInputStream(clientSocket.getInputStream());
				
				System.out.println("client msg:"+(String)ois.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				ois.close();
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addComponents() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		textField = new JTextField();
		add(textField,BorderLayout.NORTH);
		add(new JScrollPane(textArea),BorderLayout.CENTER);
		setVisible(true);
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
	}
	
	public static void main(String args[]) {
		Server server = new Server();
	}
}
