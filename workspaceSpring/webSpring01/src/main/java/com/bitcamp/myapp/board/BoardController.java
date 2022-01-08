package com.bitcamp.myapp.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	BoardDAO dao = new BoardDAO();
	
	@RequestMapping("/boardList")
	public ModelAndView boardList(PagingVO pVo) {
		ModelAndView mav = new ModelAndView();
		// 총 레코드 수
		dao.totalRecordCount(pVo);
		mav.addObject("list", dao.boardPageSelect(pVo));
		mav.addObject("pVo", pVo);
		mav.setViewName("board/boardList");
		
		return mav;
	}
	
	// 글 내용 보기
	@RequestMapping("/boardView")
	public ModelAndView boardView(BoardVO vo, PagingVO pVo) {
		ModelAndView mav = new ModelAndView();
		
		dao.boardSelect(vo);
		mav.addObject("bvo", vo);
		mav.addObject("pVo", pVo);
		mav.addObject("list", dao.replyListSelect(vo.getNo()));
		mav.setViewName("board/boardView");
		
		return mav;
	}
	
	
	// 댓글 쓰기 --- ajax로 구현
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	@ResponseBody
	public int replyWrite(ReplyVO rvo, HttpSession session) {
		rvo.setUserid((String)session.getAttribute("logid")); // 작성자 id session에서 가져오기
		return dao.replyInsert(rvo);
	}
	
	// 댓글 목록 조회
	@RequestMapping("/replyList")
	@ResponseBody
	public List<ReplyVO> replyList(int no){
		return dao.replyListSelect(no);
	}
	
	// 댓글 수정
	@RequestMapping(value="/replyEditOk", method=RequestMethod.POST)
	@ResponseBody
	public int replyEditOk(ReplyVO rvo, HttpSession session) {
		rvo.setUserid((String)session.getAttribute("logid")); // 로그인 한 사람이 댓쓴이와 같을 때만 수정 가능하게
		return dao.replyUpdate(rvo);
	}
	
	// 댓글 삭제
	@RequestMapping("/replyDel")
	@ResponseBody
	public int replyDel(int num, HttpSession session) {
		return dao.replyDelete(num, (String)session.getAttribute("logid"));
	}
}





















