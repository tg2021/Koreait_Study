package com.koreait.board7.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/idChk")
public class IdChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		System.out.println("uid : " + uid);
		int result = UserDAO.selIdChk(uid);
		
		// 아래의 형식과 동일하다
		PrintWriter pw = response.getWriter();
		// 체인링 불가
		pw.append("<h1>hello</h1>").println();
		// 체인링 가능
//		pw.append("");
//		pw.append("");
		
		
		// String 으로 가능 -> JSON
		response.getWriter()
		.append("{\"result\": ")
		.append(String.valueOf(result))
		.append("}");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
