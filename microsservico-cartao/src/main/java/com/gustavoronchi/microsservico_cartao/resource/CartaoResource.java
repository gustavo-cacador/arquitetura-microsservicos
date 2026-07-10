package com.gustavoronchi.microsservico_cartao.resource;

import com.gustavoronchi.microsservico_cartao.domain.Cartao;
import com.gustavoronchi.microsservico_cartao.dto.CartaoSaveRequest;
import com.gustavoronchi.microsservico_cartao.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartaoResource {

    private final CartaoService cartaoService;

    public CartaoResource(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<CartaoSaveRequest> cadastra(@RequestBody CartaoSaveRequest cartaoSaveRequest) {
        Cartao cartao = cartaoSaveRequest.toModel();
        cartaoService.salvar(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> buscarCartoesRendaAte(@RequestParam("renda") Long renda) {
        List<Cartao> cartoes = cartaoService.buscarCartaoRendaMenorIgual(renda);
        return ResponseEntity.ok(cartoes);
    }
}
