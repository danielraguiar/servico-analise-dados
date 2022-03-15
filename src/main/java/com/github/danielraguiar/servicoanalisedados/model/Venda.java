package com.github.danielraguiar.servicoanalisedados.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Venda {

    private Long idVenda;
    private String nomeVendedor;
    private List<Item> itens;
    private BigDecimal valorTotal;


}
