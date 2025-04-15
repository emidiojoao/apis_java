package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.UsuarioAtualizarDto;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarioAtualizar")
public class UsuarioAtualizarController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterCadastro(Model model, @PathVariable Long id){

        UsuarioAtualizarDto usuarioAtualizarDto = service.atualizarUsuarioPorId(id);
        model.addAttribute("usuarioAtualizarDto", usuarioAtualizarDto);
        return "usuarioAtualizar";
    }


}
