package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.data.domain.Estado;
import es.deusto.ingenieria.sd.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

public class RetoController {

	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public List<RetoDTO> getRetos() {
		
		return this.serviceLocator.getService().getRetos();
	}
	
	public long crearReto(Long u, String nombre, Date fechaInicio, Date fechaFin, double distancia, String tipoDeporte) {
		
		this.serviceLocator.getService().crearReto(null, nombre, fechaInicio, fechaFin, distancia, tipoDeporte)
		
		return u;
	
		
		
	}

	//public Reto obtenerReto() throws RemoteException;
	//: El usuario solicitar� al servidor que haga una b�squeda de entre sus retos y 
	//que le devuelva un reto espec�fico. El m�todo hace que el servidor devuelva el reto que el usuario haya requerido.
	
	/**
	 * El usuario despu�s de haber seleccionado un reto decide apuntarse a este. El servidor por lo tanto,
	 * recibe el reto elegido. El m�todo consiste en la recepci�n del reto escogido por el usuario.
	 */
	public void aceptarReto(Long u,Reto reto) throws RemoteException;
	
	/**
	 * 	El usuario tendr� la posibilidad de ver el estado de sus retos. Seleccionar� un reto y 
	 * podr� ver el estado del reto seleccionado. El servidor recibir� el 
	 * reto introducido y devolver� su estado. 
	 */
	public Estado consultarReto(Long u,Reto reto) throws RemoteException;
	
}
