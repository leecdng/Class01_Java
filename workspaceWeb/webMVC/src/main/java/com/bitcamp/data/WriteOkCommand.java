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
		// 파일이 업로드되는 위치의 절대주소를 구한다
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("path = " + path);
		
		// 파일업로드와 폼의 데이터를 서버로 가져가는 클래스
		// 1. request	2. 파일업로드 위치
		// 3. 업로드 가능한 파일의 최대 크기 (byte단위) 1024*1024*1024 (1기가(?))
		// 4. 한글인코딩
		// 5. 파일명이 중복될 때 파일명을 Rename 해주는 클래스를 객체로 만들어준다.
		int maxSize = 1024 * 1024 * 1024; // 3번 매개변수
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // 파일이 중복될 때 알아서 파일명 바꿔줌
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", policy);
		
		DataVO vo = new DataVO();
		vo.setTitle(mr.getParameter("title")); // 폼에서 글제목 name
		vo.setContent(mr.getParameter("content")); // mr에 request가 전달되어 있음.
		System.out.println(vo.getTitle() +", " +vo.getContent());
		
		HttpSession ses = request.getSession();
		vo.setUserid((String)ses.getAttribute("userid"));
		
		// 파일명 처리
		// 1. form에 있는 name 정보를 얻어오기
		Enumeration fileList = mr.getFileNames(); // filename
		
		while(fileList.hasMoreElements()) {
			String fileAttr = (String) fileList.nextElement();
			// 변경된 파일 이름 가져오기
			String newFilename = mr.getFilesystemName(fileAttr);
			System.out.println("파일명 --> " + newFilename);
			vo.setFilename(newFilename);
		}
		
		// 데이터베이스에 레코드 추가
		DataDAO dao = new DataDAO();
		int result = dao.dataInsert(vo);
		String viewFile = "";
		
		if(result<=0) { // 글 등록 실패시
			// 글이 등록되지 않았을 때
			// 파일 삭제 후 글쓰기폼으로 (history)
			File file = new File(path, vo.getFilename()); // 경로, 파일명인 듯
			file.delete();
		}
		request.setAttribute("cnt", result);
	
		
		return "dataWriteOk.jsp";
	}

}















