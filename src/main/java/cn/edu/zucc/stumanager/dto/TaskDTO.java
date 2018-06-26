package cn.edu.zucc.stumanager.dto;

import cn.edu.zucc.stumanager.databean.TaskEntity;

import java.sql.Timestamp;

public class TaskDTO {

    private int id;
    private String taskName;
    private Timestamp taskDate;
    private String taskContent;
    private Integer curId;
    private String curName;

    public TaskDTO(){

    }

    public TaskDTO(TaskEntity task){
        this.id = task.getId();
        this.taskContent = task.getTaskContent();
        this.taskName = task.getTaskName();
        this.taskDate = task.getTaskDate();
        this.curId = task.getCurId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Timestamp getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Timestamp taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }
}
