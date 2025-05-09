package com.senai.crud.controllers;

import com.senai.crud.dtos.UsuarioAtualizarDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarioatualizar")
public class UsuarioAtualizarController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterUsuario(Model model, @PathVariable Long id){

        UsuarioAtualizarDto usuarioCadastroDto = service.buscarUsuarioId(id);

        if (usuarioCadastroDto.getId() == 0){
            //--Não encontrou o usuário!
            return "redirect:/usuariolista";
        }

        model.addAttribute("usuarioAtualizarDto", usuarioCadastroDto);
        return "usuarioatualizar";

    }

}
