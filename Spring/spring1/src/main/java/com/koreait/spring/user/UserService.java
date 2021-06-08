package com.koreait.spring.user;

import org.apache.commons.io.FilenameUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service // bean등록
public class UserService {
// service : logic담당

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;

    public String login (UserEntity param) {
        UserEntity result = mapper.selUser(param);
        if(result == null) { // 아이디 없음
            return "/user/login?err=1";
        } else if(BCrypt.checkpw(param.getUpw(), result.getUpw())) { // 비밀번호 맞음
            // 세션처리
            result.setUpw(null);
            session.setAttribute("loginUser", result);
            return "/board/list";
        } else { // 비밀번호 틀림
            return "/user/login?err=2";

        }
    }

    public int join(UserEntity param) {
        // 암호화
        String cryptPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
        // 암호화 후 값을 다시 받음
        param.setUpw(cryptPw);
        // UserController로 보냄
        return mapper.insUser(param);
    }

    public String uploadProfile(MultipartFile img) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        final String PATH = "D:/springImg/" + loginUser.getIuser();
        // 객체생성해서 폴더 만듬
        File folder = new File(PATH);
        folder.mkdirs();

        // 확장자 구함
        String ext = FilenameUtils.getExtension(img.getOriginalFilename());
        String fileNm = UUID.randomUUID().toString() + "." + ext;

        File target = new File(PATH + "/"  + fileNm);
        try {
            img.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 비밀번호 생략해서 비밀번호는 나오지 않는다.
        UserEntity param = new UserEntity();
        param.setIuser(loginUser.getIuser());
        param.setProfileImg(fileNm);

        mapper.updUser(param);

        loginUser.setProfileImg(fileNm);
        return "/user/profile";
    }
}
