package es.deusto.ingenieria.sd.strava.server.gateway;

import java.rmi.Naming;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.google.remote.ILoginGoogle;

public class GoogleServiceGateway extends Gateway {

	private static GoogleServiceGateway instance;
	
	private ILoginGoogle loginGoogleService;
	
	private GoogleServiceGateway() {
		try {
			String URL = "//127.0.0.1:1099/GoolgeServer";
			this.loginGoogleService= (ILoginGoogle) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}
	}
	public static GoogleServiceGateway getInstance() {
		
		if(instance == null) {
			instance = new GoogleServiceGateway();
		}
		
		return instance;
	}
	@Override
	public boolean iniciarSesion(String email, String contrasenya) {
		// TODO Auto-generated method stub
		try {
			return this.loginGoogleService.iniciarSesion(email, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("   $ Error logging with google " + e.getMessage());
			return false;
		}
	}	

	
}
