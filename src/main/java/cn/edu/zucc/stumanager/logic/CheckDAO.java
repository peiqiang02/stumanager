package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.CheckEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import static cn.edu.zucc.stumanager.utils.DAOUtil.*;

@Repository
public class CheckDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public synchronized List<CheckEntity> getCheckByCurid(int curId, PageBean page){
        String hql = "from CheckEntity where curId = "+curId+" order by checkDate";
        Query query =  this.sessionFactory.openSession().createQuery(hql);

        return packPage(query,page);
    }

    public synchronized CheckEntity getCheckByid(int id){
        return (CheckEntity) this.sessionFactory.openSession().get(CheckEntity.class,id);
    }

    public synchronized int saveCheck(CheckEntity check){
        return (int)this.sessionFactory.openSession().save(check);
    }

    public synchronized void updateLateNum(int checkid){
        String procName = "{Call pro_update_lateNum(?)}";
        SQLQuery sqlQuery = this.sessionFactory.openSession().createSQLQuery(procName);
        sqlQuery.setInteger(0,checkid);
        sqlQuery.executeUpdate();
    }

    public synchronized void updateShouldNum(int checkid){
        String procName = "{Call pro_update_shouldNum(?)}";
        SQLQuery sqlQuery = this.sessionFactory.openSession().createSQLQuery(procName);
        sqlQuery.setInteger(0,checkid);
        sqlQuery.executeUpdate();
    }

    public synchronized void updateNotNum(int checkid){
        String procName = "{Call pro_update_notNum(?)}";
        SQLQuery sqlQuery = this.sessionFactory.openSession().createSQLQuery(procName);
        sqlQuery.setInteger(0,checkid);
        sqlQuery.executeUpdate();
    }

}
