package com.zime.bsk.entity;

public class CakeClassMin {
    private Integer cakeclassminId;

    private Integer cakeclassminClassid;

    private String cakeclassminName;

    private String cakeclassminInfo;

    public Integer getCakeclassminId() {
        return cakeclassminId;
    }

    public void setCakeclassminId(Integer cakeclassminId) {
        this.cakeclassminId = cakeclassminId;
    }

    public Integer getCakeclassminClassid() {
        return cakeclassminClassid;
    }

    public void setCakeclassminClassid(Integer cakeclassminClassid) {
        this.cakeclassminClassid = cakeclassminClassid;
    }

    public String getCakeclassminName() {
        return cakeclassminName;
    }

    public void setCakeclassminName(String cakeclassminName) {
        this.cakeclassminName = cakeclassminName == null ? null : cakeclassminName.trim();
    }

    public String getCakeclassminInfo() {
        return cakeclassminInfo;
    }

    public void setCakeclassminInfo(String cakeclassminInfo) {
        this.cakeclassminInfo = cakeclassminInfo == null ? null : cakeclassminInfo.trim();
    }
}