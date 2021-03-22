package com.kelvin.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kelvin.firstapi.domain.Usuario;

/**
 * Interface que representa o repositório para Usuário.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
