package com.senai.usuario_database.repositories;

import com.senai.usuario_database.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String Nome);

}
