package com.senai.crud.controllers;

import com.senai.crud.dtos.ListaUsuariosDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProdutoListaController {

    @Autowired
    ProdutoService service;

    @GetMapping("/produtolista")
    public String obterProdutoLista(Model model){

        List<ProdutoDto> listaProdutoDto = service.listaProdutos();
        model.addAttribute("ProdutoDto", listaProdutoDto);

        return "produtolista";
    }
}
