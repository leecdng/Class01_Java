package com.bitcamp.data;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.home.CommandService;

public class ListCommand implements CommandService {

	public ListCommand() {}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("����� ����ƮĿ�ǵ�");
			//���ڵ� ����
			DataDAO dao = new DataDAO();
			List<DataVO> list = dao.dataSelect();
			
			request.setAttribute("list", list); // request.setAttribute("list", dao.dataSelect());
		
		return "list.jsp";
	}

}
