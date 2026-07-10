package com.gustavoronchi.microsservico_cartao.infra.repository;

import com.gustavoronchi.microsservico_cartao.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
