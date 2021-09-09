package com.zahory.studentmgsystem.manager;

import com.zahory.studentmgsystem.dao.AdminDAO;
import com.zahory.studentmgsystem.dao.StudentDAO;
import com.zahory.studentmgsystem.dao.TeacherDAO;
import com.zahory.studentmgsystem.dao.UserDAO;
import com.zahory.studentmgsystem.dao.mapper.UserMapper;
import com.zahory.studentmgsystem.model.bo.AuthInfoBO;
import com.zahory.studentmgsystem.model.constant.UserType;
import com.zahory.studentmgsystem.model.entity.StudentEntity;
import com.zahory.studentmgsystem.model.entity.TeacherEntity;
import com.zahory.studentmgsystem.model.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserManager extends BaseManager {
    private final AdminDAO adminDAO;
    private final TeacherDAO teacherDAO;
    private final StudentDAO studentDAO;
    private final UserDAO userDao;

    public UserManager(AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO, UserDAO userDao) {
        this.adminDAO = adminDAO;
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
        this.userDao = userDao;
    }

    public AuthInfoBO getUsertypeByUsername(String username){
        return AuthInfoBO.fromUser(userDao.getUsertypeByUsername(username));
    }

    public AuthInfoBO getAuthInfoByUsername(String username, Integer userType) {
        if (userType == UserType.STUDENT) {
            return AuthInfoBO.fromStudent(studentDAO.getByNumber(username));
        } else if (userType == UserType.TEACHER) {
            return AuthInfoBO.fromTeacher(teacherDAO.getByNumber(username));
        } else if (userType == UserType.ADMIN) {
            return AuthInfoBO.fromAdmin(adminDAO.getByUsername(username));
        }

        return null;
    }

    public void updateStudentLastLoginTime(String number) {
        StudentEntity entity = studentDAO.getByNumber(number);
        if (entity == null) {
            return;
        }

        entity.setLastLoginTime(new Date());
        studentDAO.update(entity);
    }

}
