class PrintfTest 
{
	public static void main(String[] args) 
	{
		// format : ���� ����
		// ���� : %d , �Ǽ� : %f , ���ڿ� : %s, %o(Octal:8����), %x(Hex:16����), %c(char:�� ����)
		// ex : %10d , %10.3f, %8s ...��

		// �����: \n, \t, \\, \", \'

		int num = 1234;
		System.out.printf("num ������ \n���� %d \n", num);
		System.out.printf("num ������ \n���� %10d�Դϴ�. \n", num);
		System.out.printf("������ ����\t��� ��...\n����\\3,000 \n");
		System.out.printf("\"ū����ǥ\" �׸��� \'��������ǥ\' \n");

		double num2 = 210987654321.23515;
		System.out.printf("num2=%10.3f�̴�. \n", num2); // 10.3 �߿� �Ҽ��� �ڸ� 3�ڸ�????

		String nameKor ="ȫ�浿";
		String nameEng ="hong";
		System.out.printf("���� �̸��� %-10s�̴�. \n", nameKor);	// -���� ����
		System.out.printf("���� �̸��� %10s�̴�. \n", nameEng);	// ������ ����

		int num3 = 12;
		System.out.printf("%d,	%o,	%x\n", num3, num3, num3);	// 12, 14, c

	}
}
