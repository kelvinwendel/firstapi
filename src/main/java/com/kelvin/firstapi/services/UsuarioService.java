package com.kelvin.firstapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kelvin.firstapi.domain.Usuario;
import com.kelvin.firstapi.repositories.UsuarioRepository;
import com.kelvin.firstapi.services.exceptions.ObjectNotFoundException;

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
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto de ID: " + id + " não encontrado!, "
				+ "Tipo: " + Usuario.class.getName()));
	}

	/**
	 * Busca por todos os usuários cadastrados.
	 *
	 * @return
	 *   {@code List<Usuario>} contendo todos os registros cadastrados.
	 */
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

	/**
	 * Atualiza as informações do usuário especificado.
	 *
	 * @param id
	 *   ID do usuário a ser atualizado.
	 * @param usuarioAtualizado
	 *   Usuário com os devidos valores atualizados.
	 *
	 * @return
	 *   {@code Usuario} que foi atualizado.
	 */
	public Usuario update(Long id, Usuario usuarioAtualizado) {
		Usuario usuario = findByID(id);
		usuario.setLogin(usuarioAtualizado.getLogin());
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setSenha(usuarioAtualizado.getSenha());

		return usuarioRepository.save(usuario);
	}

	/**
	 * Persiste o usuário recebido da requisição na base de dados.
	 *
	 * @param usuarioCriado
	 *   Usuário criado obtido do corpo da requisição.
	 *
	 * @return
	 *   {@code Usuario} que foi criado.
	 */
	public Usuario create(Usuario usuarioCriado) {
		// Seto o valor nulo para garantir a criação e evitar um update caso informado um ID existente.
		usuarioCriado.setId(null);
		return usuarioRepository.save(usuarioCriado);
	}
}