package com.senai.crud.controllers.commons;

import com.senai.crud.dtos.*;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.services.UsuarioService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
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
    public String obterLogin(Model model, HttpServletRequest requisicao){

        // não permitir deletar após logout
        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() != 0){
            ControleSessao.encerrar(requisicao);
        }

        LoginDTO loginDto = new LoginDTO();
        model.addAttribute("loginDto",loginDto);

        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("loginDto") LoginDTO login, HttpServletRequest requisicao){


        UsuarioSessaoDTO usuarioSessaoDTO = service.logar2(login);
        ControleSessao.registrar(requisicao, usuarioSessaoDTO);

        if (usuarioSessaoDTO.getId() != 0L){
            return "redirect:/home";
        }
        return "redirect:/login?erro";
    }

}
