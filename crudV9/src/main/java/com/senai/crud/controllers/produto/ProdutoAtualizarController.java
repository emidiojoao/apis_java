package com.senai.crud.controllers.produto;

import com.senai.crud.dtos.produto.RequisicaoProdutoDTO;
import com.senai.crud.dtos.produto.ProdutoDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-produto")
public class ProdutoAtualizarController {

    @Autowired
    ProdutoService service;

    @GetMapping("/{id}")
    public String obterProduto(Model model, @PathVariable Long id){

        ProdutoDTO produtoDTO = service.obterProdutoPorId(id);
        produtoDTO.setId(id);
        model.addAttribute("produtoDTO", produtoDTO);

        return "produtoatualizar";
    }

    @PostMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute("produtoDTO") RequisicaoProdutoDTO requisicaoProdutoDTO, RedirectAttributes redirectAttributes){

        try {

            service.atualizarProduto(id, requisicaoProdutoDTO);
            return "redirect:/lista-produto?sucesso";
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/atualizar-produto/" + id;
        }

    }
}