package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.StudentChoiceCourseEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentChoiceCourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public synchronized List<StudentChoiceCourseEntity> getSCByCurId(int curId){
        String hql = "from StudentChoiceCourseEntity where curId = "+curId+" order by id";
        return this.sessionFactory.openSession().createQuery(hql).list();
    }

    public synchronized StudentChoiceCourseEntity getSCById(int id){
        return (StudentChoiceCourseEntity) this.sessionFactory.openSession().get(StudentChoiceCourseEntity.class,id);
    }

    public synchronized void updateSC(StudentChoiceCourseEntity sc){
        String hql = "update StudentChoiceCourseEntity set examScore =" +sc.getExamScore()+
                " ,taskScore ="+sc.getTaskScore()+",nomalScore="+sc.getNomalScore()+",totalGrade="+sc.getTotalGrade()+" where id="+sc.getId();
        this.sessionFactory.openSession().createQuery(hql).executeUpdate();
    }

//    public synchronized void updateSC(StudentChoiceCourseEntity sc){
//        this.sessionFactory.openSession().save(sc);
//    }

    public synchronized void saveSC(StudentChoiceCourseEntity sc){
        this.sessionFactory.openSession().save(sc);
    }

    public StudentChoiceCourseEntity getSC(int curId, int stuId){
        String hql = "from StudentChoiceCourseEntity where curId = ? and stuId = ?";
        return (StudentChoiceCourseEntity) this.sessionFactory.openSession().createQuery(hql).setParameter(0, curId).setParameter(1, stuId).list().get(0);
    }

    public synchronized void deleteSC(StudentChoiceCourseEntity sc){
        this.sessionFactory.openSession().delete(sc);
    }

}
