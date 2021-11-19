package es.deusto.ingenieria.sd.strava.data.domain;

public class RetoConEstado extends Reto{

	int porcentaje;
	
	public RetoConEstado() {
		super();
		this.porcentaje=0;
	}

	public RetoConEstado(Reto r) {
		super(r);
		this.porcentaje=0;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

}
