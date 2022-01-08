package com.bitcamp.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.service.BoardService;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;
	
	@RequestMapping("/boardList")
	public String boardList(Model model) { // model에 데이터 담김
		model.addAttribute("list", boardService.boardList());
		return "/board/list";
	}
	
	@RequestMapping("/boardView")
	public String boardView(Model model, int no) {
		model.addAttribute("vo", boardService.boardView(no));
		return "board/boardView";
	}
}
