package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    /*
        의존 자동 주입
        기능을 사용하면 스프링이 알아서 의존 객체를 찾아서 주입해준다.
     */
    private BoardMapper mapper;

    public List<BoardDomain> selBoardList() {
        List<BoardDomain> list = mapper.selBoardList();
        return list;
    }

    public BoardDomain selBoard(BoardDTO param) {
        return mapper.selBoard(param);
    }

}
