package com.kelvin.firstapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kelvin.firstapi.domain.Usuario;
import com.kelvin.firstapi.services.UsuarioService;

/*
 * Classe que representa o controller para usuários. 
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Busca um usuário através do ID informado na url.
	 *
	 * @param id
	 *   ID do usuário a ser buscado.
	 *
	 * @return
	 *   {@code ResponseEntity<Usuario>} encontrado através do ID na url.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findByID(@PathVariable Long id) {
		Usuario usuario = usuarioService.findByID(id);
		return ResponseEntity.ok().body(usuario);
	}

	/**
	 * Busca por todos os usuários cadastrados.
	 *
	 * @return
	 *   {@code ResponseEntity<List<Usuario>>} contendo todos os usuários cadastrados.
	 */
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = usuarioService.findAll();
		return ResponseEntity.ok().body(usuarios);
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
	 *   {@code ResponseEntity<Usuario>} que foi atualizado.
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
		Usuario usuario = usuarioService.update(id, usuarioAtualizado);
		return ResponseEntity.ok().body(usuario);
	}
}