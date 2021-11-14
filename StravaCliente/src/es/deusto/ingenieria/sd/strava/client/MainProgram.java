package es.deusto.ingenieria.sd.strava.client;

import java.util.List;
import java.util.Date;

import es.deusto.ingenieria.sd.strava.client.controller.EntrenamientoController;
import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.RetoController;
import es.deusto.ingenieria.sd.strava.client.gui.LoginDialog;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

public class MainProgram {

	public static void main(String[] args) {
		ServiceLocator serviceLocator = new ServiceLocator();

		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);

		LoginController loginController = new LoginController(serviceLocator);
		LoginDialog loginDialog = new LoginDialog(loginController);
		EntrenamientoController entrenamientoController =  new EntrenamientoController(serviceLocator);
		RetoController retoController= new RetoController(serviceLocator);

		//Login
		loginDialog.login();
		//Obtaining entrenamientos
		List<EntrenamientoDTO> entrenamientos = entrenamientoController.getEntrenamientos("Ciclismo");//What to enter??
		//Obtaining retos
		List<RetoDTO> retos = retoController.getRetos();
		//Crear retos
		retoController.crearReto(1L, "Reto 1", new Date(2021,11,14), new Date(2021,11,16), 15.5, "ciclismo");
		retoController.crearReto(2L, "Reto 2", new Date(2021,11,15), new Date(2021,11,19), 15.5, "running");
		//Crear entrenamientos
		entrenamientoController.crearEntrenamiento(1L, "Entrenamiento 1", "running", 7.21, new Date(2020,05,12), "15:30", 2.5);
		//Consultar reto
		retoController.consultarReto(1L, 1L);
		//Aceptar reto
		retoController.aceptarReto(1L, 2L);

		//Logout
		loginDialog.logout();
	}
}