package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// user/userJoin.jsp로 이동
		MyUtils.openJSP("user/userJoin", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 userJoin.jsp에서 uid, upw, unm, gender의 값을 getParameter 받아 
		 각각 String변수의 uid, String타입의 변수명 upw, String타입의 변수명 unm, int타입 변수명 gender
		 에 담아주고 패스워드는 String타입 변수명 hashedupw에 암호화해서 값을 저장한다
		*/
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		
		// 패스워드 암호화
		String hashedupw = BCrypt.hashpw(upw, BCrypt.gensalt());
		
		/*
		 UserVO클래스에 변수명 vo를 객체화해서 uid, hashedupw, unm, gender을 담아준다  
		 */
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(hashedupw);
		vo.setUnm(unm);
		vo.setGender(gender);
		
		/*
		UserVO클래스를 객체화한 변수명 vo값들을 BoardDAO의 joinUser메소드에 담아준다
		 */
		UserDAO.joinUser(vo);
		
		// UserLoginServlet으로 이동
		response.sendRedirect("login");
	}

}
