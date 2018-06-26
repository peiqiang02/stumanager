package cn.edu.zucc.stumanager.databean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "check", schema = "stu_grade_manager", catalog = "")
public class CheckEntity {
    private int id;
    private int curId;
    private Timestamp checkDate;
    private int shouldNum;
    private int lateNum;
    private int notNum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cur_id")
    public int getCurId() {
        return curId;
    }

    public void setCurId(int curId) {
        this.curId = curId;
    }

    @Basic
    @Column(name = "check_date")
    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "shouldNum")
    public int getShouldNum() {
        return shouldNum;
    }

    public void setShouldNum(int shouldNum) {
        this.shouldNum = shouldNum;
    }

    @Basic
    @Column(name = "lateNum")
    public int getLateNum() {
        return lateNum;
    }

    public void setLateNum(int lateNum) {
        this.lateNum = lateNum;
    }

    @Basic
    @Column(name = "notNum")
    public int getNotNum() {
        return notNum;
    }

    public void setNotNum(int notNum) {
        this.notNum = notNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckEntity that = (CheckEntity) o;

        if (id != that.id) return false;
        if (curId != that.curId) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + curId;
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        return result;
    }
}
