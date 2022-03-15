package com.github.danielraguiar.servicoanalisedados.processor;

import com.github.danielraguiar.servicoanalisedados.Enum.TipoDadoEnum;
import com.github.danielraguiar.servicoanalisedados.converter.ClienteConverter;
import com.github.danielraguiar.servicoanalisedados.converter.VendaConverter;
import com.github.danielraguiar.servicoanalisedados.converter.VendedorConverter;
import com.github.danielraguiar.servicoanalisedados.dto.RelatorioDto;
import com.github.danielraguiar.servicoanalisedados.model.Item;
import com.github.danielraguiar.servicoanalisedados.model.Venda;
import com.github.danielraguiar.servicoanalisedados.util.FileUtil;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

@Component
public class InputFileProcessor {

    private final String SPLIT_LINE = "ç";

    public RelatorioDto processamento(Path path) {

        List<String> linhas = FileUtil.readFile(path);
        RelatorioDto dto = new RelatorioDto();

        linhas.forEach(linha -> {
            String[] atributos = linha.split(SPLIT_LINE);
            switch (TipoDadoEnum.getValue(atributos[0])) {
                case CLIENTE:
                    dto.getClientes().add(ClienteConverter.converter(atributos));
                    break;
                case VENDEDOR:
                    dto.getVendedores().add(VendedorConverter.converter(atributos));
                    break;
                case VENDA:
                    Venda venda = VendaConverter.converter(atributos);
                    venda.setValorTotal(venda.getItens().stream()
                            .map(Item::getPreco)
                            .reduce(BigDecimal.ZERO, BigDecimal::add));
                    dto.getVendas().add(venda);
                    break;
            }

        });

        return dto;
    }
}
