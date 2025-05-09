package com.senai.crud.controllers;

import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.RequestDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterCadastro(Model model){

        RequestDto cadastroDto = new RequestDto();
        model.addAttribute("cadastroDto",cadastroDto);

        return "cadastro";
    }

    @PostMapping
    public String realizarCadastro(@ModelAttribute("cadastroDto") RequestDto cadastroDto){

        MensagemDto messagem = service.adicionarUsuario(cadastroDto);

        if (messagem.isSucesso()){
            return "redirect:/cadastro?sucesso";
        }

        return "redirect:/cadastro?erro";
    }

}
