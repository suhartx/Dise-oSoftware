package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.strava.data.domain.Reto;

public class EntrenamientoDAO extends DataAccessObjectBase implements IDataAccessObject<Entrenamiento> {

	private static EntrenamientoDAO instance;

	public static EntrenamientoDAO getInstance() {
		if (instance == null) {
			instance = new EntrenamientoDAO();
		}

		return instance;
	}

	private EntrenamientoDAO() {
	}

	@Override
	public void delete(Entrenamiento object) {
		// TODO Auto-generated method stub
		super.deleteObject(object);
	}

	@Override
	public Entrenamiento find(String param) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Entrenamiento result = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Reto.class.getName() + " WHERE idEntrenamiento == " + param);
			query.setUnique(true);
			result = (Entrenamiento) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Article: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

	@Override
	public List<Entrenamiento> getAll() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Entrenamiento> entrenamientos = new ArrayList<>();

		try {
			tx.begin();

			Extent<Entrenamiento> extent = pm.getExtent(Entrenamiento.class, true);

			for (Entrenamiento category : extent) {
				entrenamientos.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Challenges: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return entrenamientos;
	}

	@Override
	public void save(Entrenamiento object) {
		// TODO Auto-generated method stub
		super.saveObject(object);
	}

}
