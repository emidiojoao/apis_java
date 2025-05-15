package com.senai.crud.services;

import com.senai.crud.dtos.produto.CadastrarProdutoDTO;
import com.senai.crud.dtos.produto.ListarProdutoDTO;
import com.senai.crud.dtos.produto.RequisicaoProdutoDTO;
import com.senai.crud.dtos.produto.ProdutoDTO;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.CategoriaRepository;
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

    @Autowired
    CategoriaRepository categoriaRepository;

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


        Optional<CategoriaModel> categoriaModelOptional = categoriaRepository.findById(cadastrarProdutoDTO.getCategoriaId());
        if(categoriaModelOptional.isPresent()){
            ProdutoModel produtoModel = new ProdutoModel();

            produtoModel.setNome(cadastrarProdutoDTO.getNome());
            produtoModel.setDescricao(cadastrarProdutoDTO.getDescricao());
            produtoModel.setPreco(cadastrarProdutoDTO.getPreco());
            produtoModel.setQuantidade(cadastrarProdutoDTO.getQuantidade());
            produtoModel.setCategoria(categoriaModelOptional.get());
            repository.save(produtoModel);
        }
    }

    public ProdutoDTO obterProdutoPorId(Long id){

        ProdutoDTO produtoDTO = new ProdutoDTO();
        Optional<ProdutoModel> buscarProduto = repository.findById(id);

        if(buscarProduto.isPresent()){
            produtoDTO.setId(buscarProduto.get().getId());
            produtoDTO.setNome(buscarProduto.get().getNome());
            produtoDTO.setDescricao(buscarProduto.get().getDescricao());
            produtoDTO.setPreco(buscarProduto.get().getPreco());
            produtoDTO.setQuantidade(buscarProduto.get().getQuantidade());
        }

        return produtoDTO;
    }

    public void atualizarProduto(Long id, RequisicaoProdutoDTO requisicaoProdutoDto){

        Optional<ProdutoModel> buscarProduto = repository.findById(id);
        if(buscarProduto.isEmpty()){
            throw new InvalidOperationException("Produto inexistente!");
        }

        Optional<ProdutoModel> buscarNomeProduto = repository.findByNome(requisicaoProdutoDto.getNome());
        if(buscarNomeProduto.isPresent() && !buscarNomeProduto.get().getId().equals(id)){
            throw new InvalidOperationException("Já possui um produto com esse nome!");
        }

        if(requisicaoProdutoDto.getNome().isBlank()){
            throw new InvalidOperationException("O nome não pode ser vazio!");
        }

        if(requisicaoProdutoDto.getPreco() <= 0){
            throw new InvalidOperationException("O preço não pode ser zerado ou negativo!");
        }

        if(requisicaoProdutoDto.getQuantidade() < 0){
            throw new InvalidOperationException("O estoque não pode ser negativo!");
        }

        ProdutoModel produtoModel = buscarProduto.get();

        produtoModel.setNome(requisicaoProdutoDto.getNome());
        produtoModel.setDescricao(requisicaoProdutoDto.getDescricao());
        produtoModel.setPreco(requisicaoProdutoDto.getPreco());
        produtoModel.setQuantidade(requisicaoProdutoDto.getQuantidade());
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

