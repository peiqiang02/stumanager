package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TaskEntity;
import cn.edu.zucc.stumanager.dto.TaskDTO;
import cn.edu.zucc.stumanager.logic.CourseDAO;
import cn.edu.zucc.stumanager.logic.TaskDAO;
import cn.edu.zucc.stumanager.utils.CommonTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private CourseDAO courseDAO;

    public PageBean getTaskByCurid(int curId,PageBean page){
        String curName = courseDAO.getCourseById(curId).getCurName();
        List<TaskEntity> listTemp = taskDAO.getTaskByCurid(curId, page);
        List<TaskDTO> result = new ArrayList<>();

        for (TaskEntity task : listTemp) {
            TaskDTO one = new TaskDTO(task);
            one.setCurName(curName);
            result.add(one);
        }
        page.setList(result);
        return page;
    }

    public void saveTask(TaskEntity task){

        taskDAO.saveTask(task);
    }

    public void saveTasks(List<TaskEntity> TaskList){
        for (TaskEntity Task:TaskList) {
            taskDAO.saveTask(Task);
        }
    }

    public TaskEntity getTaskByid(int id){
        return taskDAO.getTaskByid(id);
    }
}
