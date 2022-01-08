
public class PrivateChild extends PrivateParent {

	public PrivateChild() {
		// 상위클래스의 private멤버 변수는 상속되지 않는다.
		// System.out.println("num--->"+num); // 에러
		// getData(); // 상위클래스의 메서드를 하위클래스에서 접근 불가
	}
	
//	private void getData() {
//		System.out.println("PrivateChild~");
//	}	// 오류는 나지 않지만 오버라이딩이 된 게 아니라 새로운 메서드를 만들어 준 셈.

}
