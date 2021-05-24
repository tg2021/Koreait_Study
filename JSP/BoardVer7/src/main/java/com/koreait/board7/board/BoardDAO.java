package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList() {
		List<BoardDomain> list = new ArrayList<BoardDomain>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.iuser, A.regdt "
				+ ", B.unm as writerNm "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {

				BoardDomain param = new BoardDomain();
				param.setIboard(rs.getInt("iboard"));
				param.setTitle(rs.getString("title"));
				param.setRegdt(rs.getString("regdt"));
				param.setIuser(rs.getInt("iuser"));
				param.setWriterNm(rs.getString("writerNm"));
				list.add(param);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
}
