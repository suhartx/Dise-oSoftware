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
	//: El usuario solicitará al servidor que haga una búsqueda de entre sus retos y 
	//que le devuelva un reto específico. El método hace que el servidor devuelva el reto que el usuario haya requerido.
	
	/**
	 * El usuario después de haber seleccionado un reto decide apuntarse a este. El servidor por lo tanto,
	 * recibe el reto elegido. El método consiste en la recepción del reto escogido por el usuario.
	 */
	public void aceptarReto(Long u,Reto reto) throws RemoteException;
	
	/**
	 * 	El usuario tendrá la posibilidad de ver el estado de sus retos. Seleccionará un reto y 
	 * podrá ver el estado del reto seleccionado. El servidor recibirá el 
	 * reto introducido y devolverá su estado. 
	 */
	public Estado consultarReto(Long u,Reto reto) throws RemoteException;
	
}
