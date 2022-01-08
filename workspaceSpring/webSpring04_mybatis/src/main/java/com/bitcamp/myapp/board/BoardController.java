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
	
	// �Խ��� ��� ��ȸ
	@RequestMapping("/list")
	public ModelAndView list() {
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.boardAllSelect());
		mav.setViewName("board/list");
		return mav;
	}
	
	// �Խ��� �� ����
	@RequestMapping("/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("bvo", dao.boardView(no));
		mav.setViewName("board/view");
		
		return mav;
	}

	// �۾�����
	@RequestMapping(value="/write")
	public String write() {
		
		return "board/write";
	}
	

	// �� ���
	@RequestMapping(value="/writeOk", method=RequestMethod.POST)
	public ModelAndView write(BoardVO vo, HttpSession session, HttpServletRequest request) {
		vo.setUserid((String)session.getAttribute("userid"));
		vo.setIp(request.getRemoteAddr());
		
		ModelAndView mav = new ModelAndView();
		
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardWrite(vo);
		
		if(cnt > 0) { // �� ���
			System.out.println("��ϼ���"+cnt);
			mav.setViewName("redirect:list");
		} else { // �� ��� ����
			System.out.println("��Ͻ���"+cnt);
			mav.addObject("msg", "���");
			mav.setViewName("board/writeResult");
		}
		return mav;
	}
	
	// �� ������
	@RequestMapping("/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("vo", dao.boardView(no));
		mav.setViewName("board/edit");
		return mav;
	}
	
	// �� ����
	@RequestMapping("/editOk")
	public ModelAndView editOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("userid"));
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardEdit(vo);
		mav.addObject("no", vo.getNo());
		
		if(cnt > 0) { // ���� ���� - �� ���� ����
			mav.setViewName("redirect:view");
		} else { // ���� ���� - �� ���� ȭ��
			mav.addObject("msg", "����");
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
		
		if(cnt > 0) { // ���� ���� - �� ���
			mav.setViewName("redirect:list"); // ����¡, �˻��� ������ ������ ������� ��.
		} else { // ���� ���� - �� ���뺸��
			mav.addObject("no", no); // ���� �� �� �� ����-> view �ƴϾ ������ ���� �� ����. �Ű������� ��
			mav.setViewName("redirect:view");
		}
		return mav;
	}
}













