package com.bitcamp.app.register;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.app.Constants;

public class RegisterDAO implements RegisterDAOImp{
	public JdbcTemplate template;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public RegisterDAO() { // 생성자
		this.template = Constants.template;
	}
	
	//==============================================
	
	@Override
	public RegisterVO login(RegisterVO vo) {
		// 데이터가 있는지 확인
		String sql = "select count(userid) cnt from register where userid=? and userpwd=?";
		RegisterVO logvo = template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(), vo.getUserpwd());
		
		if(logvo.getCnt()>0) {
			sql = "select userid, username from register where userid=? and userpwd=?";
			// 아이디, 비번 --> vo(Object)
			//						(sql문, sql문에서 선택된 결과, ? 안에 들어갈 내용들)
			return template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(), vo.getUserpwd());
		} else {
			return null;
		}
	}

}
