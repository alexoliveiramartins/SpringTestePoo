package com.ufg.inf.att4.springpedidos.produto;

import com.ufg.inf.att4.springpedidos.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {
    @Test
    public void getProdutosTest() {
        ProdutoController pc = new ProdutoController();
        ResponseEntity<ApiResponse<List<Produto>>> response = pc.getProdutos();

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCode().value());
        assertFalse(response.getBody().getData().isEmpty());
        assertNotNull(response.getBody().getData().getFirst());
    }

    @Test
    public void getProdutoTest() {
        ProdutoController pc = new ProdutoController();
        ResponseEntity<ApiResponse<Produto>> responseSuccess = pc.getProduto(1);
        ResponseEntity<ApiResponse<Produto>> responseNotFound = pc.getProduto(200);

        // Verifica se o código de resposta está correto e se data está definido
        assertNotNull(responseSuccess.getBody());
        assertEquals(200, responseSuccess.getStatusCode().value());
        assertNotNull(responseSuccess.getBody().getData());

        // Verifica se o código de resposta está correto e se data é null
        assertNotNull(responseNotFound.getBody());
        assertEquals(404, responseNotFound.getStatusCode().value());
        assertNull(responseNotFound.getBody().getData());
    }
}
