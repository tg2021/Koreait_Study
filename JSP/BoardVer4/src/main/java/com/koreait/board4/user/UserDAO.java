package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DBUtils;

public class UserDAO {
	
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user (uid, upw, unm, gender) VALUES(?, ?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
			/*
			execute
			1. 수행결과로 Boolean 타입의 값을 반환합니다.
			2. 모든 구문을 수행할 수 있습니다.
			*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;	
	}
	
	// 로그인 성공 : 1, 아이디 없음 : 2, 비밀번호틀림 : 3, 에러 : 4
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		/*
		 유니크가 WHERE절에 있으이면 2줄이 나올 수 없다
		 */
		String sql = "SELECT * FROM t_user WHERE uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				// 아이디가 있는 경우 &비밀번호 체크
				// 비밀번호 체크
				// 사용자가 입력한 비밀번호와 UserVO param에 DB값을 비교
				String dbPw = rs.getString("upw");
				// TODO : DB에 저장된 비밀번호와 입력한 비밀번호가 같은지 확인 
				// checkpw(입력한 비밀번호, 암호화된 비밀번호)
				if(BCrypt.checkpw(param.getUpw(), dbPw)) {
					
					// TODO : iuser와 unm값 받기
					int iuser = rs.getInt("iuser");
					String unm = rs.getString("unm");
					
					param.setIuser(iuser);
					param.setUnm(unm);
					
					return 1;
				} else {
					return 3;
				}
			} else {
				// 아이디가 없는 경우
				return 2;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return 0;
		
	}
}
