package com.senai.crud.controllers.categoria;

import com.senai.crud.dtos.categoria.CategoriaDTO;
import com.senai.crud.dtos.categoria.RequisicaoCategoriaDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-categoria")
public class CategoriaAtualizarController {

    @Autowired
    CategoriaService service;

    @GetMapping("/{id}")
    public String obterCategoria(@PathVariable Long id, Model model){

        CategoriaDTO categoriaDTO = service.buscarCategoriaPorId(id);
        model.addAttribute("categoriaDTO", categoriaDTO);

        return "categoriaatualizar";
    }

    @PostMapping("/{id}")
    public String atualizarCategoria(@PathVariable Long id, @ModelAttribute("categoriaDTO") RequisicaoCategoriaDTO requisicaoCategoriaDTO, RedirectAttributes redirectAttributes){

        try {
            service.atualizarCategoria(id, requisicaoCategoriaDTO);
            return "redirect:/lista-categoria?sucesso";
        } catch (InvalidOperationException ex){
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/atualizar-categoria/" + id;
        }
    }
}
