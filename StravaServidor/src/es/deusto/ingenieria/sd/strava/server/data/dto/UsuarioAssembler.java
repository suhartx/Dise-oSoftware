package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.data.domain.Usuario;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class UsuarioAssembler {
	private static UsuarioAssembler instance;

	private UsuarioAssembler() {
	}

	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO usuarioToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();

		//dto.setIdUsuario(usuario.getIdUsuario());
		dto.setNombre(usuario.getNombre());
		dto.setEmail(usuario.getEmail());
		dto.setFechaNacimiento(usuario.getFechaNacimiento());
		//dto.setContrasenya(usuario.getContrasenya());

		return dto;
	}

	public List<UsuarioDTO> usuarioToDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> dtos = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			dtos.add(this.usuarioToDTO(usuario));
		}

		return dtos;
	}
}