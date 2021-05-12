package com.koreait.board3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String iboard = request.getParameter("iboard");
//		
//		System.out.println("iboard : " + iboard);
//		
//		int intIboard = Integer.parseInt(iboard);
		// 위 내용과 동일하다
		int iboard = MyUtils.getParamInt("iboard",request);
		
		BoardVO3 data = BoardDAO.selBoard(iboard);
		request.setAttribute("data", data);
		                                           
		String jsp = "/WEB-INF/view/detail3.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
//		MyUtils.openJSP("detail3", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
