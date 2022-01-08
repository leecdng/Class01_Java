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
	
	// ���� �� ������ ���ε� �� ��� (name�� ���� ���)
	@RequestMapping(value="/dataUpload", method=RequestMethod.POST)
	public ModelAndView fileUploadTest(DataVO vo, HttpServletRequest request) {
		// vo -> �ۼ���, ����
		
		// ���� ���ε� ��ġ
		// D:\workspaceSpring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webSpring03_fileupload \ upload
		String path = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		// ���� ���ε带 ���ؼ��� HttpServletRequest ��ü�� �̿��Ͽ� MultipartHttpServletRequest ��ü�� ���ؾ� �Ѵ�.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request; // HttpServletRequest�� MultipartHttpServletRequest�� ��� �޴´�.
		
		// mr���� MultipartFile ��ü�� ���;� �Ѵ�. // ������ ÷���� ��ŭ mr�� ��Ƽ��Ʈ������ ���.
		List<MultipartFile> files = mr.getFiles("filename"); // name�� ������.
		System.out.println("files.size-->" + files.size());
		
		// ���ε��� ������ ������
		List<String> fileList = new ArrayList<String>(); // ���ε�� ���ϸ���� ������ ��
		
		if(files!=null) { // ���ε��� ������ ������ ---- dddd
			for(int i=0; i<files.size(); i++) { // ----- cccc
				// ���ε� �� MultipartFile ��ü�� ������
				MultipartFile mf = files.get(i); 
				// ���� ���ϸ�
				String fname = mf.getOriginalFilename();
				
				if(fname!=null && !fname.equals("")) { //~~~~~~~~~~~~~~~~~~~
					
					// ���� ���ϸ��� ������ �ִ��� Ȯ��
					File fileObj = new File(path, fname);
					File newFileObj = new File(path, fname);
					if(fileObj.exists()) { // ���� ���翩�� Ȯ�� --> ������ true, ������ false ---- bbbb
						for(int num=1; ; num++) { // ���ѷ��� ------ aaa
							// ���ϸ� ����
							int point = fname.lastIndexOf(".");
							String orgFileName = fname.substring(0, point); //���ϸ�
							String orgFileExt = fname.substring(point+1); // Ȯ���ڸ�
							String newFileName = orgFileName + "(" + num + ")." + orgFileExt; // cccc(1).jpg
							newFileObj = new File(path, newFileName);
							if(!newFileObj.exists()) { // ���ϸ��� �������� ������ �ݺ��� ����
								break;
							}
						} // for - aaa
						
					} //if bbbb
					// ���ε� ����
					try {
						mf.transferTo(newFileObj); // ���ε��ϴ� �޼��� �̶� ���ε尡 �߻�
					} catch(Exception e) {
						System.out.println("���� ���ε� ����");
						e.printStackTrace();
					}
					
					fileList.add(newFileObj.getName()); // ��� ���� ���� �̸��� ���ؼ� list�� �����
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













