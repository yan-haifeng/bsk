package com.zime.bsk.entity;

import java.util.List;

public class CakeInfo {
    private Integer cakeId;

    private String cakeName;

    private String cakeEname;

    private String cakeImg;

    private List<String> cakeImgList;

    private Integer cakeClassid;

    private Integer cakeClassminid;

    private Integer cakeSpecsid;

    private List<CakeSpecs> cakeSpecsList;

    private Integer cakeNum;

    private String cakeInfo;

    private Double cakeDiscount;

    private Integer cakeDiscountday;

    public Integer getCakeId() {
        return cakeId;
    }

    public void setCakeId(Integer cakeId) {
        this.cakeId = cakeId;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName == null ? null : cakeName.trim();
    }

    public String getCakeEname() {
        return cakeEname;
    }

    public void setCakeEname(String cakeEname) {
        this.cakeEname = cakeEname == null ? null : cakeEname.trim();
    }

    public String getCakeImg() {
        return cakeImg;
    }

    public void setCakeImg(String cakeImg) {
        this.cakeImg = cakeImg == null ? null : cakeImg.trim();
    }

    public List<String> getCakeImgList() {
        return cakeImgList;
    }

    public void setCakeImgList(List<String> cakeImgList) {
        this.cakeImgList = cakeImgList;
    }

    public Integer getCakeClassid() {
        return cakeClassid;
    }

    public void setCakeClassid(Integer cakeClassid) {
        this.cakeClassid = cakeClassid;
    }

    public Integer getCakeClassminid() {
        return cakeClassminid;
    }

    public void setCakeClassminid(Integer cakeClassminid) {
        this.cakeClassminid = cakeClassminid;
    }

    public Integer getCakeSpecsid() {
        return cakeSpecsid;
    }

    public void setCakeSpecsid(Integer cakeSpecsid) {
        this.cakeSpecsid = cakeSpecsid;
    }

    public List<CakeSpecs> getCakeSpecsList() {
        return cakeSpecsList;
    }

    public void setCakeSpecsList(List<CakeSpecs> cakeSpecsList) {
        this.cakeSpecsList = cakeSpecsList;
    }

    public Integer getCakeNum() {
        return cakeNum;
    }

    public void setCakeNum(Integer cakeNum) {
        this.cakeNum = cakeNum;
    }

    public String getCakeInfo() {
        return cakeInfo;
    }

    public void setCakeInfo(String cakeInfo) {
        this.cakeInfo = cakeInfo == null ? null : cakeInfo.trim();
    }

    public Double getCakeDiscount() {
        return cakeDiscount;
    }

    public void setCakeDiscount(Double cakeDiscount) {
        this.cakeDiscount = cakeDiscount;
    }

    public Integer getCakeDiscountday() {
        return cakeDiscountday;
    }

    public void setCakeDiscountday(Integer cakeDiscountday) {
        this.cakeDiscountday = cakeDiscountday;
    }
}