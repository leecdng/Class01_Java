import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		// ���� �� ��
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ù ��° ����� �Է��ϼ���. --> ");
		int num1 = scan.nextInt();

		System.out.print("�� ��° ����� �Է��ϼ���. --> ");
		int num2 = scan.nextInt();
		
		int result1 = num1 + num2;
		int result2 = num1 - num2;
		int result3 = num1 * num2;
		int result4 = num1 / num2;
		if(num1 > 0 && num2 > 0){
			System.out.printf("�� ���� ��Ģ������ ��� \n���ϸ� %d \n���� %d \n���ϸ� %d \n������ %d \n", result1, result2, result3, result4);
		} else{
			System.out.println("�����͸� �߸� �Է��Ͽ����ϴ�.");
		}
		System.out.println("�Ϸ�");


		// ������ ��

		int first=0, second=0, add=0, minus=0, mul=0, divide=0;
		// 1. ������ �Է�
		System.out.print("ù ��° ����= ");
		first = scan.nextInt();
		System.out.print("�� ��° ����= ");
		second = scan.nextInt();

		// 2. ���
		if(first>0 && second>0){	// �� ���� ��� ����� ��
			add = first + second;
			minus = first - second;
			mul = first * second;
			divide = first / second;
		// 3. ���
			System.out.printf("%5d + %5d = %5d\n", first, second, add);
			System.out.printf("%5d - %5d = %5d\n", first, second, minus);
			System.out.printf("%5d * %5d = %5d\n", first, second, mul);
			System.out.printf("%5d / %5d = %5d\n", first, second, divide);
		} else{	// �� ��
			System.out.println("�����͸� �߸� �Է��Ͽ����ϴ�.");
		}
	}
}


/*
	�μ��� �Է¹޾� �Է¹��� ��� ���� ����� ���� ��Ģ������ �� ����� ����ϰ�
	�μ� ��� ����� �ƴ� ���� "�����͸� �߸� �Է��Ͽ����ϴ�."��� �޼����� ����϶�.
*/
