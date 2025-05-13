package com.senai.crud.controllers.commons;

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

        LoginDTO loginDto = new LoginDTO();
        model.addAttribute("loginDto",loginDto);

        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("loginDto") LoginDTO login){

        Boolean sucesso =  service.logar(login);

        if (sucesso){
            return "redirect:/home";
        }

        return "redirect:/login?erro";

    }

}
