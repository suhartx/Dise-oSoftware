package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Tipologin;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.EstadoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {

	public long login(Tipologin tipologin, String email, String password) throws RemoteException;

	public void logout(long token) throws RemoteException;

	public long registrarUsuario(String email, String nombre, Date fecha, String contrasenya) throws RemoteException;

	public List<RetoDTO> getRetos() throws RemoteException;

	public List<EntrenamientoDTO> getEntrenamientos(String aEntrenamiento) throws RemoteException;

	/**
	 * El usuario al hacer una sesi�n de entrenamiento deber� introducir unos
	 * valores espec�ficos. Despu�s de haber rellenado los valores necesarios para
	 * la creaci�n de la sesi�n de entrenamiento, estos se enviar�n al servidor. Por
	 * lo tanto este m�todo recibir� los datos introducidos por el usuario.
	 */
	public long crearEntrenamiento(Long valor, String titulo, String tipoDeporte, double distancia, Date fechaInicio,
			String horaInicio, double duracion) throws RemoteException;

	/**
	 * El servidor recibe los valores del reto creado y los almacenar� en la BBDD,
	 * para que cualquier usuario/a registrado/a pueda acceder a ese reto. Adem�s
	 * despu�s de haber creado el reto, el servidor env�a un mensaje de confirmaci�n
	 * al usuario con los datos introducidos previamente.
	 */
	public long crearReto(Long u, String nombre, Date fechaInicio, Date fechaFin, double distancia, String tipoDeporte)
			throws RemoteException;

	// public Reto obtenerReto() throws RemoteException;
	// : El usuario solicitar� al servidor que haga una b�squeda de entre sus retos
	// y
	// que le devuelva un reto espec�fico. El m�todo hace que el servidor devuelva
	// el reto que el usuario haya requerido.

	/**
	 * El usuario despu�s de haber seleccionado un reto decide apuntarse a este. El
	 * servidor por lo tanto, recibe el reto elegido. El m�todo consiste en la
	 * recepci�n del reto escogido por el usuario.
	 */
	public void aceptarReto(Long u, Long idReto) throws RemoteException;

	/**
	 * El usuario tendr� la posibilidad de ver el estado de sus retos. Seleccionar�
	 * un reto y podr� ver el estado del reto seleccionado. El servidor recibir� el
	 * reto introducido y devolver� su estado.
	 */
	public EstadoDTO consultarReto(Long u, Long idReto) throws RemoteException;

}