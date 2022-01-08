class WhileTest02 
{
	public static void main(String[] args) 
	{
		// ÁßÃ¸¹Ýº¹¹®(while)
		int r1=0;

		while(r1<5){ //0,1,
			int i=1;
			while(i<=5){
				System.out.print(i++);
			}
			System.out.println();

			r1++; //1,2,3
		} // while
	}
}
/*

1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5

*/