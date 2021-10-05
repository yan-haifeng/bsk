package com.zime.bsk.entity;

import java.util.Date;

public class CakeOrderInfo {
    private Integer orderId;

    private String orderNo;

    private String orderCarid;

    private Integer orderUserid;

    private Date orderTime;

    private Double orderPrice;

    private Double orderDiscount;

    private Integer orderType;

    private Integer orderAddressid;

    private String orderDeliverytime;

    private Integer orderCarriage;

    private Integer orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderCarid() {
        return orderCarid;
    }

    public void setOrderCarid(String orderCarid) {
        this.orderCarid = orderCarid == null ? null : orderCarid.trim();
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderAddressid() {
        return orderAddressid;
    }

    public void setOrderAddressid(Integer orderAddressid) {
        this.orderAddressid = orderAddressid;
    }

    public String getOrderDeliverytime() {
        return orderDeliverytime;
    }

    public void setOrderDeliverytime(String orderDeliverytime) {
        this.orderDeliverytime = orderDeliverytime == null ? null : orderDeliverytime.trim();
    }

    public Integer getOrderCarriage() {
        return orderCarriage;
    }

    public void setOrderCarriage(Integer orderCarriage) {
        this.orderCarriage = orderCarriage;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}