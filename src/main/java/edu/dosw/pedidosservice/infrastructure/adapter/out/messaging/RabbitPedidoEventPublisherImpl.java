package edu.dosw.pedidosservice.infrastructure.adapter.out.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import edu.dosw.pedidosservice.domain.model.PedidoCreadoEvent;
import edu.dosw.pedidosservice.domain.port.out.PedidoEventPublisher;
import edu.dosw.pedidosservice.infrastructure.config.RabbitConfig;

@Component
public class RabbitPedidoEventPublisherImpl implements PedidoEventPublisher {

    private final RabbitTemplate rabbit;

    public RabbitPedidoEventPublisherImpl(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void publicarPedidoCreado(PedidoCreadoEvent evento) {
        rabbit.convertAndSend(RabbitConfig.EXCHANGE, "pedido.creado", evento);
    }
}
