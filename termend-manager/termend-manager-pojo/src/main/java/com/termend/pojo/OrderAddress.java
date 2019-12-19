package com.termend.pojo;

import java.io.Serializable;

/**
 * 订单地址表
 * @author admin
 *
 */
public class OrderAddress implements Serializable{
    private Integer id;//自动增长id

    private String orderId;//订单id

    private String name;//收件人姓名

    private String mobile;//电话

    private Integer gender;//1 - 男士 2 - 女士

    private String address;//地址详情

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}