package com.bitcamp.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.myapp.vo.BoardVO;

public interface BoardDAO {
	// �Խ��� ���
	@Select("select no, subject, content, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate "
			+ "from board order by no desc")	
	public List<BoardVO> boardList();
	
	
	// �Խñ� ����
	@Select("select no, subject, userid, content, hit, writedate from board where no=#{no}")
	public BoardVO boardView(int no);
}
