// import java.lang.System;	// lang에 있는 건 자동으로 java가 넣어줌.
// import java.lang.String;
import java.util.Scanner;

class ScannerTest 
{
	public static void main(String[] args) 
	{
		// Scanner : 콘솔에서 정수 또는 문자 실수 등을 입력받는 클래스
		// 1. 객체를 생성
		// 레퍼런스 변수 : 클래스의 변수로 선언된 것?
		Scanner scan = new Scanner(System.in);


		// 2. 값 입력 받는 메소드를 호출한다.
		// 객체명.메소드()
		// nextInt() : 정ㅅ가 입력, nextDouble() : 실수가 입력, next() : 1개의 단어가 문자열로 입력
		// nextLine() : 한 줄이 문자열로 입력
		System.out.println("첫 번째 정수 ->");
		int num = scan.nextInt();	// 값을 입력하고 엔터를 쳐야 아래 내용을 출력함. 타입 맞춰서 입력해야 함
		// System.out.println("num =" + num);
		
		System.out.println("두 번째 정수 ->");
		int num2 = scan.nextInt();

		int sum = num + num2;
		int minus = num - num2;
		int multiple = num * num2;
		int devide = num / num2;
		
		System.out.println("sum =" + sum);
		System.out.println("minus =" + minus);
		System.out.println("multiple =" + multiple);
		System.out.println("devide =" + devide);
		
	}
}
