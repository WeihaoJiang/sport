package com.example.jiangweihao.sport.coding.bean;

/**
 * Created by huang on 2017/11/1.
 */
public class UserInfo {
    private String name;
    private int age;
    private long time;
    private ChildData childData;
    private String isCheck;
    private String url;
    private Boolean isTest;


    public UserInfo(String name, int age, long time, String isCheck, ChildData childData) {
        this.name = name;
        this.age = age;
        this.time = time;
        this.childData = childData;
        this.isCheck = isCheck;
    }

    public String isCheck() {
        return isCheck;
    }

    public void setCheck(String check) {
        isCheck = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
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
