package com.koreait.spring.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service // bean등록
public class UserService {
// service : logic담당

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;

    public String login (UserEntity param) {
        UserEntity result = mapper.selUser(param);
        if(result == null) { // 아이디 없음
            return "/user/login?err=1";
        } else if(BCrypt.checkpw(param.getUpw(), result.getUpw())) { // 비밀번호 맞음
            // 세션처리
            result.setUpw(null);
            session.setAttribute("loginUser", result);
            return "/board/list";
        } else { // 비밀번호 틀림
            return "/user/login?err=2";

        }
    }

    public int join(UserEntity param) {
        // 암호화
        String cryptPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
        // 암호화 후 값을 다시 받음
        param.setUpw(cryptPw);
        // UserController로 보냄
        return mapper.insUser(param);
    }

}
