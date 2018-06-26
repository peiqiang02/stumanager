package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.service.TaskGradeService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskGradeController {

    @Autowired
    private TaskGradeService taskGradeService;

    @RequestMapping("/loadTaskGrade")
    @ResponseBody
    public Result<PageBean> loadTaskGrade(int curId,
                                          int stuId,
                                          @RequestParam(value = "pageLimit") int pageSize,
                                          @RequestParam(value = "pageIndex") int pageIndex){
        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = taskGradeService.loadTaskGradeBySC(curId, stuId, page);
        return ResultUtil.success(page);
    }

}
