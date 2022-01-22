package es.deusto.ingenieria.sd.strava.server;

import java.rmi.Naming;
import java.sql.Date;
import java.util.GregorianCalendar;

import es.deusto.ingenieria.sd.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;
import es.deusto.ingenieria.sd.strava.server.data.dao.EntrenamientoDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioDAO;
import es.deusto.ingenieria.sd.strava.server.remote.IRemoteFacade;
import es.deusto.ingenieria.sd.strava.server.remote.RemoteFacade;

public class MainProgram {

	public static void main(String[] args) {
		// Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		// args[0] = RMIRegistry IP
		// args[1] = RMIRegistry Port
		// args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		initDB();
		// Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Strava Server v1 '" + name + "' Iniciado!!");

		} catch (Exception ex) {
			System.err.println(name);
			System.err.println(" # Strava Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

    private static void initDB() {
        try {
            GregorianCalendar calendar = new GregorianCalendar();

            //Create Profiles
            UsuarioContra p1 = new UsuarioContra();
            p1.setEmail("jaimeamann@opendeusto.es");
            p1.setNombre("Jaime");
            p1.setFechaNacimiento(new Date(6666666));
            p1.setContrasenya("holakease");

            Entrenamiento p2 = new Entrenamiento();
            p2.setDistancia(2);
            p2.setDuracion(23);
            p2.setFechaInicio(new Date(333333));
            p2.setHoraInicio("323");
            p2.setTipoDeporte("bici");
            p2.setTitulo("titulo");
            p2.setUsuario(p1);




            //Save Users in the DB
            UsuarioDAO.getInstance().save(p1);
            EntrenamientoDAO.getInstance().save(p2);


        } catch (Exception ex) {
            System.out.println(" $ Error initializing data base:" + ex.getMessage());
        }
    }

}
