
public class AaaBbbMain {

	public AaaBbbMain() {}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		
		
		
		// 하위클래스로 객체를 생성하면 상위클래스에 대입된다.
		AAA a = new BBB();
		a.output(); //번호= 200, 연락처= 010-1234-1234, 이름hong
		// 메서드 통해서 접근하면 하위클래스의 변수와 변수값이 살아있음
		
		System.out.println("b.tel="+b.tel);
		// System.out.println("a.tel="+a.tel); // 오류 // B에만 있는 변수
		// 하위클래스의 메소드는 접근 가능하지만 메소드를 거치지 않은 변수는 접근 불가능
		System.out.println("a.name="+a.name); // hong //A 상위클래스에만 있는 변수
		System.out.println("a.num="+a.num); // 100 // A B 둘 다 있는 변수 ->A의 값으로

		
		
		// AAA a = new BBB();
		BBB c = (BBB)a;
		c.output();
		
		Object obj = new BBB();
		BBB d = (BBB)obj;
		d.output();
	}

}
