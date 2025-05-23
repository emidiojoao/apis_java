package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.ListarUsuarioDTO;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.services.UsuarioService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
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
    public String obterUsuarioLista(Model model, HttpServletRequest requisicao) {

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        List<ListarUsuarioDTO> listarUsuarioDto = service.listarUsuarios();
        model.addAttribute("listarUsuarioDto", listarUsuarioDto);

        return "usuariolista";
    }
}
