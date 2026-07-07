package com.gustavoronchi.microsservico_cliente.infra.repository;

import com.gustavoronchi.microsservico_cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> buscarPorCpf(String cpf);
}
