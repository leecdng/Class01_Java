import java.util.Scanner;


class SwitchEx 
{
	public static void main(String[] args) 
	{

			Scanner scan = new Scanner(System.in);

			int kor = 0;
			int eng = 0;
			int math = 0;

			for(int i=1;;){	//무한루프

			System.out.print("국어 = ");
			kor = scan.nextInt();
			System.out.print("영어 = ");
			eng = scan.nextInt();
			System.out.print("수학 = ");
			math = scan.nextInt();

			int total = kor + eng + math;
			double avg = total / 3.;
			//int grade = (int)(avg / 10);
			//char g = 'F';

			/* 
			switch(grade){
				case 0:	// case 10부터 시작해도 됨
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
			System.out.printf("학점 = %c\n", g);
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
			System.out.printf("총점=%d\n평균=%.1f\n학점=%s\n", total, avg, grade);

		}	//for


	}	//main
}	//class
/*
	국어, 영어, 수학 점수를 입력받아
	총점, 평균, 학점을 구하여 출력하라.
	각 과목의 점수는 0~100점
	평균은 실수를 구한다.

	학점	- 학점은 switch문으로 작성한다.
	90~100	A
	80~89	B
	70~79	C
	60~69	D
	0~59	F

	실행
	국어 =
	영어 = 
	수학 = 
	================ // 예시
	총점 = 240
	평균 = 80.0
	학점 = B
*/