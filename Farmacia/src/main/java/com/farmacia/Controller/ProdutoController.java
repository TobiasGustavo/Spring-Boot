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

import com.farmacia.Model.ProdutoModel;
import com.farmacia.Repository.ProdutoRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*") // origem da requistion
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
		public ResponseEntity<List<ProdutoModel>> getAll(){
			return ResponseEntity.ok(produtoRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/ {nome}")
	public ResponseEntity<List<ProdutoModel>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByTituloContainingIgnoreCase(nome));

	}

	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)); // HTTP 201

	}

	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)); // HTTP 201

	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		produtoRepository.deleteById(id);
	}
}
