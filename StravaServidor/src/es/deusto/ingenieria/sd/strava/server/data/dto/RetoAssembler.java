package es.deusto.ingenieria.sd.strava.server.data.dto;
//HAY QUE CAMBIAR ESTO
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Reto;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class RetoAssembler {
	private static RetoAssembler instance;

	private RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		
		return instance;
	}

	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		dto.setIdReto(reto.getIdReto());
		dto.setNombre(reto.getNombre());
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTipoDeporte(reto.getTipoDeporte());
		return dto;
	}

	public List<RetoDTO> retoToDTO(List<Reto> retos) {		
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;
	}
}