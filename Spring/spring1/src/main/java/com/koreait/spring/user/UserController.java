package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// 애노테이션
// 1차주소값
@RequestMapping("/user")
public class UserController {
// controller : mapping담당

    @Autowired // UserService에서 값을 여기로 주소값 요청
    private UserService service;
    
    //2차 주소값
    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping("/join")
    public String join() {
        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserEntity param) {
        System.out.println("uid" + param);
        service.join(param);
        return "redirect:/user/login";
    }

}


