package cn.edu.zucc.stumanager.databean;

import javax.persistence.*;

@Entity
@Table(name = "student_choice_course", schema = "stu_grade_manager", catalog = "")
public class StudentChoiceCourseEntity {
    private int id;
    private Integer curId;
    private Integer stuId;
    private Double examScore;
    private Double taskScore;
    private Double nomalScore;
    private Double totalGrade;

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
    @Column(name = "exam_score")
    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    @Basic
    @Column(name = "task_score")
    public Double getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Double taskScore) {
        this.taskScore = taskScore;
    }

    @Basic
    @Column(name = "nomal_score")
    public Double getNomalScore() {
        return nomalScore;
    }

    public void setNomalScore(Double nomalScore) {
        this.nomalScore = nomalScore;
    }

    @Basic
    @Column(name = "total_grade")
    public Double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentChoiceCourseEntity that = (StudentChoiceCourseEntity) o;

        if (id != that.id) return false;
        if (curId != null ? !curId.equals(that.curId) : that.curId != null) return false;
        if (stuId != null ? !stuId.equals(that.stuId) : that.stuId != null) return false;
        if (examScore != null ? !examScore.equals(that.examScore) : that.examScore != null) return false;
        if (taskScore != null ? !taskScore.equals(that.taskScore) : that.taskScore != null) return false;
        if (nomalScore != null ? !nomalScore.equals(that.nomalScore) : that.nomalScore != null) return false;
        if (totalGrade != null ? !totalGrade.equals(that.totalGrade) : that.totalGrade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (curId != null ? curId.hashCode() : 0);
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (examScore != null ? examScore.hashCode() : 0);
        result = 31 * result + (taskScore != null ? taskScore.hashCode() : 0);
        result = 31 * result + (nomalScore != null ? nomalScore.hashCode() : 0);
        result = 31 * result + (totalGrade != null ? totalGrade.hashCode() : 0);
        return result;
    }
}
