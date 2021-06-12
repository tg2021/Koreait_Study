package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDomain extends BoardEntity{
    // join하면서 추가되는 것들을 넣는곳
    private String writerNm;
    private String profileImg;
    private int isFav;
}
