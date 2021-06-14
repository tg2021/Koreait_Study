package com.koreait.spring1.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
    // DBtable
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String regdt;
}
