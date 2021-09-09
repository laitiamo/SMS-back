package com.zahory.studentmgsystem.model.bo;

import com.zahory.studentmgsystem.model.constant.UserType;
import com.zahory.studentmgsystem.model.entity.AdminEntity;
import com.zahory.studentmgsystem.model.entity.StudentEntity;
import com.zahory.studentmgsystem.model.entity.TeacherEntity;
import com.zahory.studentmgsystem.model.entity.UserEntity;
import lombok.Data;
import org.apache.catalina.User;

@Data
public class AuthInfoBO {
    private Integer id;
    private String username;
    private String password;
    private Integer userType;
    private Integer permission = 0;

    public AuthInfoBO() {
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType) {
        this(id, username, password, userType, 0);
    }

    private AuthInfoBO(Integer userType) {
        this.userType = userType;
    }

    public static AuthInfoBO fromUser(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getUsertype());
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType, Integer permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.permission = permission;
    }

    public static AuthInfoBO fromStudent(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.STUDENT);
    }

    public static AuthInfoBO fromTeacher(TeacherEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.TEACHER);
    }

    public static AuthInfoBO fromAdmin(AdminEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getUsername(), entity.getPassword(), UserType.ADMIN,
                entity.getPrivilege());
    }
}
