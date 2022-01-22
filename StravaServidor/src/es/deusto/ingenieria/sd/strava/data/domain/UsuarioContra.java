package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class UsuarioContra extends Usuario {

	private String contrasenya;

	public UsuarioContra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioContra(String nombre, String email, Date fechaNacimiento, String contrasenya) {
		super(nombre, email, fechaNacimiento);

		this.contrasenya = contrasenya;
		// TODO Auto-generated constructor stub
	}

	public boolean checkContrasenya(String contrasenya) {
		return this.contrasenya.equals(contrasenya);
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
}
