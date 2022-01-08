package com.seoul.myapp.board;

import java.util.ArrayList;
import java.util.List;

import com.seoul.myapp.DBConnection;

public class BoardDAO extends DBConnection {
	// 총 레코드 수
	public void countTotalRecord(PagingVO pvo) {
		try {
			dbConn();
			
			sql = "select count(no) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pvo.setTotalRecord(rs.getInt(1));
			}
		} catch(Exception e) {
			System.out.println("전체 레코드 수 조회 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 전체 목록 조회
	public List<BoardVO> boardAllList(PagingVO pvo){
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			dbConn();
			
			sql = "select * from (select * from (select no, subject, username, to_char(writedate, 'YYYY.MM.DD') writedate, hit from board b join register r on b.userid = r.userid order by no desc)"
					+ " where rownum<=? order by no asc) where rownum<=? order by no desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pvo.getNowPage() * pvo.getOnePageRecord());
			if(pvo.getNowPage() == pvo.getTotalPage() && pvo.getTotalRecord()%pvo.getOnePageRecord()!=0) {
				pstmt.setInt(2, pvo.getTotalRecord() % pvo.getOnePageRecord());
			} else {
				pstmt.setInt(2, pvo.getOnePageRecord());
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setUsername(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setHit(rs.getInt(5));
				
				list.add(vo);
			}
		} catch(Exception e) {
			System.out.println("게시판 전체 목록 조회 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
}
