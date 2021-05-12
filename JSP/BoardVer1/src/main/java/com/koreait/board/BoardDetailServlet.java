	package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		System.out.println("no : " + no);
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));	
		
		String jsp = "/WEB-INF/jsp/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		/*
		 request. : 어떠한 정보를 담고있다
		 request.getParameter  -> html의 값을 사용하고 싶을때 사용
		 
		 request.set.Attribute(키값, value); -> value를 키값에 담아서 저장
		 request.getAttribute(키값)  -> 내가 담고 내가 뺴낼때 사용
		 
		 servlet에서 jsp로 요청은 가능
		 jsp에서 servlet으로 요정은 불가능
		 */
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
