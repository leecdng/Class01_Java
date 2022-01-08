package com.bitcamp.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.MemberDAO;
import com.bitcamp.myapp.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Inject // 객체를 만들어줌
	MemberDAO memberDAO;
	
	@Override
	public MemberVO loginSelect(MemberVO vo) {
		// dao의 메서드 호출
		
		return memberDAO.loginSelect(vo);
	}
	
}
