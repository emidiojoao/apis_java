package com.senai.usuario_database.controllers;

import com.senai.usuario_database.dtos.ConsultaUsuarioDto;
import com.senai.usuario_database.dtos.MensagemDto;
import com.senai.usuario_database.dtos.RequisicaoDto;
import com.senai.usuario_database.dtos.RespostaDto;
import com.senai.usuario_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud")
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

    @GetMapping("/usuarios")
    public ResponseEntity<List<ConsultaUsuarioDto>> listaUsuarios(){
        List<ConsultaUsuarioDto> listaUsuario = service.listarUsuarios();

        return ResponseEntity.ok().body(listaUsuario);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> obterUsuarioPorId(@PathVariable Long id){
        RespostaDto resposta = service.obterUsuarioPorId(id);
        return ResponseEntity.ok().body(resposta);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> atualizar(@PathVariable Long id, @RequestBody RequisicaoDto dados){

        MensagemDto mensagem = service.atualizarUsuario(id, dados);

        //if(mensagem.getSucesso()){
            return ResponseEntity.ok().body(mensagem);
        //} else {
           // return ResponseEntity.status(404).body(mensagem);
        //}
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
