package com.bitcamp.data;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements CommandService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������ ���ε�Ǵ� ��ġ�� �����ּҸ� ���Ѵ�
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("path = " + path);
		
		// ���Ͼ��ε�� ���� �����͸� ������ �������� Ŭ����
		// 1. request	2. ���Ͼ��ε� ��ġ
		// 3. ���ε� ������ ������ �ִ� ũ�� (byte����) 1024*1024*1024 (1�Ⱑ(?))
		// 4. �ѱ����ڵ�
		// 5. ���ϸ��� �ߺ��� �� ���ϸ��� Rename ���ִ� Ŭ������ ��ü�� ������ش�.
		int maxSize = 1024 * 1024 * 1024; // 3�� �Ű�����
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // ������ �ߺ��� �� �˾Ƽ� ���ϸ� �ٲ���
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", policy);
		
		DataVO vo = new DataVO();
		vo.setTitle(mr.getParameter("title")); // ������ ������ name
		vo.setContent(mr.getParameter("content")); // mr�� request�� ���޵Ǿ� ����.
		System.out.println(vo.getTitle() +", " +vo.getContent());
		
		HttpSession ses = request.getSession();
		vo.setUserid((String)ses.getAttribute("userid"));
		
		// ���ϸ� ó��
		// 1. form�� �ִ� name ������ ������
		Enumeration fileList = mr.getFileNames(); // filename
		
		while(fileList.hasMoreElements()) {
			String fileAttr = (String) fileList.nextElement();
			// ����� ���� �̸� ��������
			String newFilename = mr.getFilesystemName(fileAttr);
			System.out.println("���ϸ� --> " + newFilename);
			vo.setFilename(newFilename);
		}
		
		// �����ͺ��̽��� ���ڵ� �߰�
		DataDAO dao = new DataDAO();
		int result = dao.dataInsert(vo);
		String viewFile = "";
		
		if(result<=0) { // �� ��� ���н�
			// ���� ��ϵ��� �ʾ��� ��
			// ���� ���� �� �۾��������� (history)
			File file = new File(path, vo.getFilename()); // ���, ���ϸ��� ��
			file.delete();
		}
		request.setAttribute("cnt", result);
	
		
		return "dataWriteOk.jsp";
	}

}















