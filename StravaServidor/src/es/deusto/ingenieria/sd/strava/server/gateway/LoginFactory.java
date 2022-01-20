package es.deusto.ingenieria.sd.strava.server.gateway;

import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;

public class LoginFactory {

	private static LoginFactory instance;

	public static LoginFactory getInstance() {

		if (instance == null) {
			instance = new LoginFactory();
		}

		return instance;
	}

	public Gateway crearGateway(Tipologin t) {
		if (t == Tipologin.GOOGLE) {
			return GoogleServiceGateway.getInstance();
		} else if (t == Tipologin.FACEBOOK) {
			return FacebookServiceGateway.getInstance();
		} else {
			return null;
		}
	}
}
