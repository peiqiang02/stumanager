package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TaskGradeEntity;
import cn.edu.zucc.stumanager.utils.DAOUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskGradeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public synchronized TaskGradeEntity getTaskGrade(int id){
        return (TaskGradeEntity) this.sessionFactory.openSession().get(TaskGradeEntity.class,id);
    }

    public synchronized void updateTaskGrade(TaskGradeEntity taskGrade){
        this.sessionFactory.openSession().update(taskGrade);
    }

    public synchronized void saveTaskGrade(TaskGradeEntity taskGrade){
        this.sessionFactory.openSession().save(taskGrade);
    }

    public synchronized void deleteTaskGrade(int taskGradeId){
        String hql = "from TaskGradeEntity where id = "+taskGradeId;
        this.sessionFactory.openSession().createQuery(hql);
    }

    public synchronized List<TaskGradeEntity> loadTaskGtradeByTaskId(int taskid){
        String hql = "from TaskGradeEntity where taskId = "+taskid+" order by id";
        return this.sessionFactory.openSession().createQuery(hql).list();
    }

    public synchronized List<TaskGradeEntity> loadTaskGradeBySC(int curId, int stuId, PageBean page) {
        String hql = "from TaskGradeEntity where curId = " + curId + " and stuId = " + stuId + "order by id";
        Query query = this.sessionFactory.openSession().createQuery(hql);
        return DAOUtil.packPage(query,page);
    }

}
