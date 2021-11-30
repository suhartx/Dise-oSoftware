package es.deusto.ingenieria.sd.auctions.facebook.remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.HashMap;

public class LoginServiceFacebook extends Thread{
	//private static final long serialVersionUID = 1L;

	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;


	public HashMap<String, String> usuarios= new HashMap<>();



	//Attribute for the Singleton pattern
	public static LoginServiceFacebook instance;

	public LoginServiceFacebook(Socket socket){
		super();
		usuarios.put("Roberto", "rober");
		usuarios.put("suhar","txabar");
		usuarios.put("yanis", "pizarro");
		usuarios.put("jokin", "egia");

		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (Exception e) {
			System.err.println("# FacebookService - TCPConnection IO error:" + e.getMessage());
		}


	}

//	public static LoginServiceFacebook getInstance() {
//		if (instance == null) {
//			try {
//				instance = new LoginServiceFacebook(this.);
//			} catch(Exception ex) {
//				System.err.println("  # Error initializing service(): " + ex.getMessage());
//			}
//		}
//
//		return instance;
//	}

	@Override
	public void run() {
		try {

			String data[] = this.in.readUTF().split("/");
			boolean cierto;
			System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data[0]+data[1] + "'");
			cierto = this.iniciarSesion(data[0], data[1]);
			this.out.writeBoolean(cierto);
			System.out.println("   - FacebookService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data[0].toUpperCase() + "'");
		} catch (Exception e) {
			System.out.println("   # FacebookService - TCPConnection error" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (Exception e) {
				System.out.println("   # TranslationService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}

	public boolean iniciarSesion(String email, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		

		if (usuarios.containsKey(email)&&usuarios.get(email).equals(contrasenya)) {

			return true;
		}

	return false;
	}
}