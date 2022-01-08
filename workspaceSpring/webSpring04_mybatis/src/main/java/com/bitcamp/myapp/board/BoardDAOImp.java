package com.bitcamp.myapp.board;

import java.util.List;

public interface BoardDAOImp {
	public List<BoardVO> boardAllSelect(); // 전체 글 목록 조회
	public BoardVO boardView(int no); // 1개 글 조회
	public int boardWrite(BoardVO vo); // 글 등록
	public int boardEdit(BoardVO vo); // 글 수정
	public int boardDelete(int no, String userid); // 글 삭제
}
