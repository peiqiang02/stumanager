package cn.edu.zucc.stumanager.dto;

import cn.edu.zucc.stumanager.databean.TaskGradeEntity;

public class TaskGradeDTO {

    private int id;
    private Integer taskId;
    private String taskName;
    private Integer curId;
    private String CurName;
    private Integer stuId;
    private String stuName;
    private Double taskScore;

    public TaskGradeDTO(){

    }

    public TaskGradeDTO(TaskGradeEntity taskGrade){
        this.id = taskGrade.getId();
        this.curId = taskGrade.getCurId();
        this.stuId = taskGrade.getStuId();
        this.taskId = taskGrade.getTaskId();
        this.taskScore = taskGrade.getTaskScore();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    public String getCurName() {
        return CurName;
    }

    public void setCurName(String curName) {
        CurName = curName;
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

    public Double getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Double taskScore) {
        this.taskScore = taskScore;
    }
}
