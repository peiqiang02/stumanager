package cn.edu.zucc.stumanager.dto;

import cn.edu.zucc.stumanager.databean.CourseEntity;

public class CourseDTO {

    private int curId;
    private String curName;
    private int teaId;
    private String curIntroduction;
    private String teaName;

    public CourseDTO(){

    }

    public CourseDTO(CourseEntity course){
        super();
        this.curId = course.getCurId();
        this.curIntroduction = course.getCurIntroduction();
        this.curName = course.getCurName();
        this.teaId = course.getTeaId();
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

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getCurIntroduction() {
        return curIntroduction;
    }

    public void setCurIntroduction(String curIntroduction) {
        this.curIntroduction = curIntroduction;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
