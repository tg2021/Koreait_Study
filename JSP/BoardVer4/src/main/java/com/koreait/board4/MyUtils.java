package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.user.UserVO;

public class MyUtils {
	// TODO : session에 값을 넣어사용하기위해
	public static int getLoginUserPK(HttpServletRequest req) {
		/*
		안좋은 코드
		if(req == null) { return null; } 
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
		*/
		if(req == null) { return 0;}
		return getLoginUser(req).getIuser();
	}
	// TODO : session을 사용하기위해 
	public static UserVO getLoginUser(HttpServletRequest req) {
		// null 체크가 없으면 서버가 죽거나 에러가 뜨기 떄문에 null로 표시해서 에러는 방지한다
		if(req == null) { return null; } 
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
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
	
	public static void openJSP(String fileNm, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO : servlet파일에서 jsp파일로 보내주는 메소드생성
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}
	
	
}
