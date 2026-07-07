package com.gustavoronchi.microsservico_cliente.dto;

import com.gustavoronchi.microsservico_cliente.domain.Cliente;

public record ClienteSaveRequest(Long id, String cpf, String nome, Integer idade) {

    public Cliente toModel() {
        return new Cliente(id, cpf, nome, idade);
    }
}
