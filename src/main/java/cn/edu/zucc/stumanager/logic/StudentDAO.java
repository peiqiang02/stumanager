package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static cn.edu.zucc.stumanager.utils.CommonTemp.studentMap;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public int saveStudent(StudentEntity student){
        return (int) this.sessionFactory.openSession().save(student);
    }

    public synchronized StudentEntity getStudent(StudentEntity student){
        return (StudentEntity) this.sessionFactory.openSession().get(StudentEntity.class,student.getStuId());
    }

    public synchronized void deleteStudent(StudentEntity student){
        this.sessionFactory.openSession().delete(student);
    }

    public synchronized StudentEntity getStudentByid(int id){
        return (StudentEntity) this.sessionFactory.openSession().get(StudentEntity.class,id);
    }

    public List<StudentEntity> getAllStudent(){
        String hql = "from StudentEntity order by stuId";
        return this.sessionFactory.openSession().createQuery(hql).list();
    }

    public  void refreshStuMap(){
        List<StudentEntity> studentList = getAllStudent();
        for (StudentEntity student : studentList) {
            studentMap.put(student.getStuId(),student);
        }
    }
}
