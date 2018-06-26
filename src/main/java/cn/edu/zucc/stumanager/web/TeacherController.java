package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.databean.TeacherEntity;
import cn.edu.zucc.stumanager.service.TeacherService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    @ResponseBody
    public Result<TeacherEntity> login(@RequestParam(value = "userId") int userId,
                                       @RequestParam(value = "password") String password,
                                       HttpSession session){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setTeaId(userId);
        TeacherEntity temp = teacherService.login(teacher.getTeaId());
        if (temp!=null&&temp.getTeaPassword().equals(password)){
            session.setAttribute("user",temp);
            return ResultUtil.success(temp);
        }
        return ResultUtil.error(1,"失败");
    }
}
