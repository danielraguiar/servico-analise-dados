package com.github.danielraguiar.servicoanalisedados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.danielraguiar.servicoanalisedados.processor.RelatorioProcessor;

@Controller
public class RelatorioVendasController {

    @Autowired
    public RelatorioVendasController(RelatorioProcessor processor) {
        processor.start();
    }
}
