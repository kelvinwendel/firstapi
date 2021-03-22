package com.kelvin.firstapi;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kelvin.firstapi.domain.Usuario;
import com.kelvin.firstapi.repositories.UsuarioRepository;

/**
 * Classe responsável pela inicialização da aplicação.
 */
@SpringBootApplication
public class FirstapiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Inicializa a aplicação.
	 * 
	 * @param args
	 *   Parâmetros de inicialização da aplicação.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FirstapiApplication.class, args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(String... args) throws Exception {
		Usuario usuarioA = new Usuario(null, "Kelvin", "kpwendel", "toor123");
		Usuario usuarioB = new Usuario(null, "Jonas", "tonabini", "torvald123");

		usuarioRepository.saveAll(Arrays.asList(usuarioA, usuarioB));
	}
}
