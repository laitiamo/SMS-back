package com.zahory.studentmgsystem.manager.student;

import com.zahory.studentmgsystem.dao.StudentCourseDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.vo.response.table.StudentExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;

    public ExamManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return studentCourseDAO.listStudentExam(studentId);
    }
}
