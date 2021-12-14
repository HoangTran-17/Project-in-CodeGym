package vn.na.ho.coffee.services;


import vn.na.ho.coffee.model.OrderDetail;

import java.util.List;

public interface IOrderDetailServices {
    OrderDetail getById(int id);
    List<OrderDetail> getOrderDetail();
    void addOrderDetail(OrderDetail newOrderDetail);
    void updateOrderDetail(OrderDetail orderDetail);
}
