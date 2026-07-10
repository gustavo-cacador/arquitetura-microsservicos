package com.gustavoronchi.microsservico_cartao.dto;

import com.gustavoronchi.microsservico_cartao.domain.CartaoCliente;

import java.math.BigDecimal;

public class CartaoClienteDto {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public CartaoClienteDto() {
    }

    public CartaoClienteDto(String nome, String bandeira, BigDecimal limiteLiberado) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.limiteLiberado = limiteLiberado;
    }

    public static CartaoClienteDto fromModel(CartaoCliente model) {
        return new CartaoClienteDto(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(BigDecimal limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }
}



