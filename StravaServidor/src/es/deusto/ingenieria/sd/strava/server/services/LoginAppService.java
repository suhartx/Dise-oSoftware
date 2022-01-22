package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;
import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioContraDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioDAO;
import es.deusto.ingenieria.sd.strava.server.gateway.LoginFactory;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	static List<UsuarioContra> Usuarios = new ArrayList<>();

	UsuarioContra user = new UsuarioContra();

	private static LoginAppService instance;

	public static LoginAppService getInstance() {
		if (instance == null) {
			instance = new LoginAppService();
		}


		return instance;
	}


	public boolean anyadirUsuario(String email, String nombre, Date fecha, String contra) {

		initializeData();


		for (Usuario usuario : Usuarios) {

			if (usuario.getEmail().equals(email)) {
				System.out.println("El usuario que intenta añadir ya existe");
				return false;
			}

		}
		System.out.println(contra + "n en añyadir usuario");
		UsuarioContra u =new UsuarioContra(nombre, email, fecha, contra);

		System.out.println(u.getContrasenya() + "despues de crear el objeto");

		UsuarioDAO.getInstance().save(u);
		initializeData();
		return true;
	}

	public Usuario login(Tipologin tipologin, String email, String contrasenya) {
		// TODO: Get User using DAO and check

//		user.setEmail("suhartx@gmail.com");
//		user.setNombre("Thomas");
//		// Generate the hash of the pasword
//		user.setContrasenya("suhar");
//		Usuarios.add(user);



		if (tipologin.equals(Tipologin.LOCAL)) {

			/*
			 * AQUI TENEMOS QUE METER QUE DEVUELVA UN USUARIO PERSONIFICADO
			 */
			// Usuario user = loginService.login(tipologin, email, password);
			// If login() success user is stored in the Server State

			for (Usuario usuario : Usuarios) {
					System.out.println(usuario.getEmail() +"=="+email);
					System.out.println(((UsuarioContra) usuario).getContrasenya() +"=="+contrasenya);


					////////
					///ERROR NULL POINTER EXCEPTION
					////////
				if (usuario.getClass().getSimpleName().equals("UsuarioContra"))
					if(usuario.getEmail().equals(email)
						&& ((UsuarioContra) usuario).getContrasenya().equals(contrasenya)) {
					// Usuarios.add(user);
						//System.out.println(Usuarios.isEmpty());
					return usuario;
				} // el propio facebook

			}
			System.out.println("ocurre esto");
			return null;

		} else if (tipologin.equals(Tipologin.FACEBOOK)) {

			if (LoginFactory.getInstance().crearGateway(Tipologin.FACEBOOK).iniciarSesion(email, contrasenya)) {
				// Long token = Calendar.getInstance().getTimeInMillis();
				// this.serverState.put(token, new Usuario(null, email, null));
				// return (token);
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
	private static void initializeData() {




		Usuarios = UsuarioContraDAO.getInstance().getAll();
	}

}