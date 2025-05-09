package com.senai.crud.controllers;

import com.senai.crud.dtos.*;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto",loginDto);

        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("loginDto") LoginDto login){

        System.out.println(login.getLogin() + " " + login.getSenha());

        MensagemDto mensagem =  service.logar(login);

        if (mensagem.isSucesso()){
            return "redirect:/home";
        }

        return "redirect:/login?erro";

    }

}
