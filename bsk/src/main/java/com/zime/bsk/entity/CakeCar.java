package com.zime.bsk.entity;

import java.util.List;

public class CakeCar {
    private Integer carId;

    private Integer carUserid;

    private Integer carCakeid;

    private List<CakeInfo> cakeInfoList;

    private Integer carSpecsid;

    private List<CakeSpecs> cakeSpecsList;

    private Integer carNum;

    private Integer carState;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarUserid() {
        return carUserid;
    }

    public void setCarUserid(Integer carUserid) {
        this.carUserid = carUserid;
    }

    public Integer getCarCakeid() {
        return carCakeid;
    }

    public void setCarCakeid(Integer carCakeid) {
        this.carCakeid = carCakeid;
    }

    public List<CakeInfo> getCakeInfoList() {
        return cakeInfoList;
    }

    public void setCakeInfoList(List<CakeInfo> cakeInfoList) {
        this.cakeInfoList = cakeInfoList;
    }

    public Integer getCarSpecsid() {
        return carSpecsid;
    }

    public void setCarSpecsid(Integer carSpecsid) {
        this.carSpecsid = carSpecsid;
    }

    public List<CakeSpecs> getCakeSpecsList() {
        return cakeSpecsList;
    }

    public void setCakeSpecsList(List<CakeSpecs> cakeSpecsList) {
        this.cakeSpecsList = cakeSpecsList;
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Integer getCarState() {
        return carState;
    }

    public void setCarState(Integer carState) {
        this.carState = carState;
    }
}