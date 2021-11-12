package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<RetoDTO> getCategories() throws RemoteException;
	
	public List<ArticleDTO> getArticles(String aCategory) throws RemoteException;
	
	public boolean makeBid(long token, int article, float amount) throws RemoteException;
	
	public float getUSDRate() throws RemoteException;
	
	public float getGBPRate() throws RemoteException;	
}