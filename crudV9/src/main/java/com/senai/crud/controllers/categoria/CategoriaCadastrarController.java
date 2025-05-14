package com.senai.crud.controllers.categoria;

import com.senai.crud.dtos.categoria.RequisicaoCategoriaDTO;
import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/cadastro-categoria")
public class CategoriaCadastrarController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public String obterCadastro(Model model){

        RequisicaoCategoriaDTO requisicaoCategoriaDTO = new RequisicaoCategoriaDTO();
        model.addAttribute("requisicaoCategoriaDTO", requisicaoCategoriaDTO);

        return "categoriacadastro";
    }
}
