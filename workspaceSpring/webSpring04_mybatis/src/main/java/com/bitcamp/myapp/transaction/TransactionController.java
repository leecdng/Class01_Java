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
	
	// --------------------- transacion ��ü
	@Autowired
	// DI �ܺο� �ִ� ��ü�� ���� // ���̶�� ���·� ��ü�� xml���� ���������
	DataSourceTransactionManager transactionManager;
	// DI : �� Ŭ���� ���� �������踦 �� ����(Bean Definition) ������ �������� �����̳ʰ� �ڵ����� �������ִ� ��
	
	
	@RequestMapping("/transactionTest")
	@Transactional(rollbackFor= {Exception.class, RuntimeException.class}) // Aop : �ߺ��� ����� ����
	public ModelAndView tran() {
		// Ʈ����� ó���� ���� ��ü ���� ************************
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED); // Ʈ������� ������ ���� ����� ������ �װ� ���
		TransactionStatus status = transactionManager.getTransaction(def); // Ʈ������� ���� def�� � ��������
		//**************************************************
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list");
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		try {
			// ù ��° �߰��� ���ڵ�
			BoardVO vo = new BoardVO();
			vo.setUserid("goguma");
			vo.setSubject("Ʈ����� �׽�Ʈ ��");
			vo.setContent("�۳��뤷��������");
			vo.setIp("123.123.123.123");
			dao.boardWrite(vo); // ù ��° �߰�
			
			// �� ��° �߰��� ���ڵ�
			BoardVO vo2 = new BoardVO();
			vo2.setUserid("ccc����"); // ���� ������ - �ѹ� �ǰ�
			vo2.setSubject("22 Ʈ����� �׽�Ʈ");
			vo2.setContent("222 �۳��뤷������");
			vo2.setIp("222.123.123.222");
			dao.boardWrite(vo2); // �� ��° �߰�
			
			transactionManager.commit(status);
			
		}catch(Exception e){
			System.out.println("Ʈ����� �׽�Ʈ ����"); // �߰��� ���� ����� �ѹ�ǰ� ������ �����س���.
			e.printStackTrace();
		}
		
		return mav;
	}
}
