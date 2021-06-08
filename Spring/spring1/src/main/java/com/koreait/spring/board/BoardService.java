package com.koreait.spring.board;

import com.koreait.spring.user.UserEntity;
import com.mysql.cj.Session;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    /*
        의존 자동 주입
        기능을 사용하면 스프링이 알아서 의존 객체를 찾아서 주입해준다.
     */
    @Autowired
    private BoardMapper mapper;

    @Autowired
    private BoardCmtMapper cmtMapper;
    @Autowired
    private HttpSession session;

    public List<BoardDomain> selBoardList() {
        List<BoardDomain> list = mapper.selBoardList();
        return list;
    }
    public BoardDomain selBoard(BoardDTO param) {
        return mapper.selBoard(param);
    }

    public int insBoardCmt(BoardCmtEntity param) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        return cmtMapper.insBoardCmt(param);
    }

    public List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param) {
        return cmtMapper.selBoardCmtList(param);
    }

    public int updBoardCmt(BoardCmtEntity param) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        return cmtMapper.updBoardCmt(param);
    }

    public int delBoardCmt(BoardCmtEntity param) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        return cmtMapper.delBoardCmt(param);
    }




}
