import java.util.Scanner;

class StandardWeight

{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int age = 0;
		int gender = 0;
		int height = 0;
		int w_now = 0;

		// 데이터 입력
		System.out.print("나이 = ");
		age = scan.nextInt();
		System.out.print("성별 선택(1:남성, 2:여성) = ");
		gender = scan.nextInt();
		System.out.print("키 = ");
		height = scan.nextInt();
		System.out.print("현재 체중 = ");
		w_now = scan.nextInt();

		// 표준체중 구하기
		int w_stan = 0;
		if( age <= 35 ){
			if ( gender == 1 ){
				w_stan = (int)((height - 100) * 0.90);
			} else if( gender == 2 ){
				w_stan = (int)((height - 100) * 0.85);
			}
		} else if( age >= 36){
			if ( gender == 1 ){
				w_stan = (int)((height - 100) * 0.95);
			} else if( gender == 2 ){
				w_stan = (int)((height - 100) * 0.90);
			}
		}

		// 표준체중지수
		double w_per = ((double)w_now / w_stan) * 100;
		String w_str = "";
		// 표준체중지수 평가기준
		if( w_per <= 85 ){
			w_str = "마른형";
		} else if( w_per >= 86 && w_per <= 95){
			w_str = "조금 마른형";
		} else if( w_per >=96 && w_per <= 115){
			w_str = "표준형";
		} else if( w_per >= 116 && w_per <= 125){
			w_str = "조금 비만형";
		} else {
			w_str = "비만형";
		}

		System.out.printf("\n결과\n표준체중 = %d\n당신의 표중체중지수는 %.14f으로 %s입니다.\n\n", w_stan, w_per, w_str);
		

	}
}
