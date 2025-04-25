package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ProdutoListaDto;
import com.senai.usuario_database.dtos.ProdutoRequisicaoDto;
import com.senai.usuario_database.services.ProdutoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/crud/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/produtos")
    public List<ProdutoListaDto> listarProduto(){
        return service.listarProdutos();
    }

    @PostMapping
    public Boolean cadastrarProduto(@RequestBody ProdutoRequisicaoDto produtoRequisicaoDto){
        return service.criarProduto(produtoRequisicaoDto);
    }
}
