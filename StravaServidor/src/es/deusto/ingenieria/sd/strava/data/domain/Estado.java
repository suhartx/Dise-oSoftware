package es.deusto.ingenieria.sd.strava.data.domain;

public class Estado {
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

	public Estado(int idEstado, int estado) {

		this.idEstado = idEstado;
		this.estado = estado;
	}

	public Estado() {
		super();
		this.idEstado = 0;
		this.estado = 0;
	}

}