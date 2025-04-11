package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.MensagemDto;
import com.senai.usuario_database.dtos.RequisicaoDto;
import com.senai.usuario_database.services.UsuarioService;
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

        RequisicaoDto cadastroDto = new RequisicaoDto();
        model.addAttribute("cadastroDto",cadastroDto);

        return "cadastro";
    }

    @PostMapping
    public String realizarCadastro(@ModelAttribute("cadastroDto") RequisicaoDto cadastroDto){

        MensagemDto mensagemDto = service.adicionarUsuario(cadastroDto);

        if(mensagemDto.getSucesso()){
            return "redirect:/cadastro?sucesso";
        }

        return "redirect:/cadastro?erro";
    }


}
