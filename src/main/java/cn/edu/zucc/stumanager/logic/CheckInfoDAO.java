package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.CheckInfoEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import static cn.edu.zucc.stumanager.utils.DAOUtil.*;

@Repository
public class CheckInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public synchronized CheckInfoEntity getCheckInfo(int id){
        return (CheckInfoEntity) this.sessionFactory.openSession().get(CheckInfoEntity.class,id);
    }

    public synchronized void updateCheckInfo(CheckInfoEntity checkinfo){
        this.sessionFactory.openSession().update(checkinfo);
    }

    public synchronized void saveCheckInfo(CheckInfoEntity checkinfo){
        this.sessionFactory.openSession().save(checkinfo);
    }

    public void insertCheckInfo(int checkId, int curId){
        String sql = "{Call pro_insert_checkInfo(?,?)}";
        SQLQuery query = this.sessionFactory.openSession().createSQLQuery(sql);
        query.setInteger(0,checkId);
        query.setInteger(1, curId);
        query.executeUpdate();
    }


    public void saveAllCheckInfo(List<CheckInfoEntity> list){
        Session session = this.sessionFactory.openSession();
        for (CheckInfoEntity checkInfo : list) {
            session.save(checkInfo);
        }
    }

    public synchronized void deleteCheckInfo(int checkInfoId){
        String hql = "from CheckInfoEntity where id = "+checkInfoId;
        this.sessionFactory.openSession().createQuery(hql).executeUpdate();

    }

    public synchronized void deleteCheckInfoList(int checkId){
        String hql = "delete from CheckInfoEntity where checkId ="+checkId;
        this.sessionFactory.openSession().createQuery(hql).executeUpdate();
    }

    public synchronized List<CheckInfoEntity> loadAllCheckInfo(int checkid, PageBean page){
        String hql = "from CheckInfoEntity where checkId = "+checkid+" order by id";
        Query query = this.sessionFactory.openSession().createQuery(hql);
        return packPage(query,page);
    }

    public synchronized List<CheckInfoEntity> loadAllCheckInfo(int checkid) {
        String hql = "from CheckInfoEntity where checkId = " + checkid + " order by id";
        return this.sessionFactory.openSession().createQuery(hql).list();
    }

}
