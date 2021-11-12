package es.deusto.ingenieria.sd.strava.server.data.dto;
//HAY QUE CAMBIAR ESTO
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.strava.data.domain.Reto;

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

	public RetoDTO categoryToDTO(Reto category) {
		RetoDTO dto = new RetoDTO();		
		dto.setName(category.getName());
		return dto;
	}

	public List<RetoDTO> categoryToDTO(List<Reto> categories) {		
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto category : categories) {
			dtos.add(this.categoryToDTO(category));
		}
		
		return dtos;
	}
}