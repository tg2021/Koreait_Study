package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list3")
public class BoardListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardVO3> list = BoardDAO.selBoardList(); // 어레이리스트 객체가 된다
		request.setAttribute("list", list);
		//BoardDAO.selBoardList(아규먼트); 아규먼트를 안 데리고 온다는것은 다 데리고 오겠다는것이다
		
		// TODO list3.jsp로 이동
		String jsp = "/WEB-INF/view/list3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		/*
		객체화한 방식
		MyUtils utils = new MyUtils();
		utils.openJSP(jsp, request, response);
		*/
		
		/*
		 static을 붙인 방식 
		 MyUtils.openJSP(jsp, request, response);
		 */
		
		MyUtils.openJSP("list3", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
