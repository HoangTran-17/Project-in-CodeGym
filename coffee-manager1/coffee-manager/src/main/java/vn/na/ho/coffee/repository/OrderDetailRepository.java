package vn.na.ho.coffee.repository;


import vn.na.ho.coffee.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepository implements IOrderDetailRepository {


    public OrderDetailRepository() {
    }


    @Override
    public OrderDetail getById(int id) {
        List<OrderDetail> orderDetailList = getOrderDetail();
        for (OrderDetail or : orderDetailList) {
            if (or.getId() == id) {
                return or;
            }
        }
        return null;
    }

    @Override
    public List<OrderDetail> getOrderDetail() {
        List<OrderDetail> newOrderDetailList = new ArrayList<>();
        List<String> records =null;
        for (String record : records) {
            newOrderDetailList .add(new OrderDetail(record));

        }
        return newOrderDetailList ;

    }

    @Override
    public boolean exist(int id) {
        return getById(id) != null;
    }

    @Override
    public void add(OrderDetail newOrderDetail) {
        List<OrderDetail> orderDetailList = getOrderDetail();
        orderDetailList.add(newOrderDetail);


    }

    @Override
    public void update(OrderDetail orderDetail) {
        List<OrderDetail> orderDetailList = getOrderDetail();
        for (OrderDetail or : orderDetailList) {
            if (or.getId() == orderDetail.getId()) {
                OrderDetail.transferFields(or, orderDetail);
            }
        }

    }
}
