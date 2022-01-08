
public class MethodInner {
	String name ="세종대왕";
	public MethodInner() {
		System.out.println("MethodInner");
	}
	
	public void start() {
		// 내부클래스
		class MethodInnerTest{
			int num = 20;
			String email = "aaaa@nate.com";
			MethodInnerTest(){
				
			}
			
			MethodInnerTest(int num){
				this.num = num;
			}
			
			void emailOutput() {
				System.out.println("num="+num);
				System.out.println("email="+email);
				// 메서드 내의 내부클래스에서도 외부클래스의 변수 사용 가능.
				System.out.println("name="+name);
			}
			
		}
		
		// 내부클래스 객체를 생성 (메서드 내에)
		MethodInnerTest mt = new MethodInnerTest(500);
		mt.emailOutput();
		
		
	}
	
	public static void main(String[] args) {
		MethodInner mi = new MethodInner();
		mi.start();	// 메서드 내에 객체 생성해야 메서드 내의 내부클래스가 실행됨??

	}

}
