package com.bitcamp.myapp.dao;

import java.util.List;

import com.bitcamp.myapp.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> boardAllSelect();
	public int boardWrite(BoardVO vo);
	public BoardVO boardView(int no);
	public int boardEdit(BoardVO vo);
	public int boardDelete(int no, String userid);
}
