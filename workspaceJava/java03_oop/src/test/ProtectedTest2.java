package test;

public class ProtectedTest2 {
	protected String tel ="010-1234-8959";
	// 객체 생성 안 됨
	protected ProtectedTest2() {
		System.out.println("다른 패키지의 생성자 메서드");
	}
	
	protected void telOutput() {
		System.out.println("전화번호="+tel);
	}
	public String getTel() {
		return tel;
	}
	public static ProtectedTest2 getInstance() {
		return new ProtectedTest2();	// 자기 클래스를 객체로 만들어서 리턴
	}
}
