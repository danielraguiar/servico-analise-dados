package com.github.danielraguiar.servicoanalisedados.Enum;

import java.util.Arrays;

import com.github.danielraguiar.servicoanalisedados.util.MessagesUtil;

public enum TipoDadoEnum {

    VENDEDOR("001"), CLIENTE("002"), VENDA("003");

    private final String code;

    TipoDadoEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static TipoDadoEnum getValue(String code) {
        return Arrays.stream(TipoDadoEnum.values())
                .filter(tipo -> tipo.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        MessagesUtil.getMessage("erro.argumento.invalido.tipo.dado", code)));
    }
}
