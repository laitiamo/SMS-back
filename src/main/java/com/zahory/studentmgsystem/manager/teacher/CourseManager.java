package com.zahory.studentmgsystem.manager.teacher;

import com.zahory.studentmgsystem.dao.TeacherDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.vo.response.table.TeacherCourseItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_CourseManager")
public class CourseManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public CourseManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TeacherCourseItemVO> listTeacherCourse(Integer teacherId) {
        return teacherDAO.listTeacherCourse(teacherId);
    }
}
