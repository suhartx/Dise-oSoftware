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
			double distancia, String tipoDeporte, double duracion) {

		System.out.println("1");
		
		Entrenamiento e = new Entrenamiento(nombre, distancia, tipoDeporte, fechaInicio, horaInicio, duracion, usuario);
		System.out.println("2");
		
		System.out.println(e.toString());
		
		System.out.println("3");
		// r.setEstado(estado);
		// usuario.anyadirReto(r);
		entrenamientos.add(e);
		System.out.println("4");
		usuario.toString();
		
		usuario.anyadirEntrenamiento(e);
		System.out.println("5");
		EntrenamientoDAO.getInstance().save(e);
		System.out.println("6");
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
