package memberdata;

import java.util.HashMap;

public class MemberDataSet2 {
	public static HashMap<String, HashMap> allMember = new HashMap<String, HashMap>();
	public static HashMap<String, MemberVO> memberList = new HashMap<String, MemberVO>();
	
	public MemberDataSet2() {
		
	}
	
	public static void addGradeMember(String grade) {
		allMember.put(grade, new HashMap());
	}
	
	public static void addMember(String grade, String id, MemberVO mvo) {
		addGradeMember(grade);
		memberList = allMember.get(grade);
		memberList.put(id, mvo);
	}
	
//	public static void addMember(String grade, String id, MemberVO mvo) {
//		memberList.put(id, mvo);
//		allMember.put(grade, memberList);
//	}
	
	
	public static void MemberData() {
		addMember("관리자", "admin1", new MemberVO("123456", "이관리", new String[] {"1991","01","04"}, "여자", new String[] {"010","1111","1234"}, "admin1@naver.com", "A1234"));
		addMember("관리자", "admin2", new MemberVO("a123456", "김관리", new String[] {"1992","02","20"}, "여자", new String[] {"010","2222","1234"}, "admin2@daum.net", "B1234"));
		addMember("관리자", "admin3", new MemberVO("a123456!", "이관리", new String[] {"1993","03","31"}, "남자",new String[] {"010","3333","1234"}, "admin3@gmail.com", "A0001"));
//		addMember("일반회원", "member1", new MemberVO("123456", "김회원", new String[] {"1991","01","01"}, "여자", new String[] {"010","1111","1111"}, "member1@naver.com"));
//		addMember("일반회원", "member2", new MemberVO("a123456", "정회원", new String[] {"1992","02","20"}, "여자", new String[] {"010","2222","2222"}, "member2@gmail.com"));
//		addMember("일반회원", "member3", new MemberVO("a123456!", "김회원", new String[] {"1993","03","31"}, "남자",new String[] {"010","3333","3333"}, "member3@nate.com"));
	}
}
