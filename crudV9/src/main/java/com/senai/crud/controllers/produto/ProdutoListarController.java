package com.senai.crud.controllers.produto;

import com.senai.crud.dtos.produto.ListarProdutoDTO;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoListarController {

    @Autowired
    ProdutoService service;

    @GetMapping("/lista-produto")
    public String obterProdutoLista(Model model){

        List<ListarProdutoDTO> listarProdutoDTO = service.listarProdutos();
        model.addAttribute("listarProdutoDTO", listarProdutoDTO);

        return "produtolista";
    }
}
