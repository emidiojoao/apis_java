package com.senai.crud.dtos.produto;

public class ListarProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private double Preco;
    private int quantidade;

    public ListarProdutoDTO() {
    }

    public ListarProdutoDTO(Long id, String nome, String descricao, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        Preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
