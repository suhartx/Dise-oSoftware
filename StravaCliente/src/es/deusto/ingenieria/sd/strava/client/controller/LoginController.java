package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

//This class implements Controller pattern.
public class LoginController {

	// Reference to the Service Locator
	private ServiceLocator serviceLocator;
	// This attibute stores the token when login success
	private long token = -1; // -1 = login has not been done or fails

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public boolean login(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().login(email, password);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}

	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}

	public long getToken() {
		return token;
	}

	public void registro(String email, String nombre, Date fecha, String contrasenya) {

		try {
			this.serviceLocator.getService().registrarUsuario(email, nombre, fecha, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}