package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class BoardModSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String no = request.getParameter("no");
		System.out.println("no : " + no);
		int intNo = Integer.parseInt(no);
		
		BoardVO vo = Database.list.get(intNo);
				
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));;
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 디테일 화면으로 이동
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		System.out.println("no : " + no);
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);
		
		int intNo = Integer.parseInt(no);
		BoardVO vo = Database.list.get(intNo);
		vo.setTitle(title);
		vo.setTitle(ctnt);
		
		request.setAttribute("data", vo);
		
		response.sendRedirect("/detail?no=" + no);
	}

}
