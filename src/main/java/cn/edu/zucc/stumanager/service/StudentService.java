package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.StudentChoiceCourseEntity;
import cn.edu.zucc.stumanager.databean.StudentEntity;
import cn.edu.zucc.stumanager.logic.StudentChoiceCourseDAO;
import cn.edu.zucc.stumanager.logic.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentChoiceCourseDAO studentChoiceCourseDAO;

    public StudentEntity getStudentById(int stuId){
        StudentEntity student = new StudentEntity();
        student.setStuId(stuId);
        return studentDAO.getStudent(student);
    }

    public void deleteStuent(StudentEntity student){
        studentDAO.deleteStudent(student);
    }

    public void saveStudent(StudentEntity student){
        studentDAO.saveStudent(student);
    }

    public void saveStudent(StudentEntity student, StudentChoiceCourseEntity sc){
        studentDAO.saveStudent(student);
        studentChoiceCourseDAO.saveSC(sc);
    }

    public StudentEntity getStudentByid(int id){
        return this.studentDAO.getStudentByid(id);
    }
}
