package com.senai.crud.controllers.categoria;

import com.senai.crud.dtos.categoria.ListaCategoriaDTO;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-categoria")
public class CategoriaListarController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public String obterListaCategoria(Model model, HttpServletRequest requisicao){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        List<ListaCategoriaDTO> listaCategoriaDTO = service.listaCategoria();
        model.addAttribute("listaCategoriaDTO", listaCategoriaDTO);

        return "categorialista";
    }
}
