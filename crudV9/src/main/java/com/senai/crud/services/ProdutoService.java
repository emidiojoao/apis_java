package com.senai.crud.services;

import com.senai.crud.dtos.produto.CadastrarProdutoDTO;
import com.senai.crud.dtos.produto.ListarProdutoDTO;
import com.senai.crud.dtos.produto.AtualizarProdutoDTO;
import com.senai.crud.dtos.produto.ObterProdutoDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ListarProdutoDTO> listarProdutos(){

        List<ProdutoModel> listaProdutoModel = repository.findAll();
        List<ListarProdutoDTO> listarProdutoDto = new ArrayList<>();

        for (ProdutoModel produto :  listaProdutoModel){

            ListarProdutoDTO produtoRetorno = new ListarProdutoDTO();

            produtoRetorno.setId(produto.getId());
            produtoRetorno.setNome(produto.getNome());
            produtoRetorno.setDescricao(produto.getDescricao());
            produtoRetorno.setQuantidade(produto.getQuantidade());
            produtoRetorno.setPreco(produto.getPreco());

            listarProdutoDto.add(produtoRetorno);
        }

        return listarProdutoDto;
    }

    public void cadastrarProduto(CadastrarProdutoDTO cadastrarProdutoDTO){

        Optional<ProdutoModel> optionalNome = repository.findByNome(cadastrarProdutoDTO.getNome());
        if(optionalNome.isPresent()){
            throw new InvalidOperationException("Já existe um produto cadastrado com esse nome!");
        }

        if(cadastrarProdutoDTO.getNome().isBlank()){
            throw new InvalidOperationException("O nome do produto é obrigatorio!");
        }

        if(cadastrarProdutoDTO.getPreco() < 0){
            throw new InvalidOperationException("O preço do produto não pode ser negativo!");
        }

        if(cadastrarProdutoDTO.getQuantidade() < 0){
            throw new InvalidOperationException("O estoque não pode ser negativo!");
        }

        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setNome(cadastrarProdutoDTO.getNome());
        produtoModel.setDescricao(cadastrarProdutoDTO.getDescricao());
        produtoModel.setPreco(cadastrarProdutoDTO.getPreco());
        produtoModel.setQuantidade(cadastrarProdutoDTO.getQuantidade());
        repository.save(produtoModel);
    }

    public ObterProdutoDTO obterProdutoPorId(Long id){

        ObterProdutoDTO obterProdutoDTO = new ObterProdutoDTO();
        Optional<ProdutoModel> buscarProduto = repository.findById(id);

        if(buscarProduto.isPresent()){
            obterProdutoDTO.setId(buscarProduto.get().getId());
            obterProdutoDTO.setNome(buscarProduto.get().getNome());
            obterProdutoDTO.setDescricao(buscarProduto.get().getDescricao());
            obterProdutoDTO.setPreco(buscarProduto.get().getPreco());
            obterProdutoDTO.setQuantidade(buscarProduto.get().getQuantidade());
        }

        return obterProdutoDTO;
    }

    public void atualizarProduto(Long id, AtualizarProdutoDTO atualizarProdutoDto){

        Optional<ProdutoModel> buscarProduto = repository.findById(id);
        if(buscarProduto.isEmpty()){
            throw new InvalidOperationException("Produto inexistente!");
        }

        Optional<ProdutoModel> buscarNomeProduto = repository.findByNome(atualizarProdutoDto.getNome());
        if(buscarNomeProduto.isPresent() && !buscarNomeProduto.get().getId().equals(id)){
            throw new InvalidOperationException("Já possui um produto com esse nome!");
        }

        if(atualizarProdutoDto.getNome().isBlank()){
            throw new InvalidOperationException("O nome não pode ser vazio!");
        }

        if(atualizarProdutoDto.getPreco() <= 0){
            throw new InvalidOperationException("O preço não pode ser zerado ou negativo!");
        }

        if(atualizarProdutoDto.getQuantidade() < 0){
            throw new InvalidOperationException("O estoque não pode ser negativo!");
        }

        ProdutoModel produtoModel = buscarProduto.get();

        produtoModel.setNome(atualizarProdutoDto.getNome());
        produtoModel.setDescricao(atualizarProdutoDto.getDescricao());
        produtoModel.setPreco(atualizarProdutoDto.getPreco());
        produtoModel.setQuantidade(atualizarProdutoDto.getQuantidade());
        repository.save(produtoModel);
    }

    public Boolean deletarProduto(Long id){

        Optional<ProdutoModel> buscarProduto = repository.findById(id);

        if(buscarProduto.isPresent()){
            repository.delete(buscarProduto.get());
            return true;
        }
        return false;
    }

}

