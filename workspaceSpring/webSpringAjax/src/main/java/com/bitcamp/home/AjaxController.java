package com.bitcamp.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping(value="/ajax")
	public String ajaxStart() {
		
		return "ajax/ajaxView";
	}
	
	@RequestMapping(value = "/ajaxStr", method=RequestMethod.GET, produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxString(int num, String name) { // 보내는 변수와 받는 변수가 똑같아야 여기에 담긴다.
		System.out.println("num" + num + ", name" + name);
		return "<h1>번호"+ num + ", 이름" + name + "</h1>";
	}
	
	@RequestMapping(value="ajaxList")
	@ResponseBody
	public List<TestVO> ajaxList(TestVO vo) {
		List<TestVO> list = new ArrayList<TestVO>();
		list.add(vo);
		
		list.add(new TestVO(200, "ggggg", "지지지"));
		list.add(new TestVO(300, "ttttt", "티티"));
		
		return list;
	}
	
	@RequestMapping(value="ajaxObject")
	@ResponseBody
	public TestVO ajaxObject() {
		return new TestVO(500, "goguma", "고구마");
	}
	
	@RequestMapping(value="/ajaxMap")
	@ResponseBody
	public HashMap<String, TestVO> ajaxMap(){
		HashMap<String, TestVO> map = new HashMap<String, TestVO>();
		map.put("k1", new TestVO(1000,"sunsin","순신"));
		map.put("k2", new TestVO(2000,"hong","길동"));
		map.put("k3", new TestVO(3000,"goguma","고구마"));
		
		return map;
	}
	
	@RequestMapping(value="/ajaxJson", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		int no = 123;
		String username = "김연경";
		String tel = "010-7896-9999";
		String addr = "서울시 마포구 백범로";
		
		// 데이터를 문자열로 만든다. (json형식처럼)
		
		String jsonData = "{\"no\":\""+no+"\", \"username\":\"" + username + "\",\"tel\":\"" + tel + "\",\"addr\":\"" + addr + "\"}";
				
		return jsonData;
	}
}





















