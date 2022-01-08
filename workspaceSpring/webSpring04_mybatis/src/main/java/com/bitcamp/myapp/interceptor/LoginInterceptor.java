package com.bitcamp.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter { // �̰� ��� ������ ��Ʈ�ѷ����� ���� ���� ��!
	// ��Ʈ�ѷ��� ȣ��Ǳ� ���� ȣ��Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		// �α��� ���θ� Ȯ���Ͽ� �α����� �� �� ��� �α��� ������ �̵� (Ȩ)
		// �α����� �� ��� ������ ��Ʈ�ѷ��� ����
		
		// �α��ε� ���̵� ���ϱ�
		String userid = (String)request.getSession().getAttribute("userid");
		
		// �α����� �� �� ���
		if(userid==null || userid.equals("")) {
			//						/myapp
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		// �α����� �� ��� -- ���� �� ��. ������ ��Ʈ�ѷ� �����ּҷ� �̵�
		return true;
	}
	
	// ��Ʈ�ѷ��� ����� �� view �������� �̵��ϱ� ���� ȣ��ȴ�.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{ // ���� Ŭ���� �������̵�
		
	}
	
	// ��Ʈ�ѷ��� ���� �� ȣ��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
	}
}
