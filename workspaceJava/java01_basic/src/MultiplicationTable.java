class MultiplicationTable
{
	public static void main(String[] args) 
	{

		// 1��° ���
		System.out.println("\t������");
		
		for(int n=1; n<=3; n++){
			for(int i=1; i<=9; i++){

				for(int mul=1; mul<=3; mul++){
					int n_mul = mul+3*(n-1);
					if(i==1){
						System.out.print("="+n_mul+"��=\t");
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




		// 2��° ��� // ���� �޾Ƽ� �غ� ��
		System.out.println("\t������");
		for(int i=1; i<=9; i+=3){
			System.out.printf("=%d��=\t=%d��=\t=%d��=\n", i, i+1, i+2);
			for(int j=2; j<=9; j++){
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
				System.out.print((i+1)+"*"+j+"="+(i+1)*j+"\t");
				System.out.print((i+2)+"*"+j+"="+(i+2)*j+"\n");
			}
		}



		// ������ ��
		System.out.println("\t������");
		for(int dan=1; dan<=9; dan+=3){	// dan=1,4,7
			// �� Ÿ��Ʋ\
			for(int i=dan; i<dan+3; i++){	// i<=dan+2 //dan=1 -> 1,2,3 // dan=4 -> 4,5,6 // dan=7 -> 7,8,9
				System.out.print("=="+i+"��==\t");
			}
			System.out.println();

			// 3�� ������ ���
			for(int k=2; k<=9; k++){	//2,3,4,5,6,7,8,9
				for(int z=dan; z<dan+3; z++){	// dan=1 -> z=1,2.3 // dan=4 -> 4,5,6 // dan=7 -> 7,8,9
					int result = z*k;
					System.out.print(z+"*"+k+"="+result+"\t");
				}
				System.out.println();
			}
		}




	/* 3�ܾ� �Ȱ��� 3�� ��� ���
		for(int i=1; i<=9; i++){
			for(int mul=1; mul<=3; mul++){
				if(i==1){
					System.out.print("="+mul+"��=\t");
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
					System.out.print("="+mul+"��=\t");
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
					System.out.print("="+mul+"��=\t");
				} else{
					System.out.print(mul+"*"+i+"="+(mul*i)+"\t");
				}
				if(mul%3==0){
					System.out.println();
				}
			}
		}
	*/



	/* �⺻ ������
		for(int mul=1; mul<=9; mul++){
			for(int i=2; i<=9; i++){
				System.out.println(mul+" * "+i+"= "+ (mul*i));
			}
		}
	*/
	}
}
