package com.lojadegames.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Modelo de BD 

@Entity
@Table(name = "tb_categoria")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O valor nao pode ser nulo e nao pode conter espaco")
	@Size(min = 2, max = 50, message = "Nesse texto o minimo e 2 e o maximo 50 de caracteres")
	private String genero;

	@NotBlank(message = "O valor nao pode ser nulo e nao pode conter espaco")
	@Size(min = 2, max = 50, message = "Nesse texto o minimo e 2 e o maximo 50 de caracteres")
	private String plataforma;

	@NotBlank(message = "O valor nao pode ser nulo e nao pode conter espaco")
	@Size(min = 2, max = 50, message = "Nesse texto o minimo e 2 e o maximo 50 de caracteres")
	private String condicao;
	
	
	
	@OneToMany(mappedBy = "Categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Categoria")
	private List<Produto> Produto;

	public List<Produto> getProduto() {
		return Produto;
	}

	public void setProduto(List<Produto> produto) {
		Produto = produto;
	}

	public long getId() {

		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

}
