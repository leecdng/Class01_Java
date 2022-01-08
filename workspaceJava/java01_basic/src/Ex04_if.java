import java.util.Scanner;

class Ex04_if 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int kor=0;
		int eng=0;
		int math=0;

		System.out.print("국어 = ");
		kor = scan.nextInt();
		System.out.print("영어 = ");
		eng = scan.nextInt();
		System.out.print("수학 = ");
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
		System.out.printf("총점 = %d점\n평균 = %3.1f점\n학점 = %s\n", sum, ave, grade);


		// 선생님 답
		/*
			int total = kor + eng + math;
			double avg = total / 3;
			char grade='F';

			if( avg >= 90 ){ // A학점
				grade = 'A';
			} else if(avg >= 80){
				grade = 'B';
			} else if(avg >= 70){
				grade = 'C';
			} else if(avg >= 60){
				grade = 'D';
			}

			// 3. 출력
			System.out.printf("총점 = %d\n평균 = %.2f\n학점 = %c\n", total, avg, grade);

			*/
		}
}

/*
	국어, 영어, 수학 점수를 입력받아
	총점, 평균, 학점을 구하여 출력하라.
	각 과목의 점수는 0~100점
	평균은 실수를 구한다.

	학점
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