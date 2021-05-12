package com.koreait.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list3")
public class BoardListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 쿼리스트링(QueryString)
	 - Get방시긍로 서버 요청을 보낼 때 
	 같이 보내는 data
	 
	 ?로 시작, 구분: & 구성: 키=값
	 예) 이름, 나이 정보를 보낸다(서버에서 정보를 원한다.)
	 
	 
	 쿼리스트링 작성방법
	 주소?name=홍길동&age=20
	 - 홍길동, 나이가 바껴도 상관없음
	 주소?age=20&name=홍길동
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		String jsp = "WEB-INF/jsp/list3.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}




}
