package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.AutenticarUsuarioDto;
import com.senai.crud.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutenticarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){

        AutenticarUsuarioDto autenticarUsuarioDto = new AutenticarUsuarioDto();
        model.addAttribute("autenticarUsuarioDto", autenticarUsuarioDto);

        return "login";
    }

    @PostMapping
    public String autenticarUsuario(@ModelAttribute("autenciarUsuarioDto") AutenticarUsuarioDto dados){

        Boolean resultado = service.autenticarUsuario(dados);

        if(resultado){
            return "redirect:/home?sucesso";
        }
        return "redicect:/login?erro";
    }
}
