package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;

//This class implements Singleton and DAO patterns
public class UsuarioContraDAO extends DataAccessObjectBase implements IDataAccessObject<UsuarioContra> {

	private static UsuarioContraDAO instance;

	public static UsuarioContraDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioContraDAO();
		}

		return instance;
	}

	private UsuarioContraDAO() {
	}

	@Override
	public void delete(UsuarioContra object) {
		super.deleteObject(object);
	}

	@Override
	public UsuarioContra find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		UsuarioContra result = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + UsuarioContra.class.getName() + " WHERE email == '" + param + "'");
			query.setUnique(true);
			result = (UsuarioContra) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

	@Override
	public List<UsuarioContra> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<UsuarioContra> users = new ArrayList<>();

		try {
			tx.begin();

			Extent<UsuarioContra> userExtent = pm.getExtent(UsuarioContra.class, true);

			for (UsuarioContra user : userExtent) {
				users.add(user);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return users;
	}

	@Override
	public void save(UsuarioContra object) {

		super.saveObject(object);
	}
}