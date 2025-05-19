package com.senai.crud.controllers.produto;

import com.senai.crud.dtos.produto.ListarProdutoDTO;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.services.ProdutoService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
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
    public String obterProdutoLista(Model model, HttpServletRequest requisicao){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() == 0){

            return "redirect:/login";
        }

        List<ListarProdutoDTO> listarProdutoDTO = service.listarProdutos();
        model.addAttribute("listarProdutoDTO", listarProdutoDTO);

        return "produtolista";
    }
}
