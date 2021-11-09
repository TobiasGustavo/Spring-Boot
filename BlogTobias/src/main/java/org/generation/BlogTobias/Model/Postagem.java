package org.generation.BlogTobias.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity 
@Table (name = "postagem" )

		public class Postagem {

		@Id   
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull(message = "O atributo título é obrigatório")
		@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 5 e no máximo 100 caracteres")
		private String titulo;
	
		
		@NotBlank(message = "O atributo texto é obrigatório")
		@Size(min = 10, max = 500, message = "O atributo título deve conter no mínimo 5 e no máximo 500 caracteres")
		private String texto;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date date = new java.sql.Date(System.currentTimeMillis());
		
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Tema tema; 
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Tema getTema() {
			return tema;
		}

		public void setTema(Tema tema) {
			this.tema = tema;
		}
		
		
}