package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
public class EntrenamientoController {

	private ServiceLocator serviceLocator;

	public EntrenamientoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public void crearEntrenamiento(Long valor, String titulo, String tipoDeporte, double distancia, Date fechaInicio,
			String horaInicio, double duracion) {


	try {
		this.serviceLocator.getService().crearEntrenamiento(valor, titulo, tipoDeporte, distancia, fechaInicio,  horaInicio, duracion);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	public List<EntrenamientoDTO> getEntrenamientos(String aEntrenamiento) {
		//TODO: Get all the categories using DAO Pattern
		try {
			return this.serviceLocator.getService().getEntrenamientos(aEntrenamiento);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
