package es.deusto.ingenieria.sd.strava.server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.strava.data.domain.Estado;
import es.deusto.ingenieria.sd.auctions.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.strava.data.domain.Usuario;


public class RetoAppService {

	private List<Reto> retos =  new ArrayList<>();
	public RetoAppService() {
		
		this.initializeData();
		
		
		
	}


	private void initializeData() {
		
		//Creamos un usuario
		
		Usuario user0 = new Usuario();
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
		
		//creamos un reto
		
		Reto reto0 = new Reto();
		reto0.setNombre("reto1");
		reto0.setFechaInicio(new Date(System.currentTimeMillis()));
		//reto0.setFechaInicio(new Date(System.currentTimeMillis()+20000));
		reto0.setDistancia(10000);
		reto0.setTipoDeporte("correr");
		
		/*
		 * Aqui a�adimos una copia del reto sin estado 
		 * porque la lista de retos general tendra 
		 * siempre estado 0, 0
		 */
		retos.add(new Reto(reto0));
		
		/*
		 * a�adimos el estado al reto que queremos a�adir al usuario
		 */
		reto0.setEstado(new Estado(1, 2));
		
		user0.anyadirReto(reto0);
		
	}
	public List<Reto> getRetos() {
		//TODO: Get all the categories using DAO Pattern		
		return this.retos;
	}
//	public List<Entrenamiento> getRetosCategoria(String categoria) {
//		//TODO: Get articles of a category using DAO Pattern
//		for (Reto cat : this.retos) {
//			if (cat.getTipoDeporte().equalsIgnoreCase(categoria)) {
//				return cat;
//			}
//		}
//	}


		public void crearReto(Usuario usuario ,String nombre, Date fechaInicio,
	Date fechaFin, double distancia, String tipoDeporte, Estado estado ) {
	
		Reto r = new Reto();
		r.setNombre(nombre);
		r.setDistancia(distancia);
		r.setFechaInicio(fechaInicio);
		r.setFechaFin(fechaFin);
		r.setTipoDeporte(tipoDeporte);
		//r.setEstado(estado);
		//usuario.anyadirReto(r);
		retos.add(r);
		
	}

		/**
		 * metodo que devuelve los retos activos de un usuario
		 * @param u Usuario en cuestion
		 * @return
		 */
	public List<Reto> obtenerRetosActivos(Usuario u){
		
		List <Reto> retosA = new ArrayList<>();
		
		for (Reto reto : u.getRetos()) {
			if (reto.getEstado().getEstado()<5) {
				retosA.add(reto);
			}
		}
		
		return retosA;
		
	}
	/**
	 * metodo que a�ade un reto al usuario
	 * @param u
	 * @param r
	 */
	public void aceptarReto(Usuario u, Reto r) {
		
		u.anyadirReto(new Reto(r));
		
		
	}
	
	
}