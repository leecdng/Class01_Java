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

	@Autowired // �Ǵ� @inject
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginOk(RegisterVO vo, HttpSession session) {
		// �α��� 
		// xml�� �߻�Ŭ������ �����Ͽ� �߻�Ŭ������ ���� �޴´�.
		RegisterDAOImp dao = sqlSession.getMapper(RegisterDAOImp.class);
		// �޼��� ���� - ���� ���ڵ尡 ������ null ���ϵǰ�, ���÷��ڵ尡 ������ vo ����
		RegisterVO logvo = dao.loginCheck(vo);
		
		// ���� ����
		if(logvo!=null) {
			session.setAttribute("userid", logvo.getUserid());
			session.setAttribute("username", logvo.getUsername());
		}
		return "home";
	}
	
	
	// �α׾ƿ�
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
