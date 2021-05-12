package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.*;
import com.koreait.board4.user.UserVO;


@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO : userVO에 iuser, uid, unm를 받아 session으로 가져와서 로그인
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		// TODO : 로그인 안되어있으면 로그인화면으로 이동
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		MyUtils.openJSP("board/write", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : 제목, 내용, 글쓴이 pk값을 BoardVO 객체에 담아주세요
		// TODO : write.jsp에서 값을 받음
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		// TODO : Session에서 값을 받아옴
		// 로그인을한 사람의 정보는 session에 들어있기떄문에 가져올 수 있다
		/*
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		int iuser = loginUser.getIuser();
		*/
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardVO param = new BoardVO();
		param.setIuser(iuser);
		param.setTitle(title);
		param.setCtnt(ctnt);

		BoardDAO.insBoard(param);
		
		response.sendRedirect("list");
	}

}
