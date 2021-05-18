package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;


@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("user/userLogin", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 
		 userLogin.jsp에서 입력받은 String자료형에 변수명 uid, String 자료형에 변수명 upw에
		 getParameter로 저장한다
		 */
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		/*
		 UserVO의 변수명 param인 객체를 생성하여 uid값을 담는다
		 */
		UserVO param = new UserVO();
		param.setUid(uid);
		
		/*
		UserDAO에 메소드selUser안에 param변수를 담소 UserVO타입에 변수명 result를 생성한다
		 */
		UserVO result = UserDAO.selUser(param);
		
		/*
		 result값이 null이면 아이디 확인 에러메세지 출력
		 result값이 들어있으면 DB에 저장된 비밀번호와 입력한 패스워드가 일치한지 확인해서
		 패스워드가 일치하면 패스워드를 지우고 나머지 UserDAO의 selUser안의 나머지 값들을 저장 후 listServlet
		 으로 이동
		 패스워드가 일치히지 않을경우 에러메세지 출력
		 */
		// TODO : 로그인 확인
		if(result == null) {
			// 아이디 없음
			request.setAttribute("errMsg", "아이디를 확인해주세요");
		} else if(BCrypt.checkpw(upw, result.getUpw())) {
			// 아이디 있음 & 비밀번호 체크성공
			result.setUpw(null);
			HttpSession hs = request.getSession();
			// session에 값을 담음
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			// return을 줘서 실행이 안되게 막음
			return;
		} else {
			// 비밀번호 틀림
			request.setAttribute("errMsg", "비밀번호를 확인해 주세요.");
		}
		doGet(request, response);

	}

}
