class ForTestBreak
{
	public static void main(String[] args) 
	{
		// �ݺ��� ����
		// break : �ݺ����� ����
		// continue : �ݺ����� �� �� �ǳʶٱ�
		
		// 1+2+3+4+5....
		// ���� 2021�� ���ʷ� �ʰ��ϴ� ��� ������ ���ؾ� �ϴ��� ���϶�.
		int sum = 0;
		for(int i=1; ; i++){	// ���� ����
			// ���� ����ϱ�
			sum += i;
			if(sum>=2021){
				System.out.println("1~"+i+"������ ���� "+sum);
				break;
			}
		} //for
		System.out.println("The End.");
	}
}
