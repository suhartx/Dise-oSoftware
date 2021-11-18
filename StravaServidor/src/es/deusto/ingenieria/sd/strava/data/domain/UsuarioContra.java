package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.Date;

public class UsuarioContra extends Usuario {
	
	private String contrasenya;

	public UsuarioContra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioContra(String nombre, String email, Date fechaNacimiento, String contrasenya) {
		super(nombre, email, fechaNacimiento);
		
		
		// TODO Auto-generated constructor stub
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public boolean checkContrasenya(String contrasenya) {
		return this.contrasenya.equals(contrasenya);
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
}
