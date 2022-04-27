package br.com.estoque.exceptions;

import br.com.estoque.model.Client;
import lombok.NonNull;

import java.util.Optional;

public class ClientNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ClientNotFoundException(String string, @NonNull String client) {
	}


	public ClientNotFoundException(String s) {
	}
}
