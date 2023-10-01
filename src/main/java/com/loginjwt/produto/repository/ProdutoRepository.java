package com.loginjwt.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginjwt.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
