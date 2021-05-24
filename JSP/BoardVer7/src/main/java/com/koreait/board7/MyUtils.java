package com.koreait.board7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board7.user.UserEntity;



public class MyUtils {
	// TODO : session에 값을 넣어사용하기위해
	
	public static int getLoginUserPK(HttpServletRequest req) {
		/*
		안좋은 코드
		if(req == null) { return null; } 
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
		*/
		/*
		if(req == null) { return 0;}
		return getLoginUser(req).getIuser();
		 */
		return 0;
	}
	// TODO : session을 사용하기위해 
	public static UserEntity getLoginUser(HttpServletRequest req) {
		// null 체크가 없으면 서버가 죽거나 에러가 뜨기 떄문에 null로 표시해서 에러는 방지한다
		if(req == null) { return null; } 
		HttpSession hs = req.getSession();
		return (UserEntity) hs.getAttribute("loginUser");
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String val = req.getParameter(key);
		int intVal = MyUtils.parseStringToInt(val);
		return intVal;
	}
	
	public static int parseStringToInt(String val) {
		// TODO : String형식을 정수형으로 변환하는 메소드 생성
		// 
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static void openJSP(String title, String jsp, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// jsp파일에 띄워주기 위함
		req.setAttribute("title", title);
		req.setAttribute("jsp", jsp);
		
		// 모든 서블릿을 template.jsp에 모으기 위함
		String temp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(temp).forward(req, res);
	}
	
	
}
