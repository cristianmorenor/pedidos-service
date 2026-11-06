package edu.dosw.pedidosservice.domain.port.in;

import edu.dosw.pedidosservice.domain.model.CrearPedidoRequest;

public interface CrearPedidoUseCase {
    String crear(CrearPedidoRequest pedido);
}
