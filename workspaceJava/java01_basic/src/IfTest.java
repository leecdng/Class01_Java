import java.util.Scanner;

class IfTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		// � ���� �Է¹޾� ¦���� ���� ����ϰ� ¦���� �ƴϸ� ������� �ʴ´�.
		System.out.println("0���� ū ������ �Է��ϼ���.");
		int num = scan.nextInt();

		//if( num%2 == 0 ){
		if( num/2 == num/2.0 ){
			System.out.printf("%d��(��) ¦���Դϴ�.\n", num);
		}

		// 3�� ����� ���� ����ϱ�
		// if( num%3 == 0 ){
		if( num/3 == num/3.0 ){
			System.out.printf("%d��(��) 3�� ����Դϴ�.\n", num);
		}
		
		// 3�� ����� �ƴ� ���� ����ϱ�
		// if( num%3 != 0 ){
		if( num/3 != num/3.0 ){
			System.out.printf("%d��(��) 3�� ����� �ƴմϴ�.\n", num);
		}
		System.out.println("End.");
	}
}



/*
	if��
	- ���ǹ��� �ݵ�� ���� ������� �Ѵ�. (true / false)

	if(���ǹ� or ���� or ���� or ���){
		���ǽ��� ���� �� ������ ���๮;
		���๮;
		���๮;
		:
		:
	}


*/