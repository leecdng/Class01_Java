class Operator2 
{
	public static void main(String[] args) 
	{
		// ��Ʈ ������ : &, |, ^(XOR), ~(����)  -> 2���� �����͸� �̿��� ������
		int a = 12;
		int b = 4;

		// & (and)
		// ex) 0011 & 0101 = 0001
		int result = a & b; // 1: true, 0: false
		System.out.println("result =" + result);	// result = 4
	
		// | (or)
		// ex) 0011 | 0101 = 0111;
		int result2 = a | b;
		System.out.println("result2 =" + result2);	// result2 = 12
		
		// ^ (XOR)
		// ex) 1101 ^ 0101 = 1000
		int result3 = a ^ b;	// �� ���� �ٸ� �� �� (�ͽ�ũ��ú����)
		System.out.println("result3 =" + result3);	// result3 = 8

		// ~ (����) : ~n = -(n+1);
		// ������ �����͸� ȯ���ϴ� ��� : 2���� -> 1�� ���� + 1
		// 1�� ������ 0�� 1�� 1�� 0���� �ٲٴ� ���̴�. (�ݴ�� �ٲٶ�� ��)
		// ex) ~ 0101 = 1010
		int result4 = ~a; // ~12
		System.out.print(result4);	// result4 = -13;


		



		// ����Ʈ ������ : ��Ʈ�� �̵���Ų��.
		// << : ��Ʈ�� �������� �̵�. ���ϱ�(*)��� ---> a << n : a�� n bit��ŭ �������� �̵��ϰ� �������� 0���� ä���� : ���ϱ� 2�� n�� �ض�.
		// >>(��ȣ�� ä����), >>>(0���� ä����) : ��Ʈ�� ���������� �̵�. ������(/) ���	---> a >> 2 : a�� n bit��ŭ ���������� �̵��ϰ� ������ ��ȣ�� ä����. // a >>> n : a�� n��Ʈ��ŭ ���������� �̵��ϰ� �������� 0���� ä����..
		// a = 12


		// << (left shift)
		int result5 = 12 << 2;	// �������� 2bit �̵��ϰ� �������� 0���� ä����
		System.out.println("result5 =" + result5);

		// >> (arithmeotic right shift)
		int result6 = 12 >> 2;	// ���������� 2bit �̵��ϰ� ������ ��ȣ�� ä����
		System.out.println("result6 =" + result6);	// 3
		int result7 = -13 >> 2;	// ���������� 2bit �̵��ϰ� ������ ��ȣ�� ä����
		System.out.println("result7 =" + result7);	// -4

		// >>> (logical right shift)
		int result8 = -13 >>> 2; // ���������� 2bit �̵��ϰ� ������ 0���� ä����
		System.out.println("result8 =" + result8);	

	}
}
