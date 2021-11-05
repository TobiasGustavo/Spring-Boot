package com.lojadegames.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.demo.Model.Categoria;


@Repository
public interface CategoriaRepository  extends JpaRepository <Categoria, Long> {
	


}
