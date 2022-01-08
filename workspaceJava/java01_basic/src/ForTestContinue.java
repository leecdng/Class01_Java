class ForTestContinue
{
	public static void main(String[] args) 
	{
		for(int i=1; i<10; i++){
			if(i%2==0){
				continue;	// 조건이 맞으면 해당 if문을 계속 반복 실행하라는 뜻
			}
			System.out.println(i);	// 홀수만 출력됨
		}
	}
}
