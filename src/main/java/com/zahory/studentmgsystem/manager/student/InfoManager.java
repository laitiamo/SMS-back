package com.zahory.studentmgsystem.manager.student;

import com.zahory.studentmgsystem.dao.StudentDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.entity.StudentEntity;
import com.zahory.studentmgsystem.model.vo.response.StudentInfoVO;
import org.springframework.stereotype.Component;

@Component
public class InfoManager extends BaseManager {
    private final StudentDAO studentDAO;

    public InfoManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInfoVO getStudentInfoByStudentId(Integer studentId) {
        return studentDAO.getStudentInfoById(studentId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public int updateStudent(StudentEntity entity) {
        return studentDAO.update(entity);
    }
}
