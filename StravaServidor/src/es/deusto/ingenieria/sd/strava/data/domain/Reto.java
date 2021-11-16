package es.deusto.ingenieria.sd.strava.data.domain;
import java.util.Date;

public class Reto {	
	private static int count=0;
	private int idReto;//FUERA, NO ES NECESARIO
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private double distancia;
	private String tipoDeporte;
	private Estado estado;
	public int getIdReto() {
		return idReto;
	}
	public Reto() {
		idReto = ++count;
	}
	
public Reto(Reto r) {
		super();
		this.idReto = r.idReto;
		this.nombre = r.nombre;
		this.fechaInicio = r.fechaInicio;
		this.fechaFin = r.fechaFin;
		this.distancia = r.distancia;
		this.tipoDeporte = r.tipoDeporte;
		this.estado= new Estado();
	}
	//	public void setIdReto(int idReto) {
//		this.idReto = idReto;
//	}
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