
public class PrivateParent {
	// private 접근제한자는 다른 클래스에 객체를 통하여 접근할 수 없다.
	//		   상속하지 않음
	private int num = 200; // 캡슐화
	// 생성자 메소드에 private 접근제한자는 객체를 생성할 수 없다.
	PrivateParent() { // 어차피 메소드가 private이면 생성자도 그래야 한다?????
		
	}
	
	// 객체를 통해서 접근불가
	// 상속도 안 함.
	private void getData() {
		System.out.println("번호= " + num);
	}

}
