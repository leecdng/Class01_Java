class StringApp 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World");	// String ���ڿ� : ���� ���ڵ� ����
		System.out.println('H');	// '' -> Character ���� : 1���ڸ� ǥ���ϴ� ������ Ÿ��
		System.out.println("H");	// String ���ڿ�

		System.out.println("Hello "
				+ "World");			// �̷��� �ص� ���� �� �ٲ�
		// new line -> \n	: �ٹٲ�
		System.out.println("Hello \nWorld");
		
		// System.out.println("Hello "World"");	// Hello "World" -> ������ ����

		// escape
		System.out.println("Hello \"World\"");	// ��� �ع��Ŵ(?)
	}
}
