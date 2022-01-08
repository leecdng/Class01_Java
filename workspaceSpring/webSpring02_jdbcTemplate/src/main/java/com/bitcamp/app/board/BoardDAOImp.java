package com.bitcamp.app.board;

import java.util.List;

public interface BoardDAOImp {
	// ����Ʈ -> ���ڵ� ��ü ����
	public List<BoardVO> allRecord();
	
	// �� ���� ����, ���������� �̵��� �� -> ���ڵ� 1�� ����
	public BoardVO oneRecord(int no);
	
	// �� �����ϱ�
	public int boardUpdate(BoardVO vo);
	
	// �� ����ϱ�
	public int boardInsert(BoardVO vo);
	
	// �� �����ϱ�
	public int boardDelete(int no);
	
}
