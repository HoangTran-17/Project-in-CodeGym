package vn.na.ho.coffee.model;


import vn.na.ho.coffee.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;



public class Order implements Serializable {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;

    private Date createdAt;

    public Order(int id, String name, String phoneNumber, String address, Date createdAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;

        this.createdAt = createdAt;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public static void  transferFields(Order oldOrder, Order newOrder){
        oldOrder.id = newOrder.id;
        oldOrder.name = newOrder.name;
        oldOrder.phoneNumber = newOrder.phoneNumber;
        oldOrder.address = newOrder.address;

        oldOrder.createdAt = newOrder.createdAt;

    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s",id,name,phoneNumber,address,DateUtils.dateToString(createdAt)) ;
    }

    public Order(String raw){
        String[] fileds = raw.split(",");
        id = Integer.parseInt(fileds[0]);
        name = fileds[1];
        phoneNumber = fileds[2];
        address = fileds[3];
        createdAt = DateUtils.stringToDate(fileds[4]);
    }
}
