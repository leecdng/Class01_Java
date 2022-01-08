import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		CollectionData data = new CollectionData();
		List<MemberVO> lst = data.getMember();
		MemberVO vo2 = new MemberVO("ZZZ","기획총괄부","2020-01-02",5000);
		
		lst.add(2, vo2);
		lst.remove(1); // BBBB의 정보 사라짐 // index로 삭제
		// lst.remove(vo2); // 객체명으로 삭제
		
		// MemberVO vo = lst.get(0); // 자동형변환..해줌. 대신 반환형 데이터를 한 번에 넣을 수 없다??? 하나씩 해줘야 함???
		
		for(int i=0; i<lst.size(); i++) {
			MemberVO vo = lst.get(i);
			vo.memberPrint();
		}
		
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
