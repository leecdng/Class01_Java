
public class ArrayCopy {

	public static void main(String[] args) {
		// �迭�� ����
		int num[] = {20, 67, 15, 95, 36, 48, 23, 14};
		//			�����迭��, ������ ����index, ������ ���� �迭��,	index	,	������ �������� ����
		//arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//				num,	2			, target		,	5	,	3
		
		// num�迭���� index 2�������� 3���� ���縦 �Ͽ� ���ο� �迭�� ����
		int target[] = new int[10];
						
		System.arraycopy(num, 2, target, 5, 3);
		
		for(int i=0; i<target.length; i++) {
			System.out.println("target["+i+"]="+target[i]);
		}
		

	}

}
