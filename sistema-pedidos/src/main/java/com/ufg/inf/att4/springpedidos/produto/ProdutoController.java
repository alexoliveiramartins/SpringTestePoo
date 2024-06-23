package com.ufg.inf.att4.springpedidos.produto;

import java.util.ArrayList;
import java.util.List;

import com.ufg.inf.att4.springpedidos.ApiResponse;
import com.ufg.inf.att4.springpedidos.cliente.ClienteController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.inf.att4.springpedidos.util.CSVUtils;

@RestController
public class ProdutoController {

    private static List<Produto> produtos = new ArrayList<Produto>();
    {
        try {
            ProdutoController.produtos = CSVUtils.lerCSV("src/main/resources/internal/produto.csv", p -> new Produto(
                Integer.parseInt(p[0]), p[1], p[2], Float.parseFloat(p[3]), Integer.parseInt(p[4])
            ));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @GetMapping("/produtos")
    public ResponseEntity<ApiResponse<List<Produto>>> getProdutos() {
        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Sucesso ao listar produtos",
                        ProdutoController.produtos
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ApiResponse<Produto>> getProduto(@PathVariable int id) {
        Produto produto = ProdutoController.produtos.stream().filter(c -> c.getIdProduto() == id).findFirst().orElse(null);

        if (produto != null) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Produto encontrado", produto),
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                new ApiResponse<>("Produto não encontrado", null),
                HttpStatus.NOT_FOUND
        );
    }
}
