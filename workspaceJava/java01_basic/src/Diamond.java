class Diamond // 실패한 거ㅠ
{
	public static void main(String[] args) 
	{
		//  알파벳 출력
		
		for(int n=1; n<=13; n++){
			int j=1;
			for(int s=1; s<=(25-j)/2; s++){
				System.out.print(" ");
			}
			for(j=1; j<=(2*n)-1; j++){;
				char c=(char)(65+(j-1));
				char c2 = (char)(c+(n-1)*(n-1));
				if(c2==90){

				}
				System.out.print(c2);
			}
			System.out.println();
		}
		


		

	}
}
