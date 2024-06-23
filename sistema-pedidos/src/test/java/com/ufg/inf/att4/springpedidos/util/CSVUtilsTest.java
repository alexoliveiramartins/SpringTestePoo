package com.ufg.inf.att4.springpedidos.util;

import java.nio.file.NoSuchFileException;
import com.ufg.inf.att4.springpedidos.cliente.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVUtilsTest {

    @Test
    public void lerCSVNumberTest() {
        assertThrows(
                NumberFormatException.class,
                () -> {
                    CSVUtils.lerCSV("src/test/resources/internal/cliente.test1.csv", c -> new Cliente(
                            Integer.parseInt(c[0]), c[1], c[2], c[3], c[4], c[5]
                    ));
                });
    }

    @Test
    public void lerCSVMapperTest() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> {
                    CSVUtils.lerCSV("src/test/resources/internal/cliente.test2.csv", c -> new Cliente(
                            Integer.parseInt(c[0]), c[1], c[2], c[3], c[4], c[5]
                    ));
                });
    }

    @Test
    public void lerCSVInvalidFileTest() {
        assertThrows(
                NoSuchFileException.class,
                () -> {
                    CSVUtils.lerCSV("caminhoDesconhecido", c -> new Cliente(
                            Integer.parseInt(c[0]), c[1], c[2], c[3], c[4], c[5]
                    ));
                });
    }
}
