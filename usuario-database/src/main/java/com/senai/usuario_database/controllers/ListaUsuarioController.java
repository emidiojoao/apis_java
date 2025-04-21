package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ConsultaUsuarioDto;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lista")
public class ListaUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterUserList(
            @RequestParam(value = "user_list_filter", required = false) Long userId,
            Model model) {

        if (userId != null) {
            // Se um ID foi fornecido, busca só esse usuário
            List<ConsultaUsuarioDto> listUsersDTO = new ArrayList<>();

            ConsultaUsuarioDto usuario = service.buscarUsuarioPorId3(userId);
            if (usuario != null) {
                listUsersDTO.add(usuario);
            }

            model.addAttribute("consultaUsuarioDto", listUsersDTO);
        } else {
            // Caso contrário, busca todos
            List<ConsultaUsuarioDto> listUsersDTO = service.listarUsuarios();
            model.addAttribute("consultaUsuarioDto", listUsersDTO);
        }

        return "lista";
    }


}
