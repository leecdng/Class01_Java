import java.util.Scanner;

class ForTest03
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("단 입력 = ");
		int i = scan.nextInt();

		for(int j=2; j<=9; j++){
			// System.out.println(i+" * "+j+" = "+ (i*j));
			int result = i * j;
			System.out.printf("%d * %d = %d\n", i, j, result);
		}
	}
}
/*
	실행
	단입력=5
	5 * 2 = 10
	5 * 3 = 15
	5 * 4 = 20
	:
	:
	5 * 9 = 45
*/