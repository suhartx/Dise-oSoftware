package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Estado;

public class EstadoAssembler {
	
	private static EstadoAssembler instance;

	private EstadoAssembler() { }
	
	public static EstadoAssembler getInstance() {
		if (instance == null) {
			instance = new EstadoAssembler();
		}

		return instance;
	}

	public EstadoDTO estadoToDTO(Estado estado) {
		EstadoDTO dto = new EstadoDTO();
		
		dto.setIdEstado(estado.getIdEstado());
		dto.setEstado(estado.getEstado());
		
		return dto;
	}
	
	public List<EstadoDTO> estadoToDTO(List<Estado> estados) {		
		List<EstadoDTO> dtos = new ArrayList<>();
		
		for (Estado estado : estados) {
			dtos.add(this.estadoToDTO(estado));
		}
		
		return dtos;
	}


}
