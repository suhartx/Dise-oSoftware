package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	List<Usuario> Usuarios = new ArrayList<>();

	@SuppressWarnings("unused")
	public Usuario login(String email, String contrasenya) {
		// TODO: Get User using DAO and check

		UsuarioContra user = new UsuarioContra();
		user.setEmail("thomas.e2001@gmail.com");
		user.setNombre("Thomas");
		// Generate the hash of the pasword
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
		user.setContrasenya(sha1);

		Usuarios.add(user);

		for (Usuario usuario : Usuarios) {

			if (usuario.getClass().getSimpleName().equals("UsuarioContra") && usuario.getEmail().equals(email)
					&& ((UsuarioContra) usuario).checkContrasenya(contrasenya)) {
				return user;
			} else if (false) {
			} // aqui implementaremos si el usuario viene de facebook y hara la comprobacion
				// el propio facebook

		}
		return null;
	}

	public boolean anyadirUsuario(String email, String nombre, Date fecha, String contrasenya) {

		for (Usuario usuario : Usuarios) {

			if (usuario.getEmail().equals(email)) {
				System.out.println("El usuario que intenta añadir ya existe");
				return false;
			}

		}

		Usuarios.add(new UsuarioContra(nombre, email, fecha, contrasenya));

		return true;
	}

}