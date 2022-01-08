
public class StaticTest2 {
	// static 
	// 멤버변수의 데이터형 왼쪽 public static int a =100;
	//					  static int b =200;
	// 메서드 반환형 왼쪽에 표기한다.
	//		public static void method(){}
	//		static void method(){}
	
	// 멤버 영역에 실행문 표기 할 수 없음
	// 근데 static{}에는 실행문 표기 할 수 있음!
	// static{}과 생성자메서드 중 static이 먼저 실행됨
	static {
		for(int i=1; i<=10; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	public StaticTest2() {
		System.out.println("StaticTest2() 메서드 실행됨");
	}
	
	public static void main(String[] args) {
		new StaticTest2();
	}

}
