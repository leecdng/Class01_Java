import java.util.Scanner;

class DoWhileEx1 // �ݾ� ������ ��
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		do{
			//�ݾ�
			System.out.print("�ݾ��� �Է��ϼ���? ");
			int money = scan.nextInt();

			//ȭ��
			int cnt = money/50000; // 5����
			if(cnt>0){
				System.out.println("50000�� = "+ cnt +"��");
				money = money - cnt*50000; // = money%50000;
			}

			cnt = money/10000; // 1����
			if(cnt>0){
				System.out.println("10000�� = "+ cnt +"��");
				money = money - cnt*10000; // = money%10000;
			}

			cnt = money/5000;
			if(cnt>0){
				System.out.println("5000�� = "+ cnt +"��");
				money = money - cnt*5000; // = money%10000;
			}
			
			cnt = money/1000;
			if(cnt>0){
				System.out.println("1000�� = "+ cnt +"��");
				money = money - cnt*1000; // = money%10000;
			}

			cnt = money/500;
			if(cnt>0){
				System.out.println("500�� = "+ cnt +"��");
				money = money - cnt*500; // = money%10000;
			}

			cnt = money/100;
			if(cnt>0){
				System.out.println("100�� = "+ cnt +"��");
				money = money - cnt*100; // = money%10000;
			}
			
			//����
			System.out.print("����Ͻðڽ��ϱ�(1.��, 2.�ƴϿ�)? ");
			int status = scan.nextInt();

			if(status==2)
				break;
		}while(true);
	}
}
