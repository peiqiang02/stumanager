package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TaskGradeEntity;
import cn.edu.zucc.stumanager.dto.TaskGradeDTO;
import cn.edu.zucc.stumanager.logic.CourseDAO;
import cn.edu.zucc.stumanager.logic.StudentDAO;
import cn.edu.zucc.stumanager.logic.TaskDAO;
import cn.edu.zucc.stumanager.logic.TaskGradeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.edu.zucc.stumanager.utils.CommonTemp.taskMap;
import static cn.edu.zucc.stumanager.utils.CommonTemp.courseMap;
import static cn.edu.zucc.stumanager.utils.CommonTemp.studentMap;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskGradeService {

    @Autowired
    private TaskGradeDAO taskGradeDAO;

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseDAO courseDAO;

    public TaskGradeEntity getTaskGrade(int id){
        return taskGradeDAO.getTaskGrade(id);
    }

    public List<TaskGradeEntity> loadAllTaskGrade(int taskId){
        return taskGradeDAO.loadTaskGtradeByTaskId(taskId);
    }

    public void updateTaskGrade(TaskGradeEntity taskGrade){
        taskGradeDAO.updateTaskGrade(taskGrade);
    }

    public void deleteTaskGrade(int taskGradeId){
        taskGradeDAO.deleteTaskGrade(taskGradeId);
    }

    public void saveTaskGrade(TaskGradeEntity taskGrade){
        taskGradeDAO.saveTaskGrade(taskGrade);
    }

    public void saveTaskGradeList(List<TaskGradeEntity> TaskGradeList){
        for (TaskGradeEntity taskGrade:TaskGradeList) {
            taskGradeDAO.saveTaskGrade(taskGrade);
        }
    }

    public PageBean loadTaskGradeBySC(int curId, int stuId, PageBean page) {
        List<TaskGradeEntity> list = taskGradeDAO.loadTaskGradeBySC(curId, stuId, page);
        List<TaskGradeDTO> result = new ArrayList<>();
        for (TaskGradeEntity temp : list){
            int taskId = temp.getTaskId();
            if (taskMap.get(taskId) == null) {
                taskDAO.refreshTaskMap();
            }
            if (courseMap.get(curId) == null) {
                courseDAO.refreshCurMap();
            }
            if (studentMap.get(stuId) == null) {
                studentDAO.refreshStuMap();
            }
            TaskGradeDTO DTO = new TaskGradeDTO(temp);
            DTO.setCurName(courseMap.get(curId).getCurName());
            DTO.setStuName(studentMap.get(stuId).getStuName());
            DTO.setTaskName(taskMap.get(taskId).getTaskName());
            result.add(DTO);
        }
        page.setList(result);
        return page;
    }


}
