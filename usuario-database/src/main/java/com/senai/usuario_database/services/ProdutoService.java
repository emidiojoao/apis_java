package com.senai.usuario_database.services;

import com.senai.usuario_database.dtos.MensagemDto;
import com.senai.usuario_database.dtos.ProdutoListaDto;
import com.senai.usuario_database.dtos.ProdutoRequisicaoDto;
import com.senai.usuario_database.models.ProdutoModel;
import com.senai.usuario_database.models.UsuarioModel;
import com.senai.usuario_database.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ProdutoListaDto> listarProdutos(){

        List<ProdutoListaDto> listaProdutoDto = new ArrayList<>();
        List<ProdutoModel> listaProdutoModel = repository.findAll();

        for(ProdutoModel produtoModel : listaProdutoModel){
            ProdutoListaDto produtoDto = new ProdutoListaDto();
            produtoDto.setId(produtoDto.getId());
            produtoDto.setNome(produtoDto.getNome());
            produtoDto.setPreco(produtoDto.getPreco());
            produtoDto.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());
            listaProdutoDto.add(produtoDto);
        }
        return listaProdutoDto;
    }

    public MensagemDto criarProduto(ProdutoRequisicaoDto produtoDto){
        MensagemDto mensagem =  new MensagemDto();

        Optional<ProdutoModel> obterProduto = repository.findByNome(produtoDto.getNome());
        if(obterProduto.isPresent()){
            mensagem.setSucesso(false);
            return mensagem;
        }

        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setId(produtoDto.getId());
        produtoModel.setNome(produtoDto.getNome());
        produtoModel.setDescricao(produtoDto.getDescricao());
        produtoModel.setPreco(produtoDto.getPreco());
        produtoModel.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());

        return mensagem;
    }

}
