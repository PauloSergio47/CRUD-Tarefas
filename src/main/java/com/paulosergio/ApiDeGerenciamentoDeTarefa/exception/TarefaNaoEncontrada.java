package com.paulosergio.ApiDeGerenciamentoDeTarefa.exception;

public class TarefaNaoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TarefaNaoEncontrada(Long id) {
		super("Tarefa não encontrada com o ID: "+id);
	}

}
