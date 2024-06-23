package com.ufg.inf.att4.springpedidos.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUtils {

    // Créditos Caio Vinicius (16/06/2024)
    // Adaptado de: https://blog.cvinicius.com.br/2018/03/lendo-e-manipulando-arquivos-csv-com.html

    public static <T> List<T> lerCSV(String caminho, Function<? super String[], ? extends T> mapper) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(caminho))) {
            return lines.skip(1) // Skip header
                    .map(line -> line.split(","))
                    .map(mapper)
                    .collect(Collectors.toList());
        }
    }
}
