package cn.edu.zucc.stumanager.databean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = "stu_grade_manager", catalog = "")
public class StudentEntity {
    private int stuId;
    private Integer stuAge;
    private String stuName;
    private String stuSex;
    private String stuMajor;
    private String stuClass;

    @Id
//    @GenericGenerator(name = "generator", strategy = "native")
//    @GeneratedValue(generator = "generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stu_age")
    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    @Basic
    @Column(name = "stu_name")
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "stu_sex")
    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    @Basic
    @Column(name = "stu_major")
    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    @Basic
    @Column(name = "stu_class")
    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (stuId != that.stuId) return false;
        if (stuAge != null ? !stuAge.equals(that.stuAge) : that.stuAge != null) return false;
        if (stuName != null ? !stuName.equals(that.stuName) : that.stuName != null) return false;
        if (stuSex != null ? !stuSex.equals(that.stuSex) : that.stuSex != null) return false;
        if (stuMajor != null ? !stuMajor.equals(that.stuMajor) : that.stuMajor != null) return false;
        if (stuClass != null ? !stuClass.equals(that.stuClass) : that.stuClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuId;
        result = 31 * result + (stuAge != null ? stuAge.hashCode() : 0);
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        result = 31 * result + (stuSex != null ? stuSex.hashCode() : 0);
        result = 31 * result + (stuMajor != null ? stuMajor.hashCode() : 0);
        result = 31 * result + (stuClass != null ? stuClass.hashCode() : 0);
        return result;
    }
}
