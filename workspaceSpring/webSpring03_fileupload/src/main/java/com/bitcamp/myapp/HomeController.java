package com.bitcamp.myapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	// 여러 개 파일을 업로드 할 경우 (name이 같을 경우)
	@RequestMapping(value="/dataUpload", method=RequestMethod.POST)
	public ModelAndView fileUploadTest(DataVO vo, HttpServletRequest request) {
		// vo -> 작성자, 제목
		
		// 파일 업로드 위치
		// D:\workspaceSpring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webSpring03_fileupload \ upload
		String path = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		// 파일 업로드를 위해서는 HttpServletRequest 객체를 이용하여 MultipartHttpServletRequest 객체를 구해야 한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request; // HttpServletRequest가 MultipartHttpServletRequest를 상속 받는다.
		
		// mr에서 MultipartFile 객체를 얻어와야 한다. // 파일을 첨부한 만큼 mr에 멀티파트파일이 담김.
		List<MultipartFile> files = mr.getFiles("filename"); // name을 적어줌.
		System.out.println("files.size-->" + files.size());
		
		// 업로드할 파일이 있으면
		List<String> fileList = new ArrayList<String>(); // 업로드된 파일명들을 저장할 곳
		
		if(files!=null) { // 업로드할 파일이 있으면 ---- dddd
			for(int i=0; i<files.size(); i++) { // ----- cccc
				// 업로드 할 MultipartFile 객체를 얻어오기
				MultipartFile mf = files.get(i); 
				// 원래 파일명
				String fname = mf.getOriginalFilename();
				
				if(fname!=null && !fname.equals("")) { //~~~~~~~~~~~~~~~~~~~
					
					// 같은 파일명이 서버에 있는지 확인
					File fileObj = new File(path, fname);
					File newFileObj = new File(path, fname);
					if(fileObj.exists()) { // 파일 존재여부 확인 --> 있으면 true, 없으면 false ---- bbbb
						for(int num=1; ; num++) { // 무한루프 ------ aaa
							// 파일명 변경
							int point = fname.lastIndexOf(".");
							String orgFileName = fname.substring(0, point); //파일명
							String orgFileExt = fname.substring(point+1); // 확장자명
							String newFileName = orgFileName + "(" + num + ")." + orgFileExt; // cccc(1).jpg
							newFileObj = new File(path, newFileName);
							if(!newFileObj.exists()) { // 파일명이 존재하지 않으면 반복문 멈춤
								break;
							}
						} // for - aaa
						
					} //if bbbb
					// 업로드 실행
					try {
						mf.transferTo(newFileObj); // 업로드하는 메서드 이때 업로드가 발생
					} catch(Exception e) {
						System.out.println("파일 업로드 실패");
						e.printStackTrace();
					}
					
					fileList.add(newFileObj.getName()); // 경로 빼고 파일 이름만 구해서 list에 담아줌
				} // if ~~~~~~~~~~~~~~~~~~~~~~~~~
			} // for cccc
		} // if dddd
		vo.setFileList(fileList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("result");
		return mav;
	}
}













