package com.lojadegames.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.Repository.CategoriaRepository;
import com.lojadegames.demo.Model.Categoria;


@RestController
@RequestMapping("/categoria")
@CrossOrigin (origins = "*" , allowedHeaders = "*" ) // origem da requistion 

public class CategoriaController {

	@Autowired // exemplo em ilustracao 
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll()); // puxa do Repository
		
		
		
	}
	
}
