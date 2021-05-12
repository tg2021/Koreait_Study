package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DBUtils;
import com.koreait.board4.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MyUtils.openJSP("user/join", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : join.jsp에서 값을 받는다
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		
		// TODO : 암호화
		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
		// 암화화 확인
		System.out.println("hashedUpw : " + hashedUpw);
		
		// TODO : 받아온 값을 UserVO에 저장 
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(hashedUpw);
		vo.setUnm(unm);
		vo.setGender(gender);
		
		// TODO : UserDAO의 joinUser(회원가입 정보를 DB에 저장) 호출
		UserDAO.joinUser(vo);
		
		response.sendRedirect("login");
	}

}
