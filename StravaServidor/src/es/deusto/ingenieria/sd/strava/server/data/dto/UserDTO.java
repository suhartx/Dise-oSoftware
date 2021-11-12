package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;

//This class implements DTO pattern
public class UserDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;	
	private String nombre;
	private String email;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nickname) {
		this.nombre = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}