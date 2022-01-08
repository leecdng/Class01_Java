package com.bitcamp.myapp.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.board.BoardDAOImp;
import com.bitcamp.myapp.board.BoardVO;

@Controller
public class TransactionController {
	@Autowired
	SqlSession sqlSession;
	
	// --------------------- transacion 객체
	@Autowired
	// DI 외부에 있는 객체를 구현 // 빈이라는 형태로 객체를 xml에서 만들어줬음
	DataSourceTransactionManager transactionManager;
	// DI : 각 클래스 간의 의존관계를 빈 설정(Bean Definition) 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것
	
	
	@RequestMapping("/transactionTest")
	@Transactional(rollbackFor= {Exception.class, RuntimeException.class}) // Aop : 중복된 기능을 재사용
	public ModelAndView tran() {
		// 트랜잭션 처리를 위한 객체 생성 ************************
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED); // 트랜잭션이 없으면 새로 만들고 있으면 그걸 써라
		TransactionStatus status = transactionManager.getTransaction(def); // 트랜잭션의 상태 def가 어떤 상태인지
		//**************************************************
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list");
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		try {
			// 첫 번째 추가할 레코드
			BoardVO vo = new BoardVO();
			vo.setUserid("goguma");
			vo.setSubject("트랜잭션 테스트 중");
			vo.setContent("글내용ㅇㅇㅇㅇㅇ");
			vo.setIp("123.123.123.123");
			dao.boardWrite(vo); // 첫 번째 추가
			
			// 두 번째 추가할 레코드
			BoardVO vo2 = new BoardVO();
			vo2.setUserid("cccㅑㅑ"); // 오류 내보기 - 롤백 되게
			vo2.setSubject("22 트랜잭션 테스트");
			vo2.setContent("222 글내용ㅇㅇㅇㅇ");
			vo2.setIp("222.123.123.222");
			dao.boardWrite(vo2); // 두 번째 추가
			
			transactionManager.commit(status);
			
		}catch(Exception e){
			System.out.println("트랜잭션 테스트 오류"); // 중간에 예외 생기면 롤백되게 위에서 설정해놨음.
			e.printStackTrace();
		}
		
		return mav;
	}
}
