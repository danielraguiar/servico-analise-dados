package com.github.danielraguiar.servicoanalisedados.converter;


import com.github.danielraguiar.servicoanalisedados.model.Cliente;

public class ClienteConverter {

    public static Cliente converter(String[] atributos){
        return Cliente.builder()
                .cnpj(atributos[1])
                .nome(atributos[2])
                .areaNegocio(atributos[3]).build();
    }

}
