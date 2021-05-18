package com.koreait.board5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBUtils {
	
	public static Connection getCon() throws Exception {
		/* 
		TODO DB연결 순서 
		1.드라이버 로딩 -> 2.DB연결 -> 3.쿼리준비 -> 4.쿼리실행 -> 5.쿼리 결과  가져오기 -> 6.닫기
		DB의 테이블명, 드라이버, URL, DB이름, 패스워드입력
		JDBC URL -> jdbc:[DBMS]://[데이터베이스식별자]/ 
		*/
		final String DB_NAME = "boardver4";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/" + DB_NAME;
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		/*
		 TODO 드라이버로딩 
		 */
		Class.forName(DRIVER);
		
		
		/*
		TODO DB연결
		*/
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("연결 성공!!");
		
		return con;
	}
	/*
	 TODO DB닫기
	 */
	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		
		if(ps != null) {
			try { ps.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		
		if(con != null) {
			try { con.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		// 하나가 에러가 나더라도 나머지는 닫기위해 if문을 따로 만든다
		/*
		try{
		    //에러가 발생할 수 있는 코드
		    throw new Exception(); //강제 에러 출력 
		}catch (Exception e){
		    //에러시 수행
		     e.printStackTrace(); //오류 출력(방법은 여러가지)
		     throw e; //최상위 클래스가 아니라면 무조건 던져주자
		}finally{
		    //무조건 수행
		} 
		*/
	}
}
