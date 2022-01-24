package es.deusto.ingenieria.sd.strava.server.data.dto;

//HAY QUE CAMBIAR ESTO
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.data.domain.RetoConEstado;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class RetoAssembler {
	private static RetoAssembler instance;

	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}

	private RetoAssembler() {

	}

	public List<RetoDTO> retoToDTO(List<Reto> retos) {
		List<RetoDTO> dtos = new ArrayList<>();

		for (Reto reto : retos) {
			System.out.println("5");
			System.out.println(reto.toString());
			dtos.add(this.retoToDTO(reto));
			System.out.println(reto.toString());
		}
		System.out.println();
		return dtos;
	}

	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		dto.setIdReto(reto.getIdReto());
		dto.setNombre(reto.getNombre());
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTipoDeporte(reto.getTipoDeporte());
		dto.setEmailPropietario(reto.getDuenyo().getEmail());
		if (reto.getClass().getSimpleName().equals("RetoConEstado")) {
			dto.setPorcentaje(((RetoConEstado) reto).getPorcentaje());
		} else {
			dto.setPorcentaje(0);
		}

		return dto;
	}
}