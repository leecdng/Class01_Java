package com.seoul.myapp.register;

import com.seoul.myapp.DBConnection;

public class RegisterDAO extends DBConnection {
	public RegisterVO selectUser(String userid, String userpwd) {
		RegisterVO vo = new RegisterVO();
		try {
			dbConn();
			sql = "select userid, userpwd, username from register where userid=? and userpwd=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUserid(rs.getString(1));
				vo.setUserpwd(rs.getString(2));
				vo.setUsername(rs.getString(3));
			}
		} catch(Exception e) {
			System.out.println("회원정보 불러오기 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
}
