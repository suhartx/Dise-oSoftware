package es.deusto.ingenieria.sd.auctions.strava.data.domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Article_CambiarAentrenamiento {
	private int idEntrenamiento;
	private String titulo;
	private double distancia;
	private enum tipodeporte{
		correr, monte, bici
	};
	private Date fechaInicio;
	private String horaInicio;
	private double duracion;
	List<Usuario> usuarios= new ArrayList<>();
	/*
	 * la logica aqui dicta que esto no puede ser asi, la relacion de cardinalidad 
	 * entre usuario y reto tiene que ser de 1 a n por tanto este arraylist hay que quitarlo
	 * y cambiar en diagrama de clases
	 */
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "Article_CambiarAentrenamiento [idEntrenamiento=" + idEntrenamiento + ", titulo=" + titulo
				+ ", distancia=" + distancia + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio
				+ ", duracion=" + duracion + ", usuarios=" + usuarios + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEntrenamiento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article_CambiarAentrenamiento other = (Article_CambiarAentrenamiento) obj;
		return idEntrenamiento == other.idEntrenamiento;
	}
	
}