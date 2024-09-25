package com.paulosergio.ApiDeGerenciamentoDeTarefa.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulosergio.ApiDeGerenciamentoDeTarefa.entidade.Tarefas;
import com.paulosergio.ApiDeGerenciamentoDeTarefa.repositorios.TarefasRepositorio;
import com.paulosergio.ApiDeGerenciamentoDeTarefa.servicos.TarefasServico;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaControlador {
	
	private final TarefasRepositorio tarefasRepositorio;
	private final TarefasServico tarefasServico;

	public TarefaControlador(TarefasServico tarefasServico, TarefasRepositorio tarefasRepositorio) {
		this.tarefasServico = tarefasServico;
		this.tarefasRepositorio = tarefasRepositorio;
	}

	@GetMapping
	public ResponseEntity<List<Tarefas>> findAll() {
		List<Tarefas> lista = tarefasServico.visualizar();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
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

	@GetMapping("/sucesso")
	public String sucesso(Model model) {
		model.addAttribute("mensagem", "Tarefa cadastrada com sucesso!");
		return "sucesso.html"; // Página HTML que exibe a mensagem
	}

}
