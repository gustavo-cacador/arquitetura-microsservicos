package com.gustavoronchi.microsservico_cartao.resource;

import com.gustavoronchi.microsservico_cartao.domain.Cartao;
import com.gustavoronchi.microsservico_cartao.domain.CartaoCliente;
import com.gustavoronchi.microsservico_cartao.dto.CartaoSaveRequest;
import com.gustavoronchi.microsservico_cartao.dto.CartaoClienteDto;
import com.gustavoronchi.microsservico_cartao.service.CartaoClienteService;
import com.gustavoronchi.microsservico_cartao.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
public class CartaoResource {

    private final CartaoService cartaoService;
    private final CartaoClienteService cartaoClienteService;

    public CartaoResource(CartaoService cartaoService, CartaoClienteService cartaoClienteService) {
        this.cartaoService = cartaoService;
        this.cartaoClienteService = cartaoClienteService;
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

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartaoClienteDto>> buscarCartoesPorCliente(@RequestParam("cpf") String cpf) {
        List<CartaoCliente> cartaoClientes = cartaoClienteService.cartoesPorCpf(cpf);
        List<CartaoClienteDto> cartaoClienteResponse = cartaoClientes
                .stream()
                .map(CartaoClienteDto::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cartaoClienteResponse);
    }
}
