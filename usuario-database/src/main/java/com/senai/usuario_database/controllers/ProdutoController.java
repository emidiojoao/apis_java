package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.MensagemDto;
import com.senai.usuario_database.dtos.ProdutoListaDto;
import com.senai.usuario_database.dtos.ProdutoRequisicaoDto;
import com.senai.usuario_database.services.ProdutoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("produtodeletar")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarProduto(@PathVariable Long id){

        Boolean retorno = service.deletarProduto(id);

        if(retorno){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.status(404).body(false);
    }
}
