package com.paulosergio.ApiDeGerenciamentoDeTarefa.repositorios;

import com.paulosergio.ApiDeGerenciamentoDeTarefa.entidade.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepositorio extends JpaRepository<Tarefas, Long> {
    Tarefas findByTitulo(String titulo);
}
