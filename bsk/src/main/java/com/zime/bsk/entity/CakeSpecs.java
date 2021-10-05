package com.zime.bsk.entity;

public class CakeSpecs {
    private Integer cakespecsId;

    private Integer cakespecsCakeid;

    private String cakespecsName;

    private Double cakespecsPrice;

    private Integer cakespecsSweet;

    private String cakespecsSize;

    private String cakespecsPerson;

    private String cakespecsTableware;

    private String cakespecsTime;

    public Integer getCakespecsId() {
        return cakespecsId;
    }

    public void setCakespecsId(Integer cakespecsId) {
        this.cakespecsId = cakespecsId;
    }

    public Integer getCakespecsCakeid() {
        return cakespecsCakeid;
    }

    public void setCakespecsCakeid(Integer cakespecsCakeid) {
        this.cakespecsCakeid = cakespecsCakeid;
    }

    public String getCakespecsName() {
        return cakespecsName;
    }

    public void setCakespecsName(String cakespecsName) {
        this.cakespecsName = cakespecsName == null ? null : cakespecsName.trim();
    }

    public Double getCakespecsPrice() {
        return cakespecsPrice;
    }

    public void setCakespecsPrice(Double cakespecsPrice) {
        this.cakespecsPrice = cakespecsPrice;
    }

    public Integer getCakespecsSweet() {
        return cakespecsSweet;
    }

    public void setCakespecsSweet(Integer cakespecsSweet) {
        this.cakespecsSweet = cakespecsSweet;
    }

    public String getCakespecsSize() {
        return cakespecsSize;
    }

    public void setCakespecsSize(String cakespecsSize) {
        this.cakespecsSize = cakespecsSize == null ? null : cakespecsSize.trim();
    }

    public String getCakespecsPerson() {
        return cakespecsPerson;
    }

    public void setCakespecsPerson(String cakespecsPerson) {
        this.cakespecsPerson = cakespecsPerson == null ? null : cakespecsPerson.trim();
    }

    public String getCakespecsTableware() {
        return cakespecsTableware;
    }

    public void setCakespecsTableware(String cakespecsTableware) {
        this.cakespecsTableware = cakespecsTableware == null ? null : cakespecsTableware.trim();
    }

    public String getCakespecsTime() {
        return cakespecsTime;
    }

    public void setCakespecsTime(String cakespecsTime) {
        this.cakespecsTime = cakespecsTime == null ? null : cakespecsTime.trim();
    }
}