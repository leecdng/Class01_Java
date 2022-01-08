class ForTest05
{
	public static void main(String[] args) 
	{
		/*
			1~100까지의 값 중 다음 데이터를 출력하라.
			1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22....98??? 규칙 찾기
			-> 3의 배수, 5의 배수가 아닌 숫자를 출력...
		*/
		
		for(int i=1; i<=100; i++){
			if(i%3 != 0 && i%5 != 0){
				System.out.println(i);
			}
		}
	}
}
