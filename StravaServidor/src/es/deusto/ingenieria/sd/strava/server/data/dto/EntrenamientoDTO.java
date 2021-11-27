package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;

//This class implements DTO pattern
public class EntrenamientoDTO implements Serializable {
	// This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;

	private int idEntrenamiento;
	private String titulo;
	private double distancia;
	private String tipoDeporte;//ENUM!
	private Date fechaInicio;
	private String horaInicio;
	private double duracion;

	public int getIdEntrenamiento() {
		return idEntrenamiento;
	}

	public void setIdEntrenamiento(int idEntrenamiento) {
		this.idEntrenamiento = idEntrenamiento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDistancia() {
		return distancia;
	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
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

	@Override
	public String toString() {
		return "EntrenamientoDTO [idEntrenamiento=" + idEntrenamiento + ", titulo=" + titulo + ", distancia="
				+ distancia + ", tipoDeporte=" + tipoDeporte + ", fechaInicio=" + fechaInicio + ", horaInicio="
				+ horaInicio + ", duracion=" + duracion + "]";
	}

}