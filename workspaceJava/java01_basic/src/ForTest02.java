class ForTest02 
{
	public static void main(String[] args) 
	{
		int sum = 0; // ���๮�� ���� ������ �̸� ����
		for(int i=1; i<=100; i++){
			sum = sum + i;	// Sum+=i; �� ���� �� ��ȣ
			System.out.println("1~"+ i+"������ ���� "+sum);
		}
		// System.out.println("1~100������ ���� "+ sum);
		

		// 1~10������ ��, 1~20������ ��, 30������ ��,.. 100������ �ո� ����ϱ�
		int sum2 = 0; // ���๮�� ���� ������ �̸� ����
		for(int j=1; j<=100; j++){
			sum2 +=j;	// Sum+=i; �� ���� �� ��ȣ
			if(j%10 ==0){
				System.out.println("1~"+ j+"������ ���� "+sum);
			}
		}
		// System.out.println("1~100������ ���� "+ sum);




	}
}
