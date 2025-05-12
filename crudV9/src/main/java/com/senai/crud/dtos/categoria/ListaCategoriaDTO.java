package com.senai.crud.dtos.categoria;

import com.senai.crud.models.CategoriaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaCategoriaDTO {

    private Long id;
    private String nome;

    public ListaCategoriaDTO of(CategoriaModel model) {
        ListaCategoriaDTO dto = new ListaCategoriaDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        return dto;
    }
}
