class Variable	// Ŭ������ �빮�ڷ� �����ϰ� �ռ����� ���� �� �ܾ��� ù ��° ���ڸ� �빮�ڷ� �Ѵ�. 256��¥���� ����
{
	public static void main(String[] args) 
	{
		// ������: �� �Ǵ� �����͸� �����ϴ� ����� ������.
		/* �⺻�������� :	������ -> byte(1byte), short(2byte), int(4byte), long(8byte)
						�Ǽ��� -> float(4byte), double(8byte)
						�� -> boolean (true / false -> 1byte)
						���� -> char(2byte)

			���۷�����
		*/

		// ���� 50��, ���� 80��, ���� 70��

		//byte kor = 50;	// 1byte
		int kor2 = 50;	// 4byte	������ ����� int���̴�.
		int eng = 80;
		int math = 70;

		//���� ���� ��Ģ
		// ù ���ڴ� �ҹ��ڷ� �����ϰų�, _ �Ǵ� $�� ������ �� �ִ�.
		// �ռ����� ���� �� ��° ���� �ܾ�� �빮�ڷ� �����Ѵ�.
		// ��ɾ�(�����)�� ������ ����� �� ����.
		// ����: name, _name, $name
		// �Ұ���: 9name, *name, if(�����)...

		// ���
		// ������ : +, -, *, / , %(������)


		int sum = kor2 + eng + math;

		// ����, ������ ����ϸ� = ����
		// ����, �Ǽ� ����ϸ� = �Ǽ�
		// �Ǽ�, ���� = �Ǽ�
		// �Ǽ�, �Ǽ� = �Ǽ�

		double ave = sum / 3.0;	// �Ǽ��� �⺻ ������ Ÿ���� double, 3�� �Ǽ��� �ٲ��ַ��� 3.0���� ��.
								// double�� �ַ� ����, float = 31.4f (�ڿ� f�� �ٿ���)
		System.out.println("���� = " + sum);
		System.out.println("��� = " + ave);


		boolean state = true;	// true, false
		char lastName = 'ȫ';	// �������� ''�� ""�ϸ� ������ ������
		String firstName = "�浿";
		
		// ����ȯ (���� ��)
		float data = (float) 3562.3265;
		int data2 = (int) 12.1;

		System.out.println(data);
		System.out.println(data2);

		// ū ���������� �����͸� ���� ���������� ������ ������ ���� ����ȯ�� �ϸ� �ȴ�.
		// ���� ���������� �����͸� ū ���������� ������ ������ ���� ����ȯ�� ���� �ʾƵ� �ȴ�.
		double data3 = 1234567;

		
	}
}
