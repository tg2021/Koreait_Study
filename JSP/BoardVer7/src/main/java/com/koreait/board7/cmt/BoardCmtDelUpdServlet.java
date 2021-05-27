package com.koreait.board7.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;


@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // 댓글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.delBoardCmt(param);
		
		response.getWriter()
		.append("{\"result\": ")
		.append(String.valueOf(result))
		.append("}")
		.flush();		
		
		
	}

	//댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int icmt = MyUtils.getParamInt("icmt", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request);
		
		System.out.println("icmt : " + icmt);
		System.out.println("cmt : " + cmt);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		Gson gson = new Gson();
		String json = gson.toJson(BoardCmtDAO.updBoardCmt(param)); // 0 1
		System.out.println("json : " + json);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append(json); // 
 		
		
		
	}

}
