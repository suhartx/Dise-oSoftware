package es.deusto.ingenieria.sd.strava.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookServiceGateway extends Gateway {

	private static FacebookServiceGateway instance;
	public static FacebookServiceGateway getInstance() {

		if (instance == null) {
			instance = new FacebookServiceGateway("127.0.0.1", 35600);
		}

		return instance;
	}
	String serverIP;// = args[0];
	// args[1] = Server socket port
	int serverPort;// = Integer.parseInt(args[1]);

	// argrs[2] = Message
	String message;// = args[2];

	/**
	 * NOTE: try-with resources Statement -
	 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
	 * Try statement that declares one or more resources. A resource is an object
	 * that must be closed after the program is finished with it. The
	 * try-with-resources statement ensures that each resource is closed at the end
	 * of the statement. Any object that implements java.lang.AutoCloseable, which
	 * includes all objects which implement java.io.Closeable, can be used as a
	 * resource.
	 */
	private FacebookServiceGateway(String servIP, int servPort) {
		serverIP = servIP;
		serverPort = servPort;
	}

	@Override
	public boolean iniciarSesion(String email, String contrasenya) {

		// Declaration of the socket to send/receive information to/from the server (an
		// IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				// Streams to send and receive information are created from the Socket
				DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())) {

			// Send request (a Srting) to the server
			message = email + "/" + contrasenya;
			out.writeUTF(message);
			System.out.println("- EchoClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":"
					+ tcpSocket.getPort() + "' -> '" + message + "'");

			// Read response (a String) from the server
//			String data = in.readUTF();
//			System.out.println("- EchoClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			return in.readBoolean();
		} catch (Exception e) {
			System.out.println("# EchoClient: Error: " + e.getMessage());
		}
		return false;
	}
}
