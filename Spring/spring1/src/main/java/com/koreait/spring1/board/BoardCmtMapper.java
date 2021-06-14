package com.koreait.spring1.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCmtMapper {
    int insBoardCmt(BoardCmtEntity param);
    List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param);
    int updBoardCmt(BoardCmtEntity param);
    int delBoardCmt(BoardCmtEntity param);
}
