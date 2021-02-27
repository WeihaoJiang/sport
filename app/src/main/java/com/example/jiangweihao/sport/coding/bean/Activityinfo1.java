package com.example.jiangweihao.sport.coding.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by huang on 2017/11/1.
 */
public class Activityinfo1 implements Serializable {

    private String name;
    private int num, totalNum;
    private String time;
    private ChildData childData;
    private String activityAddress;
    private String url;
    private Boolean isSuccess;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    byte image[] = new byte[125*250];


    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Boolean getSuccess() {
        isSuccess = false;
        if (num >= totalNum){
            isSuccess = true;
        }
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Activityinfo1(String name, int totalNum,String time, String activityAddress) {
        this.name = name;
        this.num = totalNum -num;
        this.totalNum = totalNum;
        this.time = time;
        this.activityAddress = activityAddress;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String check) {
        activityAddress = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ChildData getChildData() {
        return childData;
    }

    public void setChildData(ChildData childData) {
        this.childData = childData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
