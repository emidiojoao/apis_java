package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.usuario.AtualizarUsuarioDTO;
import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.UsuarioService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-usuario")
public class UsuarioAtualizarController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterUsuario(Model model, @PathVariable Long id, HttpServletRequest requisicao){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(requisicao);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        AtualizarUsuarioDTO usuarioCadastroDto = service.buscarUsuarioId(id);
        if (usuarioCadastroDto.getId() == 0){
            //--Não encontrou o usuário!
            return "redirect:/usuariolista";
        }

        model.addAttribute("usuarioAtualizarDTO", usuarioCadastroDto);
        return "usuarioatualizar";
    }

    @PostMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute("usuarioAtualizarDTO") AtualizarUsuarioDTO atualizarUsuarioDTO, RedirectAttributes redirectAttributes){

        try {
            service.atualizarUsuario(id, atualizarUsuarioDTO);
            return "redirect:/lista-usuario?sucesso";
        } catch (InvalidOperationException ex){
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/atualizar-usuario/" + id;
        }
    }

}
