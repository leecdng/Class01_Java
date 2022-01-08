import java.util.Scanner;

class IfTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		// 어떤 수를 입력받아 짝수일 때는 출력하고 짝수가 아니면 출력하지 않는다.
		System.out.println("0보다 큰 정수를 입력하세요.");
		int num = scan.nextInt();

		//if( num%2 == 0 ){
		if( num/2 == num/2.0 ){
			System.out.printf("%d은(는) 짝수입니다.\n", num);
		}

		// 3의 배수일 때만 출력하기
		// if( num%3 == 0 ){
		if( num/3 == num/3.0 ){
			System.out.printf("%d은(는) 3의 배수입니다.\n", num);
		}
		
		// 3의 배수가 아닐 때만 출력하기
		// if( num%3 != 0 ){
		if( num/3 != num/3.0 ){
			System.out.printf("%d은(는) 3의 배수가 아닙니다.\n", num);
		}
		System.out.println("End.");
	}
}



/*
	if문
	- 조건문은 반드시 논리형 결과여야 한다. (true / false)

	if(조건문 or 수식 or 변수 or 상수){
		조건식이 참일 때 실행할 실행문;
		실행문;
		실행문;
		:
		:
	}


*/