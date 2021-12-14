package vn.na.ho.coffee.model;


import java.io.Serializable;



public class OrderDetail implements Serializable {
    private int id;
    private int quantity;
    private long price;
    private int drinkId;
    private String drinkName;
    private long total ;
    private long idOrder;

    public OrderDetail() {
    }

    public OrderDetail(int id, int drinkId, String drinkName, long price, int quantity, long total, long idOrder) {
        this.id = id;
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.idOrder = idOrder;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%s,%d,%d,%d,%d",id,drinkId,drinkName,price,quantity,total,idOrder);
    }

    public static void  transferFields(OrderDetail oldOrderdetail, OrderDetail newOrderDetail){
        oldOrderdetail.id = newOrderDetail.id;
        oldOrderdetail.quantity = newOrderDetail.quantity;
        oldOrderdetail.price = newOrderDetail.price;
        oldOrderdetail.drinkId = newOrderDetail.drinkId;
        oldOrderdetail.drinkName = newOrderDetail.drinkName;
        oldOrderdetail.total = newOrderDetail.total;
        oldOrderdetail.idOrder = newOrderDetail.idOrder;
    }
    public OrderDetail(String raw){
        String[] fields = raw.split(",");
        id = Integer.parseInt(fields[0]);
        drinkId = Integer.parseInt(fields[1]);
        drinkName = fields[2];
        price = Long.parseLong(fields[3]);
        quantity = Integer.parseInt(fields[4]);
        total = Long.parseLong(fields[5]);
        idOrder = Long.parseLong(fields[6]);

    }
}
