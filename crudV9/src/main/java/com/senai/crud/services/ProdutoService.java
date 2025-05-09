package com.senai.crud.services;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ProdutoDto> listaProdutos(){

        List<ProdutoModel> listaProdutos = repository.findAll();
        List<ProdutoDto> listaProdutoDto = new ArrayList<>();

        for (ProdutoModel produto :  listaProdutos){

            ProdutoDto produtoRetorno = new ProdutoDto();

            produtoRetorno.setId(produto.getId());
            produtoRetorno.setNome(produto.getNome());
            produtoRetorno.setDescricao(produto.getDescricao());
            produtoRetorno.setQuantidade(produto.getQuantidade());
            produtoRetorno.setPreco(produto.getPreco());

            listaProdutoDto.add(produtoRetorno);
        }

        return listaProdutoDto;
    }

}

