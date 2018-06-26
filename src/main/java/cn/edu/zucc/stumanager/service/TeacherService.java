package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.TeacherEntity;
import cn.edu.zucc.stumanager.logic.TeacherDAO;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public TeacherEntity login(int teaid){
        return teacherDAO.getTeacher(teaid);
    }

    public void addTeacher(TeacherEntity teacher){
        teacherDAO.saveTeacher(teacher);
    }

}
