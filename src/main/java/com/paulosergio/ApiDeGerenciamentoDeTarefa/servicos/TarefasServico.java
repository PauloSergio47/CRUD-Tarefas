package com.paulosergio.ApiDeGerenciamentoDeTarefa.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulosergio.ApiDeGerenciamentoDeTarefa.entidade.Tarefas;
import com.paulosergio.ApiDeGerenciamentoDeTarefa.exception.TarefaNaoEncontrada;
import com.paulosergio.ApiDeGerenciamentoDeTarefa.repositorios.TarefasRepositorio;

@Service
public class TarefasServico {

    @Autowired
    private TarefasRepositorio tarefasRepositorio;

    public List<Tarefas> visualizar() {
        return tarefasRepositorio.findAll();
    }

    public Tarefas procurarPorID(Long id) {
        //Optional<Tarefas> obj = tarefasRepositorio.findById(id);
        //return obj.get();
        return tarefasRepositorio.findById(id).orElseThrow(() -> new TarefaNaoEncontrada(id));
    }

    public Tarefas criar(Tarefas tarefa) {
        return tarefasRepositorio.save(tarefa);
    }
}
