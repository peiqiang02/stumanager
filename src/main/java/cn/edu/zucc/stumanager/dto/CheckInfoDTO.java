package cn.edu.zucc.stumanager.dto;

import cn.edu.zucc.stumanager.databean.CheckInfoEntity;

public class CheckInfoDTO {

    private int id;
    private Integer checkId;
    private Integer stuId;
    private String stuName;
    private String state;

    public CheckInfoDTO(){

    }

    public CheckInfoDTO(CheckInfoEntity checkInfo){
        this.id = checkInfo.getId();
        this.checkId = checkInfo.getCheckId();
        this.stuId = checkInfo.getStuId();
        this.state = checkInfo.getState();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
