class ForTestContinue
{
	public static void main(String[] args) 
	{
		for(int i=1; i<10; i++){
			if(i%2==0){
				continue;	// ������ ������ �ش� if���� ��� �ݺ� �����϶�� ��
			}
			System.out.println(i);	// Ȧ���� ��µ�
		}
	}
}
