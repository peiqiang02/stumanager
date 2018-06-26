package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.CheckEntity;
import cn.edu.zucc.stumanager.databean.CheckInfoEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TeacherEntity;
import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.service.CheckService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping("/getCheck")
    @ResponseBody
    public Result<PageBean> getCheckInfo(int curId,
                                                @RequestParam(value = "pageLimit") int pageSize,
                                                @RequestParam(value = "pageIndex") int pageIndex) {
        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = checkService.getCheckByCurid(curId, page);
        return ResultUtil.success(page);
    }

    @PostMapping("/addCheck")
    @ResponseBody
    public Result addCheck(CheckEntity check){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        check.setCheckDate(now);
        checkService.saveCheck(check);
        return ResultUtil.success();
    }

    @PostMapping("/getOneCheck")
    @ResponseBody
    public Result getCheck(int checkId) {
        return ResultUtil.success(checkService.getCheckByid(checkId));
    }

}
