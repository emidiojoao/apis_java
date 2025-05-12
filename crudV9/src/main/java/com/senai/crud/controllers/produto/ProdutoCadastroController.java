package com.senai.crud.controllers.produto;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("cadastro-produto")
public class ProdutoCadastroController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterCadastro(Model model){

        ProdutoDto produtoDto = new ProdutoDto();
        model.addAttribute("produtoDto", produtoDto);

        return "produtocadastro";
    }

    @PostMapping
    public String cadastrarProduto(@ModelAttribute("produtoDto") ProdutoDto produtoDto, RedirectAttributes redirectAttributes){

        try {
            service.cadastrarProduto(produtoDto);
            return "redirect:/produtolista?sucesso";
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/cadastro-produto";
        }
    }
}
