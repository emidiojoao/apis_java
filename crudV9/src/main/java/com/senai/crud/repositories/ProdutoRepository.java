package com.senai.crud.repositories;

import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Optional<ProdutoModel> findByNome(String nome);
}
