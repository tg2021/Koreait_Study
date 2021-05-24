package com.koreait.board7.board;
// BoardDomain이 BoardEntity보다 범위가 더 크다
public class BoardDomain extends BoardEntity {
	private String writerNm;

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
	
	
}
