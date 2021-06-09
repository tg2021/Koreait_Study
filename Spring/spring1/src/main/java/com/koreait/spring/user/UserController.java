package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
// 어노테이션
// 1차주소값
@RequestMapping("/user")
public class UserController {
// controller : mapping담당

    @Autowired // UserService에서 값을 여기로 주소값 요청
    private UserService service;
    
    //2차 주소값
    @RequestMapping(value = "/login")
    // @RequestParam("err") = 쿼리스트링 보내게끔
    // defaultValue = "0" 기본값 0
    public String login(@RequestParam(value = "err", defaultValue = "0") int err, Model model)
    { // model이 알아서 request.setAttribute해준다
        switch (err) {
            case 1: // 아이디 없음
                model.addAttribute("errMsg", "아이이를 확인해 주세요.");
                break;
            case 2: // 비밀번호 틀림
                model.addAttribute("errMsg", "비밀번호를 확인해 주세요.");
                break;
        }
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserEntity param) {
        return "redirect:" + service.login(param);
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

    @GetMapping("/logout")
    public String logout(HttpSession hs, HttpServletRequest request) {
        hs.invalidate();
        // 전 페이지로 이동
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
        
        /*
            로그인 페이지로 이동
            return "redirect:/user/login";
         */
    }
    
    @GetMapping("/profile")
    public void profile() {}



    //@RequestMapping(value = "/profile", method = RequestMethod.POST)
    @PostMapping("/profile")
    public String profile(MultipartFile profileImg) {
        return "redirect:" + service.uploadProfile(profileImg);
    }

}


