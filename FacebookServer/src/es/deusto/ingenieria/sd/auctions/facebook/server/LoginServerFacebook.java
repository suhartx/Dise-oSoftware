package es.deusto.ingenieria.sd.auctions.facebook.server;

import java.io.IOException;
import java.net.ServerSocket;

import es.deusto.ingenieria.sd.auctions.facebook.remote.LoginServiceFacebook;

public class LoginServerFacebook {

	private static int numClients = 0;

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println(" # Usage: TranslationServer [PORT]");
			System.out.print(args[0]);
			System.exit(1);
		}

		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[0]);

		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - TranslationServer: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");

			while (true) {
				new LoginServiceFacebook(tcpServerSocket.accept());
				System.out.println(" - FacebookServer: New client connection accepted. Client number: " + ++numClients);
			}
		} catch (IOException e) {
			System.out.println("# FacebookServer: IO error:" + e.getMessage());
		}

	}
}