package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no"); // 0번째글, 1번째글
		int intNo = Integer.parseInt(no);
		
		List<BoardVO> list = Database.db;
		BoardVO vo = list.get(intNo);
		
		request.setAttribute("no", no);
		request.setAttribute("vo", vo);
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title"); 
		String ctnt = request.getParameter("ctnt");
		String no = request.getParameter("no");
		
		BoardVO vo = Database.db.get(Integer.parseInt(no));;
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		request.setAttribute("vo", vo);
		response.sendRedirect("/detail?no=" + no);
	}

}
