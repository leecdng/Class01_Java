package com.bitcamp.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.BoardDAO;
import com.bitcamp.myapp.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	@Inject
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> boardList() {
		return boardDAO.boardList();
	}

	@Override
	public BoardVO boardView(int no) {
		return boardDAO.boardView(no);
	}

}
