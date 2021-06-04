package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> pegarTodosUsuario() throws Exception{
		return usuarioRepository.findAll();
	}
	
	public Usuario cadastrarUsuario(Usuario user) throws Exception{
		if(user.getNome() != null && user.getEmail() != null && user.getSenha() != null) {
			return usuarioRepository.save(user);
		} else {
			throw new Exception("Algum Campo está Vazios!");
		}
	}
	
	public Boolean login(UsuarioDto dto) throws Exception{
		
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());

		if(usuario.getSenha().equals(dto.getSenha())) {
			return true;
		}else {
			throw new Exception("Email ou senha Invalidos!");
		}
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
}
