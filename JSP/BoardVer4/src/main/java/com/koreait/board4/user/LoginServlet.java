package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : login이된 상태면 login창으로 접속하면 board/list.jsp로 이동`
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		// TODO : jsp파일로 보내기
		MyUtils.openJSP("user/login", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : login.jsp에서 값을 받는다
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		// TODO : 받아온 값을 UserVO에 저장
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);
		
		// TODO : 로그인이 성공
		if(result == 1) {
			HttpSession hs = request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo);
			// vo가 가리키는 UserVO객체는 (iuser, uid, unm 값만 담고 있다)
			
			response.sendRedirect("/board/list");
			return;
		}
		
		// TODO : 로그인 실패
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러가 발생하었습니다.";
			break;
		case 2: 
			errMsg = "아이디를 확인해 주세요.";
			break;
			
		case 3: 
			errMsg = "비밀번호를 확인해 주세요.";
		
		}
		request.setAttribute("errMsg", errMsg);
		// loginServlet의 get방식으로 호출
		doGet(request, response);
		
//		switch(result) {
//		case 1:
//			response.sendRedirect("/board/list");
//			break;
//		default:
//			/* TODO 로그인 페이지로 다시 이동 방법 2가지
//			 doGet, response.sendRedirect
//			 
//			 차이점
//			 doGet : 메소드호출로 해결
//			 response.sendRedirect : 호출하는 순간 주소값 이동(쿼리스트링으로만 값전달)
//			 */
//			doGet(request, response);
//			// response.sendRedirect("login");
//			break;
//		}
	
	}

}
