package memberdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberDataSet {
	public static HashMap<String, MemberVO> memberList = new HashMap<String, MemberVO>();
	public static List<MemberVO> bookingList = new ArrayList<MemberVO>();
	
	public MemberDataSet() {
		
	}
	
	// 회원 추가
	public static void addMember(String id, MemberVO mvo) {
		memberList.put(id, mvo);
	}
	
	// 회원 목록
	public static void memberData() {
		addMember("admin1", new MemberVO("123456", "이관리", "19910104", "여자", "01011111234", "관리자"));
		addMember("admin2", new MemberVO("a123456", "김관리", "19920220", "여자", "01022221234", "관리자"));
		addMember("admin3", new MemberVO("a123456!", "이관리", "19930331", "남자", "01033331234", "관리자"));
		addMember("member1", new MemberVO("123456", "김회원", "19910101", "여자", "01011111111", "일반회원"));
		addMember("member2", new MemberVO("a123456", "정회원", "19920220", "여자", "01022222222", "일반회원"));
		addMember("member3", new MemberVO("a123456!", "김회원", "19930331", "남자", "01033333333", "일반회원"));
	}
	
	// 예약 추가
	public static void addBooking(MemberVO mvo) {
		bookingList.add(mvo);
	}
	
	// 예약 목록
	public static void bookingData() {
		addBooking(new MemberVO("A1", "9788995834985", "수요일의 커피하우스", 1, "member1", "김회원", "01011111111"));
		addBooking(new MemberVO("A2", "9788995834985", "수요일의 커피하우스", 2, "member2", "정회원", "01022222222"));
		addBooking(new MemberVO("A3", "9788995834985", "수요일의 커피하우스", 3, "member1", "김회원", "01011111111"));
	}
	
}
