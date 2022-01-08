package com.bitcamp.myapp.board;

import java.util.List;

public interface BoardDAOImpl {
	// �� ���ڵ� ��
	public void totalRecordCount(PagingVO pVo);
	
	// �ش������� ���ڵ� ����
	public List<BoardVO> boardPageSelect(PagingVO pVo);
	
	// �۳��뺸��
	//public BoardVO boardSelect(int no);
	//public BoardVO boardSelect(BoardVO vo);
	public void boardSelect(BoardVO vo);
	
	
	// ��� ����
	public int replyInsert(ReplyVO rvo);
	
	// ��� ��� ��ȸ
	public List<ReplyVO> replyListSelect(int no);
	
	// ��� ����
	public int replyUpdate(ReplyVO rvo);
	
	// ��� ����
	public int replyDelete(int num, String userid);
	
}
