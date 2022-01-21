package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable

public class Usuario {

	private String email;
	private String nombre;
	private Date fechaNacimiento;

	@Join
	@Persistent(mappedBy = "usuario", dependentElement = "true", defaultFetchGroup = "true")
	private List<Entrenamiento> entrenamientos = new ArrayList<>();

	// @Join
	// @Persistent(mappedBy="usuario", defaultFetchGroup="true")//
	// dependentElement="true", defaultFetchGroup="true")
	@Persistent(table = "RETOS_USUARIOS", defaultFetchGroup = "true")
	@Join(column = "idReto")
	@Element(column = "email")
	private List<RetoConEstado> retos = new ArrayList<>();

	public Usuario() {

		// idUsuario = ++count;
		// Esto genera automaticamente el id de usuario
		// cada vez que se inizializa uno nuevo

	}

	public Usuario(String nombre, String email, Date fechaNacimiento) {

		// idUsuario = ++count;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public void anyadirEntrenamiento(Entrenamiento e) {
		this.entrenamientos.add(e);
	}

	public void anyadirReto(Reto r) {

		this.retos.add(new RetoConEstado(r));
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario) obj).email);
		}

		return false;
	}

	public String getEmail() {
		return email;
	}

//	public int getIdUsuario() {
//		return idUsuario;
//	}

//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public List<RetoConEstado> getRetos() {
		return retos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRetos(List<RetoConEstado> retos) {
		this.retos = retos;
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
}