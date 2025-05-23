package com.senai.crud.controllers.commons;

import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String obterHome( Model model, HttpServletRequest requesicao){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requesicao);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        model.addAttribute("nomeUsuario",usuarioSessaoDTO.getNome());
        return "home";
    }
}
