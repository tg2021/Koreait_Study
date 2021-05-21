package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	public static int getAllPage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT ceil(COUNT(*) / ?) as cnt FROM t_board "
				+ " WHERE title LIKE ?";
		
		int result = 0;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%" + param.getSearch() + "%");
			
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {			
			e.printStackTrace();			
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT B.unm"
				+ "	, A.iboard, A.title, A.iuser, A.regdt "				
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE A.title LIKE ? "
				+ " ORDER BY iboard DESC "
				+ " LIMIT ?, ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" + param.getSearch() + "%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
			
			rs = ps.executeQuery();			
			while(rs.next()) {
				BoardVO vo = new BoardVO();								
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO selBoard(BoardVO param) {
		BoardVO result = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT B.unm "
				+ "	, A.iboard, A.title, A.ctnt, A.iuser, A.regdt "				
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();			
			if(rs.next()) {
				result = new BoardVO();
				result.setIboard(rs.getInt("iboard"));
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setRegdt(rs.getString("regdt"));
				result.setIuser(rs.getInt("iuser"));
				result.setUnm(rs.getString("unm"));
			}			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
}
