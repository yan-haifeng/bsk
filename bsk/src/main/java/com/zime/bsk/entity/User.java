package com.zime.bsk.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userNickname;

    private String userPhone;

    private String userPwd;

    private Integer userAge;

    private Integer userSex;

    private Integer userAddressid;

    private Date userCreatetime;

    private Date userChangetime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAddressid() {
        return userAddressid;
    }

    public void setUserAddressid(Integer userAddressid) {
        this.userAddressid = userAddressid;
    }

    public Date getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(Date userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public Date getUserChangetime() {
        return userChangetime;
    }

    public void setUserChangetime(Date userChangetime) {
        this.userChangetime = userChangetime;
    }
}