package com.senai.crud.controllers.categoria;

import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deletar-categoria")
public class CategoriaDeletarController {

    @Autowired
    CategoriaService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarCategoria(@PathVariable Long id){

        Boolean sucesso = service.deletarCategoria(id);
        if(sucesso){
            return ResponseEntity.ok().body(true);
        }

        return ResponseEntity.ok().body(false);
    }
}
