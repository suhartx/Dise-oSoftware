package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.strava.data.domain.Reto;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class CategoryAssembler {
	private static CategoryAssembler instance;

	private CategoryAssembler() { }
	
	public static CategoryAssembler getInstance() {
		if (instance == null) {
			instance = new CategoryAssembler();
		}
		
		return instance;
	}

	public CategoryDTO categoryToDTO(Reto category) {
		CategoryDTO dto = new CategoryDTO();		
		dto.setName(category.getName());
		return dto;
	}

	public List<CategoryDTO> categoryToDTO(List<Reto> categories) {		
		List<CategoryDTO> dtos = new ArrayList<>();
		
		for (Reto category : categories) {
			dtos.add(this.categoryToDTO(category));
		}
		
		return dtos;
	}
}