package com.koreait.spring1.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCmtEntity {
    private int icmt;
    private int iboard;
    private int iuser;
    private String cmt;
    private String regdate;
}
