package cn.edu.zucc.stumanager.web;

import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.StudentChoiceCourseEntity;
import cn.edu.zucc.stumanager.databean.StudentEntity;
import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.service.StudentChoiceCourseService;
import cn.edu.zucc.stumanager.service.StudentService;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SC")
public class SCController {

    @Autowired
    private StudentChoiceCourseService scService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/loadSC")
    @ResponseBody
    public Result<PageBean> loadSCByCurId(int curId,
                                          @RequestParam(value = "pageLimit") int pageSize,
                                          @RequestParam(value = "pageIndex") int pageIndex){
        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = scService.getSCByCurId(curId, page);
        return ResultUtil.success(page);
    }

    @RequestMapping("/loadStudentByCurId")
    @ResponseBody
    public Result<PageBean> loadStudentByCurId(int curId,
                                          @RequestParam(value = "pageLimit") int pageSize,
                                          @RequestParam(value = "pageIndex") int pageIndex){
        PageBean page = new PageBean();
        page.setPage(pageIndex);
        page.setRows(pageSize);
        page = scService.getStudentByCurId(curId, page);
        return ResultUtil.success(page);
    }

    @RequestMapping("/loadSCByStuIdandCurId")
    @ResponseBody
    public Result loadSC(int curId, int stuId){
        System.out.println(curId);
        System.out.println(stuId);
        return ResultUtil.success(scService.getSC(curId, stuId));
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public Result addStudent(StudentEntity student, int curId){
        if (studentService.getStudentByid(student.getStuId()) != null) {
            return ResultUtil.error(101, "该学生已经存在");
        }
        StudentChoiceCourseEntity sc = new StudentChoiceCourseEntity();
        sc.setCurId(curId);
//        sc.setStuId(student.getStuId());
        scService.saveSC(sc, student);
        return ResultUtil.success();
    }

    @RequestMapping("/updateGrades")
    @ResponseBody
    public Result updateGrades(int scId, double examScore,
                               double taskScore, double nomalScore, double totalScore) {
        StudentChoiceCourseEntity sc = scService.getSCByid(scId);
        sc.setExamScore(examScore);
        sc.setNomalScore(nomalScore);
        sc.setTaskScore(taskScore);
        sc.setTotalGrade(totalScore);
        scService.updateSC(sc);
        return ResultUtil.success();
    }

}
