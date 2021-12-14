package vn.na.ho.coffee.services;


import vn.na.ho.coffee.model.Order;

import java.util.List;

public interface IOrderServices {

    Order getById(int id);

    List<Order> getOrder();

    void addOrder(Order newOrder);

    void updateOrder(Order order);
}
