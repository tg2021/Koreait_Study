package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyFileUtils;
import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/user/mypage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변경될 라이브러리 
		//String uploadPath = request.getRealPath("res/img/temp");
		
		/*
		풀어쓴 것
		ServletContext application = request.getServletContext();
		application.getRealPath("");
		*/
		
		// getRealPath : 절대 디스크 파일 시스템 경로로 변환하기위한 것
		
		// 줄여쓴 것
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; // 10 * 1024 * 1024(10mb)
		System.out.println("uploadPath : " + uploadPath);
		
		try {
			// 파일정보, 파일주  소, 파일크기, 인코딩, 파일중복을(1)로 바꿔줌
			MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize,
					"UTF-8", new DefaultFileRenamePolicy());
			
			String fileNm = multi.getFilesystemName("profileImg");
			System.out.println("fileNm : " + fileNm);
			
			// null이 뜨면 마이페이지로
			if(fileNm == null) {
				doGet(request, response);
				return;
			}
			
			UserEntity loginUser = MyUtils.getLoginUser(request);
			int loginUserPk = loginUser.getIuser();
			
			String targetFolder = uploadPath + "/user/" + loginUserPk;
			MyFileUtils.delFolder(targetFolder); // 폴더 삭제
			
			File folder = new File(targetFolder);
			folder.mkdirs();
			
			
			
			// 오른쪽에서 가장 먼저나오는 점을 기준으로 인덱스를 찾음
			int lastDotIdx = fileNm.lastIndexOf(".");
			String ext = fileNm.substring(lastDotIdx); // 확장자 구함		
			//String ext2 = fileNm.substring(fileNm.lastIndexOf(".") + 1);
			
			String newFileNm = UUID.randomUUID().toString() + ext;
			
			// 파일 객체화
			File imgFile = new File(uploadPath + "/temp/" + fileNm);
			imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
			
			UserEntity param = new UserEntity();
			param.setIuser(loginUserPk);
			param.setProfileImg(newFileNm);
			
			UserDAO.updUser(param);		
			loginUser.setProfileImg(newFileNm);
			
		} catch (Exception e) {
			
		}
	
		doGet(request, response);
	}

}
