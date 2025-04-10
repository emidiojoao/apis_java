package com.senai.usuario_database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class UsuarioHome {

    @GetMapping
    public String obterHome(){

        return "home";
    }
}
