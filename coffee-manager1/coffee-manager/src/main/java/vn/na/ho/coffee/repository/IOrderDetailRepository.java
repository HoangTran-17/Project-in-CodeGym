package vn.na.ho.coffee.repository;


import vn.na.ho.coffee.model.OrderDetail;

import java.util.List;

public interface IOrderDetailRepository {
    OrderDetail getById(int id);
    List<OrderDetail> getOrderDetail();
    boolean exist(int id) ;
    void add(OrderDetail newOrderDetail) ;
    void update(OrderDetail orderdetail) ;
}
