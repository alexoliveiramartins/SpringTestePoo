package com.ufg.inf.att4.springpedidos.cliente;

import com.ufg.inf.att4.springpedidos.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    @Test
    public void getClientesTest() {
        ClienteController cc = new ClienteController();
        ResponseEntity<ApiResponse<List<Cliente>>> response = cc.getClientes();

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCode().value());
        assertFalse(response.getBody().getData().isEmpty());
        assertNotNull(response.getBody().getData().getFirst());
    }

    @Test
    public void getClienteTest() {
        ClienteController cc = new ClienteController();
        ResponseEntity<ApiResponse<Cliente>> responseSuccess = cc.getCliente(1);
        ResponseEntity<ApiResponse<Cliente>> responseNotFound = cc.getCliente(200);

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
