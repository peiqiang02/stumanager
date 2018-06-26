package cn.edu.zucc.stumanager.databean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task", schema = "stu_grade_manager", catalog = "")
public class TaskEntity {
    private int id;
    private String taskName;
    private Timestamp taskDate;
    private String taskContent;
    private Integer curId;

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
    @Column(name = "task_name")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "task_date")
    public Timestamp getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Timestamp taskDate) {
        this.taskDate = taskDate;
    }

    @Basic
    @Column(name = "task_content")
    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    @Basic
    @Column(name = "cur_id")
    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (id != that.id) return false;
        if (taskName != null ? !taskName.equals(that.taskName) : that.taskName != null) return false;
        if (taskDate != null ? !taskDate.equals(that.taskDate) : that.taskDate != null) return false;
        if (taskContent != null ? !taskContent.equals(that.taskContent) : that.taskContent != null) return false;
        if (curId != null ? !curId.equals(that.curId) : that.curId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (taskDate != null ? taskDate.hashCode() : 0);
        result = 31 * result + (taskContent != null ? taskContent.hashCode() : 0);
        result = 31 * result + (curId != null ? curId.hashCode() : 0);
        return result;
    }
}
