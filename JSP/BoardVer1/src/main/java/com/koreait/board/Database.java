package com.koreait.board;

import java.util.ArrayList;
import java.util.List;

public class Database {

	public final static List<BoardVO> list = new ArrayList();
	/*
	List<BoardVO> : 제네릭 -> 제약사항
	사용하기편함
	*/
	
	/*
	 Array : 넣고 뺴기위해 사용 
	 
	 빼는 기능
	 .get(인덱스(정수형))
	 .add(넣는값(제네릭에 따라 변경가능하며 제네릭이 없으면 오브젝트이므로 아무값이나 들어감))
	 .size()
	 BoVO : 넣고 뺴기위해 사용
	 */
	
	/*
	 Map형식 key=value, request
	 
	 
	 Sequence 형식 배열, ArrayList, LinkedList -> 순서
	 */
}
