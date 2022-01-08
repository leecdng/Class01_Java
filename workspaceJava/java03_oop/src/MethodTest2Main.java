
public class MethodTest2Main {

	public MethodTest2Main() {
		
	}

	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2();
		
		String gugu = mt.gugudan(8);
		System.out.println(gugu);
		
		// 반환형이 없는 메소드 호출	// 변수 없이 그냥..
		mt.powerStart();
		
		//
		mt.channelUp(); // 12
		mt.channelUp(); // 13
		mt.channelDown(); // 12
		
		// static이 없는 메소드는 반드시 객체를 만들어 메서드를 호출해야 한다.
		mt.sum(20);
		// static이 메서드의 반환형 왼쪽에 있는 경우는 메소드를 객체 생성하지 않고 호출 가능
		// 클래스명.메서드명(매개변수);
		MethodTest2.sum(50);

	}

}
