package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.koreait.board5.MyUtils;


@WebServlet("/board/cmt")
public class BoardCmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPK(request);

		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		 
		
		CmtDAO.delCmt(param);			
		
		// iboard가 있으면 수정 없으면 등록으로 구분할 수 있다
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request);
		int icmt = MyUtils.getParamInt("icmt", request);
		
		CmtVO param = new CmtVO();
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		if(icmt != 0) { // 수정
			param.setIcmt(icmt);
			CmtDAO.updCmt(param);
			
		} else { // 등록
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
		}
		
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

}
