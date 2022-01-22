package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dao.EntrenamientoDAO;

public class EntrenamientoAppService {

	private List<Entrenamiento> entrenamientos = new ArrayList<>();

	public EntrenamientoAppService() {
		this.initializeData();// TODO Auto-generated constructor stub
	}

	public void crearEntrenamiento(Usuario usuario, String nombre, Date fechaInicio, String horaInicio,
			double distancia, String tipoDeporte) {

		Entrenamiento e = new Entrenamiento();
		e.setTitulo(nombre);
		e.setDistancia(distancia);
		e.setFechaInicio(fechaInicio);
		e.setHoraInicio(horaInicio);
		e.setTipoDeporte(tipoDeporte);
		// r.setEstado(estado);
		// usuario.anyadirReto(r);
		entrenamientos.add(e);
		usuario.anyadirEntrenamiento(e);
		EntrenamientoDAO.getInstance().save(e);
	}

	public List<Entrenamiento> getEntrenamientos() {
		// TODO: Get all the categories using DAO Pattern
		return entrenamientos;
	}

	private void initializeData() {// CLASES DE TEST QUITARLOS



		entrenamientos =  EntrenamientoDAO.getInstance().getAll();

		//EntrenamientoDAO.getInstance().save(e);

	}

}
