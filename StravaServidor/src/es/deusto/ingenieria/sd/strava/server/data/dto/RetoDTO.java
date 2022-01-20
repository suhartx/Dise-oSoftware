package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;

//This class implements DTO pattern
public class RetoDTO implements Serializable {
	// This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;
	private long idReto;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private double distancia;
	private String tipoDeporte;// ENUM!

	private String emailPropietario;
	private int porcentaje;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdReto() {
		return idReto;
	}

	public void setIdReto(long idReto) {
		this.idReto = idReto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechainicio) {
		this.fechaInicio = fechainicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getEmailPropietario() {
		return emailPropietario;
	}

	public void setEmailPropietario(String emailPropietario) {
		this.emailPropietario = emailPropietario;
	}

	@Override
	public String toString() {
		return "RetoDTO [idReto=" + idReto + ", nombre=" + nombre + ", fechainicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", distancia=" + distancia + ", tipoDeporte=" + tipoDeporte + "]";
	}

}