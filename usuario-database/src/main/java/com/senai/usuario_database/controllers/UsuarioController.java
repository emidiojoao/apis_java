package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.*;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crud")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/usuario")
    public ResponseEntity<MensagemDto> criarUsuario(@RequestBody RequisicaoDto requisicao){
        MensagemDto mensagem = service.adicionarUsuario(requisicao);

        if(mensagem.getSucesso()){
            return ResponseEntity.ok().body(mensagem);
        } else {
            return ResponseEntity.status(404).body(mensagem);
        }
    }

    @PostMapping("/usuario/{id}")
    public String atualizar(@ModelAttribute("usuarioAtualizarDto") UsuarioAtualizarDto usuarioAtualizarDto, @PathVariable Long id){

        boolean retorno = service.atualizarUsuario(id, usuarioAtualizarDto);

        if(retorno){
            return "redirect:/lista";
        }
        return "redirect:/usuarioatualizar/" + id.toString() + "?erro";
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> deletarUsuario(@PathVariable Long id){

        MensagemDto mensagem = service.deletarUsuario(id);

        if(mensagem.getSucesso()){
            return ResponseEntity.ok().body(mensagem);
        } else {
            return ResponseEntity.status(404).body(mensagem);
        }
    }
}
