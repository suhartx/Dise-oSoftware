package es.deusto.ingenieria.sd.strava.server.services;

import es.deusto.ingenieria.sd.auctions.strava.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public Usuario login(String email, String contrasenya) {
		//TODO: Get User using DAO and check 		
		Usuario user = new Usuario();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNombre("Thomas");		
		//Generate the hash of the pasword
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setContrasenya(sha1);
		
		if (user.getEmail().equals(email) && user.checkContrasenya(contrasenya)) {		
			return user;
		} else {
			return null;
		}
	}
}