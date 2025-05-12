package com.senai.crud.controllers.usuario;

import com.senai.crud.dtos.*;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deletar-usuario")
public class UsuarioDeletarController {

    @Autowired
    UsuarioService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){

        Boolean sucesso = service.removerUsuario(id);

        if(sucesso) {
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }

    }

}
