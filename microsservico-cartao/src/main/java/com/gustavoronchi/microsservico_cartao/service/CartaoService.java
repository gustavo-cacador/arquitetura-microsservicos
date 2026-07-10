package com.gustavoronchi.microsservico_cartao.service;

import com.gustavoronchi.microsservico_cartao.domain.Cartao;
import com.gustavoronchi.microsservico_cartao.infra.repository.CartaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Transactional
    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }
}
