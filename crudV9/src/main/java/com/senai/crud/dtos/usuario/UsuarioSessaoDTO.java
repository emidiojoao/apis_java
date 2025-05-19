package com.senai.crud.dtos.usuario;

public class UsuarioSessaoDTO {

    private Long id;
    private String nome;

    public UsuarioSessaoDTO() {
        this.id = 0L;
        this.nome = "";
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
}
