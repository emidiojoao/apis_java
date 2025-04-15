package com.senai.usuario_database.dtos;

import lombok.Data;

@Data
public class UsuarioAtualizarDto {

    private Long id;
    private String nome;
    private String login;
    private String senha;

}