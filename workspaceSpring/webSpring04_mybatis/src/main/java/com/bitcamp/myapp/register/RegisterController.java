package com.bitcamp.myapp.register;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired // 또는 @inject
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginOk(RegisterVO vo, HttpSession session) {
		// 로그인 
		// xml과 추상클래스를 매핑하여 추상클래스를 리턴 받는다.
		RegisterDAOImp dao = sqlSession.getMapper(RegisterDAOImp.class);
		// 메서드 실행 - 선택 레코드가 없으면 null 리턴되고, 선택레코드가 있으면 vo 리턴
		RegisterVO logvo = dao.loginCheck(vo);
		
		// 세션 저장
		if(logvo!=null) {
			session.setAttribute("userid", logvo.getUserid());
			session.setAttribute("username", logvo.getUsername());
		}
		return "home";
	}
	
	
	// 로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
