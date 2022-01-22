package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.data.domain.RetoConEstado;

public class RetoConEstadoDAO extends DataAccessObjectBase implements IDataAccessObject<RetoConEstado> {

	private static RetoConEstadoDAO instance;

	public static RetoConEstadoDAO getInstance() {
		if (instance == null) {
			instance = new RetoConEstadoDAO();
		}

		return instance;
	}

	private RetoConEstadoDAO() {
	}

	@Override
	public void delete(RetoConEstado object) {
		// TODO Auto-generated method stub
		super.deleteObject(object);
	}

	@Override
	public RetoConEstado find(String param) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		RetoConEstado result = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Reto.class.getName() + " WHERE idReto == " + param);
			query.setUnique(true);
			result = (RetoConEstado) query.execute();

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
	public List<RetoConEstado> getAll() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<RetoConEstado> retos = new ArrayList<>();

		try {
			tx.begin();

			Extent<RetoConEstado> extent = pm.getExtent(RetoConEstado.class, true);

			for (RetoConEstado category : extent) {
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
	public void save(RetoConEstado object) {
		// TODO Auto-generated method stub
		super.saveObject(object);
	}

}
