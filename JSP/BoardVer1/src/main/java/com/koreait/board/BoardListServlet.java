package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 클라이언트 (브라우저)값이 서버쪽으로 넘어왔음
		 
		 <값 뺴내는 방법>
		 request.getParmeter(키값);
		 -------------------------
		 
		 서블릿에서 jsp로 값 전달하는 방법
		 <값 넣는 방법>
		 request.setAttribute(키값, 밸류값);
		 
		 <값 뺴는 방법>
		 request.getAttribute(키값);
		 */
		// 정보를 보내주는 역할
		request.setAttribute("data", Database.list);
		
		// list.jsp
		String jsp = "/WEB-INF/jsp/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
