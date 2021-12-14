package vn.na.ho.coffee.repository;


import vn.na.ho.coffee.model.Order;

import java.io.IOException;
import java.util.List;

public interface IOrderRepository {
   Order getById(int id);
   List<Order> getOrder();
   boolean exist(int id);
   void add(Order newOrder);
   void update(Order order);


}
