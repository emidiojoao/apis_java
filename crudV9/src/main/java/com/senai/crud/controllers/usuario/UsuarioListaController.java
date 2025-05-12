package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.ListarUsuarioDTO;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioListaController {

    @Autowired
    UsuarioService service;

    @GetMapping("/lista-usuario")
    public String obterUsuarioLista(Model model){

        List<ListarUsuarioDTO> listarUsuarioDto = service.listarUsuarios();
        model.addAttribute("listarUsuarioDto", listarUsuarioDto);

        return "usuariolista";
    }

}
