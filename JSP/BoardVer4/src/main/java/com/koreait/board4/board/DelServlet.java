package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/board/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : iboard 값과 iuser값을 변수에 담는다
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPK(request);
		
		// TODO : BoardVO를 객체화해 iboard값과 iuser값을 담는다
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		param.setIuser(iuser);
		
		// TODO : BoardDAO의 delBoard에 담아 listServlet으로 보냄
		BoardDAO.delBoard(param);
		response.sendRedirect("list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
