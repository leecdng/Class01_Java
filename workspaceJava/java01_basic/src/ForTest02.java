class ForTest02 
{
	public static void main(String[] args) 
	{
		int sum = 0; // 실행문에 들어올 변수는 미리 선언
		for(int i=1; i<=100; i++){
			sum = sum + i;	// Sum+=i; 이 식을 더 선호
			System.out.println("1~"+ i+"까지의 합은 "+sum);
		}
		// System.out.println("1~100까지의 합은 "+ sum);
		

		// 1~10까지의 합, 1~20까지의 합, 30까지의 합,.. 100까지의 합만 출력하기
		int sum2 = 0; // 실행문에 들어올 변수는 미리 선언
		for(int j=1; j<=100; j++){
			sum2 +=j;	// Sum+=i; 이 식을 더 선호
			if(j%10 ==0){
				System.out.println("1~"+ j+"까지의 합은 "+sum);
			}
		}
		// System.out.println("1~100까지의 합은 "+ sum);




	}
}
