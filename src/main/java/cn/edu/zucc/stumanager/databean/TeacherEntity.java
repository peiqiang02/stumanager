package cn.edu.zucc.stumanager.databean;

import javax.persistence.*;

@Entity
@Table(name = "teacher", schema = "stu_grade_manager", catalog = "")
public class TeacherEntity {
    private int teaId;
    private Integer teaAge;
    private String teaName;
    private String teaSex;
    private Integer teaType;
    private String teaPassword;

    @Id

    @Column(name = "tea_id")
    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "tea_age")
    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }

    @Basic
    @Column(name = "tea_name")
    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Basic
    @Column(name = "tea_sex")
    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    @Basic
    @Column(name = "tea_type")
    public Integer getTeaType() {
        return teaType;
    }

    public void setTeaType(Integer teaType) {
        this.teaType = teaType;
    }

    @Basic
    @Column(name = "tea_password")
    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (teaId != that.teaId) return false;
        if (teaAge != null ? !teaAge.equals(that.teaAge) : that.teaAge != null) return false;
        if (teaName != null ? !teaName.equals(that.teaName) : that.teaName != null) return false;
        if (teaSex != null ? !teaSex.equals(that.teaSex) : that.teaSex != null) return false;
        if (teaType != null ? !teaType.equals(that.teaType) : that.teaType != null) return false;
        if (teaPassword != null ? !teaPassword.equals(that.teaPassword) : that.teaPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teaId;
        result = 31 * result + (teaAge != null ? teaAge.hashCode() : 0);
        result = 31 * result + (teaName != null ? teaName.hashCode() : 0);
        result = 31 * result + (teaSex != null ? teaSex.hashCode() : 0);
        result = 31 * result + (teaType != null ? teaType.hashCode() : 0);
        result = 31 * result + (teaPassword != null ? teaPassword.hashCode() : 0);
        return result;
    }
}
