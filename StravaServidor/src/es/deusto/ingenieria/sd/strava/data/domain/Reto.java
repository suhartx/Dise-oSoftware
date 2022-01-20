package es.deusto.ingenieria.sd.strava.data.domain;

import java.util.Date;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable

public class Reto {
	private static int count = 0;
	@PrimaryKey
	private long idReto;// FUERA, NO ES NECESARIO
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private double distancia;
	private String tipoDeporte;
	@Join
	@Persistent(defaultFetchGroup = "true")
	private Usuario Duenyo;

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
	}

	public long getIdReto() {
		return this.idReto;
	}

	public void setIdReto(long idReto) {
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


	public Usuario getDuenyo() {
		return Duenyo;
	}

	public void setDuenyo(Usuario duenyo) {
		Duenyo = duenyo;
	}

}