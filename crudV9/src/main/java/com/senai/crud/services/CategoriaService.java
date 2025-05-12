package com.senai.crud.services;

import com.senai.crud.dtos.categoria.CategoriaDTO;
import com.senai.crud.dtos.categoria.ListaCategoriaDTO;
import com.senai.crud.dtos.categoria.RequisicaoCategoriaDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Boolean cadastrarCategoria(RequisicaoCategoriaDTO requisicaoCategoriaDTO){

        Boolean resultado = validaDuplicidade(requisicaoCategoriaDTO.getNome());
        if(resultado){
            throw new InvalidOperationException("Nome de categoria já cadastrado!");
        }

        CategoriaModel categoriaModel = new CategoriaModel();

        categoriaModel.setNome(requisicaoCategoriaDTO.getNome());
        repository.save(categoriaModel);
        return true;
    }

    protected Boolean validaDuplicidade(String nome){
        Optional<CategoriaModel> categoriaModelOptional = repository.findByNome(nome);

        if(categoriaModelOptional.isPresent()){
            return true;
        }
        return false;
    }

    public Boolean atualizarCategoria(Long id, RequisicaoCategoriaDTO requisicaoCategoriaDTO){

        Optional<CategoriaModel> buscarCategoria = repository.findById(id);
        if(buscarCategoria.isEmpty()){
            throw new InvalidOperationException("Cstegoria não encontrada!");
        }

        Boolean sucesso = validaDuplicidade(requisicaoCategoriaDTO.getNome());
        if(sucesso){
            throw new InvalidOperationException("Nome de categoria já cadastrada!");
        }

        CategoriaModel categoriaModel = buscarCategoria.get();

        categoriaModel.setNome(requisicaoCategoriaDTO.getNome());
        repository.save(categoriaModel);
        return true;
    }
}
