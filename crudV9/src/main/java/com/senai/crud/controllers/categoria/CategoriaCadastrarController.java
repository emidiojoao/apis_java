package com.senai.crud.controllers.categoria;

import com.senai.crud.dtos.categoria.RequisicaoCategoriaDTO;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro-categoria")
public class CategoriaCadastrarController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public String obterCadastro(Model model, HttpServletRequest requisicao){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        RequisicaoCategoriaDTO requisicaoCategoriaDTO = new RequisicaoCategoriaDTO();
        model.addAttribute("requisicaoCategoriaDTO", requisicaoCategoriaDTO);

        return "categoriacadastro";
    }

    @PostMapping
    public String criarCategoria(@ModelAttribute("requisicaoCategoriaDTO") RequisicaoCategoriaDTO requisicaoCategoriaDTO, RedirectAttributes redirectAttributes){

        try {
            service.cadastrarCategoria(requisicaoCategoriaDTO);
            return "redirect:/lista-categoria?sucesso";
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/cadastro-categoria";
        }

    }
}
