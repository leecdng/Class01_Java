// import java.lang.System;	// lang�� �ִ� �� �ڵ����� java�� �־���.
// import java.lang.String;
import java.util.Scanner;

class ScannerTest 
{
	public static void main(String[] args) 
	{
		// Scanner : �ֿܼ��� ���� �Ǵ� ���� �Ǽ� ���� �Է¹޴� Ŭ����
		// 1. ��ü�� ����
		// ���۷��� ���� : Ŭ������ ������ ����� ��?
		Scanner scan = new Scanner(System.in);


		// 2. �� �Է� �޴� �޼ҵ带 ȣ���Ѵ�.
		// ��ü��.�޼ҵ�()
		// nextInt() : ������ �Է�, nextDouble() : �Ǽ��� �Է�, next() : 1���� �ܾ ���ڿ��� �Է�
		// nextLine() : �� ���� ���ڿ��� �Է�
		System.out.println("ù ��° ���� ->");
		int num = scan.nextInt();	// ���� �Է��ϰ� ���͸� �ľ� �Ʒ� ������ �����. Ÿ�� ���缭 �Է��ؾ� ��
		// System.out.println("num =" + num);
		
		System.out.println("�� ��° ���� ->");
		int num2 = scan.nextInt();

		int sum = num + num2;
		int minus = num - num2;
		int multiple = num * num2;
		int devide = num / num2;
		
		System.out.println("sum =" + sum);
		System.out.println("minus =" + minus);
		System.out.println("multiple =" + multiple);
		System.out.println("devide =" + devide);
		
	}
}
