package es.deusto.ingenieria.sd.strava.client.controller;

import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.dto.*;
public class EntrenamientoController {
	
	private ServiceLocator serviceLocator;
	
	public EntrenamientoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public void crearentrEnamiento(Usuario usuario ,String nombre, Date fechaInicio,
			String horaInicio, double distancia, String tipoDeporte) {


	this.serviceLocator.getService().crearEntrenamiento(null, nombre, fechaInicio, horaInicio, distancia,  tipoDeporte);
	
}
	public List<EntrenamientoDTO> getEntrenamientos(String aEntrenamiento) {
		//TODO: Get all the categories using DAO Pattern		
		return this.serviceLocator.getService().getEntrenamientos(aEntrenamiento);
	}
	
}
