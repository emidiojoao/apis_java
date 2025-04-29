package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ConsultaUsuarioDto;
import com.senai.usuario_database.dtos.ProdutoDto;
import com.senai.usuario_database.dtos.ProdutoListaDto;
import com.senai.usuario_database.services.ProdutoService;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/listaprodutos")
public class ProdutoListaController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterUserList(Model model) {

        List<ProdutoListaDto> produtoListaDto = service.listarProdutos();
        model.addAttribute("produtoListaDto", produtoListaDto);

        return "listaproduto";
    }

//    @GetMapping
//    public String obterListaProduto(
//            @RequestParam(value = "product_list_filter", required = false) Long produtoId,
//            Model model) {
//
//        if (produtoId != null) {
//            // Se um ID foi fornecido, busca só esse usuário
//            List<ProdutoDto> produtoDto = new ArrayList<>();
//
//            ProdutoDto produto = service.obterProdutoPorId(produtoId);
//            if (produto != null) {
//                produtoDto.add(produto);
//            }
//
//            model.addAttribute("produtoDto", produtoDto);
//        } else {
//            // Caso contrário, busca todos
//            List<ProdutoDto> listaProdutoDto = service.listarProdutos();
//            model.addAttribute("produtoDto", listaProdutoDto);
//        }
//
//        return "listaproduto";
//    }


}
