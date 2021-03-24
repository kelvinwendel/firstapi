package com.kelvin.firstapi.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kelvin.firstapi.domain.Usuario;
import com.kelvin.firstapi.repositories.UsuarioRepository;

/**
 * Classe que representa os serviços de usuários.
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Busca um usuário através do ID informado.
	 *
	 * @param id
	 *   ID do usuário.
	 *
	 * @return 
	 *   {@code Usuario} encontrado através do ID informado.
	 */
	public Usuario findByID(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}
}