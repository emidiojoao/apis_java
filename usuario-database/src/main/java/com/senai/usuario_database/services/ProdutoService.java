package com.senai.usuario_database.services;

import com.senai.usuario_database.dtos.MensagemDto;
import com.senai.usuario_database.dtos.ProdutoDto;
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

    //--Lista todos os produtos
    public List<ProdutoListaDto> listarProdutos(){

        List<ProdutoListaDto> listaProdutoDto = new ArrayList<>();
        List<ProdutoModel> listaProdutoModel = repository.findAll();

        for(ProdutoModel produtoModel : listaProdutoModel){
            ProdutoListaDto produtoDto = new ProdutoListaDto();
            produtoDto.setId(produtoModel.getId());
            produtoDto.setNome(produtoModel.getNome());
            produtoDto.setPreco(produtoModel.getPreco());
            produtoDto.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());

            listaProdutoDto.add(produtoDto);
        }
        return listaProdutoDto;
    }

    //--Cria um novo produto
    public Boolean criarProduto(ProdutoRequisicaoDto produtoDto) {

//        try {
            //--Valida se nome de produto ja existe
            Optional<ProdutoModel> obterProduto = repository.findByNome(produtoDto.getNome());
            if (obterProduto.isPresent()) {
                return false;
            }

            ProdutoModel produtoModel = new ProdutoModel();

            produtoModel.setNome(produtoDto.getNome());
            produtoModel.setDescricao(produtoDto.getDescricao());

            if(produtoDto.getPreco() <= 0 || produtoDto.getQuantidadeEstoque() <= 0) {
                return false;
            }
            produtoModel.setPreco(produtoDto.getPreco());
            produtoModel.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());

            repository.save(produtoModel);

            return true;
//        } catch (IllegalArgumentException ex){
//            throw new RuntimeException("Erro ao salvar produto: " + ex.getMessage(),ex);
//        }
    }

    public ProdutoDto obterProdutoPorId(Long id){

        Optional<ProdutoModel> produtoModel = repository.findById(id);

        if(produtoModel.isEmpty()){
            return new ProdutoDto();
        }

        return ProdutoDto.of(produtoModel.get());
    }

    public Boolean atualizarProduto(Long id, ProdutoDto produtoDto){

        Optional<ProdutoModel> produtoModel = repository.findById(id);

        if(produtoModel.isEmpty()){
            return false;
        }

        ProdutoModel model = produtoModel.get();
        model.setId(produtoDto.getId());
        model.setNome(produtoDto.getNome());
        model.setDescricao(produtoDto.getDescricao());
        model.setPreco(produtoDto.getPreco());
        model.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());

        repository.save(model);
        return true;
    }

    public Boolean deletarProduto(Long id){

        Optional<ProdutoModel> produtoModel = repository.findById(id);

        if(produtoModel.isEmpty()){
            return false;
        }

        repository.delete(produtoModel.get());
        return true;
    }

}
