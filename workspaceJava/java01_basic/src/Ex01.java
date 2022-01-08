import java.util.Scanner;

class Ex01 
{
	public static void main(String[] args) 
	{
/*		내가 쓴 답

		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		//System.out.println(num1);
		
		int result = (num1 > num2)? num1 : num2;
		System.out.println("두 수 중 큰값은 " + result); 

*/



		// 답
		Scanner input = new Scanner(System.in);
		// 데이터 얻어오기
		System.out.println("정수 =");
		int n1 = input.nextInt();
		System.out.println("정수 =");
		int n2 = input.nextInt();
		// 계산
		int result2 = (n1 > n2)? n1 : n2;
		// 출력
		System.out.println(n1 + "과" + n2 + "중에 큰값은" + result2 + "입니다.");





	}
}


/*
	두 수를 입력받아 큰 값을 출력하라.
*/