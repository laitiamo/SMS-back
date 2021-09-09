package com.zahory.studentmgsystem.service;

import com.zahory.studentmgsystem.manager.LoginStatusManager;
import com.zahory.studentmgsystem.model.bo.LoginStatusBO;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class BaseService {
    @Autowired
    private HttpSession session;
    @Autowired
    private LoginStatusManager loginStatusManager;

    private LoginStatusBO getLoginStatus() {
        return loginStatusManager.getLoginStatus(session);
    }

    protected Integer getUserId() {
        return getLoginStatus().getUserId();
    }

    protected ResultVO result(Object data) {
        return new ResultVO(ResultVO.SUCCESS, "success", data);
    }

    protected ResultVO result(Object data, String message) {
        return new ResultVO(ResultVO.SUCCESS, message, data);
    }

    protected ResultVO failedResult(String message) {
        return new ResultVO(ResultVO.FAIL, message, null);
    }

    protected ResultVO failedResult(String message, Object data) {
        return new ResultVO(ResultVO.FAIL, message, data);
    }
}
