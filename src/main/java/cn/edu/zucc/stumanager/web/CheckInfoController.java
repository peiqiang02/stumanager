package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.CheckInfoEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.logic.CheckInfoDAO;
import cn.edu.zucc.stumanager.service.CheckInfoService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckInfoController {

    @Autowired
    private CheckInfoService checkInfoService;


    @PostMapping("/getCheckInfo")
    @ResponseBody
    public Result getCheckInfo(int checkId){
        System.out.println(checkId);
        return ResultUtil.success(checkInfoService.loadAllCheckInfo(checkId));
    }

    @PostMapping("/saveCheckInfo/{checkId}")
    @ResponseBody
    public Result saveCheckInfo(@PathVariable("checkId") int checkId,
                                @RequestBody List<CheckInfoEntity> list) {
        System.out.println(list.get(0).getCheckId());
        System.out.println(checkId);
        checkInfoService.saveCheckInfoList(checkId, list);
        return ResultUtil.success();
    }
}
