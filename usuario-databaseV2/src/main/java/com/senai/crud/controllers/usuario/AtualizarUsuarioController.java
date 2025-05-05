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

    @GetMapping
    public String obterUsuario(Model model, @PathVariable Long id){

        AtualizarUsuarioDto atualizarUsuarioDto = service.atualizarUsuario(id);

        model.addAttribute("usuarioAtualizarDto", atualizarUsuarioDto);
        return "atualizarusuario";
    }

    @PostMapping("/{id}")
    public String atualizarUsuario(@ModelAttribute("usuarioAtualizarDto") AtualizarUsuarioDto usu)

}
