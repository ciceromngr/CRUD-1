package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

	Tarefas findByTituloTarefa(String tituloTarefa);
}
