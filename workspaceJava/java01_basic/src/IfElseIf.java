import java.util.Scanner;

class IfElseIf
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		/*
			급여의 값를 입력받아 급여가
			10000~20000이면 보너스 20%지급
			20000~30000이면 보너스 15%
			30000~40000이면 보너스 10%
			40000~50000이면 보너스 5%
			그 외는 보너스 없음
		*/

		// 1. 급여 입력
		System.out.print("급여를 입력하세요. -->");
		int sal = scan.nextInt();
		
		// 2. 보너스 구하기
		int bonus = 0;	// 그 외 값이 이미 0으로 입력되어 있어서 else는 안 썼음
		if(sal >=10000 && sal <= 20000){
			bonus = (int)(sal * 0.2);
		} else if(sal > 20000 && sal <= 30000){
			bonus = (int)(sal * 0.15);
		} else if(sal > 30000 && sal <= 40000){
			bonus = (int)(sal * 0.1);
		} else if(sal > 40000 && sal <= 50000){
			bonus = (int)(sal * 0.05);
		}

		System.out.printf("급여 = %d원, 보너스= %d원\n", sal, bonus);
	}
}

/*
	if~elseif문
	
	if(조건식){
		실행문;
	} else if(조건식){
		실행문;
	} else if(조건식){
		실행문;
	} else{
		실행문;
	}

*/