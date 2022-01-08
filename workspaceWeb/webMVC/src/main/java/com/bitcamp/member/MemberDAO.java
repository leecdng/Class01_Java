package com.bitcamp.member;

import com.bitcamp.home.DBConnection;

public class MemberDAO extends DBConnection {

	public MemberDAO() {}
	
	// 로그인
	public MemberVO loginOk(String userid, String userpwd) {
		MemberVO vo = new MemberVO();
		
		try {
			dbConn();
			
			sql = "select userid, username from register where userid=? and userpwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUserid(rs.getString(1));
				vo.setUsername(rs.getString(2));
			}	
		} catch(Exception e) {
			System.out.println("로그인 에러.........");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}

}
