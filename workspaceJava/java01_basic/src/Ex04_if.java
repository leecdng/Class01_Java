import java.util.Scanner;

class Ex04_if 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int kor=0;
		int eng=0;
		int math=0;

		System.out.print("���� = ");
		kor = scan.nextInt();
		System.out.print("���� = ");
		eng = scan.nextInt();
		System.out.print("���� = ");
		math = scan.nextInt();
		
		int sum = kor + eng + math;
		double ave = sum / 3;
		String grade;
		if( ave >= 90 && ave <=100 ){	// if(ave >= 90){
			grade = "A";
		} else if( ave >= 80 && ave < 90 ){
			grade = "B";
		} else if( ave >= 70 && ave < 80 ){
			grade = "C";
		} else if( ave >= 60 && ave < 70 ){
			grade = "D";
		} else{
			grade = "F";
		}
		System.out.printf("���� = %d��\n��� = %3.1f��\n���� = %s\n", sum, ave, grade);


		// ������ ��
		/*
			int total = kor + eng + math;
			double avg = total / 3;
			char grade='F';

			if( avg >= 90 ){ // A����
				grade = 'A';
			} else if(avg >= 80){
				grade = 'B';
			} else if(avg >= 70){
				grade = 'C';
			} else if(avg >= 60){
				grade = 'D';
			}

			// 3. ���
			System.out.printf("���� = %d\n��� = %.2f\n���� = %c\n", total, avg, grade);

			*/
		}
}

/*
	����, ����, ���� ������ �Է¹޾�
	����, ���, ������ ���Ͽ� ����϶�.
	�� ������ ������ 0~100��
	����� �Ǽ��� ���Ѵ�.

	����
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