package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.CheckEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.dto.CheckDTO;
import cn.edu.zucc.stumanager.logic.CheckDAO;
import cn.edu.zucc.stumanager.logic.CheckInfoDAO;
import cn.edu.zucc.stumanager.logic.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CheckService {

    @Autowired
    private CheckDAO checkDAO;

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private CheckInfoDAO checkInfoDAO;

    public PageBean getCheckByCurid(int curId, PageBean page){
        String curName = courseDAO.getCourseById(curId).getCurName();
        List<CheckEntity> temp = checkDAO.getCheckByCurid(curId,page);
        List<CheckDTO> result = new ArrayList<>();
        for (CheckEntity check:temp) {
            CheckDTO checktemp = new CheckDTO(check);
            checktemp.setCurName(curName);
            result.add(checktemp);
        }
        page.setList(result);
        return page;
    }

    public void saveCheck(CheckEntity check){
        int checkId = checkDAO.saveCheck(check);
        checkInfoDAO.insertCheckInfo(checkId,check.getCurId());

    }

    public void saveChecks(List<CheckEntity> checkList){
        for (CheckEntity check:checkList) {
            checkDAO.saveCheck(check);
        }
    }

    public CheckDTO getCheckByid(int id){
        CheckEntity temp = checkDAO.getCheckByid(id);
        CheckDTO result = new CheckDTO(temp);
        result.setCurName(courseDAO.getCourseById(temp.getCurId()).getCurName());
        return result;
    }


}
