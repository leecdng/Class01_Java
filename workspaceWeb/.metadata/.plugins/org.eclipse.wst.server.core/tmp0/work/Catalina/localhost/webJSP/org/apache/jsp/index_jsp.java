/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.50
 * Generated at: 2021-09-03 00:41:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 // 선언부
// 메서드 정의할 곳
public int sum(int a, int b){
	return a+b;
}


  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/04_include/top.jspf", Long.valueOf(1630564924409L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- 지시부 -->\r\n");
      out.write(" <!-- 이 뒤에 import 써도 됨 -->\r\n");
      out.write("<!-- %@import %> -->\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	img{\r\n");
      out.write("		width:300px;\r\n");
      out.write("		height:200px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("	//document.write('javascript~~~ 이게 먼저 찍힘');\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- jspf파일은 웹에서 실행이 안 됨 -->\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	*{\r\n");
      out.write("		box-sizing:border-box;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	ul, li{\r\n");
      out.write("		margin:0;\r\n");
      out.write("		padding:0;\r\n");
      out.write("		list-style:none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#menu > li{\r\n");
      out.write("		float:left;\r\n");
      out.write("		width:200px;\r\n");
      out.write("		height:50px;\r\n");
      out.write("		line-height:50px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.container{\r\n");
      out.write("		width:1000px;\r\n");
      out.write("		margin:0 auto;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div style=\"height:100px; background-color:lightblue\">\r\n");
      out.write("	\r\n");
      out.write("	");

		int num = 1234;
		String username = "이순신";
	
      out.write("\r\n");
      out.write("	<!--=num --> <!--=username -->\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<ul id=\"menu\">\r\n");
      out.write("		<li><a href=\"/webJSP/index.jsp\">홈</a></li>\r\n");
      out.write("		<li><a href=\"/webJSP/board/boardList.jsp\">게시판</a></li>\r\n");
      out.write("		<li>\r\n");
      out.write("		");

			// logId, logName
			if(session.getAttribute("logId")!=null && !session.getAttribute("logId").equals("")){ // 로그인 상태
				
      out.write("\r\n");
      out.write("				");
      out.print(session.getAttribute("logName"));
      out.write("님, <a href=\"");
      out.print(request.getContextPath());
      out.write("/daum_login/logout.jsp\">로그아웃</a>\r\n");
      out.write("				");

			} else{ // 로그인 안 한 상태
				
      out.write("\r\n");
      out.write("				<a href=\"");
      out.print(request.getContextPath());
      out.write("/daum_login/login1.html\">로그인</a>\r\n");
      out.write("				");

			}
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		</li>\r\n");
      out.write("	</ul>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("<br/>\r\n");
      out.print(session.getId());
      out.write("\r\n");
      out.write("\r\n");
      out.write("<hr/>\r\n");
      out.write("<!-- 로그인 확인 \r\n");
      out.write("	로그인 상태 : 회원이름 로그아웃\r\n");
      out.write("	로그인이 안 된 상태 : 로그인\r\n");
      out.write("\r\n");
      out.write("-->\r\n");

	// logId, logName
	if(session.getAttribute("logId")!=null && !session.getAttribute("logId").equals("")){ // 로그인 상태
		
      out.write("\r\n");
      out.write("		");
      out.print(session.getAttribute("logName"));
      out.write("님, <a href=\"");
      out.print(request.getContextPath());
      out.write("/daum_login/logout.jsp\">로그아웃</a>\r\n");
      out.write("		");

	} else{ // 로그인 안 한 상태
		
      out.write("\r\n");
      out.write("		<a href=\"");
      out.print(request.getContextPath());
      out.write("/daum_login/login1.html\">로그인</a>\r\n");
      out.write("		");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1>JSP 첫 번째 페이지</h1>\r\n");
 // 스크립트릿
	// 자바 들어오는 곳
	
	int a = 100;
	String name ="김연경";
	
	a = a*2;
	
	out.println("a="+a); // response 했다는 것
	out.println("<img src='img/wbb2.jpg'/>");
	out.println("sum(100,200)="+sum(100,200));
	
	System.out.println("sum(56,43)="+sum(56,43)); // 콘솔에 찍힘
	
	
	for(int i=1; i<10; i++){
		out.println(i);
	}

      out.write("\r\n");
      out.write("<hr/>\r\n");
      out.write("<h1>변수, 간단한 수식, 메서드 호출하여 결과를 클라이언트한테 보낼 때</h1>\r\n");
      out.write("a = ");

	out.println(a);

      out.write("\r\n");
      out.write("a = ");
      out.print(a);
      out.write(" <!-- 반드시 %=는 반드시 붙여야 함. out.print라고 생각하면 됨 -->\r\n");
      out.write("<br/>\r\n");
      out.write("a = ");
      out.print(a+10 );
      out.write("<br/>\r\n");
      out.write("sum = ");
      out.print(sum(5,124) );
      out.write(" <!-- 여기선 세미콜론 쓰면 에러남 -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
