package es.deusto.ingenieria.sd.strava.google.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.google.remote.ILoginGoogle;
import es.deusto.ingenieria.sd.strava.google.remote.LoginServiceGoogle;

public class LoginServerGoogle {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			ILoginGoogle remoteObject = LoginServiceGoogle.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * Servidor de google '" + name + "' iniciado!!");
		} catch (Exception ex) {
			System.out.println(" # Servidor de google: " + ex.getMessage());
			ex.printStackTrace();
		}
//
	}
}