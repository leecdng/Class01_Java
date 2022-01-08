package com.bitcamp.myapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 게시판 목록 조회
	@RequestMapping("/list")
	public ModelAndView list() {
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.boardAllSelect());
		mav.setViewName("board/list");
		return mav;
	}
	
	// 게시판 글 보기
	@RequestMapping("/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("bvo", dao.boardView(no));
		mav.setViewName("board/view");
		
		return mav;
	}

	// 글쓰기폼
	@RequestMapping(value="/write")
	public String write() {
		
		return "board/write";
	}
	

	// 글 등록
	@RequestMapping(value="/writeOk", method=RequestMethod.POST)
	public ModelAndView write(BoardVO vo, HttpSession session, HttpServletRequest request) {
		vo.setUserid((String)session.getAttribute("userid"));
		vo.setIp(request.getRemoteAddr());
		
		ModelAndView mav = new ModelAndView();
		
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardWrite(vo);
		
		if(cnt > 0) { // 글 등록
			System.out.println("등록성공"+cnt);
			mav.setViewName("redirect:list");
		} else { // 글 등록 실패
			System.out.println("등록실패"+cnt);
			mav.addObject("msg", "등록");
			mav.setViewName("board/writeResult");
		}
		return mav;
	}
	
	// 글 수정폼
	@RequestMapping("/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("vo", dao.boardView(no));
		mav.setViewName("board/edit");
		return mav;
	}
	
	// 글 수정
	@RequestMapping("/editOk")
	public ModelAndView editOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("userid"));
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardEdit(vo);
		mav.addObject("no", vo.getNo());
		
		if(cnt > 0) { // 수정 성공 - 글 내용 보기
			mav.setViewName("redirect:view");
		} else { // 수정 실패 - 글 수정 화면
			mav.addObject("msg", "수정");
			mav.setViewName("/board/writeResult");
		}
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(int no, HttpSession session) {
		String userid= (String)session.getAttribute("userid");
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardDelete(no, userid);
		
		if(cnt > 0) { // 삭제 성공 - 글 목록
			mav.setViewName("redirect:list"); // 페이징, 검색어 있으면 데이터 보내줘야 함.
		} else { // 삭제 실패 - 글 내용보기
			mav.addObject("no", no); // 이해 잘 안 됨 질문-> view 아니어도 데이터 보낼 수 있음. 매개변수로 감
			mav.setViewName("redirect:view");
		}
		return mav;
	}
}













