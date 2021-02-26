package com.example.jiangweihao.sport.coding.bean;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable(name="表名")
public class Time {
    @SmartColumn(id =1,name = "日期")
    private String date;
    @SmartColumn(id=2,name="时间")
    private String time;
    @SmartColumn(id = 3,name = "是否可预定")
    private String used;

    public Time(String date, String time, String used) {
        this.date = date;
        this.time = time;
        this.used = used;
    }

    public Time(String s, int nextInt, long l, boolean b, ChildData childData) {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String isUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}

