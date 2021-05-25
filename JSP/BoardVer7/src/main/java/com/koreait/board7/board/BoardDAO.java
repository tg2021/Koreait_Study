package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.koreait.board7.DBUtils;

public class BoardDAO {
	
	public static int selPageingCnt(BoardDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		// StringBuilder문자열 합칠때 사용
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL(COUNT(iboard) / ?)")
		.append("FROM t_board A")
		.append(" INNER JOIN t_user B ")
		.append(" ON A.iuser = B.iuser ");
		
		if(param.getSearchType() > 0) {
			sb.append(" WHERE ");
		}
		
		switch(param.getSearchType()) {
		case 1: // 제목+내용
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 2: // 제목
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 3: // 내용
			sb.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4: // 글쓴이
			sb.append("B.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
			
		}
		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;		
	}
	
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList<BoardDomain>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.iuser, A.regdt "
				+ ", B.unm as writerNm "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser ";
				
				switch(param.getSearchType()) {
				case 1: // 제목+내용
					sql += String.format("WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%'"
							, param.getSearchText(), param.getSearchText());
					break;
				case 2: // 제목
					sql += String.format("WHERE A.title LIKE '%%%s%%' "
							, param.getSearchText());
					break;
				case 3: // 내용
					sql += String.format("WHERE A.ctnt LIKE '%%%s%%' "
							, param.getSearchText());
					break;
				case 4: // 글쓴이
//					sql += String.format("WHERE B.unm LIKE '%%s%%' "
//							, param.getSearchText());
					sql += "WHERE B.unm LIKE '%" + param.getSearchText() + "%'";
					break;
					
				}
				
	   sql +=  " ORDER BY iboard DESC"
				+ "	LIMIT ?, ? ";
				
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String writerNm = rs.getString("writerNm");
				
				BoardDomain dm = new BoardDomain();
				list.add(dm);
				dm.setIboard(iboard);
				dm.setTitle(title);
				dm.setWriterNm(writerNm);
				dm.setRegdt(regdt);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardDomain selBoard(BoardDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDomain result = null;
		
		String sql = "SELECT A.iboard, A.title, A.iuser, A.regdt, A.ctnt "
				+ ", B.unm AS writerNm "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser"
				+ " WHERE A.iboard = ? ";
				
		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				result = new BoardDomain();
				result.setIboard(param.getIboard());
				result.setTitle(rs.getString("title"));
				result.setIuser(rs.getInt("iuser"));
				result.setRegdt(rs.getString("regdt"));
				result.setCtnt(rs.getString("ctnt"));
				result.setWriterNm(rs.getString("writerNm"));
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	
}
