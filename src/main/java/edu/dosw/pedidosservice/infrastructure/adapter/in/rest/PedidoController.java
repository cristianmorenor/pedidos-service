package edu.dosw.pedidosservice.infrastructure.adapter.in.rest;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.dosw.pedidosservice.domain.model.CrearPedidoRequest;
import edu.dosw.pedidosservice.domain.port.in.CrearPedidoUseCase;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CrearPedidoUseCase crearPedido;

    public PedidoController(CrearPedidoUseCase crearPedido) {
        this.crearPedido = crearPedido;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> crear(@RequestBody CrearPedidoRequest pedido) {
        String id = crearPedido.crear(pedido);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("pedidoId", id, "estado", "RECIBIDO"));
    }
}
