import java.util.Scanner;
class ForDiamond2
{
	public static void main(String[] args) 
	{

		// ȥ�� Ǯ��� ���Ф�
		// ���ĺ� ���
		/*
		for(int n=1; n<=13; n++){
			for(int s=1; s<=13-n; s++){
				System.out.print(" ");
			}
			for(int j=1; j<=(2*n)-1; j++){;
				char c=(char)(65+(j-1));
				char c2 = (char)(c+(n-1)*(n-1));
				if(c2==90){

				}
				System.out.print(c2);
			}
			System.out.println();
		}
		*/

		
		Scanner scan = new Scanner(System.in);

		System.out.print("Ȧ��(1~49)�Է�=");
		int max = scan.nextInt();

		// ¦���� ��� Ȧ���� ���� // 1���� ��Ű��
		if(max%2==0){	
			max++;
		}

		// ����� ���� �ʱⰪ
		char txt = 'A';
		int step = 2; // ���� ����
		for(int row=1; row>0; row+=step){	// �� 1,3,5,7,9...max
			// ����ó��
			for(int s=1; s<=(max-row)/2; s++){
				System.out.print(" ");
			}
			//1�� ���� ���
			for(int cnt=1; cnt<=row; cnt++){ 
				System.out.print(txt++);
				if(txt > 'Z'){
					txt = 'A';
				}
			}
			System.out.println();
			if(row >= max){
				step= -2;
			}
		}



	}
}
