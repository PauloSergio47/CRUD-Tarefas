package com.paulosergio.ApiDeGerenciamentoDeTarefa.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.paulosergio.ApiDeGerenciamentoDeTarefa.exception.TarefaNaoEncontrada;

@ControllerAdvice
public class ControleGlobalDeExcessoes {
	
	@ExceptionHandler(TarefaNaoEncontrada.class)
	public ResponseEntity<String> handleTarefaNaoEncontrada(TarefaNaoEncontrada ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
