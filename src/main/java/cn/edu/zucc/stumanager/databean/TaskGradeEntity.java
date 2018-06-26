package cn.edu.zucc.stumanager.databean;

import javax.persistence.*;

@Entity
@Table(name = "task_grade", schema = "stu_grade_manager", catalog = "")
public class TaskGradeEntity {
    private int id;
    private Integer taskId;
    private Integer curId;
    private Integer stuId;
    private Double taskScore;

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
    @Column(name = "task_id")
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "cur_id")
    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    @Basic
    @Column(name = "stu_id")
    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "task_score")
    public Double getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Double taskScore) {
        this.taskScore = taskScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskGradeEntity that = (TaskGradeEntity) o;

        if (id != that.id) return false;
        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        if (curId != null ? !curId.equals(that.curId) : that.curId != null) return false;
        if (stuId != null ? !stuId.equals(that.stuId) : that.stuId != null) return false;
        if (taskScore != null ? !taskScore.equals(that.taskScore) : that.taskScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (curId != null ? curId.hashCode() : 0);
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (taskScore != null ? taskScore.hashCode() : 0);
        return result;
    }
}
