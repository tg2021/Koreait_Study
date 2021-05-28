package com.koreait.board7.board;
// BoardDomain이 BoardEntity보다 범위가 더 크다
public class BoardDomain extends BoardEntity {
	private String writerNm;
	private String profileImg;
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
	
	
}
