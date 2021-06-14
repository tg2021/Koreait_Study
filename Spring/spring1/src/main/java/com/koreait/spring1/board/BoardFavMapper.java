package com.koreait.spring1.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardFavMapper {
    int insBoardFav(BoardFavEntity param);
    int selBoardFav(BoardFavEntity param);
    int delBoardFav(BoardFavEntity param);
}
