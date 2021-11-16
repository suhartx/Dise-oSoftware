package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
	private static int count = 0;
	private final int idUsuario;
	private String nombre;
	private String email;
	private Date fechaNacimiento;
	private String contrasenya;
	/*
	 * faltan las clases relacionadas
	 */
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	private List<Reto> retos = new ArrayList<>();

	public Usuario() {

		idUsuario = ++count;
		// Esto genera automaticamente el id de usuario
		// cada vez que se inizializa uno nuevo

	}

	public Usuario(String nombre, String email, Date fechaNacimiento, String contrasenya) {

		idUsuario = ++count;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasenya = contrasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean checkContrasenya(String contrasenya) {
		return this.contrasenya.equals(contrasenya);
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public void anyadirEntrenamiento(Entrenamiento e) {
		this.entrenamientos.add(e);
	}

	public List<Reto> getRetos() {
		return retos;
	}

	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}

	public void anyadirReto(Reto r) {
		this.retos.add(r);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();

		result.append(this.nombre);
		result.append(" - ");
		result.append(this.email);
		result.append(" - (");
//		result.append(this.articles.size());
//		result.append(" articles) - (");
//		result.append(this.bids.size());
//		result.append(" bids)");

		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario) obj).email);
		}

		return false;
	}
}