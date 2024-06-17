package br.ufg.com.sistema_pedidos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @GetMapping("/")
    public String hello(){
        return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    }

    @GetMapping("/produto")
    public Produto getProduto(){
        Produto produto = new Produto(1, "Camisa", "Camisa do Mengão",10.0);
        return produto;
    }


    @GetMapping("/teste_id")
    public String getProdutoId(String id, String name){
        return "O id do produto é: " + id + " e o nome é: " + name;
    }
}
