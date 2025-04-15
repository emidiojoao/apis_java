package com.senai.usuario_database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @PostMapping
    public String obterLogout(){

        return "redirect:/login?logout";
    }
}
