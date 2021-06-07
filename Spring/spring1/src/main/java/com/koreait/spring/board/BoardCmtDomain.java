package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardCmtDomain extends BoardCmtEntity{
    // 상속받게해서 추가되는 내용은 여기다 적는다
    private String writerNm;
    private String profileImg;
}
