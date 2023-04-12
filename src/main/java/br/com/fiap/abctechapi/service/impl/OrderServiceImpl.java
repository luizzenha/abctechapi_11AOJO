package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final AssistanceRepository assistanceRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(
            AssistanceRepository assistanceRepository,
            OrderRepository orderRepository
    ) {
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> assistsId) {
        ArrayList<Assistance> list = new ArrayList<>();
        assistsId.forEach( id -> {
            Assistance assistance = assistanceRepository.findById(id).orElseThrow();
            list.add(assistance);
        });

        order.setAssists(list);

        orderRepository.save(order);
    }
}
