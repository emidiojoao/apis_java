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
public class CategoriaDTO {

    private Long id;
    private String nome;

    public static CategoriaDTO of(CategoriaModel model) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(model.getId());
        categoriaDTO.setNome(model.getNome());

        return categoriaDTO;
    }
}
