package com.gustavoronchi.microsservico_cartao.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao() {
    }

    public Cartao(Long id, String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.id = id;
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }
}
