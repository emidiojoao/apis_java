package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.RequisicaoUsuarioDto;
import com.senai.crud.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastrarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterCadastro(Model model){

        RequisicaoUsuarioDto requisicaoUsuarioDto = new RequisicaoUsuarioDto();
        model.addAttribute("cadastroDto", requisicaoUsuarioDto);

        return "cadastrousuario";
    }

    @PostMapping
    public String cadastrarUsuario(@ModelAttribute("cadastroDto") RequisicaoUsuarioDto cadastroDto){

        Boolean sucesso = service.criarUsuario(cadastroDto);

        if(sucesso){
            return "redirect:/cadastro?sucesso";
        }
        return "redirect:/cadastro?erro";
    }
}
