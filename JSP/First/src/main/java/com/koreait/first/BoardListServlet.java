package com.koreait.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 주소값은 바꿀 수 있다
@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append("Served at: ")
		.append("<html>")
		.append("")
		.append("</html>");
		PrintWriter out = response.getWriter();
		out.print("ddd");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doGet(request, response);
	}
	// 중요한건 Web-INF에 생성
	// get방식 : 오픈 방식-> 주소에 먼가 찍히면 get방식
	// post방식 : 숨기는 방식, 속도빠름, 로그인은 post방식
	// 주소값뒤에 붙는것은 쿼리방식
}
