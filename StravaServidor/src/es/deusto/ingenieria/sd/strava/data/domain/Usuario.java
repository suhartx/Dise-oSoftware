package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario {

	private String email;
	private String nombre;
	private Date fechaNacimiento;

	@Join
	@Persistent(mappedBy="user", dependentElement="true", defaultFetchGroup="true")
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	
	@Join
	@Persistent(mappedBy="owner", dependentElement="true", defaultFetchGroup="true")
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public int getIdUsuario() {
//		return idUsuario;
//	}

//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public List<RetoConEstado> getRetos() {
		return retos;
	}

	public void setRetos(List<RetoConEstado> retos) {
		this.retos = retos;
	}

	public void anyadirReto(Reto r) {

		this.retos.add(new RetoConEstado(r));
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