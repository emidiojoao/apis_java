package com.senai.usuario_database.dtos;

import com.senai.usuario_database.models.UsuarioModel;
import lombok.Data;

@Data
public class UsuarioAtualizarDto {

    private Long id;
    private String nome;
    private String login;
    private String senha;

    public UsuarioAtualizarDto() {
    }

    public UsuarioAtualizarDto(UsuarioModel usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }

    public UsuarioAtualizarDto(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    /*public UsuarioAtualizarDto of(UsuarioModel usuario) {
        UsuarioAtualizarDto newUser = new UsuarioAtualizarDto();
        newUser.setId(usuario.getId());
        newUser.setNome(usuario.getNome());
        newUser.setLogin(usuario.getLogin());
        newUser.setSenha(usuario.getSenha());

        return newUser;
    }*/
}