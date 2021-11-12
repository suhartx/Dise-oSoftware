package es.deusto.ingenieria.sd.auctions.strava.data.domain;
//HAY QUE CAMBIAR ESTO
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reto {	
	private int idReto;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private double distancia;
	private String tipoDeporte;
	private Estado estado;
	public int getIdReto() {
		return idReto;
	}
	public void setIdReto(int idReto) {
		this.idReto = idReto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Reto [idReto=" + idReto + ", nombre=" + nombre + ", fechainicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", distancia=" + distancia + ", tipoDeporte=" + tipoDeporte + ", estado=" + estado + "]";
	}

}