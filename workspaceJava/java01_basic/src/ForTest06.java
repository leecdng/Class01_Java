class ForTest06
{
	public static void main(String[] args) 
	{
		// 중첩 for문

		/*
			12345
			12345
			12345
			12345
			12345
		*/
		for(int i=1; i<=5; i++){ // 1, 2, 3, 4, 5 - 행

			for(int j=1; j<=5; j++){	// 1, 2, 3, 4, 5 - 열
				System.out.print(j+"\t");
			}
			System.out.println(); //줄바꿈
		}
		System.out.println();
		/*
			1 2 3 4 5			------------------복습해볼 것
			6 7 8 9 10
			1112131415
			1617181920
			2122232425
		*/
		// 내가 쓴 답
		for(int i=0; i<25; i+=5){
			for(int j=i+1; j<=i+5; j++){
				System.out.print(j+"\t");
			}
			System.out.println();
		}
		System.out.println();

		// 선생님 답
		int a=0;
		for(int i=1; i<=5; i++){
			for(int j=1; j<=5; j++){
				System.out.print(++a +"\t");
			}
			System.out.println();
		}
		System.out.println();

		for(int i=1; i<=25; i++){ // 1,2,3,4,5,...25
			System.out.print(i+"\t");
			if (i%5 ==0){
				System.out.println();
			}
		}
		System.out.println();


		/*
			1
			1 2
			1 2 3
			1 2 3 4
			1 2 3 4 5
		*/
		for(int i=1; i<=5; i++){	// i가 행의 수만큼 돌아가게
			for(int j=1; j<=i; j++){
				System.out.print(j+" ");
			}
			System.out.println();
		}



		System.out.println();


		/*
			1 2 3 4 5
			1 2 3 4
			1 2 3
			1 2
			1
		*/

		for(int i=5; i>=1; i--){	// i가 행의 수만큼 돌아가게 // i>0라고 해도 됨.
			for(int j=1; j<=i; j++){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println();

	/*

		* 공백4 *1 =5
	   ** 공백3 *2
	  *** 공백2 *3
	 ****
	*****

	*/
	for(int i=1; i<=5; i++){
		// 공백
		for(int s=1; s<=5-i; s++){
			System.out.print(" ");
		}
		// 문자
		for(int j=1; j<=i; j++){
			System.out.print("*");
		}
		// 줄바꿈
		System.out.println();
	}
	
	/*

	***** 공0 별5
	 **** 공1 별4
	  *** 공2 별3
	   ** 공3 별2
	    * 공4 별1
	*/

	for(int i=5; i>=1; i--){ // i가 5번 돌아가게 하기
		for(int s=1; s<=5-i; s++){
			System.out.print(" ");
		}
		for(int j=1; j<=i; j++){
			System.out.print("*");
		}
		System.out.println();
	}
	

		/*

		*			5-1-5
	   ***			4-3-4
	  *****			3-5-3
	 *******		2-7-2
	*********		1-9-1
   ***********		0-11-0

	*/
	
	// 내가 쓴 답

	for(int i=1; i<=6; i++){
		for(int s1=1; s1<=6-i; s1++){
			System.out.print(" ");
		}
		for(int j=1; j<=i*2-1; j++){
			System.out.print("*");
		}
		/* for(int s2=1; s2<=6-i; s2++){
			System.out.print(" ");
		} */
		System.out.println();
	}

	// 선생님 답

	for(int i=1; i<=11; i+=2){ // 1,3,5,7,9,11
		//공백
		for(int s=1; s<=(11-i)/2; s++){
			System.out.print(" ");
		}
		//문자 출력
		for(int j=1; j<=i; j++){
			System.out.print("*");
		}
		//줄바꿈
		System.out.println();
	}

	/*

   ***********	0-11
    *********	1-9
	 *******	2-7
	  *****		3-5
	   ***		4-3
	    *		5-1
	*/

	for(int i=6; i>=1; i--){
		for(int s=1; s<=6-i; s++){
			System.out.print(" ");
		}
		for(int j=1; j<=i*2-1; j++){
			System.out.print("*");
		}
		System.out.println();
	}




	}
	
}
