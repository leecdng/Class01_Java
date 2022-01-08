import test.DefaultData;
import test.LottoOOP1;
public class ModifierTest {

	public ModifierTest() {
//		LottoOOP1 lotto = new LottoOOP1();
//		lotto.lottoStart();
		
		DefaultData dd = new DefaultData();
		// 객체명.멤버변수
		System.out.println("이름=" + dd.getName());
		// System.out.println("연락처="+ dd.tel); // DefaultData 클래스의 멤버변수에 public 써야 사용 가능
		
		DefaultData dd2 = new DefaultData("이순신", "010-8888-8888");
		dd2.sum();
		
		// static Test
		DefaultData.sum(); // 잘 실행됨 -> 지역변수만 있어서 메서드 실행 때 변수가 생성됨
		// DefaultData.getName(); // static 선언해도 에러남 - 전역변수가 있을 땐 객체를 생성하거나, 전역변수도 static 변수로 해줘야 함.
		
	}

	public static void main(String[] args) {
		// 접근제한자
		// 클래스 : public, default(접근제한자 생략한 것)
		// 생성자 메서드, 메서드, 멤버변수 : public, protected, default, private
		
		new ModifierTest();
	}

}
