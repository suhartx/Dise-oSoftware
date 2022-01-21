package es.deusto.ingenieria.sd.strava.server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;
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
		return EntrenamientoDAO.getInstance().getAll();
	}

	private void initializeData() {// CLASES DE TEST QUITARLOS
		UsuarioContra user0 = new UsuarioContra();
		user0.setNombre("tomas");
		user0.setContrasenya("cositas");
		user0.setEmail("tomas@gmail.com");
		String str = "10 23 1997";
		SimpleDateFormat df = new SimpleDateFormat("MM dd yyyy");
		long tiempo = 0;
		try {
			tiempo = df.parse(str).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user0.setFechaNacimiento(new Date(tiempo));

		Entrenamiento entr0 = new Entrenamiento();
		entr0.setTitulo("entrenamiento 0");
		entr0.setTipoDeporte("senderismo");
		entr0.setDuracion(2000);
		entr0.setDistancia(30000);
		entr0.setFechaInicio(new Date(System.currentTimeMillis()));
		entr0.setHoraInicio("20:00");

		entrenamientos.add(entr0);

		user0.anyadirEntrenamiento(entr0);

		//EntrenamientoDAO.getInstance().save(e);

	}

}
