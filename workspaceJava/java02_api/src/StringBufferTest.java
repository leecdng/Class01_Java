
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}
	public void start() {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(100);
		
		// append() : 문자열 추가
		sb1.append("Buffer append Test.."); // Buffer append Test..
		sb1.append(123456); // Buffer append Test..123456
		
		// insert() : index위치 문자 삽입
		sb1.insert(5, "(스트링버퍼)"); // Buffe(스트링버퍼)r append Test..123456
		sb1.insert(15, 23235.21544554); // Buffe(스트링버퍼)r a23235.21544554ppend Test..123456
		
		sb1.deleteCharAt(6); // Buffe(트링버퍼)r a23235.21544554ppend Test..123456
		// 6번째 문자 삭제
		
		sb1.delete(1,4); // Be(트링버퍼)r a23235.21544554ppend Test..123456
		// 1~3번째까지 삭제 (4앞까지)
		
		sb1.replace(1, 3, "(자바)");	// B(자바)트링버퍼)r a23235.21544554ppend Test..123456
		// 1~2번째까지(3앞까지) 문자를 (자바)로 대체해라
		
		sb1.reverse(); // 654321..tseT dnepp45544512.53232a r)퍼버링트)바자(B
		// 문자열을 거꾸로 반환
		
		
		// 확보된 공간 확인하기
		System.out.println("sb1.capacity="+sb1.capacity()); //16byte // 문자열이 추가(수정)되면 약 두 배씩 공간 확보가 됨
		System.out.println("sb2.capacity="+sb2.capacity()); // 100byte
		System.out.println(sb1);
	}

	public static void main(String[] args) {
		new StringBufferTest();
		

	}

}
