package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ProdutoDto;
import com.senai.usuario_database.dtos.ProdutoRequisicaoDto;
import com.senai.usuario_database.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atualizar-produto")
public class AtualizarCadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/{id}")
    public String obterAtualizarProduto(@PathVariable Long id, Model model){

        ProdutoDto produtoDto = service.obterProdutoPorId(id);
        model.addAttribute("produtoAtualizarDto", produtoDto);

        return "atualizarcadastroproduto";
    }


    @PostMapping("/{id}")
    public String realizarAtualizacaoProduto(@PathVariable Long id, @ModelAttribute("produtoAtualizarDto") ProdutoDto produtoDto){
        Boolean resultado = service.atualizarProduto(id, produtoDto);

        if(!resultado){
            return "redirect:/listaprodutos?erro";
        }

        return "redirect:/listaprodutos";
    }


}
