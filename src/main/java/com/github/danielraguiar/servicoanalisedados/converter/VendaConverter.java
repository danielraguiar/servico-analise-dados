package com.github.danielraguiar.servicoanalisedados.converter;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.github.danielraguiar.servicoanalisedados.model.Item;
import com.github.danielraguiar.servicoanalisedados.model.Venda;

public class VendaConverter {

    public static Venda converter(String[] atributos) {
        return Venda.builder()
                .idVenda(Long.parseLong(atributos[1]))
                .itens(converterItens(atributos[2]))
                .nomeVendedor(atributos[3]).build();
    }

    private static List<Item> converterItens(String linha) {
        List<String> itens = Arrays.asList(linha.replaceAll("\\[|]", "").split(","));
        return itens.stream()
                .map(ItemConverter::converter)
                .collect(Collectors.toList());
    }

}
