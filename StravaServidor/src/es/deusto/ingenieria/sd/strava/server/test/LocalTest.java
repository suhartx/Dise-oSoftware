package es.deusto.ingenieria.sd.strava.server.test;

import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {
		RemoteFacade facade = null;
		List<RetoDTO> retos = null;
		RetoDTO reto = null;
		List<EntrenamientoDTO> entrenamientos = null;
		EntrenamientoDTO entrenamiento = null;
		long token = 0l;

		try {
			facade = new RemoteFacade();

			// Get Retos
			retos = facade.getRetos();
			reto = retos.get(0);

			for (RetoDTO c : retos) {
				System.out.println("\t- " + c);
			}

			// Get Entrenamientos
			entrenamientos = facade.getEntrenamientos();
			entrenamiento = entrenamientos.get(0);

			for (EntrenamientoDTO a : entrenamientos) {
				System.out.println("\t- " + a);
			}

			// Check currency conversion
//			float rateGBP = facade.getGBPRate();
//			float rateUSD = facade.getUSDRate();

//			System.out.println("\t- USD rate = " + rateGBP);
//			System.out.println("\t- USD rate = " + rateUSD);

			// Make a bid (fails because no login has been done)
//			facade.makeBid(0, article.getNumber(), article.getActualPrice()+1);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());
		}

		try {
			// Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.login(Tipologin.LOCAL, "thomas.e2001@gmail.com", sha1);
			// Make a bid
			// facade.makeBid(token, article.getNumber(), article.getActualPrice()+1);
			// Logout
			facade.logout(token);
			// Get articles again to check if the bid has been registered
			retos = facade.getRetos();
			reto = retos.get(0);
			System.out.println("\t- " + reto);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());
		}

		// Force exit to stop RMI Server
		System.exit(0);
	}
}
