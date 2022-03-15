package com.github.danielraguiar.servicoanalisedados.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.github.danielraguiar.servicoanalisedados.model.Cliente;
import com.github.danielraguiar.servicoanalisedados.model.Venda;
import com.github.danielraguiar.servicoanalisedados.model.Vendedor;

@Getter
@Setter
public class RelatorioDto {

    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Venda> vendas;

    public RelatorioDto() {
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }
}
