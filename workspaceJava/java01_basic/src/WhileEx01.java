import java.util.Scanner;

class WhileEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("정수 입력 = ");
		int data = scan.nextInt();

		int i = 1;
		int sum = 0, oddSum=0, evenSum=0, threeSum=0;

		while(i<=data){
			// 합
			sum += i;
			// 홀수합, 짝수합
			if(i%2!=0){
				oddSum += i;
			} else{
				evenSum += i;
			}
			
			//3의 배수합
			if(i%3 ==0){
				threeSum += i;
			}
			i++;
		}
		System.out.printf("1~%d까지의 합은 %d\n", data, sum);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n", data, oddSum);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n", data, evenSum);
		System.out.printf("1~%d까지의 3의 배수의 합은 %d\n", data, threeSum);
		System.out.println("The End.");
	}
}

/*
임의의 수(정수)를 입력받아 그 수까지 합과, 짝수합, 홀수합, 3의 배수의 합을 구하여 출력하라.
반드시 반복문은 while문을 활용하라.

실행
정수입력=15
1~15까지의 합은 ____
1~15까지의 홀수의 합은 ____
1~15까지의 짝수의 합은 ____
1~15까지의 3의 배수의 합은 ____
*/