package com.termend.pojo;

import java.io.Serializable;

public class OrderItem implements Serializable{
    private Integer orderItem;//自动增长id

    private Integer diskId;//菜品id

    private String orderId;//订单id

    private Integer num;//商品购买数量

    private String title;//商品标题

    private Float price;//商品单价

    private Float disPrice;//商品折扣价

    private Float totalPrice;//商品总金额

    private String img;//商品图片地址

    public Integer getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Integer orderItem) {
        this.orderItem = orderItem;
    }

    public Integer getDiskId() {
        return diskId;
    }

    public void setDiskId(Integer diskId) {
        this.diskId = diskId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(Float disPrice) {
        this.disPrice = disPrice;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}