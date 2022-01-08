import java.util.Scanner;

class StandardWeight

{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int age = 0;
		int gender = 0;
		int height = 0;
		int w_now = 0;

		// ������ �Է�
		System.out.print("���� = ");
		age = scan.nextInt();
		System.out.print("���� ����(1:����, 2:����) = ");
		gender = scan.nextInt();
		System.out.print("Ű = ");
		height = scan.nextInt();
		System.out.print("���� ü�� = ");
		w_now = scan.nextInt();

		// ǥ��ü�� ���ϱ�
		int w_stan = 0;
		if( age <= 35 ){
			if ( gender == 1 ){
				w_stan = (int)((height - 100) * 0.90);
			} else if( gender == 2 ){
				w_stan = (int)((height - 100) * 0.85);
			}
		} else if( age >= 36){
			if ( gender == 1 ){
				w_stan = (int)((height - 100) * 0.95);
			} else if( gender == 2 ){
				w_stan = (int)((height - 100) * 0.90);
			}
		}

		// ǥ��ü������
		double w_per = ((double)w_now / w_stan) * 100;
		String w_str = "";
		// ǥ��ü������ �򰡱���
		if( w_per <= 85 ){
			w_str = "������";
		} else if( w_per >= 86 && w_per <= 95){
			w_str = "���� ������";
		} else if( w_per >=96 && w_per <= 115){
			w_str = "ǥ����";
		} else if( w_per >= 116 && w_per <= 125){
			w_str = "���� ����";
		} else {
			w_str = "����";
		}

		System.out.printf("\n���\nǥ��ü�� = %d\n����� ǥ��ü�������� %.14f���� %s�Դϴ�.\n\n", w_stan, w_per, w_str);
		

	}
}
