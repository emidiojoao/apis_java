package com.senai.crud.controllers.produto;

import com.senai.crud.dtos.categoria.CategoriaDTO;
import com.senai.crud.dtos.categoria.ListaCategoriaDTO;
import com.senai.crud.dtos.produto.CadastrarProdutoDTO;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.ProdutoService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/cadastro-produto")
public class ProdutoCadastrarController {

    @Autowired
    ProdutoService service;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public String obterCadastro(Model model, HttpServletRequest requisicao){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        CadastrarProdutoDTO cadastrarProdutoDTO = new CadastrarProdutoDTO();
        model.addAttribute("cadastrarProdutoDTO", cadastrarProdutoDTO);

        List<ListaCategoriaDTO> listaCategoriaDTO = categoriaService.listaCategoria();
        model.addAttribute("listaCategoriaDTO", listaCategoriaDTO);

        return "produtocadastro";
    }

    @PostMapping
    public String cadastrarProduto(@ModelAttribute("cadastrarProdutoDTO") CadastrarProdutoDTO cadastrarProdutoDTO, RedirectAttributes redirectAttributes){

        try {
            service.cadastrarProduto(cadastrarProdutoDTO);
            return "redirect:/lista-produto?sucesso";
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/cadastro-produto";
        }
    }
}
