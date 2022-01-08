package com.bitcamp.data;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.home.CommandService;

public class DownCountCommand implements CommandService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		DataDAO dao = new DataDAO();
		int cnt = dao.downCount(num);

		request.setAttribute("cnt", cnt);
		System.out.println("�ٿ�ī��ƮĿ�ǵ�" + cnt+", "+num);
		
		return "downCountResult.jsp";
	}

}
