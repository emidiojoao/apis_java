package com.senai.usuario_database.dtos;

import com.senai.usuario_database.models.ProdutoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoDto {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;

    public static ProdutoDto of(ProdutoModel model){
        ProdutoDto produto = new ProdutoDto();
        produto.setId(model.getId());
        produto.setNome(model.getNome());
        produto.setDescricao(model.getDescricao());
        produto.setPreco(model.getPreco());
        produto.setQuantidadeEstoque(model.getQuantidadeEstoque());

        return produto;
    }

}
