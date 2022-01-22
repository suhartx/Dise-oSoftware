package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.data.domain.RetoConEstado;
import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dao.RetoDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioDAO;

public class RetoAppService {

	private List<Reto> retos = new ArrayList<>();

	public RetoAppService() {

		this.initializeData();

	}

	/**
	 * metodo que añade un reto al usuario
	 *
	 * @param u
	 * @param r
	 */
	public void aceptarReto(Usuario u, Reto r) {

		u.anyadirReto(new Reto(r));
		UsuarioDAO.getInstance().save(u);

	}

	public RetoConEstado consultarReto(Usuario u, Reto r) {
		for (RetoConEstado reto : u.getRetos()) {
			if (reto.getIdReto() == r.getIdReto()) {
				return reto;
			}

		}
		System.out.println("Ese entrenamiento no existe");
		return null;

	}

	public void crearReto(Usuario usuario, Reto r) {

		retos.add(r);
		RetoDAO.getInstance().save(r);
		// usuario.anyadirReto(r);

	}

	public List<Reto> getRetos() {
		// TODO: Get all the categories using DAO Pattern
		//RetoDAO.getInstance().getAll();
		return this.getRetos();

	}
//	public List<Entrenamiento> getRetosCategoria(String categoria) {
//		//TODO: Get articles of a category using DAO Pattern
//		for (Reto cat : this.retos) {
//			if (cat.getTipoDeporte().equalsIgnoreCase(categoria)) {
//				return cat;
//			}
//		}
//	}

	private void initializeData() {




		retos = RetoDAO.getInstance().getAll();
	}

	/**
	 * metodo que devuelve los retos activos de un usuario
	 *
	 * @param u Usuario en cuestion
	 * @return
	 */
	public List<RetoConEstado> obtenerRetosActivos(Usuario u) {

		return u.getRetos();

	}

}
