import java.util.Scanner;

class ForTest07
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		// ���� �� ��
		/*
		for(int i=1;;){ // ���ѷ���
			
			System.out.print("�޴� [1. �簢���� ����, 2. ���� ����, 3. ����]? ");
			int menu = scan.nextInt();

			int width = 0, height = 0;
			int result1 = 0;
			int radius = 0;
			final double PI = 3.141592;
			double result2 = 0;

			switch(menu){
				case 1:
					System.out.print("���� = ");
					width = scan.nextInt();
					System.out.print("���� = ");
					height = scan.nextInt();

					result1 = width * height;

					System.out.printf("�簢���� ���� = %d\n", result1);

					break;

				case 2:
					System.out.print("������ = ");
					radius = scan.nextInt();

					result2 = radius * radius * PI;
					
					System.out.printf("���� ���� = %.2f\n", result2);

					break;

				case 3:
					System.exit(0);
			}

		} //for

			*/

		for(;;){
			System.out.print("[1. �簢���� ����, 2. ���� ����, 3. ����]? ");
			int menu = scan.nextInt();
			if(menu==1){
				System.out.print("���� = ");
				int w = scan.nextInt();
				System.out.print("���� = ");
				int h = scan.nextInt();

				int rect = w * h;
				System.out.println("�簢���� ����= " + rect);
			} else if(menu==2){
				System.out.print("������= ");
				int r = scan.nextInt();

				double circle = r * r * 3.141592;
				System.out.println("���� ����= "+circle);
			} else if(menu==3){
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� �����ϼ���.");
			}



		} // for



		
	} // main
}	// class
/*
	�簢���� ���� = ���� * ����
	���� ���� = ������ * ������ * 3.141592

	����
	�޴� [1. �簢���� ����, 2. ���� ����, 3. ����]? 1
	���� =
	���� =
	�簢���� ���� =

	�޴� [1. �簢���� ����, 2. ���� ����, 3. ����]? 2
	������ =
	���� ���� =

	�޴� [1. �簢���� ����, 2. ���� ����, 3. ����]? 2

*/