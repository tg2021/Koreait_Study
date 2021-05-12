package com.koreait.board3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	// 글등록
	public static int insertBoard(BoardVO3 vo) {
		/* TODO DB연결 변수 선언
		Connection : DB연결권한
		Statement : CRUD SQL 연결
		ResultSet : 데이터 담을 객체
		*/
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board (title, ctnt)" + "VALUES (?, ?)";
		/*
		 "INSERT INTO t_board (title, ctnt)" 에서 (title, ctnt)을 지우면 table값을 모두 넣어야한다
		 */

		/*
		물음표의 위치값에 값이 들어간다 "VALUES (?, ?)" 1 안녕하세요, 2 반갑습니다 "VALUES (안녕하세요, 반갑습니다)"
		 */
		/*
		 TODO try catch로 검사 
		 */
		try {
			// TODO DB연결
			con = DBUtils.getCon();
			
			// TODO DB에서 가져올 값 준비
			ps = con.prepareStatement(sql);
			// 넣고자하는 값이 int형
			// ps.setInt(1, 100);

			// 넣고자하는 값이 String형
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate(); // insert, update, delete
			// 내가 영향을 미친 레코드수

		} catch (Exception e) {
			// TODO printStackTrace : 에러문구를 띄워줌
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static List<BoardVO3> selBoardList() {
		List<BoardVO3> list = new ArrayList<BoardVO3>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT iboard, title, regdt FROM t_board " + " ORDER BY iboard DESC ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery(); // select에 사용

			while (rs.next()) {
				BoardVO3 vo = new BoardVO3();
				list.add(vo);

				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				// 레퍼런스변수이기때문에 list.add(vo)가 어디있던 상관없다
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		/*
		 * 예시 BoardVO3 vo = new BoardVO3(); vo.setIboard(1); vo.setTitle("안녕");
		 * list.add(vo);
		 * 
		 * vo = new BoardVO3(); vo.setIboard(2); vo.setTitle("Hello"); list.add(vo);
		 * 
		 * vo = new BoardVO3(); vo.setIboard(3); vo.setTitle("반가워"); list.add(vo);
		 */
		return list;
	}

	public static BoardVO3 selBoard(int iboard) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_board WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);

			rs = ps.executeQuery();

			if (rs.next()) {
				BoardVO3 vo = new BoardVO3();

				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");

				
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);

				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static int updBoard(BoardVO3 iboard) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board SET title = ?, ctnt = ? "
				+ " WHERE iBoard = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, iboard.getTitle());
			ps.setString(2, iboard.getCtnt());
			ps.setInt(3, iboard.getIboard());
			
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}
	
	public static int delBoard(BoardVO3 iboard) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM t_board WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, iboard.getIboard());

			return ps.executeUpdate(); // insert, update, delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;

	}



}
