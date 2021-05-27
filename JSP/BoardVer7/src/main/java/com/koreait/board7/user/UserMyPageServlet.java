package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		//String uploadPath = request.getRealPath("res/img/temp");
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; // 10 * 1024 * 1024(10mb)
		System.out.println("uploadPath : " + uploadPath);
		
		// 요청, 파일주소, 파일크기, 인코딩, 파일중복을(1)로 바꿔줌
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize,
				"UTF-8", new DefaultFileRenamePolicy());	
		int loginUserPk = MyUtils.getLoginUserPK(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		
		File folder = new File(targetFolder);
		// false면 true
		// folder.mkdirs(); 안에서 어차피 exists 검사하기 때문에 밖에서 할 필요 없다.
		folder.mkdirs();
		
		
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println("fileNm : " + fileNm);
		
		// 오른쪽에서 가장 먼저나오는 점을 기준으로 인덱스를 찾음
		int lastDotIdx = fileNm.lastIndexOf(".");
		String ext = fileNm.substring(lastDotIdx); // 확장자 구함		
		//String ext2 = fileNm.substring(fileNm.lastIndexOf(".") + 1);
		
		String newFileNm = UUID.randomUUID().toString() + ext;
		
		// 파일 객체화
		File imgFile = new File(uploadPath + "/temp" + "/" + fileNm);
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
	}

}
