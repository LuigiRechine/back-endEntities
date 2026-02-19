package com.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoBiblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
