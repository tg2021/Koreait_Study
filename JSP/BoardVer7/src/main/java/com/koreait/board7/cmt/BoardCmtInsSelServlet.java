package com.koreait.board7.cmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : cmt는 ajax로 처리
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		
		/*
		 아래 방식을 풀어서쓴 것
		String json = "[";
		for(int i = 0; i < list.size(); i ++) {
			String item = "{";
			
			BoardCmtDomain vo = list.get(i);
			item += "\"icmt\":";
			item += vo.getIcmt();
			
			item += "\"iboard\":";
			item += vo.getIboard();
			
			item += "},";
			json += item;
		}
		*/
		
		// JSON 라이브러리 사용
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("json : " + json);
		response.getWriter()
		.append(json);
	}

	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.insBoardCmt(param);
		// JSON 전송방식
		PrintWriter pw = response.getWriter();
		pw.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
		System.out.println(pw);
	}

}
