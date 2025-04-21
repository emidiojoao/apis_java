package com.senai.usuario_database.dtos;

import com.senai.usuario_database.models.UsuarioModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaUsuarioDto {

    private Long id;
    private String nome;
    private String login;

    public ConsultaUsuarioDto(Long id) {
        this.id = id;
    }

    public ConsultaUsuarioDto of(UsuarioModel model) {
        ConsultaUsuarioDto usuarioDTO = new ConsultaUsuarioDto();
        usuarioDTO.setId(model.getId());
        usuarioDTO.setNome(model.getNome());
        usuarioDTO.setLogin(model.getLogin());

        return usuarioDTO;
    }
}

