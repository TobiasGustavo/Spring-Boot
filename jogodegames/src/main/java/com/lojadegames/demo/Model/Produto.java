package com.lojadegames.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")

public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id_produto;
	
	
	@NotBlank(message= "O valor nao pode ser nulo e nao pode conter espaco")
	@Size(min= 4, max= 100, message= "Nesse texto o minimo e 2 e o maximo 50 de caracteres")
	private String titulo;
	
	
	@NotBlank(message= "O valor nao pode ser nulo e nao pode conter espaco")
	private double preco;

	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;
	
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
