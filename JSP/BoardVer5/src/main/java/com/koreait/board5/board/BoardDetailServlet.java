package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;
import com.koreait.board5.cmt.CmtVO;


@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		// TODO BoardDAO에 selBoard에서 값을 받아옴
		
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		
		CmtVO cv = new CmtVO();
		cv.setIboard(iboard);
		// TODO : 주소값 담음
		request.setAttribute("data", BoardDAO.selBoard(param));
		request.setAttribute("cmtList", CmtDAO.selCmtList(cv));
		
		MyUtils.openJSP("board/detail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
