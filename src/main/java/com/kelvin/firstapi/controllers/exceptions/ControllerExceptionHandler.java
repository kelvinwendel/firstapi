package com.kelvin.firstapi.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.kelvin.firstapi.services.exceptions.ObjectNotFoundException;

/**
 * Classe que manipula as exceções relacionadas aos controllers. 
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * Método responsável por tratar a exceção de objeto não encontrado.
	 *
	 * @param e
	 *   Exceção a ser retornada.
	 *
	 * @return
	 *   {@code StandardError} que representa uma exceção ocorrida.
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
		StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(),
				e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
}