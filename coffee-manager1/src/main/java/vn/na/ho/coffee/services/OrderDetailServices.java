package vn.na.ho.coffee.services;


import vn.na.ho.coffee.exception.NotFoundException;
import vn.na.ho.coffee.model.OrderDetail;
import vn.na.ho.coffee.repository.IOrderDetailRepository;
import vn.na.ho.coffee.repository.OrderDetailRepository;

import java.util.List;

public class OrderDetailServices implements IOrderDetailServices {
    private IOrderDetailRepository orderDetailRepository;

    public OrderDetailServices() {
        orderDetailRepository = new OrderDetailRepository();
    }

    @Override
    public OrderDetail getById(int id)  {
        OrderDetail orderItem = orderDetailRepository.getById(id);
        if (orderItem == null)
            throw new NotFoundException("OrderItem not found");
        return orderItem;
    }

    @Override
    public List<OrderDetail> getOrderDetail() {
        return orderDetailRepository.getOrderDetail();
    }

    @Override
    public void addOrderDetail(OrderDetail newOrderItem) {
        if (orderDetailRepository.exist(newOrderItem.getId()))
            throw new IllegalArgumentException("OrderItem already exists");
        orderDetailRepository.add(newOrderItem);

    }

    @Override
    public void updateOrderDetail(OrderDetail orderItem) {
        if (orderDetailRepository.exist(orderItem.getId()))
            orderDetailRepository.update(orderItem);
    }
}
