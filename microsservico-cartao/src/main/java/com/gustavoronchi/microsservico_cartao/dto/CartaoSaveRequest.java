package com.gustavoronchi.microsservico_cartao.dto;

import com.gustavoronchi.microsservico_cartao.domain.BandeiraCartao;
import com.gustavoronchi.microsservico_cartao.domain.Cartao;

import java.math.BigDecimal;

public record CartaoSaveRequest(
        Long id,
        String nome,
        BandeiraCartao bandeira,
        BigDecimal renda,
        BigDecimal limite) {

    public Cartao toModel() {
        return new Cartao(id, nome, bandeira, renda, limite);
    }
}
