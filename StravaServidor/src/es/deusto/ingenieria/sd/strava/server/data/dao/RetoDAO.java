package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.data.domain.Reto;

public class RetoDAO extends DataAccessObjectBase implements IDataAccessObject<Reto> {

	private static RetoDAO instance;

	private RetoDAO() {
	}

	public static RetoDAO getInstance() {
		if (instance == null) {
			instance = new RetoDAO();
		}

		return instance;
	}

	@Override
	public void save(Reto object) {
		// TODO Auto-generated method stub
		super.saveObject(object);
	}

	@Override
	public void delete(Reto object) {
		// TODO Auto-generated method stub
		super.deleteObject(object);
	}

	@Override
	public List<Reto> getAll() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Reto> retos = new ArrayList<>();

		try {
			tx.begin();

			Extent<Reto> extent = pm.getExtent(Reto.class, true);

			for (Reto category : extent) {
				retos.add(category);
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

		return retos;
	}

	@Override
	public Reto find(String param) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Reto result = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Reto.class.getName() + " WHERE idReto == " + param);
			query.setUnique(true);
			result = (Reto) query.execute();

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

}
