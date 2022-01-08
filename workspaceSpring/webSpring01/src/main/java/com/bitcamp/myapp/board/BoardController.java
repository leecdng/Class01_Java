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
		// �� ���ڵ� ��
		dao.totalRecordCount(pVo);
		mav.addObject("list", dao.boardPageSelect(pVo));
		mav.addObject("pVo", pVo);
		mav.setViewName("board/boardList");
		
		return mav;
	}
	
	// �� ���� ����
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
	
	
	// ��� ���� --- ajax�� ����
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	@ResponseBody
	public int replyWrite(ReplyVO rvo, HttpSession session) {
		rvo.setUserid((String)session.getAttribute("logid")); // �ۼ��� id session���� ��������
		return dao.replyInsert(rvo);
	}
	
	// ��� ��� ��ȸ
	@RequestMapping("/replyList")
	@ResponseBody
	public List<ReplyVO> replyList(int no){
		return dao.replyListSelect(no);
	}
	
	// ��� ����
	@RequestMapping(value="/replyEditOk", method=RequestMethod.POST)
	@ResponseBody
	public int replyEditOk(ReplyVO rvo, HttpSession session) {
		rvo.setUserid((String)session.getAttribute("logid")); // �α��� �� ����� ���̿� ���� ���� ���� �����ϰ�
		return dao.replyUpdate(rvo);
	}
	
	// ��� ����
	@RequestMapping("/replyDel")
	@ResponseBody
	public int replyDel(int num, HttpSession session) {
		return dao.replyDelete(num, (String)session.getAttribute("logid"));
	}
}





















