package com.koreait.spring.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity pram);
    List<BoardDomain> selBoardList(BoardDTO param);
    BoardDomain selBoard(BoardDTO param);
    int delBoard(BoardEntity param);
    int updBoard(BoardEntity pram);
    int selMaxPageVal(BoardDTO param);

    /*
         Mapper 인터페이스
         MyBatis-Spring은 Mapper 인터페이스를 이용해서
         실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
     */

}

