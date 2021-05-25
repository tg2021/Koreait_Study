package com.koreait.board7.board;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.koreait.board7.MyUtils;



@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 선언
		BoardDTO param = new BoardDTO();
		
		//페이징
		final int recordCnt = 5;
		int cPage = MyUtils.getParamInt("cPage", request);
		// 페이지가 없다면 1로변경
		if(cPage == 0)  {cPage = 1; }
		int startIdx = (cPage - 1) * recordCnt;
		
		param.setStartIdx(startIdx);
		param.setRecordCnt(recordCnt);
		
		// 검색
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText =  request.getParameter("searchText");
		
		
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			param.setSearchText(searchText);
			param.setSearchType(searchType);
		}
		
		
		request.setAttribute("pagingCnt", BoardDAO.selPageingCnt(param));
		request.setAttribute("page", BoardDAO.selBoardList(param));
		
		MyUtils.openJSP("리스트", "board/boardList", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
