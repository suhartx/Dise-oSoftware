package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;
import es.deusto.ingenieria.sd.strava.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.data.domain.UsuarioContra;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.services.EntrenamientoAppService;
import es.deusto.ingenieria.sd.strava.server.services.LoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.RetoAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;

	private Map<Long, Usuario> serverState = new HashMap<>();

	private Map<Long, Reto> serverStateReto = new HashMap<>();

	private LoginAppService loginService = new LoginAppService();
	private RetoAppService retoService = new RetoAppService();
	private EntrenamientoAppService entrenaService = new EntrenamientoAppService();

	public RemoteFacade() throws RemoteException {
		super();
	}

	@Override
	public void aceptarReto(Long u, Long idReto) throws RemoteException {
		System.out.println(" * RemoteFacade aceptarReto()");
		retoService.aceptarReto(serverState.get(u), serverStateReto.get(idReto));
	}

	@Override
	public RetoDTO consultarReto(Long u, Long idReto) throws RemoteException {

		System.out.println(" * RemoteFacade consultarReto()");
		return RetoAssembler.getInstance()
				.retoToDTO(retoService.consultarReto(serverState.get(u), serverStateReto.get(idReto)));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RetoDTO> consultarRetosActivos(Long u) throws RemoteException {

		System.out.println(" * RemoteFacade consultarReto()");
		return (List<RetoDTO>) RetoAssembler.getInstance()
				.retoToDTO((Reto) retoService.obtenerRetosActivos(serverState.get(u)));
	}

	@Override
	public long crearEntrenamiento(Long valor, String titulo, String tipoDeporte, double distancia, Date fechaInicio,
			String horaInicio, double duracion) throws RemoteException {

		System.out.println(" * RemoteFacade crearEntrenamiento()");
		entrenaService.crearEntrenamiento(serverState.get(valor), titulo, fechaInicio, horaInicio, distancia,
				tipoDeporte);
		return 0;
	}

	@Override
	public long crearReto(Long u, String nombre, Date fechaInicio, Date fechaFin, double distancia, String tipoDeporte)
			throws RemoteException {

		Reto r = new Reto();

		r.setNombre(nombre);
		r.setDistancia(distancia);
		r.setFechaInicio(fechaInicio);
		r.setFechaFin(fechaFin);
		r.setTipoDeporte(tipoDeporte);

		System.out.println(" * RemoteFacade crearReto()");
		retoService.crearReto(serverState.get(u), r);
		serverStateReto.put(r.getIdReto(), r);
		return r.getIdReto();
	}

	@Override
	public List<EntrenamientoDTO> getEntrenamientos(String aEntrenamiento) throws RemoteException {
		System.out.println(" * RemoteFacade getEntrenamientos()");

		// Get Categories using BidAppService
		List<Entrenamiento> entrenamientos = entrenaService.getEntrenamientos();

		if (entrenamientos != null) {
			// Convert domain object to DTO
			return EntrenamientoAssembler.getInstance().entrenamientoToDTO(entrenamientos);
		} else {
			throw new RemoteException("getRetos() fails!");
		}
	}

	@Override
	public List<RetoDTO> getRetos() throws RemoteException {
		System.out.println(" * RemoteFacade getRetos()");

		// Get Categories using BidAppService
		List<Reto> retos = retoService.getRetos();

		if (retos != null) {
			// Convert domain object to DTO
			return RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("getRetos() fails!");
		}
	}

	@Override
	public synchronized long login(Tipologin tipologin, String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
		// AÑADIMOS EL TIPOLOGIN PARA DEPENDE DEL TIPO DE LOGUEO SE LOGUEE CON FACEBOOK
		// GOOGLE O STRAVA
		// Perform login() using LoginAppService
		Usuario user = loginService.login(tipologin, email, password);
		if (user != null) {
			// If user is not logged in
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();
				this.serverState.put(token, user);
				return (token);
			} else {
				throw new RemoteException("El usuario ya esta logueado!");
			}
		} else {
			throw new RemoteException("El logueo falla!");
		}
		/*
		 * if (tipologin.equals(Tipologin.LOCAL)) {
		 *
		 * // // If login() success user is stored in the Server State if (user != null)
		 * { // If user is not logged in if (!this.serverState.values().contains(user))
		 * { Long token = Calendar.getInstance().getTimeInMillis();
		 * this.serverState.put(token, user); return (token); } else { throw new
		 * RemoteException("El usuario ya esta logueado!"); } } else { throw new
		 * RemoteException("El logueo falla!"); } } else if
		 * (tipologin.equals(tipologin.FACEBOOK)) {
		 *
		 * if
		 * (LoginFactory.getInstance().crearGateway(tipologin.FACEBOOK).iniciarSesion(
		 * email, password)) { Long token = Calendar.getInstance().getTimeInMillis();
		 * this.serverState.put(token, new Usuario(null, email, null)); return (token);
		 * } else { throw new RemoteException("El logueo falla!"); } } else if
		 * (tipologin.equals(tipologin.GOOGLE)) {// usuarioFacebook
		 *
		 * if (LoginFactory.getInstance().crearGateway(tipologin.GOOGLE).iniciarSesion(
		 * email, password)) { Long token = Calendar.getInstance().getTimeInMillis();
		 * this.serverState.put(token, new Usuario(null, email, null)); return (token);
		 * } else { throw new RemoteException("El logueo falla!"); }
		 *
		 * } return 0L;
		 */
	}

	@Override
	public void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);

		if (this.serverState.containsKey(token)) {
			// Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("El usuario no esta logueado!");
		}
	}

	@Override
	public long registrarUsuario(String email, String nombre, Date fecha, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub

		boolean sigue = loginService.anyadirUsuario(email, nombre, fecha, contrasenya);

		Long token = null;
		if (sigue) {

			token = login(Tipologin.LOCAL, email, contrasenya);
		}

		this.serverState.put(token, new UsuarioContra(nombre, email, fecha, contrasenya));
		return (token);
	}

//	@Override
//	public long registrarUsuario(String email, String nombre, Date fecha, String contrasenya) throws RemoteException {
//		System.out.println(" * RemoteFacade registrarUsuario()");
//
//
//		return 0;
//	}

}