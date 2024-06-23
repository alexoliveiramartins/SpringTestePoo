package com.ufg.inf.att4.springpedidos.cliente;

import java.util.ArrayList;
import java.util.List;

import com.ufg.inf.att4.springpedidos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.inf.att4.springpedidos.util.CSVUtils;

@RestController
public class ClienteController {
    private static List<Cliente> clientes = new ArrayList<Cliente>();
    {
        try {
            ClienteController.clientes = CSVUtils.lerCSV("src/main/resources/internal/cliente.csv", c -> new Cliente(
                Integer.parseInt(c[0]), c[1], c[2], c[3], c[4], c[5]
            ));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @GetMapping("/clientes")
    public ResponseEntity<ApiResponse<List<Cliente>>> getClientes() {
        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Sucesso ao listar clientes",
                        ClienteController.clientes
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ApiResponse<Cliente>> getCliente(@PathVariable int id) {
        Cliente cliente = ClienteController.clientes.stream().filter(c -> c.getIdCliente() == id).findFirst().orElse(null);

        if (cliente != null) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Cliente encontrado", cliente),
                    HttpStatus.OK
            );
        }


        return new ResponseEntity<>(
                new ApiResponse<>("Cliente não encontrado", null),
                HttpStatus.NOT_FOUND
        );
    }
}
