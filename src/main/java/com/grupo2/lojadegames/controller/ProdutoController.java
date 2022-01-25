package com.grupo2.lojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.grupo2.lojadegames.model.Produto;
import com.grupo2.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;
	
	//BUSCAS
	@GetMapping("/all")
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> list = repository.findAll();
		
		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Lista Vazia!");
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}
	
	
	
}