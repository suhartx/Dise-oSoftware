package es.deusto.ingenieria.sd.strava.client;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.SwingUtilities;

import es.deusto.ingenieria.sd.strava.client.controller.EntrenamientoController;
import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.RetoController;
import es.deusto.ingenieria.sd.strava.client.gui.InitializationWindow;
import es.deusto.ingenieria.sd.strava.client.gui.LoginDialog;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;



public class MainProgram {
	private static ServiceLocator serviceLocator;
	private static MainProgram instance;
	private LoginController loginController = new LoginController(serviceLocator);
	private LoginDialog loginDialog = new LoginDialog(loginController);
	private EntrenamientoController entrenamientoController = new EntrenamientoController(serviceLocator);
	private RetoController retoController = new RetoController(serviceLocator);
	
	
	public static void main(String[] args) {
		serviceLocator = new ServiceLocator();

		// args[0] = RMIRegistry IP
		// args[1] = RMIRegistry Port
		// args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				InitializationWindow iw = new InitializationWindow();
				iw.NewScreen();
				
			}
		});


		// Login
		//loginDialog.login();
		// Obtaining entrenamientos
//		List<EntrenamientoDTO> entrenamientos = entrenamientoController.getEntrenamientos("Ciclismo");// What to enter??
//		// Obtaining retos
//		List<RetoDTO> retos = retoController.getRetos();
//		// Crear retos
//
//		String str = "14 11 2021";
//		String str2 = "16 11 2021";
//		String str3 = "15 11 2021";
//		String str4 = "19 11 2021";
//		SimpleDateFormat df = new SimpleDateFormat("MM dd yyyy");
//		long tiempo = 0;
//		long tiempo2 = 0;
//		long tiempo3 = 0;
//		long tiempo4 = 0;
//		try {
//			tiempo = df.parse(str).getTime();
//			tiempo2 = df.parse(str).getTime();
//			tiempo3 = df.parse(str).getTime();
//			tiempo4 = df.parse(str).getTime();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		retoController.crearReto(loginController.getToken(), "Reto 1", new Date(tiempo), new Date(tiempo2), 15.5,
//				"ciclismo");
//		retoController.crearReto(loginController.getToken(), "Reto 2", new Date(tiempo3), new Date(tiempo4), 15.5,
//				"running");
//		// Crear entrenamientos
//		entrenamientoController.crearEntrenamiento(loginController.getToken(), "Entrenamiento 1", "running", 7.21,
//				new Date(tiempo), "15:30", 2.5);
//		
//		// Aceptar reto
//		retoController.aceptarReto(loginController.getToken(),  retoController.getRetos().get(0).getIdReto());
//
//		
//		// Consultar reto
//		retoController.consultarReto(loginController.getToken(),  retoController.getRetos().get(0).getIdReto());
//
//
//		// Logout
//		loginDialog.logout();
	}
	public static MainProgram getInstance() {
		
		if(instance == null) {
			instance = new MainProgram();
		}
		
		return instance;
	}
	public LoginController getLoginController() {
		return loginController;
	}
	public LoginDialog getLoginDialog() {
		return loginDialog;
	}
	public EntrenamientoController getEntrenamientoController() {
		return entrenamientoController;
	}
	public RetoController getRetoController() {
		return retoController;
	}


}