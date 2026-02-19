package com.projetoBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoBiblioteca.entities.Fornecedor;
import com.projetoBiblioteca.services.FornecedorService;

@RestController
@RequestMapping ("/fornecedor")
public class FornecedorController {
	
	@Autowired
    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService produtoService) {
        this.fornecedorService = produtoService;
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedoresId(@PathVariable Long id) {
    	Fornecedor fornecedor = fornecedorService.buscarFornecedoresPorId(id);
        if (fornecedor != null) {
            return ResponseEntity.ok(fornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Fornecedor>> buscarTodosFornecedores() {
        List<Fornecedor> produtos = fornecedorService.buscarTodosFornecedores();
        return ResponseEntity.ok(produtos);
    }

 
    @PostMapping("/")
    public ResponseEntity<Fornecedor> salvaProduto(@RequestBody Fornecedor fornecedor) {
    	Fornecedor saveFornecedores = fornecedorService.salvarFornecedores(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveFornecedores);
    }
    
 
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> alteraProdutos(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
    	Fornecedor atualizaFornecedor = fornecedorService.atualizarFornecedor(id, fornecedor);
        if (atualizaFornecedor != null) {
            return ResponseEntity.ok(atualizaFornecedor); // Retorna o produto atualizado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    }
    
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Fornecedor> apagaFornecedor(@PathVariable Long id) {
        boolean apagaFornecedor = fornecedorService.apagarFornecedor(id);
        if (apagaFornecedor) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    }

}
