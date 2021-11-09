package com.farmacia.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.Model.CategoriaModel;


@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	Object findAllByCategoriaContainingIgnoreCase(String Categoria);

}

