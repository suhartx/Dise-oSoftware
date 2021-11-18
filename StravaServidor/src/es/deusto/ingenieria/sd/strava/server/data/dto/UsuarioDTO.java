package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;

//This class implements DTO pattern
public class UsuarioDTO implements Serializable {
	// This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;

//	private int idUsuario;
	private String nombre;
	private String email;
	private Date fechaNacimiento;
	//private String contrasenya;

//	public int getIdUsuario() {
//		return idUsuario;
//	}

//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nombre=" + nombre + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

//	public String getContrasenya() {
//		return contrasenya;
//	}
//
//	public void setContrasenya(String contrasenya) {
//		this.contrasenya = contrasenya;
//	}

	

}