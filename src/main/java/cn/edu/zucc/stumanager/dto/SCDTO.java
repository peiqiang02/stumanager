package cn.edu.zucc.stumanager.dto;

import cn.edu.zucc.stumanager.databean.StudentChoiceCourseEntity;

public class SCDTO {

    private int id;
    private Integer curId;
    private String curName;
    private Integer stuId;
    private String stuName;
    private Double examScore;
    private Double taskScore;
    private Double nomalScore;
    private Double totalGrade;

    public SCDTO(){

    }

    public SCDTO(StudentChoiceCourseEntity sc){
        this.id = sc.getId();
        this.curId = sc.getCurId();
        this.stuId = sc.getStuId();
        this.examScore = sc.getExamScore();
        this.taskScore = sc.getTaskScore();
        this.nomalScore = sc.getNomalScore();
        this.totalGrade = sc.getTotalGrade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
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

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Double getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Double taskScore) {
        this.taskScore = taskScore;
    }

    public Double getNomalScore() {
        return nomalScore;
    }

    public void setNomalScore(Double nomalScore) {
        this.nomalScore = nomalScore;
    }

    public Double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }
}
