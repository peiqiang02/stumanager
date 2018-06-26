package cn.edu.zucc.stumanager.logic;

import cn.edu.zucc.stumanager.databean.CourseEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static cn.edu.zucc.stumanager.utils.CommonTemp.courseMap;

import java.util.List;

import static cn.edu.zucc.stumanager.utils.DAOUtil.*;


@Repository
public class CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<CourseEntity> getCourseListByteaId(int teaId, PageBean page){

        String hql = "from CourseEntity where teaId = "+teaId+" order by curId";
        Session session = this.sessionFactory.openSession();
        Query query =  session.createQuery(hql);
//        int count = query.list().size();
//        page.setRowsTotal(count);
//        query.setFirstResult((page.getPage()-1)*page.getRows());
//        //分页时，一次最多产寻的对象数
//        query.setMaxResults(page.getRows());
//        List<?> list=query.list();
//        page.setList(list);

        return packPage(query,page);
    }

    public List<CourseEntity> getCourseListByteaId(int teaId){

        String hql = "from CourseEntity where teaId = "+teaId+" order by curId";
        Query query =  this.sessionFactory.openSession().createQuery(hql);
        return query.list();
    }

    public void saveCourse(CourseEntity course){
        this.sessionFactory.getCurrentSession().save(course);
    }
    
    public CourseEntity getCourseById(int id){
        return (CourseEntity) this.sessionFactory.openSession().get(CourseEntity.class,id);
    }

    public List<CourseEntity> loadAllCourse(PageBean page){
        String hql = "from CourseEntity order by curId";
        Query query =  this.sessionFactory.openSession().createQuery(hql);
        return packPage(query,page);
    }

    public List<CourseEntity> loadAllCourse(){
        String hql = "from CourseEntity order by curId";
        Query query =  this.sessionFactory.openSession().createQuery(hql);
        return query.list();
    }

    public void refreshCurMap(){
        List<CourseEntity> courseList = loadAllCourse();
        for (CourseEntity course : courseList) {
            courseMap.put(course.getCurId(),course);
        }
    }

}
