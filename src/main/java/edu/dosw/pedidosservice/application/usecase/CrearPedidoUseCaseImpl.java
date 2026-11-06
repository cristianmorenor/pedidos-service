package edu.dosw.pedidosservice.application.usecase;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;
import edu.dosw.pedidosservice.domain.model.CrearPedidoRequest;
import edu.dosw.pedidosservice.domain.model.PedidoCreadoEvent;
import edu.dosw.pedidosservice.domain.port.in.CrearPedidoUseCase;
import edu.dosw.pedidosservice.domain.port.out.PedidoEventPublisher;

@Service
public class CrearPedidoUseCaseImpl implements CrearPedidoUseCase {

    private final PedidoEventPublisher publisher;

    public CrearPedidoUseCaseImpl(PedidoEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String crear(CrearPedidoRequest pedido) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        publisher.publicarPedidoCreado(new PedidoCreadoEvent(
                id, pedido.cliente(), pedido.arepas(), LocalDateTime.now().toString()));
        return id;
    }
}
