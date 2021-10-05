package com.zime.bsk.entity;

public class CakeUserTalk {
    private Integer talkId;

    private Integer talkUserid;

    private Integer talkCakeid;

    private Integer talkCommoditygrade;

    private Integer talkLogisticsgrade;

    private Integer talkServicegrade;

    private Integer talkIsimg;

    private String talkImg;

    private String talkInfo;

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public Integer getTalkUserid() {
        return talkUserid;
    }

    public void setTalkUserid(Integer talkUserid) {
        this.talkUserid = talkUserid;
    }

    public Integer getTalkCakeid() {
        return talkCakeid;
    }

    public void setTalkCakeid(Integer talkCakeid) {
        this.talkCakeid = talkCakeid;
    }

    public Integer getTalkCommoditygrade() {
        return talkCommoditygrade;
    }

    public void setTalkCommoditygrade(Integer talkCommoditygrade) {
        this.talkCommoditygrade = talkCommoditygrade;
    }

    public Integer getTalkLogisticsgrade() {
        return talkLogisticsgrade;
    }

    public void setTalkLogisticsgrade(Integer talkLogisticsgrade) {
        this.talkLogisticsgrade = talkLogisticsgrade;
    }

    public Integer getTalkServicegrade() {
        return talkServicegrade;
    }

    public void setTalkServicegrade(Integer talkServicegrade) {
        this.talkServicegrade = talkServicegrade;
    }

    public Integer getTalkIsimg() {
        return talkIsimg;
    }

    public void setTalkIsimg(Integer talkIsimg) {
        this.talkIsimg = talkIsimg;
    }

    public String getTalkImg() {
        return talkImg;
    }

    public void setTalkImg(String talkImg) {
        this.talkImg = talkImg == null ? null : talkImg.trim();
    }

    public String getTalkInfo() {
        return talkInfo;
    }

    public void setTalkInfo(String talkInfo) {
        this.talkInfo = talkInfo == null ? null : talkInfo.trim();
    }
}