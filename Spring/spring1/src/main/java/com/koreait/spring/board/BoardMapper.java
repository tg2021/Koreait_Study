package com.koreait.spring.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDomain> selBoardList();
    BoardDomain selBoard(BoardDTO param);

    /*
         Mapper 인터페이스
         MyBatis-Spring은 Mapper 인터페이스를 이용해서
         실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
     */

}

