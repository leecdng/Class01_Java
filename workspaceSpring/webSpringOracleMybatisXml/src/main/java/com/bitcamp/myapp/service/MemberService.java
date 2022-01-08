package com.bitcamp.myapp.service;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.vo.MemberVO;


public interface MemberService {
	public MemberVO loginSelect(MemberVO vo);
}
