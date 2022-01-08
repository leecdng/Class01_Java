package com.bitcamp.myapp.board;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.myapp.DBConnection;

public class BoardDAO extends DBConnection implements BoardDAOImpl {

	@Override
	public void totalRecordCount(PagingVO pVo) {
		try {
			dbConn();
			sql = "select count(no) from board";
			// 검색어가 있을 때
			if(pVo.getSearchWord()!=null && !pVo.getSearchWord().equals("")) {
				sql += " where "+pVo.getSearchKey()+" like '%" + pVo.getSearchWord() +"%'";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pVo.setTotalRecord(rs.getInt(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	
	@Override
	public List<BoardVO> boardPageSelect(PagingVO pVo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			dbConn();
			sql = "select * from (select * from (select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate from board ";
				//검색어가 있으면
				if(pVo.getSearchWord()!=null && !pVo.getSearchWord().equals("")) {
					sql += "where " + pVo.getSearchKey() + " like '%" + pVo.getSearchWord() + "%'";
				}
				sql += "order by no desc)"
				+ " where rownum <= ? order by no asc) "
				+ " where rownum <= ? order by no desc";
			pstmt = conn.prepareStatement(sql);
			// 현재페이지 * 한 페이지당 레코드 수
			pstmt.setInt(1, pVo.getNowPage() * pVo.getOnePageRecord());
			// 한 페이지당 레코드 수
			// 마지막 페이지의 남은 레코드수 계산
			int lastPageRecord = pVo.getTotalRecord() % pVo.getOnePageRecord(); // 0,1,2,3,4 // 0이면 5의 배수일 때라 if문에서 제외하기
			if(pVo.getTotalPage() == pVo.getNowPage() && lastPageRecord != 0) { // 마지막페이지일 때
				pstmt.setInt(2, lastPageRecord);
			} else {
				pstmt.setInt(2, pVo.getOnePageRecord());
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setNo(rs.getInt(1));
				bvo.setSubject(rs.getString(2));
				bvo.setUserid(rs.getString(3));
				bvo.setHit(rs.getInt(4));
				bvo.setWritedate(rs.getString(5));
				
				list.add(bvo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}


	@Override
	public void boardSelect(BoardVO vo) {
		try {
			dbConn();
			
			sql = "select no, userid, subject, content, hit, to_char(writedate, 'MM/DD HH:MI') writedate from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setWritedate(rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	
	// 댓글 등록
	@Override
	public int replyInsert(ReplyVO rvo) {
		int cnt = 0;
		try {
			dbConn();
			sql = "insert into replyboard(num, userid, coment, no) values(replySq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getUserid());
			pstmt.setString(2, rvo.getComent());
			pstmt.setInt(3, rvo.getNo());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("댓글 쓰기 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	
	// 댓글 목록 조회
	@Override
	public List<ReplyVO> replyListSelect(int no) {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		try {
			dbConn();
			sql = "select num, userid, coment, to_char(writedate, 'YYYY-MM-DD HH:MI') writedate from replyboard where no=? order by no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setNum(rs.getInt(1));
				rvo.setUserid(rs.getString(2));
				rvo.setComent(rs.getString(3));
				rvo.setWritedate(rs.getString(4));
				
				list.add(rvo);
			}
		} catch(Exception e) {
			System.out.println("댓글 목록 조회 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}


	@Override
	public int replyUpdate(ReplyVO rvo) {
		int cnt = 0;
		try {
			dbConn();
			sql = "update replyboard set coment=? where num=? and userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getComent());
			pstmt.setInt(2, rvo.getNum());
			pstmt.setString(3, rvo.getUserid());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("댓글 수정 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}


	@Override
	public int replyDelete(int num, String userid) {
		int cnt = 0;
		try {
			dbConn();
			sql = "delete from replyboard where num=? and userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, userid);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("댓글 삭제 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
}

















