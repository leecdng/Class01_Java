import java.util.Scanner;
class IfElseTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		// 입력받은 임의의 값이 짝수면 100을 곱하여 출력
		// 홀수면 200을 곱하여 출력하라.

		System.out.print("양의 정수를 입력 =");
		int data = scan.nextInt();
/*
		if ( data%2 == 0 ){	//짝수
			int result = data * 100;
			System.out.printf("%d --> %d \n", data, result);
		} else{	//홀수
			int result = data * 200;
			System.out.printf("%d --> %d \n", data, result);
		}
*/

		int result = 0;

		if(data%2 == 1){ // 홀수
			result = data * 200;
		} else{ // 짝수
			result = data * 100;
		}

		System.out.printf("%d --> %d \n", data, result);
	}
}


/*
	if~else문

	if(조건문){
		조건문이 참일 때 실행;
	}else{
		조건문이 거짓일 때 실행;
	}
*/