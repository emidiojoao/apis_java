package com.senai.usuario_database.repositories;

import com.senai.usuario_database.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String Nome);

}
