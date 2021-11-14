package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idEstado;
	private int estado;
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "EstadoDTO [idEstado=" + idEstado + ", estado=" + estado + "]";
	}
	
}
