package com.bitcamp.home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/*.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, CommandService> hm = new HashMap<String, CommandService>();
       

    public HomeController() {
        super();
    }

    
    public void init(ServletConfig config) throws ServletException{
    	// urlMapping.properties에 있는 key와 value를 구하여 HashMap에 주소와 객체를 저장한다.
    	// web.xml에서 properties 파일명 가져오기
    	String propFileName = config.getInitParameter("path");
    	System.out.println("propFileName = " + propFileName);
    	
    	Properties prop = new Properties();
    	try {
    		// 파일에서 문자열을 읽어 Properties 객체로 저장한다.
    		FileInputStream fis = new FileInputStream(propFileName);
    		prop.load(fis);
    		
    	}catch(Exception e) {
    		System.out.println("프로퍼티 객체 입력 에러 발생" + e.getMessage());
    	}
    	/////////////////////////////////////////////
    	// properties 객체의 모든 키를 구한다.
    	Enumeration keyList = prop.propertyNames();
    	while(keyList.hasMoreElements()) {
    		String key = (String)keyList.nextElement();
    		String className = prop.getProperty(key);
    		
    		// key는 HashMap의 key로 사용하고
    		// value는 객체를 만들어 HashMap의 값으로 사용한다.
    		try {
    			Class commandClass = Class.forName(className); // lang에 Class라는 클래스 있음. // 54,55행 이해 안 됨
    			CommandService service = (CommandService) commandClass.getDeclaredConstructors()[0].newInstance(); // com.bitcamp.home.IndexCommand는 객체가 됨
    			hm.put(key, service);
    		} catch(Exception e) {
    			System.out.println("Command 객체 에러 발생.");
    		}
    		
    		System.out.println("key = " + key + ", className = " + className);
    	}
    }
    
    
    //									정보 가져올 때, 보낼 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctxPath = request.getContextPath();
		String uri = request.getRequestURI();
		System.out.println("ContextPath = " + ctxPath);
		System.out.println("uri = " + uri);
		
		//mapping 주소 구하기
		String key = uri.substring(ctxPath.length()); // index.do
		CommandService command = hm.get(key);
		String viewFileName = command.execute(request, response); // 뷰파일명을 리턴 받음.
		
		// view파일명의 위치로 이동하기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewFileName);
		dispatcher.forward(request, response);
	}

}










