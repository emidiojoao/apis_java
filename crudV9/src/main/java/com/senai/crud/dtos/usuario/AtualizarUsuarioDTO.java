package com.senai.crud.dtos.usuario;

import com.senai.crud.models.UsuarioModel;

public class AtualizarUsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;

    public AtualizarUsuarioDTO() {
    }

    public AtualizarUsuarioDTO(Long id) {
        this.id = id;
    }

    //--Construtura criado para receber um Model na hora de criação de um DTO
    public AtualizarUsuarioDTO(UsuarioModel usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }

    public AtualizarUsuarioDTO(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
