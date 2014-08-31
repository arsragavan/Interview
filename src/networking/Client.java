package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	private Socket clientSocket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public Client() {
		try {
			clientSocket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
			while(true) {
				oos = new ObjectOutputStream(clientSocket.getOutputStream());
				oos.flush();
				ois = new ObjectInputStream(clientSocket.getInputStream());
				System.out.println("server msg:"+(String)ois.readObject());
			}			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				ois.close();
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Client client = new Client();

	}

}
