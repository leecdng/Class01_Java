import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{

		// ���� �� ��
		Scanner scan = new Scanner(System.in);

		System.out.print("���� �Է� = ");
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
		System.out.printf("1~%d������ ���� %d\n", i, sum);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n", i, sum1);
		System.out.printf("1~%d������ ¦���� ���� %d\n", i, sum2);

		

		// ������ ��

		System.out.print("���� �Է� = ");
		int max = scan.nextInt();

		int total = 0, oddTotal=0, evenTotal=0; // ��ü��, Ȧ����, ¦����.. �� ���� ���� ���� ����
		for(int a=1; a<=max; a++){
			total += a;
			if(a%2==0){ // ¦��
				evenTotal+=a;
			} else{ // Ȧ��
				oddTotal+=a;
			}
		}
		// ��� ���
		System.out.printf("1~%d������ ���� %d\n", max, total);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n", max, oddTotal);
		System.out.printf("1~%d������ ¦���� ���� %d\n", max, evenTotal);
	}
}
/*
	����
	���� �Է� = 100
	1~100������ ���� 5050
	1~100������ Ȧ���� ���� 2500
	1~100������ ¦���� ���� 2550
*/