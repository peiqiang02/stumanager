package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TaskEntity;
import cn.edu.zucc.stumanager.utils.DAOUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static cn.edu.zucc.stumanager.utils.CommonTemp.taskMap;

import java.util.List;

@Repository
public class TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public synchronized TaskEntity getTaskByid(int taskid){
        return (TaskEntity) this.sessionFactory.openSession().get(TaskEntity.class,taskid);
    }

    public synchronized List<TaskEntity> getTaskByCurid(int curId, PageBean page){
        String hql = "from TaskEntity where curId = "+curId;
        Session session = this.sessionFactory.openSession();
        Query query =  session.createQuery(hql);

        return DAOUtil.packPage(query,page);
    }

    public synchronized List<TaskEntity> getTask(){
        String hql = "from TaskEntity";
        return this.sessionFactory.openSession().createQuery(hql).list();
    }

    public synchronized void saveTask(TaskEntity task){
        this.sessionFactory.openSession().save(task);
    }


    public void refreshTaskMap(){
        List<TaskEntity> taskList = getTask();
        for (TaskEntity task : taskList) {
            taskMap.put(task.getId(),task);
        }
    }
}
