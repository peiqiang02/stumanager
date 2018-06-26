package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.CheckInfoEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.dto.CheckInfoDTO;
import cn.edu.zucc.stumanager.logic.CheckDAO;
import cn.edu.zucc.stumanager.logic.CheckInfoDAO;
import cn.edu.zucc.stumanager.logic.StudentDAO;
import cn.edu.zucc.stumanager.utils.CommonTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CheckInfoService {

    @Autowired
    private CheckInfoDAO checkInfoDAO;

    @Autowired
    private CheckDAO checkDAO;

    @Autowired
    private StudentDAO studentDAO;

    public PageBean loadAllCheckInfo(int checkid, PageBean page) {
        page.setList(this.checkInfoDAO.loadAllCheckInfo(checkid, page));
        return page;
    }

    public List<CheckInfoDTO> loadAllCheckInfo(int checkid) {
        List<CheckInfoDTO> result = new ArrayList<>();
        List<CheckInfoEntity> list = this.checkInfoDAO.loadAllCheckInfo(checkid);
        for (CheckInfoEntity checkInfo : list) {
            CheckInfoDTO temp = new CheckInfoDTO(checkInfo);
            if (CommonTemp.studentMap.get(checkInfo.getStuId()) == null) {
                studentDAO.refreshStuMap();
            }
            temp.setStuName(CommonTemp.studentMap.get(checkInfo.getStuId()).getStuName());
            result.add(temp);
        }
        return result;
    }

    public void updateCheckInfo(CheckInfoEntity checkinfo){
        this.checkInfoDAO.updateCheckInfo(checkinfo);
        int checkid = checkinfo.getCheckId();
        checkDAO.updateLateNum(checkid);
        checkDAO.updateNotNum(checkid);
        checkDAO.updateShouldNum(checkid);
    }

    public void saveCheckInfo(CheckInfoEntity checkinfo){
        checkInfoDAO.saveCheckInfo(checkinfo);
        int checkid = checkinfo.getCheckId();
        checkDAO.updateLateNum(checkid);
        checkDAO.updateNotNum(checkid);
        checkDAO.updateShouldNum(checkid);
    }

    public void deleteCheckInfo(int checkInfoid){
        checkInfoDAO.deleteCheckInfo(checkInfoid);
        int checkid = checkInfoDAO.getCheckInfo(checkInfoid).getCheckId();
        checkDAO.updateLateNum(checkid);
        checkDAO.updateNotNum(checkid);
        checkDAO.updateShouldNum(checkid);
    }

    public CheckInfoEntity getCheckInfo(int id){
        return checkInfoDAO.getCheckInfo(id);
    }

    public void saveCheckInfoList(int checkId, List<CheckInfoEntity> list){
        checkInfoDAO.deleteCheckInfoList(checkId);

        checkInfoDAO.saveAllCheckInfo(list);
        int checkid = list.get(0).getCheckId();
        checkDAO.updateLateNum(checkid);
        checkDAO.updateNotNum(checkid);
        checkDAO.updateShouldNum(checkid);
    }
}
