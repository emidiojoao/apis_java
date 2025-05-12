package com.senai.crud.services;

import com.senai.crud.dtos.categoria.CategoriaDTO;
import com.senai.crud.dtos.categoria.ListaCategoriaDTO;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<ListaCategoriaDTO> listaCategoria(){

        List<ListaCategoriaDTO> listaCategoriaDTO = new ArrayList<>();
        List<CategoriaModel> listaCategoriaModel = repository.findAll();

        for(CategoriaModel categoriaModel : listaCategoriaModel){
            ListaCategoriaDTO categoriaDto = new ListaCategoriaDTO();
            categoriaDto.setId(categoriaModel.getId());
            categoriaDto.setNome(categoriaModel.getNome());

            listaCategoriaDTO.add(categoriaDto);
        }

        return listaCategoriaDTO;

    }
}
