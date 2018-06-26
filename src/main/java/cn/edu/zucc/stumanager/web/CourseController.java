package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.CourseEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TeacherEntity;
import cn.edu.zucc.stumanager.dto.CourseDTO;
import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.service.CourseService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/test1")
    @ResponseBody
    public Result<PageBean> getCourseEntityByteaId(@RequestParam(value = "teaId") int teaId,
                                                   @RequestParam(value = "pageLimit") int pageSize,
                                                   @RequestParam(value = "pageIndex") int pageIndex){
        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = courseService.getCourseEntityByTeaId(teaId,page);
        if (page.getList().size()>0){
            return ResultUtil.success(page);
        }
        return ResultUtil.error(0,"查询失败");
    }

    @RequestMapping("/loadCourseById")
    @ResponseBody
    public Result<PageBean> getCourseName(HttpSession session){
        TeacherEntity teacher = (TeacherEntity) session.getAttribute("user");
        int teaId = teacher.getTeaId();
        return ResultUtil.success(courseService.getCourseEntityByTeaId(teaId));
    }

    @RequestMapping("/loadCourseByCurId")
    @ResponseBody
    public Result<CourseEntity> getCourseByCurId(int curId){
        CourseDTO course = courseService.getCourseByid(curId);
        return ResultUtil.success(course);
    }

    @RequestMapping("/addCourse")
    @ResponseBody
    public Result addCourse(CourseEntity course, HttpSession session){
        TeacherEntity user = (TeacherEntity) session.getAttribute("user");
        course.setTeaId(user.getTeaId());
        courseService.saveCourese(course);
        return ResultUtil.success();
    }

    @PostMapping("/loadAllCourse")
    @ResponseBody
    public Result<PageBean> loadAllCourse(@RequestParam(value = "pageLimit") int pageSize,
                                          @RequestParam(value = "pageIndex") int pageIndex){
        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = courseService.loadAllCourse(page);
        return ResultUtil.success(page);
    }

}
