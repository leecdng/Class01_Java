class MultiplicationTable
{
	public static void main(String[] args) 
	{

		// 1번째 방법
		System.out.println("\t구구단");
		
		for(int n=1; n<=3; n++){
			for(int i=1; i<=9; i++){

				for(int mul=1; mul<=3; mul++){
					int n_mul = mul+3*(n-1);
					if(i==1){
						System.out.print("="+n_mul+"단=\t");
					} else{
						System.out.print(n_mul+"*"+i+"="+(n_mul*i)+"\t");
					}
					if(mul%3==0){
						System.out.println();
					}
				}
			}
		}



		System.out.println();




		// 2번째 방법 // 도움 받아서 해본 것
		System.out.println("\t구구단");
		for(int i=1; i<=9; i+=3){
			System.out.printf("=%d단=\t=%d단=\t=%d단=\n", i, i+1, i+2);
			for(int j=2; j<=9; j++){
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
				System.out.print((i+1)+"*"+j+"="+(i+1)*j+"\t");
				System.out.print((i+2)+"*"+j+"="+(i+2)*j+"\n");
			}
		}



		// 선생님 답
		System.out.println("\t구구단");
		for(int dan=1; dan<=9; dan+=3){	// dan=1,4,7
			// 단 타이틀\
			for(int i=dan; i<dan+3; i++){	// i<=dan+2 //dan=1 -> 1,2,3 // dan=4 -> 4,5,6 // dan=7 -> 7,8,9
				System.out.print("=="+i+"단==\t");
			}
			System.out.println();

			// 3단 구구단 출력
			for(int k=2; k<=9; k++){	//2,3,4,5,6,7,8,9
				for(int z=dan; z<dan+3; z++){	// dan=1 -> z=1,2.3 // dan=4 -> 4,5,6 // dan=7 -> 7,8,9
					int result = z*k;
					System.out.print(z+"*"+k+"="+result+"\t");
				}
				System.out.println();
			}
		}




	/* 3단씩 똑같이 3번 출력 방법
		for(int i=1; i<=9; i++){
			for(int mul=1; mul<=3; mul++){
				if(i==1){
					System.out.print("="+mul+"단=\t");
				} else{
					System.out.print(mul+"*"+i+"="+(mul*i)+"\t");
				}
				if(mul%3==0){
					System.out.println();
				}
			}
		}
		for(int i=1; i<=9; i++){
			for(int mul=4; mul<=6; mul++){
				if(i==1){
					System.out.print("="+mul+"단=\t");
				} else{
					System.out.print(mul+"*"+i+"="+(mul*i)+"\t");
				}
				if(mul%3==0){
					System.out.println();
				}
			}
		}
		for(int i=1; i<=9; i++){
			for(int mul=7; mul<=9; mul++){
				if(i==1){
					System.out.print("="+mul+"단=\t");
				} else{
					System.out.print(mul+"*"+i+"="+(mul*i)+"\t");
				}
				if(mul%3==0){
					System.out.println();
				}
			}
		}
	*/



	/* 기본 구구단
		for(int mul=1; mul<=9; mul++){
			for(int i=2; i<=9; i++){
				System.out.println(mul+" * "+i+"= "+ (mul*i));
			}
		}
	*/
	}
}
