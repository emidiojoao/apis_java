package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.AtualizarUsuarioDto;
import com.senai.crud.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarioatualizar")
public class AtualizarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterUsuario(Model model, @PathVariable Long id){

        AtualizarUsuarioDto atualizarUsuarioDto = service.atualizarUsuarioPorId(id);

        model.addAttribute("usuarioAtualizarDto", atualizarUsuarioDto);
        return "atualizarusuario";
    }

    @PostMapping("/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute("usuarioAtualizarDto") AtualizarUsuarioDto usuarioDto){

        Boolean sucesso = service.atualizarUsuario(id, usuarioDto);

        if(sucesso){
            return "redirect:/listausuario";
        }
        return "redirect:/listausuario?erro";
    }

}
