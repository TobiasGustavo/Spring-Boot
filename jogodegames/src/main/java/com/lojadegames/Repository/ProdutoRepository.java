package com.lojadegames.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.demo.Model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long  > {

}