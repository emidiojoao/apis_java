package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.ListaUsuarioDto;
import com.senai.crud.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/listausuario")
public class ListaUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLista(Model model){

        List<ListaUsuarioDto> listaUsuarioDto = service.obterUsuarios();

        model.addAttribute("listaUsuarioDto", listaUsuarioDto);

        return "listausuario";

    }
}
