package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;

//This class implements Controller pattern.
public class LoginController {

	// Reference to the Service Locator
	private ServiceLocator serviceLocator;
	// This attibute stores the token when login success
	private long token = -1; // -1 = login has not been done or fails

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public boolean login(Tipologin t, String email, String password) {

		try {
			this.token = this.serviceLocator.getService().login(t, email, password);
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

	public long registro(String email, String nombre, Date fecha, String contrasenya) {
		Long l= null;
		try {
			l = this.serviceLocator.getService().registrarUsuario(email, nombre, fecha, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//token =l;
		return l;
	}

	public void setToken(long token) {
		this.token = token;
	}
}