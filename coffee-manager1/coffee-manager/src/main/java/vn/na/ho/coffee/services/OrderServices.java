package vn.na.ho.coffee.services;


import vn.na.ho.coffee.exception.NotFoundException;
import vn.na.ho.coffee.model.Order;
import vn.na.ho.coffee.repository.IOrderRepository;
import vn.na.ho.coffee.repository.OrderRepository;

import java.util.List;

public class OrderServices implements IOrderServices {

    private IOrderRepository orderRepository;

    public OrderServices(){
        orderRepository = new OrderRepository();
    }
    @Override
    public Order getById(int id) {
        Order order = orderRepository.getById(id);
        if (order == null)
            throw new NotFoundException("Order not found");
        return order;
    }

    @Override
    public List<Order> getOrder() {
        return orderRepository.getOrder();
    }

    @Override
    public void addOrder(Order newOrder) {
        if (orderRepository.exist(newOrder.getId()))
            throw new IllegalArgumentException("Order already exists");
        orderRepository.add(newOrder);

    }

    @Override
    public void updateOrder(Order order) {
        if (orderRepository.exist(order.getId()))
            orderRepository.update(order);

    }
}
