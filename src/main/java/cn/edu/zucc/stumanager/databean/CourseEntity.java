package cn.edu.zucc.stumanager.databean;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "stu_grade_manager", catalog = "")
public class CourseEntity {
    private int curId;
    private String curName;
    private int teaId;
    private String curIntroduction;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_id")
    public int getCurId() {
        return curId;
    }

    public void setCurId(int curId) {
        this.curId = curId;
    }

    @Basic
    @Column(name = "cur_name")
    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    @Basic
    @Column(name = "tea_id")
    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "cur_introduction")
    public String getCurIntroduction() {
        return curIntroduction;
    }

    public void setCurIntroduction(String curIntroduction) {
        this.curIntroduction = curIntroduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (curId != that.curId) return false;
        if (teaId != that.teaId) return false;
        if (curName != null ? !curName.equals(that.curName) : that.curName != null) return false;
        if (curIntroduction != null ? !curIntroduction.equals(that.curIntroduction) : that.curIntroduction != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = curId;
        result = 31 * result + (curName != null ? curName.hashCode() : 0);
        result = 31 * result + teaId;
        result = 31 * result + (curIntroduction != null ? curIntroduction.hashCode() : 0);
        return result;
    }
}
