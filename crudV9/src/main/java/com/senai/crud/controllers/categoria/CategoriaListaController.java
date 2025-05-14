package com.senai.crud.controllers.categoria;

import com.senai.crud.dtos.categoria.ListaCategoriaDTO;
import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-categoria")
public class CategoriaListaController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public String obterListaCategoria(Model model){

        List<ListaCategoriaDTO> listaCategoriaDTO = service.listaCategoria();
        model.addAttribute("listaCategotiaDTO", listaCategoriaDTO);

        return "categorialista";
    }
}
