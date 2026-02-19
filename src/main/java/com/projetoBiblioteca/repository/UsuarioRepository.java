package com.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoBiblioteca.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
