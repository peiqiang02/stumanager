package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeacherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public synchronized TeacherEntity getTeacher(int teaId){
        return (TeacherEntity) this.sessionFactory.openSession().get(TeacherEntity.class,teaId);
    }

    public synchronized void saveTeacher(TeacherEntity teacher){
        this.sessionFactory.openSession().save(teacher);
    }

    public List<TeacherEntity> getAllTeacher(){
        String hql = "from TeacherEntity ";
        return this.sessionFactory.openSession().createQuery(hql).list();
    }


}
