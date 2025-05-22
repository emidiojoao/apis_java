package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.RequisicaoUsuarioDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro")
public class UsuarioCadastrarController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterCadastro(Model model){

        RequisicaoUsuarioDTO cadastroDto = new RequisicaoUsuarioDTO();
        model.addAttribute("cadastroDto",cadastroDto);

        return "cadastro";
    }

    @PostMapping
    public String realizarCadastro(@ModelAttribute("cadastroDto") RequisicaoUsuarioDTO cadastroDto, RedirectAttributes redirectAttributes){

         try {
             service.adicionarUsuario(cadastroDto);
             return "redirect:/cadastro?sucesso";

         } catch (InvalidOperationException ex) {
             redirectAttributes.addFlashAttribute("erro", ex.getMessage());
             return "redirect:/cadastro";
         }
    }

}
