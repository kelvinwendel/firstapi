package com.kelvin.firstapi.services.exceptions;

/**
 * Classe que representa uma exceção para objeto não encontrado.
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
}