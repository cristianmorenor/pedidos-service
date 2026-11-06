package edu.dosw.pedidosservice.domain.model;

import java.util.List;

public record CrearPedidoRequest(String cliente, List<String> arepas) {}
