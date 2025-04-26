package com.senai.usuario_database.dtos;

import com.senai.usuario_database.models.ProdutoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoListaDto {

    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;

    public static ProdutoListaDto of(ProdutoModel produto){
        ProdutoListaDto produtoListaDto = new ProdutoListaDto();
        produtoListaDto.setId(produto.getId());
        produtoListaDto.setNome(produto.getNome());
        produtoListaDto.setPreco(produto.getPreco());
        produtoListaDto.setQuantidadeEstoque(produto.getQuantidadeEstoque());

        return produtoListaDto;
    }

}
