package com.koreait.spring;

import com.koreait.spring.user.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AuthCheckInterceptor implements HandlerInterceptor {
    private final String[] needLoginUriArr = {"/board/writeMod", "/board/favList", "/user/profile"};

    // controller로 보내기 전에 처리;
    // 이동방향 처리
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    // controller의 handler가 끝나면 처리(화면 열기 직전)
    // 화면이동 가능
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            UserEntity loginUser = (UserEntity) request.getSession().getAttribute("loginUser");

            if(loginUser == null) {
                // String으로 처리
                System.out.println("viewName" + modelAndView.getViewName());
                modelAndView.setViewName("/user/needLogin");
            }

    }

    // view까지 처리가 끝난 후에 처리
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
