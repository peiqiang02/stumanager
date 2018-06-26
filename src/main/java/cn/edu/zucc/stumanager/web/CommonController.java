package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.CourseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("main")
    public String main(){
        return "/main";
    }

    @RequestMapping("first")
    public String first(){
        return "/first";
    }

    @GetMapping("CheckIn")
    public String CheckInfo(){
        return "checkInfo";
    }

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("checkInDetail")
    public String checkdetail(){
        return "checkInDetail";
    }

    @RequestMapping("courseHome")
    public String courseHome(){
        return "courseHome";
    }

    @RequestMapping("courseGrades")
    public String courseGrades(){
        return "courseGrades";
    }

    @RequestMapping("task")
    public String task(){
        return "task";
    }

    @RequestMapping("taskDetail")
    public String taskDetail(){
        return "taskDetail";
    }


}
