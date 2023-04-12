package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.OrderDto;

public interface OrderApplication {

    public void createOrder(OrderDto orderDto) throws Exception;
}
