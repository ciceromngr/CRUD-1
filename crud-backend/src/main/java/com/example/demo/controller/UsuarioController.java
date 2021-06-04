package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping
	public List<Usuario> pegarTodosUsuarios() throws Exception{
		return usuarioService.pegarTodosUsuario();
	}
	
	@PostMapping("/cadastrar")
	public Usuario cadastrar(@RequestBody Usuario usuario) throws Exception {
		return usuarioService.cadastrarUsuario(usuario);
	}
	
	@PostMapping("/login")
	public Boolean logar(@RequestBody UsuarioDto dto) throws Exception {
		return usuarioService.login(dto);
	}
	
	@DeleteMapping("/excluir")
	public void excluirUsuario(Long id) {
		usuarioService.deletarUsuario(id);
	}
}
