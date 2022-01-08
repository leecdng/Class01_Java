import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{

		// 내가 쓴 답
		Scanner scan = new Scanner(System.in);

		System.out.print("정수 입력 = ");
		int i = scan.nextInt();
		
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		for(int j=1; j<=i; j++){
			sum = sum + j;
			if(j%2 != 0){
				sum1 = sum1 + j;
			} else if(j%2 == 0){
				sum2 = sum2 + j;
			}
		}
		System.out.printf("1~%d까지의 합은 %d\n", i, sum);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n", i, sum1);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n", i, sum2);

		

		// 선생님 답

		System.out.print("정수 입력 = ");
		int max = scan.nextInt();

		int total = 0, oddTotal=0, evenTotal=0; // 전체합, 홀수합, 짝수합.. 한 번에 변수 선언 가능
		for(int a=1; a<=max; a++){
			total += a;
			if(a%2==0){ // 짝수
				evenTotal+=a;
			} else{ // 홀수
				oddTotal+=a;
			}
		}
		// 결과 출력
		System.out.printf("1~%d까지의 합은 %d\n", max, total);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n", max, oddTotal);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n", max, evenTotal);
	}
}
/*
	실행
	정수 입력 = 100
	1~100까지의 합은 5050
	1~100까지의 홀수의 합은 2500
	1~100까지의 짝수의 합은 2550
*/