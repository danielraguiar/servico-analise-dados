package com.github.danielraguiar.servicoanalisedados.converter;


import java.math.BigDecimal;

import com.github.danielraguiar.servicoanalisedados.model.Item;

public class ItemConverter {

    private static final String SPLIT_LINE = "-";

    public static Item converter(String linha){
        String[] atributos = linha.split(SPLIT_LINE);
        return Item.builder()
                .id(Long.parseLong(atributos[0]))
                .quantidade(Integer.parseInt(atributos[1]))
                .preco(new BigDecimal(atributos[2])).build();
    }

}
