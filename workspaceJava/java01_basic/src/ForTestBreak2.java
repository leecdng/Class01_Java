class ForTestBreak2
{
	public static void main(String[] args) 
	{
		abc: // ��, �󺧸��� ����
		for(int i=1; i<=10; i++){
			
			for(int j=1; ; j++){	// ���ѷ���
				System.out.println("i="+i+" , j="+j);
				if(j>5){	// j�� 5���� ũ��(6�� �Ǹ�) ����� -> �����ϰ� ����
					break abc;
				}
			}
			// break �ɸ� �� ���⼭ for�� ����

			/*if(i>3){	// i�� 3���� Ŀ����(4�� �Ǹ�) �����
				break;
			}*/
		}
		// for�� ����
		System.out.println("========");
	}
}
