package com.gustavoronchi.microsservico_cartao.service;

import com.gustavoronchi.microsservico_cartao.domain.CartaoCliente;
import com.gustavoronchi.microsservico_cartao.infra.repository.CartaoClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoClienteService {

    private final CartaoClienteRepository cartaoClienteRepository;

    public CartaoClienteService(CartaoClienteRepository cartaoClienteRepository) {
        this.cartaoClienteRepository = cartaoClienteRepository;
    }

    public List<CartaoCliente> cartoesPorCpf(String cpf) {
        return cartaoClienteRepository.findByCpf(cpf);
    }
}
