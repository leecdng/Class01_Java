package com.bitcamp.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter { // 이걸 상속 받으면 컨트롤러보다 먼저 여길 옴!
	// 컨트롤러가 호출되기 전에 호출되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		// 로그인 여부를 확인하여 로그인이 안 된 경우 로그인 폼으로 이동 (홈)
		// 로그인이 된 경우 접속한 컨트롤러로 구현
		
		// 로그인된 아이디 구하기
		String userid = (String)request.getSession().getAttribute("userid");
		
		// 로그인이 안 된 경우
		if(userid==null || userid.equals("")) {
			//						/myapp
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		// 로그인이 된 경우 -- 가던 길 감. 접속한 컨트롤러 매핑주소로 이동
		return true;
	}
	
	// 컨트롤러가 실행된 후 view 페이지로 이동하기 전에 호출된다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{ // 상위 클래스 오버라이딩
		
	}
	
	// 컨트롤러가 실행 후 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
	}
}
