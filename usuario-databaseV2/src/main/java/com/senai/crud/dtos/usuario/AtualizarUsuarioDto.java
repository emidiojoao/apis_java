package com.senai.crud.dtos.usuario;

import com.senai.crud.models.usuario.UsuarioModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AtualizarUsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public AtualizarUsuarioDto(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public AtualizarUsuarioDto(UsuarioModel usuarioModel){
        this.id = usuarioModel.getId();
        this.nome = usuarioModel.getNome();
        this.email = usuarioModel.getEmail();
        this.senha = usuarioModel.getEmail();
    }
}
