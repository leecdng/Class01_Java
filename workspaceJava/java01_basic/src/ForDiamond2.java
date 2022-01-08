import java.util.Scanner;
class ForDiamond2
{
	public static void main(String[] args) 
	{

		// 혼자 풀어보기 실패ㅋ
		// 알파벳 출력
		/*
		for(int n=1; n<=13; n++){
			for(int s=1; s<=13-n; s++){
				System.out.print(" ");
			}
			for(int j=1; j<=(2*n)-1; j++){;
				char c=(char)(65+(j-1));
				char c2 = (char)(c+(n-1)*(n-1));
				if(c2==90){

				}
				System.out.print(c2);
			}
			System.out.println();
		}
		*/

		
		Scanner scan = new Scanner(System.in);

		System.out.print("홀수(1~49)입력=");
		int max = scan.nextInt();

		// 짝수일 경우 홀수로 변경 // 1증가 시키기
		if(max%2==0){	
			max++;
		}

		// 출력할 문자 초기값
		char txt = 'A';
		int step = 2; // 증감 변수
		for(int row=1; row>0; row+=step){	// 줄 1,3,5,7,9...max
			// 공백처리
			for(int s=1; s<=(max-row)/2; s++){
				System.out.print(" ");
			}
			//1줄 문자 출력
			for(int cnt=1; cnt<=row; cnt++){ 
				System.out.print(txt++);
				if(txt > 'Z'){
					txt = 'A';
				}
			}
			System.out.println();
			if(row >= max){
				step= -2;
			}
		}



	}
}
