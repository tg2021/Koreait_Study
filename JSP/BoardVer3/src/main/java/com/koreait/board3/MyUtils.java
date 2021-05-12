package com.koreait.board3;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static int parseStringTolnt(String strNum) {
		/*
		String 값을 정수값으로 변환하는데 숫자와 문자가 섞여있으면 에러가 발생하기 때문에
		try catch문으로 에러확인
		*/
		try { return Integer.parseInt(strNum); } catch (Exception e) { return 0; }
			
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String strVal = req.getParameter(key);
		int intVal = parseStringTolnt(strVal);
		return intVal;
		
	}
	
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/*
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		forward에서 throws 한다
		
		객체화를 할 필요가 없다
		
		*/
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		
		
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}
