package cn.edu.zucc.stumanager.dto;

import cn.edu.zucc.stumanager.databean.CheckEntity;

import java.util.Date;

public class CheckDTO {

    private int id;
    private int curId;
    private String curName;
    private Date checkDate;
    private int shouldNum;
    private int lateNum;
    private int notNum;

    public CheckDTO(){

    }

    public CheckDTO(CheckEntity check){
        super();
        this.checkDate = check.getCheckDate();
        this.curId = check.getCurId();
        this.id = check.getId();
        this.lateNum = check.getLateNum();
        this.notNum = check.getNotNum();
        this.shouldNum = check.getShouldNum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurId() {
        return curId;
    }

    public void setCurId(int curId) {
        this.curId = curId;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public int getShouldNum() {
        return shouldNum;
    }

    public void setShouldNum(int shouldNum) {
        this.shouldNum = shouldNum;
    }

    public int getLateNum() {
        return lateNum;
    }

    public void setLateNum(int lateNum) {
        this.lateNum = lateNum;
    }

    public int getNotNum() {
        return notNum;
    }

    public void setNotNum(int notNum) {
        this.notNum = notNum;
    }
}
