package com.zime.bsk.entity;

public class CakeClass {
    private Integer cakeclassId;

    private String cakeclassName;

    private String cakeclassInfo;

    public Integer getCakeclassId() {
        return cakeclassId;
    }

    public void setCakeclassId(Integer cakeclassId) {
        this.cakeclassId = cakeclassId;
    }

    public String getCakeclassName() {
        return cakeclassName;
    }

    public void setCakeclassName(String cakeclassName) {
        this.cakeclassName = cakeclassName == null ? null : cakeclassName.trim();
    }

    public String getCakeclassInfo() {
        return cakeclassInfo;
    }

    public void setCakeclassInfo(String cakeclassInfo) {
        this.cakeclassInfo = cakeclassInfo == null ? null : cakeclassInfo.trim();
    }
}