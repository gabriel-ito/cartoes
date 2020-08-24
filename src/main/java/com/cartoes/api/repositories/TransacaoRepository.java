package com.cartoes.api.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cartoes.api.entities.Cartao;

public interface TransacaoRepository extends JpaRepository<Cartao, Integer> {

	@Query("SELECT ca FROM Cartao ca WHERE ca.cartao.id = :cartaoId")
	List<Cartao> findByCartaoId(@Param("cartaoId") int cartaoid);
}