class ForTest05
{
	public static void main(String[] args) 
	{
		/*
			1~100������ �� �� ���� �����͸� ����϶�.
			1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22....98??? ��Ģ ã��
			-> 3�� ���, 5�� ����� �ƴ� ���ڸ� ���...
		*/
		
		for(int i=1; i<=100; i++){
			if(i%3 != 0 && i%5 != 0){
				System.out.println(i);
			}
		}
	}
}
