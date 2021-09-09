package com.zahory.studentmgsystem.model.bo;

import com.zahory.studentmgsystem.model.constant.UserType;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginStatusBO implements Serializable {
    private Boolean loggedIn = false;
    private Integer userId;
    private String username;
    private Integer userType = UserType.NO;
    private Integer permission = 0;

    public static LoginStatusBO fromAuthInfo(AuthInfoBO authInfo) {
        LoginStatusBO loginStatus = new LoginStatusBO();
        loginStatus.loggedIn = true;
        loginStatus.userId = authInfo.getId();
        loginStatus.username = authInfo.getUsername();
        loginStatus.userType = authInfo.getUserType();
        loginStatus.permission = authInfo.getPermission();

        return loginStatus;
    }
}
