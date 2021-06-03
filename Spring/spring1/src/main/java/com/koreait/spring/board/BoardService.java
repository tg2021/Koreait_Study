package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    public List<BoardDomain> selBoardList() {
        List<BoardDomain> list = mapper.selBoardList();
        return list;
    }

}
