import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		// 내가 쓴 답
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 양수를 입력하세요. --> ");
		int num1 = scan.nextInt();

		System.out.print("두 번째 양수를 입력하세요. --> ");
		int num2 = scan.nextInt();
		
		int result1 = num1 + num2;
		int result2 = num1 - num2;
		int result3 = num1 * num2;
		int result4 = num1 / num2;
		if(num1 > 0 && num2 > 0){
			System.out.printf("두 수를 사칙연산한 결과 \n더하면 %d \n빼면 %d \n곱하면 %d \n나누면 %d \n", result1, result2, result3, result4);
		} else{
			System.out.println("데이터를 잘못 입력하였습니다.");
		}
		System.out.println("완료");


		// 선생님 답

		int first=0, second=0, add=0, minus=0, mul=0, divide=0;
		// 1. 데이터 입력
		System.out.print("첫 번째 정수= ");
		first = scan.nextInt();
		System.out.print("두 번째 정수= ");
		second = scan.nextInt();

		// 2. 계산
		if(first>0 && second>0){	// 두 수가 모두 양수일 때
			add = first + second;
			minus = first - second;
			mul = first * second;
			divide = first / second;
		// 3. 출력
			System.out.printf("%5d + %5d = %5d\n", first, second, add);
			System.out.printf("%5d - %5d = %5d\n", first, second, minus);
			System.out.printf("%5d * %5d = %5d\n", first, second, mul);
			System.out.printf("%5d / %5d = %5d\n", first, second, divide);
		} else{	// 그 외
			System.out.println("데이터를 잘못 입력하였습니다.");
		}
	}
}


/*
	두수를 입력받아 입력받은 모든 수가 양수일 때는 사칙연산을 한 결과를 출력하고
	두수 모두 양수가 아닐 때는 "데이터를 잘못 입력하였습니다."라는 메세지를 출력하라.
*/
