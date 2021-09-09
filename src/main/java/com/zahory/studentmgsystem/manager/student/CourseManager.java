package com.zahory.studentmgsystem.manager.student;

import com.zahory.studentmgsystem.dao.CourseDAO;
import com.zahory.studentmgsystem.dao.StudentCourseDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.entity.StudentCourseEntity;
import com.zahory.studentmgsystem.model.vo.response.table.StudentCourseSelectedItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("student_CourseManager")
public class CourseManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;
    private final CourseDAO courseDAO;

    public CourseManager(StudentCourseDAO studentCourseDAO, CourseDAO courseDAO) {
        this.studentCourseDAO = studentCourseDAO;
        this.courseDAO = courseDAO;
    }

    public StudentCourseEntity getStudentCourseById(Integer studentCourseId) {
        return studentCourseDAO.get(studentCourseId);
    }

    @Transactional
    public int deleteStudentCourse(StudentCourseEntity studentCourseEntity) {
        courseDAO.decreaseSelectedCount(studentCourseEntity.getCourseId());
        return studentCourseDAO.delete(studentCourseEntity.getId());
    }

    public List<StudentCourseSelectedItemVO> listStudentCourseSelected(Integer studentId) {
        return studentCourseDAO.listStudentCourseSelected(studentId);
    }
}
