package com.zahory.studentmgsystem.service;

import com.zahory.studentmgsystem.dao.UserDAO;
import com.zahory.studentmgsystem.manager.LoginStatusManager;
import com.zahory.studentmgsystem.manager.UserManager;
import com.zahory.studentmgsystem.model.bo.AuthInfoBO;
import com.zahory.studentmgsystem.model.bo.LoginStatusBO;
import com.zahory.studentmgsystem.model.constant.UserType;
import com.zahory.studentmgsystem.model.entity.UserEntity;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.util.Md5Encrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends BaseService {

    private final HttpSession session;
    private final UserManager manager;
    private final LoginStatusManager loginStatusManager;
    private final Md5Encrypt md5Encrypt;

    public UserService(HttpSession session, UserManager manager, LoginStatusManager loginStatusManager, Md5Encrypt md5Encrypt) {
        this.session = session;
        this.manager = manager;
        this.loginStatusManager = loginStatusManager;
        this.md5Encrypt = md5Encrypt;
    }

    public ResultVO login(String username, String password) {
        AuthInfoBO type = manager.getUsertypeByUsername(username);
        if (type != null) {
            Integer usertype = type.getUserType();
            AuthInfoBO authInfo = manager.getAuthInfoByUsername(username, usertype);
            if (authInfo == null) {
                return failedResult("用户不存在");
            }

            if (!password.equals(authInfo.getPassword())) {
                return failedResult("密码错误");
            }

            if (authInfo.getUserType().equals(UserType.STUDENT)) {
                manager.updateStudentLastLoginTime(username);
            }

            LoginStatusBO statusBO = LoginStatusBO.fromAuthInfo(authInfo);
            loginStatusManager.setLoginStatus(session, statusBO);
            return result(statusBO);
        } else {
            return failedResult("用户不存在！");
        }
    }

    public ResultVO getLoginStatus() {
        LoginStatusBO statusBO = loginStatusManager.getLoginStatus(session);
        return result(statusBO);
    }

    public ResultVO logout() {
        loginStatusManager.setLoginStatus(session, null);
        return result("注销成功");
    }

    public String computePasswordHash(String password) {
        String md5 = md5Encrypt.computeHexString(password);
        return md5Encrypt.computeHexString(md5);
    }
}
