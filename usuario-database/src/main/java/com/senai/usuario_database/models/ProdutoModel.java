package com.senai.usuario_database.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    public ProdutoModel(Long id, String nome, String descricao, Double preco, Integer quantidadeEstoque) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }

    public void setPreco(Double preco) {
        if(preco < 0.0){
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        if(quantidadeEstoque < 0)
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
