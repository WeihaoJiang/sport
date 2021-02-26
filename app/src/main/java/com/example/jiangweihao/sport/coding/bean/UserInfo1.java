package com.example.jiangweihao.sport.coding.bean;

/**
 * Created by huang on 2017/11/1.
 */
public class UserInfo1 {
    private String name;
    private int age;
    private String time;
    private ChildData childData;
    private String content;
    private String url;
    private Boolean isTest;


    public UserInfo1(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String check) {
        content = check;
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
