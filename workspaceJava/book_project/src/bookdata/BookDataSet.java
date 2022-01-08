package bookdata;

import java.util.HashMap;

import memberdata.MemberVO;

public class BookDataSet {
	public static HashMap<String, BookVO> bookList = new HashMap<String, BookVO>();
	public static HashMap<String, MemberVO> memberList;
	
	public BookDataSet() {
		
	}
	
	public static void basicBookData() {
		bookList.put("9788994492032", new BookVO("Java의정석", "남궁 성", "도우출판", "500", 30000, 10));
		bookList.put("9788937460449", new BookVO("데미안", "헤르만 헤세", "민음사", "800", 8000, 8));
		bookList.put("9788931003352", new BookVO("생의 한가운데", "루이제 린저", "문예출판사", "800", 9000, 5));
		bookList.put("9788995834985", new BookVO("수요일의 커피하우스", "고솜이", "돌풍", "800", 9000, 0));
		bookList.put("9788956250823", new BookVO("무량수전 배흘림기둥에 기대서서", "최순우", "학고재", "600", 19800, 3));
		bookList.put("9788974793739", new BookVO("인문학을 좋아하는 사람들을 위한 불교수업", "김사업", "불광출판사", "200", 16000, 1));
		bookList.put("9788956609959", new BookVO("종의 기원", "정유정", "은행나무", "800", 13000, 12));
		bookList.put("9791166932298", new BookVO("가벼운 프랑스어", "가벼운학습지", "레모네이드", "700", 15000, 12));
		bookList.put("9788936478735", new BookVO("있지만 없는 아이들", "은유", "창비", "300", 15000, 27));
		bookList.put("9788937472060", new BookVO("우리가 쓴 것", "조남주", "민음사", "800", 14000, 17));
		bookList.put("9788974564698", new BookVO("생의 이면", "이승우", "문이당", "500", 13000, 2));
	}

}
