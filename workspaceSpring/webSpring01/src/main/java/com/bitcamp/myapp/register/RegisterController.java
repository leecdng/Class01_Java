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

@Controller // ��Ʈ�ѷ� ��ü�� �� (��ӹ޴� ����)
public class RegisterController {
	RegisterDAO dao = new RegisterDAO();
	
	
	public RegisterController() { // ���� �߰����� ��
		System.out.println("�������ͻ�����"); // ���� ������ ������ ��ü�� ���� (�����ڸ� �����)
	}
	
	@RequestMapping("/registerForm") // index.do ���� ����. �� �̸��ϰ� �Ʒ� �޼�����ϰ� ������ (�򰥸��� ����)
	public String registerForm() {
		
		return "register/form";
	}
	
	
	
	
	
	@RequestMapping("/idCheck")
	public ModelAndView idCheck(String userid){	// �����Ϳ� �����ϸ��� ��� ��� ��ü
		
		int result = dao.idDoubleCheck(userid);
		
		ModelAndView mav = new ModelAndView(); // �����Ͽ� �ʿ��� ������, �����ϸ��� �����ϴ� ��ü
		mav.addObject("userid", userid);
		mav.addObject("result", result);
		mav.setViewName("register/idCheck");
		
		return mav;
	}
	
	// �����ȣ �˻���������
	@RequestMapping("/zipSearch")
	public String zipSearch() {
		
		return "register/zipcodeSearch";
	}
	
	// �����ȣ �˻�
	@RequestMapping("/zipFind")
	@ResponseBody	// �̵� �� �Ϸ��� Ajax ������ ����
	public List<ZipCodeVO> zipFind(String doro){
		// 	List<ZipCodeVO> list = dao.zipSearchRecord(doro);
		
		return dao.zipSearchRecord(doro);
	}
	
	// ȸ�����								post����� ���� �ݵ�� ���
	@RequestMapping(value = "/formOk", method = RequestMethod.POST)
	public String formOk(RegisterVO vo, Model model) { // �Ű������� vo�� ���ָ�, jsp���� name�� vo�� �ִ� ��������� ������ �ڵ����� request�ȴ�. ip�� �Ұ�.
		// ȸ�����
		int result = dao.insertRecord(vo);
		// ��Ͽ���, �����ϸ�
		model.addAttribute("result", result);
		return "register/formResult";
	}
	
	// �α�����
	@RequestMapping("/login")
	public String loginForm() {
		return "register/login";
	}
	
	// �α���
	@RequestMapping(value="loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest req, RegisterVO vo) {
		dao.loginSelect(vo);
		
		ModelAndView mav = new ModelAndView();
		if(vo.getLogStatus()) {	// �α��� ���� - �α���������
			HttpSession session = req.getSession(); // ������������ �ٷ� ���� �޾ƿ͵� ��.
			// �̸�, �α��� ����
			session.setAttribute("logname", vo.getUsername());
			session.setAttribute("logid", vo.getUserid());
			session.setAttribute("logStatus", vo.getLogStatus());
			System.out.print(vo.getLogStatus());
			mav.setViewName("redirect:/"); // redirect -> ��Ʈ�ѷ��� �̵���Ŵ. // ������ ����� jsp�� �����ִ� �� �� ����. ����� �����ִ� ���̰�, ���� ã�⵵ ����.
		} else { // �α��� ���� - Ȩ����
			mav.setViewName("redirect:login");
		}
		return mav;
	}
	
	// �α׾ƿ�
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();	// ���� �ʱ�ȭ
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;	// String���� redirect:/�� ���൵ ��.
	}
	
	// ȸ������ ��ȸ (����ȭ��)
	@RequestMapping("/registerEdit")
	public ModelAndView registerEdit(HttpSession session) { // ������ �Ű������� �־��ָ� �������� �ڵ����� ������Ʈ�� ���༭(?) �ٷ� �������� �޾ƿ͵� �ȴ�.
		RegisterVO vo = new RegisterVO();
		vo.setUserid((String)session.getAttribute("logid"));
		dao.selectRecord(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("register/edit");
		return mav;
	}
	
	// ȸ������ ����
	@RequestMapping(value = "/editOk", method=RequestMethod.POST)
	public ModelAndView editOk(RegisterVO regVo, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		regVo.setUserid((String)session.getAttribute("logid"));
		int result = dao.updateRecord(regVo);
		
		// ���� ���н� history, ���� ���� : ���������� �̵�
		///////////////�Է��ϱ�
		
		mav.addObject("result", result);
		mav.addObject("vo", regVo);
		mav.setViewName("register/editResult");
		
		return mav;
	}
}
