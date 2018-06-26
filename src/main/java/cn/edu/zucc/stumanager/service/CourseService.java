package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.CourseEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.TeacherEntity;
import cn.edu.zucc.stumanager.dto.CourseDTO;
import cn.edu.zucc.stumanager.logic.CourseDAO;
import cn.edu.zucc.stumanager.logic.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CourseService {


    private Map<Integer,String> map = new HashMap<>();

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    public PageBean getCourseEntityByTeaId(int teaId, PageBean page){
        String teaName = teacherDAO.getTeacher(teaId).getTeaName();
        List<CourseEntity> temp = courseDAO.getCourseListByteaId(teaId,page);
        List<CourseDTO> result = new ArrayList<>();
        for (CourseEntity course:temp) {
            CourseDTO courseTemp = new CourseDTO(course);
            courseTemp.setTeaName(teaName);
            result.add(courseTemp);
        }
        page.setList(result);
        return page;
    }

    public PageBean loadAllCourse(PageBean page){
        List<CourseEntity> tempList = courseDAO.loadAllCourse(page);


        List<CourseDTO> result = new ArrayList<>();
        for (CourseEntity course:tempList) {
//            String teaName = teacherDAO.getTeacher(course.getTeaId()).getTeaName();
            if (map.get(course.getTeaId()) == null) {
                updateTeaMap();
            }
            String teaName = map.get(course.getTeaId());
            CourseDTO courseDTO = new CourseDTO(course);
            courseDTO.setTeaName(teaName);
            result.add(courseDTO);
        }
        page.setList(result);
        return page;
    }

    public List<CourseEntity> getCourseEntityByTeaId(int teaId){
        return courseDAO.getCourseListByteaId(teaId);
    }



    public void saveCourese(CourseEntity course){
        courseDAO.saveCourse(course);
    }

    public CourseDTO getCourseByid(int id){
        CourseEntity course = courseDAO.getCourseById(id);
        CourseDTO result = new CourseDTO(course);
        result.setTeaName(map.get(course.getTeaId()));
        return result;
    }

    public void updateTeaMap(){
        for (TeacherEntity teacher:teacherDAO.getAllTeacher()) {
            map.put(teacher.getTeaId(),teacher.getTeaName());
        }
    }

}
