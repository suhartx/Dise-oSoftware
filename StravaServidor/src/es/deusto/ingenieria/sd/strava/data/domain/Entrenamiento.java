package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.Date;
import java.util.Objects;

public class Entrenamiento {
	private static int count = 0;
	private int idEntrenamiento;
	private String titulo;
	private double distancia;
	private String tipoDeporte;
	private Date fechaInicio;
	private String horaInicio;
	private double duracion;
	// List<Usuario> usuarios= new ArrayList<>();
	/*
	 * la logica aqui dicta que esto no puede ser asi, la relacion de cardinalidad
	 * entre usuario y reto tiene que ser de 1 a n por tanto este arraylist hay que
	 * quitarlo y cambiar en diagrama de clases
	 */

	public Entrenamiento() {
		idEntrenamiento = ++count;
	}

	public int getIdEntrenamiento() {
		return idEntrenamiento;
	}
//	public void setIdEntrenamiento(int idEntrenamiento) {
//		this.idEntrenamiento = idEntrenamiento;
//
//	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public double getDuracion() {
		return duracion;
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

	@Override
	public String toString() {
		return "Entrenamiento [idEntrenamiento=" + idEntrenamiento + ", titulo=" + titulo + ", distancia=" + distancia
				+ ", tipoDeporte=" + tipoDeporte + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio
				+ ", duracion=" + duracion + ""
				// + ", usuarios=" + usuarios
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEntrenamiento);
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

}