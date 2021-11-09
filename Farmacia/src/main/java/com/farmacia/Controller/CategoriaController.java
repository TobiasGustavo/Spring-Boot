package com.farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.Model.CategoriaModel;
import com.farmacia.Repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*" , allowedHeaders = "*" ) 

public class CategoriaController {
	
	@Autowired // exemplo em ilustracao 
	private CategoriaRepository Repository;
	
	@GetMapping
	    public ResponseEntity<List<CategoriaModel>> getAll(){
		return ResponseEntity.ok(Repository.findAll());
		
	 }

		@GetMapping("/{id}")
		public ResponseEntity<CategoriaModel> getById(@PathVariable long id) {
			return Repository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build()); 
		}
		
		@GetMapping("/Categoria/{Categoria}")
		public ResponseEntity<List<CategoriaModel>> GetByName(@PathVariable String Categoria){
			return ResponseEntity.ok(Repository.findAllByCategoriaContainingIgnoreCase(Categoria)); // implementar 
								
		}


		@PostMapping
		public ResponseEntity<CategoriaModel> postCategoria(@RequestBody CategoriaModel Tipo) {
			return ResponseEntity.status(HttpStatus.CREATED).body(Repository.save(Tipo)); // HTTP 201
		
		}
		
		@PutMapping
		public ResponseEntity<CategoriaModel> putCategoria (@RequestBody CategoriaModel Tipo) {
			return ResponseEntity.status(HttpStatus.OK).body(Repository.save(Tipo)); // HTTP 201
			
		}
		
		@DeleteMapping("/{id}")
		public void deleteProduto(@PathVariable long id) {
			Repository.deleteById(id);	
	
	
	}
}
