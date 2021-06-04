package com.example.demo.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Tarefas;
import com.example.demo.repository.TarefasRepository;

@Service
public class TarefasService {

	@Autowired
	private TarefasRepository tarefasRepository;
	
	
	public List<Tarefas> pegarTodasTarefas(){
		return tarefasRepository.findAll();
	}
	
	public Tarefas pegarTarefaPorTitulo(String titulo) throws Exception {
		Tarefas tarefa = tarefasRepository.findByTituloTarefa(titulo);
		System.out.println(tarefa);
		return tarefa;
	}
	
	public Tarefas adicionarTarefa(Tarefas tarefa) throws Exception {
		if(tarefa.getTituloTarefa() != null && tarefa.getNomeTarefa() != null) {
			return tarefasRepository.save(tarefa);
		}else {
			throw new Exception("Titulo ou Nome da Tarefa estão");
		}
	}
	
	public Tarefas atualizar(Tarefas tarefa) throws Exception{
		return tarefasRepository.save(tarefa);
	}
	
	public void deletar(Long id) {
		tarefasRepository.deleteById(id);
	}
}
