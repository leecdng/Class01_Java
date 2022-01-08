class WhileTest01 
{
	public static void main(String[] args) 
	{
		//1~5까지 출력
		// 초기값, 증가값이 while문에 존재하지 않기 때문에 별도로 식을 표시하여야 한다.
		int i=1; // 초기값

		while(i<=5){ // 초건식이 참일 때 실행
			System.out.println(i);
			// i의 값을 증가시키는 수식
			i++;
		}

		/////////////////

		// 5,4,3,2,1
		int j=5;
		while(j>=1){
			j--; // 자리 수정 불가일 때
			System.out.print(j+" ");
		}
		
	}
}
/*
	While : 반복문

	while(조건문){
		실행문;
		실행문;
		:
		:

	}

*/