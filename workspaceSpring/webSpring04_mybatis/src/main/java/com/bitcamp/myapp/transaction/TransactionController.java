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
	
	// --------------------- transacion 梓端
	@Autowired
	// DI 須採拭 赤澗 梓端研 姥薄 // 朔戚虞澗 莫殿稽 梓端研 xml拭辞 幻級嬢早製
	DataSourceTransactionManager transactionManager;
	// DI : 唖 適掘什 娃税 税糎淫域研 朔 竺舛(Bean Definition) 舛左研 郊伝生稽 珍砺戚格亜 切疑生稽 尻衣背爽澗 依
	
	
	@RequestMapping("/transactionTest")
	@Transactional(rollbackFor= {Exception.class, RuntimeException.class}) // Aop : 掻差吉 奄管聖 仙紫遂
	public ModelAndView tran() {
		// 闘沓先芝 坦軒研 是廃 梓端 持失 ************************
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED); // 闘沓先芝戚 蒸生檎 歯稽 幻級壱 赤生檎 益杏 潤虞
		TransactionStatus status = transactionManager.getTransaction(def); // 闘沓先芝税 雌殿 def亜 嬢恐 雌殿昔走
		//**************************************************
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list");
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		try {
			// 湛 腰属 蓄亜拝 傾坪球
			BoardVO vo = new BoardVO();
			vo.setUserid("goguma");
			vo.setSubject("闘沓先芝 砺什闘 掻");
			vo.setContent("越鎧遂ししししし");
			vo.setIp("123.123.123.123");
			dao.boardWrite(vo); // 湛 腰属 蓄亜
			
			// 砧 腰属 蓄亜拝 傾坪球
			BoardVO vo2 = new BoardVO();
			vo2.setUserid("cccちち"); // 神嫌 鎧左奄 - 継拷 鞠惟
			vo2.setSubject("22 闘沓先芝 砺什闘");
			vo2.setContent("222 越鎧遂しししし");
			vo2.setIp("222.123.123.222");
			dao.boardWrite(vo2); // 砧 腰属 蓄亜
			
			transactionManager.commit(status);
			
		}catch(Exception e){
			System.out.println("闘沓先芝 砺什闘 神嫌"); // 掻娃拭 森須 持奄檎 継拷鞠惟 是拭辞 竺舛背鎌製.
			e.printStackTrace();
		}
		
		return mav;
	}
}
