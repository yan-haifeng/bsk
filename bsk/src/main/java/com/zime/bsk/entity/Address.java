package com.zime.bsk.entity;

public class Address {
    private Integer addressId;

    private Integer addressUserid;

    private String addressName;

    private String addressNameFirst;

    private String addressPhone;

    private String addressInfo;

    private String addressDetail;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAddressUserid() {
        return addressUserid;
    }

    public void setAddressUserid(Integer addressUserid) {
        this.addressUserid = addressUserid;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getAddressNameFirst() {
        return addressNameFirst;
    }

    public void setAddressNameFirst(String addressNameFirst) {
        this.addressNameFirst = addressNameFirst;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo == null ? null : addressInfo.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

}