package com.paulosergio.ApiDeGerenciamentoDeTarefa.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulosergio.ApiDeGerenciamentoDeTarefa.entidade.Tarefas;
import com.paulosergio.ApiDeGerenciamentoDeTarefa.repositorios.TarefasRepositorio;
import com.paulosergio.ApiDeGerenciamentoDeTarefa.servicos.TarefasServico;

@RestController
@RequestMapping("/tarefas")
public class TarefaControlador {
	
	private final TarefasServico tarefasServico;

	public TarefaControlador(TarefasServico tarefasServico, TarefasRepositorio tarefasRepositorio) {
		this.tarefasServico = tarefasServico;
	}

	@GetMapping
	public ResponseEntity<List<Tarefas>> findAll() {
		List<Tarefas> lista = tarefasServico.visualizar();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefas> findById(@PathVariable Long id) {
		Tarefas obj = tarefasServico.procurarPorID(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/cadastrarTarefa")
	public ResponseEntity<Tarefas> cadastrarTarefa(@ModelAttribute Tarefas novaTarefa) {
		System.out.println("Cadastrado: "+novaTarefa);
        Tarefas tarefaCriada = tarefasServico.criar(novaTarefa);
        return ResponseEntity.ok().body(tarefaCriada);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Tarefas> updateTarefas(@PathVariable long id, @RequestBody Tarefas tarefasDetalhes) {
		Tarefas updateTarefas = tarefasServico.updateTarefa(id, tarefasDetalhes);
		return ResponseEntity.ok(updateTarefas);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteTarefas(@PathVariable long id) {
		tarefasServico.deletarTarefas(id);
		return ResponseEntity.ok().build();
	}

}
