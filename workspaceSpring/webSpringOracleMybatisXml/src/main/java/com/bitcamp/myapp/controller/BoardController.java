package com.bitcamp.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.service.BoardService;
import com.bitcamp.myapp.vo.BoardVO;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;
	@RequestMapping("/board/list")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", boardService.boardAllSelect());
		mav.setViewName("board/list");
		
		return mav;
	}
	
	@RequestMapping("/board/write")
	public String boardWrite() {
		return "board/write";
	}
	
	@RequestMapping(value="/board/writeOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo, HttpServletRequest request) {
		vo.setIp(request.getRemoteAddr());
		vo.setUserid((String)request.getSession().getAttribute("userid"));
		int cnt = boardService.boardWrite(vo);
		ModelAndView mav = new ModelAndView();
		if(cnt > 0) { // 이번엔 그냥 등록 실패해도 리스트로 보내기
			mav.setViewName("redirect:/board/list");
		} else {
			mav.setViewName("redirect:/board/list");
		}
		
		return mav;
	}
	
	@RequestMapping("/board/view")
	public ModelAndView boardView(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", boardService.boardView(no));
		mav.setViewName("/board/view");
		return mav;
	}
	
	@RequestMapping("/board/edit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", boardService.boardView(no));
		mav.setViewName("/board/edit");
		return mav;
	}
	
	@RequestMapping("/board/editOk")
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		vo.setUserid((String)session.getAttribute("userid"));
		int result = boardService.boardEdit(vo);
		if(result>0) {
			mav.addObject("no", vo.getNo());
			mav.setViewName("redirect:/board/view");
		} else {
			mav.setViewName("board/result");
		}
		return mav;
	}
	
	@RequestMapping("/board/delete")
	public ModelAndView boardDelete(int no, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String userid = (String)session.getAttribute("userid");
		int result = boardService.boardDelete(no, userid);
		if(result>0) {
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("/board/result"); // 쌤은 no 데이터 보내고 view로 보내셨음
		}
		return mav;
	}
	
}
