package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ConsultaUsuarioDto;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lista")
public class ListaUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLista(Model model){

        List<ConsultaUsuarioDto> listaUsuarioDto = service.listarUsuarios();
        model.addAttribute("consultaUsuarioDto", listaUsuarioDto);


        return "lista";
    }


}
