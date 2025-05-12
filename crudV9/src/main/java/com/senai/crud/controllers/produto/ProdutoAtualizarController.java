package com.senai.crud.controllers.produto;

import com.senai.crud.dtos.AtualizarProdutoDTO;
import com.senai.crud.dtos.ObterProdutoDTO;
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

        ObterProdutoDTO obterProdutoDTO = service.obterProdutoPorId(id);
        model.addAttribute("obterProdutoDTO", obterProdutoDTO);

        return "produtoatualizar";
    }

    @PostMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute("atualizarProdutoDTO") AtualizarProdutoDTO atualizarProdutoDTO, RedirectAttributes redirectAttributes){

        try {

            service.atualizarProduto(id, atualizarProdutoDTO);
            return "redirect:/produtolista?sucesso";
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/atualizar-produto/" + id;
        }

    }
}