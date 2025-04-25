package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ProdutoRequisicaoDto;
import com.senai.usuario_database.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class CadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterProduto(Model model){

        ProdutoRequisicaoDto produtoRequisicaoDto = new ProdutoRequisicaoDto();
        model.addAttribute("produtoRequisicaoDto", produtoRequisicaoDto);

        return "cadastroproduto";
    }


    @PostMapping
    public String realizarCadastro(@ModelAttribute("produtoRequisicaoDto") ProdutoRequisicaoDto produtoRequisicaoDto){
        Boolean resultado = service.criarProduto(produtoRequisicaoDto);

        if(!resultado){
            return "redirect:/listaprodutos?erro";
        }

        return "redirect:/listaprodutos";
    }


}
