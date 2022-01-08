package com.bitcamp.myapp.board;

import java.util.List;

public interface BoardDAOImpl {
	// 총 레코드 수
	public void totalRecordCount(PagingVO pVo);
	
	// 해당페이지 레코드 선택
	public List<BoardVO> boardPageSelect(PagingVO pVo);
	
	// 글내용보기
	//public BoardVO boardSelect(int no);
	//public BoardVO boardSelect(BoardVO vo);
	public void boardSelect(BoardVO vo);
	
	
	// 댓글 쓰기
	public int replyInsert(ReplyVO rvo);
	
	// 댓글 목록 조회
	public List<ReplyVO> replyListSelect(int no);
	
	// 댓글 수정
	public int replyUpdate(ReplyVO rvo);
	
	// 댓글 삭제
	public int replyDelete(int num, String userid);
	
}
