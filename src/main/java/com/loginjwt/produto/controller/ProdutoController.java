package com.loginjwt.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginjwt.produto.model.Produto;
import com.loginjwt.produto.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produtos = service.getAll();
        return ResponseEntity.ok().body(produtos);
    }
    
}
