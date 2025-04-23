package com.senai.usuario_database.repositories;

import com.senai.usuario_database.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
