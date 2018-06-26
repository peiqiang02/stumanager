package cn.edu.zucc.stumanager.service;

import cn.edu.zucc.stumanager.databean.CourseEntity;
import cn.edu.zucc.stumanager.databean.PageBean;
import cn.edu.zucc.stumanager.databean.StudentChoiceCourseEntity;
import cn.edu.zucc.stumanager.databean.StudentEntity;
import cn.edu.zucc.stumanager.dto.SCDTO;
import cn.edu.zucc.stumanager.logic.CourseDAO;
import cn.edu.zucc.stumanager.logic.StudentChoiceCourseDAO;
import cn.edu.zucc.stumanager.logic.StudentDAO;
import cn.edu.zucc.stumanager.utils.CommonTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.edu.zucc.stumanager.utils.CommonTemp.courseMap;
import static cn.edu.zucc.stumanager.utils.CommonTemp.studentMap;

@Service
@Transactional
public class StudentChoiceCourseService {

//    private Map<Integer, StudentEntity> studentMap = new HashMap<>();
//    private Map<Integer, CourseEntity> courseMap = new HashMap<>();

    @Autowired
    private StudentChoiceCourseDAO scDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseDAO courseDAO;

    public PageBean getSCByCurId(int curId, PageBean page){
        List<StudentChoiceCourseEntity> scList = scDAO.getSCByCurId(curId);

        List<CourseEntity> courseList = courseDAO.loadAllCourse();
        for (CourseEntity course : courseList) {
            courseMap.put(course.getCurId(),course);
        }
        List<StudentEntity> studentList = studentDAO.getAllStudent();
        for (StudentEntity student : studentList) {
            studentMap.put(student.getStuId(),student);
        }

        List<SCDTO> result = new ArrayList<>();
        for (StudentChoiceCourseEntity sc : scList) {
            String curName = courseMap.get(sc.getCurId()).getCurName();
            String stuName = studentMap.get(sc.getStuId()).getStuName();
            SCDTO scdto = new SCDTO(sc);
            scdto.setCurName(curName);
            scdto.setStuName(stuName);
            result.add(scdto);
        }
        page.setList(result);
        return page;
    }

    public PageBean getStudentByCurId(int curId, PageBean page){
        List<StudentChoiceCourseEntity> scList = scDAO.getSCByCurId(curId);

        List<CourseEntity> courseList = courseDAO.loadAllCourse();
        for (CourseEntity course : courseList) {
            courseMap.put(course.getCurId(),course);
        }
        List<StudentEntity> studentList = studentDAO.getAllStudent();
        for (StudentEntity student : studentList) {
            studentMap.put(student.getStuId(),student);
        }

        List<StudentEntity> result = new ArrayList<>();
        for (StudentChoiceCourseEntity sc : scList) {
            StudentEntity student = studentMap.get(sc.getStuId());
            result.add(student);
        }
        page.setList(result);
        return page;
    }

    public StudentChoiceCourseEntity getSCByid(int id){
        return scDAO.getSCById(id);
    }

    public void updateSC(StudentChoiceCourseEntity sc){
        scDAO.updateSC(sc);
    }

    public void saveSC(StudentChoiceCourseEntity sc){
        scDAO.saveSC(sc);
    }

    public void saveSC(StudentChoiceCourseEntity sc, StudentEntity student) {

        int temp = studentDAO.saveStudent(student);
        sc.setStuId(temp);
        scDAO.saveSC(sc);
    }

    public SCDTO getSC(int curId, int stuId){
        StudentChoiceCourseEntity sc = scDAO.getSC(curId, stuId);
        SCDTO result = new SCDTO(sc);
        if (studentMap.get(stuId) == null) {
            studentDAO.refreshStuMap();
        }
        if (courseMap.get(curId) == null) {
            courseDAO.refreshCurMap();
        }
        result.setStuName(studentMap.get(stuId).getStuName());
        result.setCurName(courseMap.get(curId).getCurName());
        return result;
    }

    public void deleteSC(StudentChoiceCourseEntity sc){
        scDAO.deleteSC(sc);
    }

//    private void refreshStuMap(){
//        List<StudentEntity> studentList = studentDAO.getAllStudent();
//        for (StudentEntity student : studentList) {
//            studentMap.put(student.getStuId(),student);
//        }
//    }
//
//    private void refreshCurMap(){
//        List<CourseEntity> courseList = courseDAO.loadAllCourse();
//        for (CourseEntity course : courseList) {
//            courseMap.put(course.getCurId(),course);
//        }
//    }

}
