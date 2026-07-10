package com.gustavoronchi.microsservico_cartao.infra.repository;

import com.gustavoronchi.microsservico_cartao.domain.CartaoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoClienteRepository extends JpaRepository<CartaoCliente, Long> {
    List<CartaoCliente> findByCpf(String cpf);
}
