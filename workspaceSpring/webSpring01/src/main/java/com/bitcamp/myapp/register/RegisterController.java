package com.bitcamp.myapp.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // 컨트롤러 객체가 됨 (상속받는 느낌)
public class RegisterController {
	RegisterDAO dao = new RegisterDAO();
	
	
	public RegisterController() { // 내가 추가해준 것
		System.out.println("레지스터생성자"); // 서버 연결할 때마다 객체를 생성 (생성자만 실행됨)
	}
	
	@RequestMapping("/registerForm") // index.do 같은 느낌. 이 이름하고 아래 메서드명하고 맞춰줌 (헷갈릴까 봐ㅎ)
	public String registerForm() {
		
		return "register/form";
	}
	
	
	
	
	
	@RequestMapping("/idCheck")
	public ModelAndView idCheck(String userid){	// 데이터와 뷰파일명을 모두 담는 객체
		
		int result = dao.idDoubleCheck(userid);
		
		ModelAndView mav = new ModelAndView(); // 뷰파일에 필요한 데이터, 뷰파일명을 저장하는 객체
		mav.addObject("userid", userid);
		mav.addObject("result", result);
		mav.setViewName("register/idCheck");
		
		return mav;
	}
	
	// 우편번호 검색페이지로
	@RequestMapping("/zipSearch")
	public String zipSearch() {
		
		return "register/zipcodeSearch";
	}
	
	// 우편번호 검색
	@RequestMapping("/zipFind")
	@ResponseBody	// 이동 안 하려고 Ajax 때문에 써줌
	public List<ZipCodeVO> zipFind(String doro){
		// 	List<ZipCodeVO> list = dao.zipSearchRecord(doro);
		
		return dao.zipSearchRecord(doro);
	}
	
	// 회원등록								post방식일 때는 반드시 명시
	@RequestMapping(value = "/formOk", method = RequestMethod.POST)
	public String formOk(RegisterVO vo, Model model) { // 매개변수에 vo로 써주면, jsp에서 name이 vo에 있는 멤버변수와 같으면 자동으로 request된다. ip는 불가.
		// 회원등록
		int result = dao.insertRecord(vo);
		// 등록여부, 뷰파일명
		model.addAttribute("result", result);
		return "register/formResult";
	}
	
	// 로그인폼
	@RequestMapping("/login")
	public String loginForm() {
		return "register/login";
	}
	
	// 로그인
	@RequestMapping(value="loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest req, RegisterVO vo) {
		dao.loginSelect(vo);
		
		ModelAndView mav = new ModelAndView();
		if(vo.getLogStatus()) {	// 로그인 성공 - 로그인폼으로
			HttpSession session = req.getSession(); // 스프링에서는 바로 세션 받아와도 됨.
			// 이름, 로그인 상태
			session.setAttribute("logname", vo.getUsername());
			session.setAttribute("logid", vo.getUserid());
			session.setAttribute("logStatus", vo.getLogStatus());
			System.out.print(vo.getLogStatus());
			mav.setViewName("redirect:/"); // redirect -> 컨트롤러로 이동시킴. // 보내는 기능을 jsp로 나눠주는 게 더 좋음. 기능을 나눠주는 것이고, 오류 찾기도 쉬움.
		} else { // 로그인 실패 - 홈으로
			mav.setViewName("redirect:login");
		}
		return mav;
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();	// 세션 초기화
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;	// String으로 redirect:/만 써줘도 됨.
	}
	
	// 회원정보 조회 (수정화면)
	@RequestMapping("/registerEdit")
	public ModelAndView registerEdit(HttpSession session) { // 세션을 매개변수로 넣어주면 스프링이 자동으로 리퀘스트를 해줘서(?) 바로 세션으로 받아와도 된다.
		RegisterVO vo = new RegisterVO();
		vo.setUserid((String)session.getAttribute("logid"));
		dao.selectRecord(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("register/edit");
		return mav;
	}
	
	// 회원정보 수정
	@RequestMapping(value = "/editOk", method=RequestMethod.POST)
	public ModelAndView editOk(RegisterVO regVo, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		regVo.setUserid((String)session.getAttribute("logid"));
		int result = dao.updateRecord(regVo);
		
		// 수정 실패시 history, 수정 성공 : 수정폼으로 이동
		///////////////입력하기
		
		mav.addObject("result", result);
		mav.addObject("vo", regVo);
		mav.setViewName("register/editResult");
		
		return mav;
	}
}
