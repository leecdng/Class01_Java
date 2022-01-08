import java.util.Scanner;

public class OOP_Ex02 {
	int dan; // 입력받은 단을 저장할 변수 = 0
	String gugu=""; // 구구단을 저장할 변수 = null
	
	public OOP_Ex02() {
//		int dan = danInput();
//		String result = gugudan(dan);
//		System.out.println(result);
		
		// System.out.println(gugudan(danInput()));
	}

	// 단 입력받기
	int danInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력 = ");
		
		return scan.nextInt();
	}
	
	// 구구단 출력하기
	void gugudan() {
		for(int i=2; i<=9; i++) {
			gugu += dan+"*"+i+"="+ dan*i+"\n";
		}	
	}
	
	void start() {
		dan = danInput();
		gugudan();
		System.out.println(gugu);
	}
	
	
	// 메인 메서드
	public static void main(String[] args) {
		OOP_Ex02 oop = new OOP_Ex02();
		
		// System.out.println(oop.gugudan(oop.danInput()));
		
		oop.start();
		

	}

}
// 콘솔에서 단을 입력받아 입력받은 구구단을 출력하라
// 1) 단 입력받기 -> 메인메서드에서 단 입력 받을 때만 스캐너 사용하기
// 2) 구구단 출력