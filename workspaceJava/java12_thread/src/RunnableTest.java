
public class RunnableTest implements Runnable{
	String msg;
	public RunnableTest() {
		;
	}
	public RunnableTest(String msg) {
		this.msg = msg;
	}
	
	// 쓰레드 구현 영역을 run() 메서드에 오버라이딩
	public void run() {
		int i =1;
		while(true) {
			System.out.println("mag"+"-->"+ i++);
		}
	}

	public static void main(String[] args) {
		RunnableTest rt1 = new RunnableTest("첫 번째 쓰레드");
		RunnableTest rt2 = new RunnableTest("두 번째 쓰레드");
		
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		
		t1.start();
		t2.start();
	}

}
