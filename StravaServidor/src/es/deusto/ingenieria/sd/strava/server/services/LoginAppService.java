package es.deusto.ingenieria.sd.strava.server.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;
import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;
import es.deusto.ingenieria.sd.strava.server.gateway.LoginFactory;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	List<Usuario> Usuarios = new ArrayList<>();

	UsuarioContra user = new UsuarioContra();



	public Usuario login(Tipologin tipologin,String email, String contrasenya) {
		// TODO: Get User using DAO and check

		user.setEmail("suhartx@gmail.com");
		user.setNombre("Thomas");
		// Generate the hash of the pasword
		user.setContrasenya("suhar");
		Usuarios.add(user);


	if (tipologin.equals(Tipologin.LOCAL)) {

			/*
			 * AQUI TENEMOS QUE METER QUE DEVUELVA UN USUARIO PERSONIFICADO
			 */
			//Usuario user = loginService.login(tipologin, email, password);
			// If login() success user is stored in the Server State


		for (Usuario usuario : Usuarios) {

			if (usuario.getClass().getSimpleName().equals("UsuarioContra") && usuario.getEmail().equals(email)
					&& ((UsuarioContra) usuario).checkContrasenya(contrasenya)) {
				//Usuarios.add(user);
				return usuario;
			}// el propio facebook

		}
		return null;

		} else if (tipologin.equals(Tipologin.FACEBOOK)) {

			if (LoginFactory.getInstance().crearGateway(Tipologin.FACEBOOK).iniciarSesion(email, contrasenya)) {
				//Long token = Calendar.getInstance().getTimeInMillis();
				//this.serverState.put(token, new Usuario(null, email, null));
				//return (token);
				Usuario u = new Usuario();
				u.setEmail(email);
				return u;
			} else {
				return null;
			}
		} else if (tipologin.equals(Tipologin.GOOGLE)) {// usuarioFacebook

			if (LoginFactory.getInstance().crearGateway(Tipologin.GOOGLE).iniciarSesion(email, contrasenya)) {
				Usuario u = new Usuario();
				u.setEmail(email);
				return u;
			} else {
				return null;
			}

		}


//////////////////////////////////////////////////////////////////////////
//		UsuarioContra user = new UsuarioContra();
//		user.setEmail("suhartx@gmail.com");
//		user.setNombre("Thomas");
//		// Generate the hash of the pasword
//		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("suhar");
//		user.setContrasenya("suhar");


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