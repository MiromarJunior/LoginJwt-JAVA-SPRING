package com.loginjwt.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginjwt.produto.model.Produto;
import com.loginjwt.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getAll(){
        return repository.findAll();
    }

    
    
}
