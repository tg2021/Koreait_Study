package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.koreait.board7.DBUtils;

public class UserDAO {
	// 아이디가 있으면 리턴 1, 아이디가 없으면: 0 리턴
	public static int selIdChk(String uid) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT uid FROM t_user WHERE uid = ?";
				
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim());
			rs = ps.executeQuery();
			
			if(rs.next()) { result = 1; }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result; 
		
	}
	
	public static int joinUser(UserEntity param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user (uid, upw, unm, gender) VALUES (?, ?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			
			return ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
		
	}
	
public static UserEntity selUser(UserEntity param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserEntity result = null;
		
		String sql = "SELECT iuser, uid, upw, unm, profileImg "
				+ " FROM t_user "
				+ " WHERE uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int iuser = rs.getInt("iuser");
				String uid = rs.getString("uid");
				String upw = rs.getString("upw");
				String unm = rs.getString("unm");
				String profileImg = rs.getString("profileImg");
				
				result = new  UserEntity();
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);
				result.setProfileImg(profileImg);
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
		
	}

	public static int updUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		String updString = null;
		
		String sql = "UPDATE t_user SET ";
		
		if(param.getUpw() != null && !param.getUpw().equals("")) {
			sql += " upw = ? ";
			updString = param.getUpw();
			
		} else if (param.getProfileImg() != null && !param.getProfileImg().equals("")) {
			sql += " profileImg = ? ";
			updString = param.getProfileImg();
			
		}
		sql += " WHERE iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, updString);
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;			
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
