import java.util.Scanner;


class SwitchEx 
{
	public static void main(String[] args) 
	{

			Scanner scan = new Scanner(System.in);

			int kor = 0;
			int eng = 0;
			int math = 0;

			for(int i=1;;){	//���ѷ���

			System.out.print("���� = ");
			kor = scan.nextInt();
			System.out.print("���� = ");
			eng = scan.nextInt();
			System.out.print("���� = ");
			math = scan.nextInt();

			int total = kor + eng + math;
			double avg = total / 3.;
			//int grade = (int)(avg / 10);
			//char g = 'F';

			/* 
			switch(grade){
				case 0:	// case 10���� �����ص� ��
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					g = 'F';
					break;
				case 6:
					g = 'D';
					break;
				case 7:
					g = 'C';
					break;
				case 8:
					g = 'B';
					break;
				case 9:
				case 10:
					g = 'A';
					break;
			}
			System.out.printf("���� = %c\n", g);
			*/

			String grade = "";
			switch((int)avg/10){
				case 10:
				case 9:
					grade = "A";
					break;
				case 8:
					grade = "B";
					break;
				case 7:
					grade = "C";
					break;
				case 6:
					grade = "D";
					break;
				default:
					grade = "F";
			}	//switch
			System.out.printf("����=%d\n���=%.1f\n����=%s\n", total, avg, grade);

		}	//for


	}	//main
}	//class
/*
	����, ����, ���� ������ �Է¹޾�
	����, ���, ������ ���Ͽ� ����϶�.
	�� ������ ������ 0~100��
	����� �Ǽ��� ���Ѵ�.

	����	- ������ switch������ �ۼ��Ѵ�.
	90~100	A
	80~89	B
	70~79	C
	60~69	D
	0~59	F

	����
	���� =
	���� = 
	���� = 
	================ // ����
	���� = 240
	��� = 80.0
	���� = B
*/