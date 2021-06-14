package com.koreait.spring1;

import com.koreait.spring1.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component // bean등록
public class MyUtils {

    @Autowired
    private HttpSession session;

    public int getLoginUserPk() {
        UserEntity loginUser = getLoginUser();
        return loginUser == null ? 0 : getLoginUser().getIuser();
    }

    public UserEntity getLoginUser() {
        return (UserEntity) session.getAttribute("loginUser");
    }
}
