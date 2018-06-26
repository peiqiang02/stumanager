package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TaskEntity;
import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.service.TaskService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/loadTaskByCouseId")
    @ResponseBody
    public Result<PageBean> loadTaskByCouseId(int curId,
                                              @RequestParam(value = "pageLimit") int pageSize,
                                              @RequestParam(value = "pageIndex") int pageIndex){

        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = taskService.getTaskByCurid(curId,page);
        return ResultUtil.success(page);

    }

    @PostMapping("/getOneTask")
    @ResponseBody
    public Result loadTaskByCouseId(int taskId){
        return ResultUtil.success(taskService.getTaskByid(taskId));
    }

    @PostMapping("/addTask")
    @ResponseBody
    public Result loadTaskByCouseId(TaskEntity task, int curId){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        task.setTaskDate(now);
        task.setCurId(curId);
        taskService.saveTask(task);
        return ResultUtil.success();
    }


}
