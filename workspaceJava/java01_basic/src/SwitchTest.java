import java.util.Scanner;

class SwitchTest
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		// 정수를 입력받아 1이면 빨강, 2면 노랑, 3이면 파랑, 4면 초록, 그 외의 값은 검정으로 출력하라
		System.out.print("정수 입력 = ");
		int color = scan.nextInt();
		
		switch( color ){
			case 1 :
				System.out.println("빨강");
				break;
			case 2 : 
				System.out.println("노랑");
				break;
			case 3 : 
				System.out.println("파랑");
				
			case 4 : 
				System.out.println("초록");
				break;
			default :
				System.out.println("검정");
		}
	}
}

/*
	범위를 지정할 수 없는 조건문
	
	switch(상수, 변수, 수식){	//( ) 안에는 int, String 또는 int보다 작은데이터 타입 사용 가능
		case 상수:
		 	실행문;
			실행문;
			break;
		case 상수:
		 	실행문;
			실행문;
			break;
		:
		:
		default:	// default는 생략 가능
			실행문;
			실행문;
		
	}

*/