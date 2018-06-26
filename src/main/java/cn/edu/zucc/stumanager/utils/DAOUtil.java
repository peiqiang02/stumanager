package cn.edu.zucc.stumanager.utils;

import cn.edu.zucc.stumanager.databean.PageBean;
import org.hibernate.Query;

import java.util.List;

public class DAOUtil {

    public static List packPage(Query query, PageBean page){
        int count = query.list().size();
        page.setRowsTotal(count);
        query.setFirstResult((page.getPage()-1)*page.getRows());
        //分页时，一次最多产寻的对象数
        query.setMaxResults(page.getRows());
        return query.list();
    }

}
