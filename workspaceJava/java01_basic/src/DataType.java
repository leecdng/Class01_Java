class DataType{
	public static void main(String[] args) 
	{
		System.out.println(6);	// Number
		System.out.println("six"); //String ���ڿ�
		
		System.out.println("6"); // String 6

		System.out.println(6+6); // 12
		System.out.println("6"); // 66

		System.out.println(6*6); // 36
		// System.out.println("6"*"6"); // ������ ����. ���ڿ��� ���ϱ� �� ��.

		System.out.println("1234".length()); // 4
		//System.out.println(1111.length()); // ������ ���� - String ���� ����..


		System.out.println("___________");
		int n = 0;
		String a = (n>0)? "���":"����";
		String b = (n == 0)? "0":a;
		System.out.println(b);


	}
}
