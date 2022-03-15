package com.github.danielraguiar.servicoanalisedados.service;

import com.github.danielraguiar.servicoanalisedados.dto.RelatorioDto;
import com.github.danielraguiar.servicoanalisedados.model.Venda;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
public class AnaliseDadosService {

    private RelatorioDto dto;

    public int getQuantidadeClientes() {
        if (dto.getClientes() != null) {
            return dto.getClientes().size();
        }
        return 0;
    }

    public int getQuantidadeVendedores() {
        if (dto.getVendedores() != null) {
            return dto.getVendedores().size();
        }
        return 0;
    }

    public Long getIdVendaMaisCara() {
        if (dto.getVendas() != null) {
            Venda venda = dto.getVendas()
                    .stream()
                    .max(Comparator.comparing(Venda::getValorTotal))
                    .orElse(null);

            if (venda != null) {
                return venda.getIdVenda();
            }
        }

        return null;
    }

    public String getPiorVendedor() {

        if (dto.getVendas() != null && !dto.getVendas().isEmpty()) {

            Map<String, BigDecimal> vendedorVendaMap = dto.getVendas()
                    .stream()
                    .collect(Collectors.groupingBy(Venda::getNomeVendedor,
                            Collectors.reducing(BigDecimal.ZERO, Venda::getValorTotal, BigDecimal::add)));

            Map.Entry<String, BigDecimal> vendedorMenorVenda = Collections.min(vendedorVendaMap.entrySet(),
                    Comparator.comparing(Map.Entry::getValue));

            if (vendedorMenorVenda != null && vendedorMenorVenda.getKey() != null) {
                return vendedorMenorVenda.getKey();
            }
        }

        return "";
    }
}
