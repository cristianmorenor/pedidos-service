package edu.dosw.pedidosservice.domain.port.out;

import edu.dosw.pedidosservice.domain.model.PedidoCreadoEvent;

public interface PedidoEventPublisher {
    void publicarPedidoCreado(PedidoCreadoEvent evento);
}
