package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.AutenticarUsuarioDto;
import com.senai.usuario_database.dtos.MensagemDto;
import com.senai.usuario_database.dtos.RequisicaoDto;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class UsuarioAuth {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){

        AutenticarUsuarioDto autenticarUsuarioDto = new AutenticarUsuarioDto();
        model.addAttribute(" ", autenticarUsuarioDto);

        return "login";
    }

    @PostMapping
    public String autenticarUsuario(@ModelAttribute("autenticarUsuarioDto") AutenticarUsuarioDto dados){

        System.out.println(dados.getLogin() + " " + dados.getSenha());

        return "login";
    }
}
