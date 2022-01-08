package com.seoul.myapp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seoul.myapp.board.BoardDAO;
import com.seoul.myapp.board.BoardVO;
import com.seoul.myapp.board.PagingVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(PagingVO pvo) {
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardDAO dao = new BoardDAO();
		dao.countTotalRecord(pvo);
		list = dao.boardAllList(pvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pvo", pvo);
		mav.addObject("list", list);
		mav.setViewName("index");
		
		
		return mav;
	}
	
}
