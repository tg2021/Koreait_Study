package com.koreait.board7.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardCmtDAO {
	
	public static int insBoardCmt(BoardCmtEntity param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String Sql = " INSERT INTO t_board_cmt "
				+ " (iboard, iuser, cmt)"
				+ " VALUES"
				+ "(?, ?, ?) "; 
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(Sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return result;

	}
	
	public static List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param) {
		List<BoardCmtDomain> list = new ArrayList<BoardCmtDomain>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.icmt, A.cmt, A.regdate, "
				+ " B.iuser, B.unm AS writerNm "
				+ " FROM t_board_cmt A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE A.iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			// 리스트는 작성글을 모두 출력해야하기 때문에 while
			// if는 한 번만 출력할때 사용, 레코드를 확인할 때 if문사용
			
			while(rs.next()) {
				BoardCmtDomain vo = new BoardCmtDomain();
				list.add(vo);
				
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writernm"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}		
		return list;
	}
}
