package com.senai.crud.controllers.commons;

import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @PostMapping
    public String obterLogout(HttpServletRequest requesicao){

        ControleSessao.encerrar(requesicao);
        return "redirect:/login";
    }
}
