package com.projetoBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoBiblioteca.entities.Usuario;
import com.projetoBiblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	final private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> buscarTodosUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuariosPorId(Long id){
		  Optional <Usuario> usuario = usuarioRepository.findById(id);
	        return usuario.orElse(null);
	}
	
	public Usuario salvarUsuarios(Usuario atUsuario) {
		return usuarioRepository.save(atUsuario);
	}
	
	public Usuario atualizarUsuario(Long id, Usuario atUsuario) {
		Optional <Usuario> exeUsuario = usuarioRepository.findById(id);
		if(exeUsuario.isPresent()) {
			atUsuario.setId(id);
			return usuarioRepository.save(atUsuario);
		}
		else {
			return null;
		}
	}
	
	public Boolean apagarUsuario(Long id) {
		Optional<Usuario> exeUsuario = usuarioRepository.findById(id);
		if(exeUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
