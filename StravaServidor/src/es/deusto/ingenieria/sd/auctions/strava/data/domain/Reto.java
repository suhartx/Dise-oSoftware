package es.deusto.ingenieria.sd.auctions.strava.data.domain;
//HAY QUE CAMBIAR ESTO
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reto {	
	private int idReto;
	private String nombre;
	private Date fechainicio;
	private Date fechaFin;
	private double distancia;
	private enum deporte{
		correr, bicicleta, senderismo
	};
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
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Category_CambiarAReto [idReto=" + idReto + ", nombre=" + nombre + ", fechainicio=" + fechainicio
				+ ", fechaFin=" + fechaFin + ", distancia=" + distancia + ", estado=" + estado + "]";
	}
}