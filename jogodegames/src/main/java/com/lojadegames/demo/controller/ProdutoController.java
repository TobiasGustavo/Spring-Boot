package com.lojadegames.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.Repository.ProdutoRepository;
import com.lojadegames.demo.Model.Produto;



@RestController
@RequestMapping("/categoria")
@CrossOrigin (origins = "*" , allowedHeaders = "*" ) // origem da requistion 

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
		
		
	}

}
