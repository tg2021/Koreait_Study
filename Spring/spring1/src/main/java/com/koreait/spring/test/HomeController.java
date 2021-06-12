package com.koreait.spring.test;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping ("/test")
public class HomeController {
    // @RequestMapping에 주소값이 jsp파일명과 같으면 리턴생략가능
    @RequestMapping ("/home")
    public void home() {
    }

}
