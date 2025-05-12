package com.senai.crud.controllers.produto;

import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deletar-produto")
public class ProdutoDeletarController {

    @Autowired
    ProdutoService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarProduto(@PathVariable Long id){

        Boolean sucesso = service.deletarProduto(id);

        if(sucesso){
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }
    }
}
