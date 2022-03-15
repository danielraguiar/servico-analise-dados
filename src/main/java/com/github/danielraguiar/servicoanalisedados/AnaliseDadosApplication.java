package com.github.danielraguiar.servicoanalisedados;

import com.github.danielraguiar.servicoanalisedados.Enum.TipoDadoEnum;
import com.github.danielraguiar.servicoanalisedados.config.PathConfig;
import com.github.danielraguiar.servicoanalisedados.util.FileUtil;
import com.github.danielraguiar.servicoanalisedados.util.MessagesUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AnaliseDadosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnaliseDadosApplication.class, args);
    }

}
