package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Entrenamiento;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class EntrenamientoAssembler {	
	private static EntrenamientoAssembler instance;

	private EntrenamientoAssembler() { }
	
	public static EntrenamientoAssembler getInstance() {
		if (instance == null) {
			instance = new EntrenamientoAssembler();
		}

		return instance;
	}

	public EntrenamientoDTO entrenamientoToDTO(Entrenamiento entrenamiento) {
		EntrenamientoDTO dto = new EntrenamientoDTO();
		
		dto.setIdEntrenamiento(entrenamiento.getIdEntrenamiento());
		dto.setTitulo(entrenamiento.getTitulo());
		dto.setDistancia(entrenamiento.getDistancia());
		dto.setTipoDeporte(entrenamiento.getTipoDeporte());
		dto.setFechaInicio(entrenamiento.getFechaInicio());
		dto.setHoraInicio(entrenamiento.getHoraInicio());
		dto.setDuracion(entrenamiento.getDuracion());
		
		return dto;
	}
	
	public List<EntrenamientoDTO> entrenamientoToDTO(List<Entrenamiento> entrenamientos) {
		List<EntrenamientoDTO> dtos = new ArrayList<>();
		
		for (Entrenamiento entrenamiento : entrenamientos) {
			dtos.add(this.entrenamientoToDTO(entrenamiento));
		}
		
		return dtos;		
	}
}