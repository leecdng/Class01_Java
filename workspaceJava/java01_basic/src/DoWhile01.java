class DoWhile01
{
	public static void main(String[] args) 
	{
		// 1,2,3,4,5
		// do~while문
		
		int i=1;
		do{
			System.out.println(i);
			i++;
		}while(i<=5);  // true를 넣으면 무한루프
	}
}
/*

do{
	실행문;
	실행문;
	:
	:

}while(조건문);

*/