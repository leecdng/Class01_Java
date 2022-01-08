package com.bitcamp.myapp.board;

import java.util.List;

public interface BoardDAOImp {
	public List<BoardVO> boardAllSelect(); // ��ü �� ��� ��ȸ
	public BoardVO boardView(int no); // 1�� �� ��ȸ
	public int boardWrite(BoardVO vo); // �� ���
	public int boardEdit(BoardVO vo); // �� ����
	public int boardDelete(int no, String userid); // �� ����
}
