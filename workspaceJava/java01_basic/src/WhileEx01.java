import java.util.Scanner;

class WhileEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("���� �Է� = ");
		int data = scan.nextInt();

		int i = 1;
		int sum = 0, oddSum=0, evenSum=0, threeSum=0;

		while(i<=data){
			// ��
			sum += i;
			// Ȧ����, ¦����
			if(i%2!=0){
				oddSum += i;
			} else{
				evenSum += i;
			}
			
			//3�� �����
			if(i%3 ==0){
				threeSum += i;
			}
			i++;
		}
		System.out.printf("1~%d������ ���� %d\n", data, sum);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n", data, oddSum);
		System.out.printf("1~%d������ ¦���� ���� %d\n", data, evenSum);
		System.out.printf("1~%d������ 3�� ����� ���� %d\n", data, threeSum);
		System.out.println("The End.");
	}
}

/*
������ ��(����)�� �Է¹޾� �� ������ �հ�, ¦����, Ȧ����, 3�� ����� ���� ���Ͽ� ����϶�.
�ݵ�� �ݺ����� while���� Ȱ���϶�.

����
�����Է�=15
1~15������ ���� ____
1~15������ Ȧ���� ���� ____
1~15������ ¦���� ���� ____
1~15������ 3�� ����� ���� ____
*/