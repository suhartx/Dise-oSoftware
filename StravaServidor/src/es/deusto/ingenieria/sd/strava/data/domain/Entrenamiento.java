package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.Date;
import java.util.Objects;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Entrenamiento {
	private static int count = 0;
	@PrimaryKey
	private int idEntrenamiento;
	private String titulo;
	private double distancia;
	private String tipoDeporte;
	private Date fechaInicio;
	private String horaInicio;
	private double duracion;

	@Persistent(defaultFetchGroup = "true")
	private Usuario usuario;

	// List<Usuario> usuarios= new ArrayList<>();
	/*
	 * la logica aqui dicta que esto no puede ser asi, la relacion de cardinalidad
	 * entre usuario y reto tiene que ser de 1 a n por tanto este arraylist hay que
	 * quitarlo y cambiar en diagrama de clases
	 */

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Entrenamiento() {
		idEntrenamiento = ++count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Entrenamiento other = (Entrenamiento) obj;
		return idEntrenamiento == other.idEntrenamiento;
	}

	public double getDistancia() {
		return distancia;
	}

	public double getDuracion() {
		return duracion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public int getIdEntrenamiento() {
		return idEntrenamiento;
	}
//	public void setIdEntrenamiento(int idEntrenamiento) {
//		this.idEntrenamiento = idEntrenamiento;
//
//	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEntrenamiento);
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Entrenamiento [idEntrenamiento=" + idEntrenamiento + ", titulo=" + titulo + ", distancia=" + distancia
				+ ", tipoDeporte=" + tipoDeporte + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio
				+ ", duracion=" + duracion + ""
				// + ", usuarios=" + usuarios
				+ "]";
	}

}