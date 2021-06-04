package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Tarefas;
import com.example.demo.service.TarefasService;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "*")
public class TarefasController {

	@Autowired
	private TarefasService tarefasService;
	
	
	@GetMapping
	public List<Tarefas> getAll(){
		return tarefasService.pegarTodasTarefas();
	}
	
	@PostMapping("/adicionar")
	public Tarefas adicionartarefa(@RequestBody Tarefas tarefa) throws Exception {
		return tarefasService.adicionarTarefa(tarefa);
	}
	
	@GetMapping("/{pegarTarefaPelotitulo}")
	public Tarefas pegarTarefaPelotitulo(@PathVariable(value="pegarTarefaPelotitulo") String titulo) throws Exception {
		return tarefasService.pegarTarefaPorTitulo(titulo);
	}
	
	@PutMapping("/atualizar")
	public Tarefas atualizarTarefa(@RequestBody Tarefas tarefa) throws Exception {
		return tarefasService.atualizar(tarefa);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarTarefa(@PathVariable(value="id") Long id) {
		tarefasService.deletar(id);
	}
	
	
}
