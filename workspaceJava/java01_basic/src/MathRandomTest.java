
public class MathRandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ���� : ��ǻ�Ͱ� ����Ǵ� ������ 0.0�� 1.0 ���� ������ ���� �����ȴ�.
		// ���� ���� ����� -> *10�� �ϸ� 0~9 / 100�� ���ϸ� 0~999 / 50�̸� 0~49����
		// 50~100 ������� (����ȭ)(����*(������ ����)+������--> (int)(����*51)+50--> ���� ����--> ū��-������+1
		
		for(int i=1; i<=1000; i++) {
			double ran = Math.random();
			//int ranInt = (int)(ran*50);
			//�ֻ��� ���� ����
			int ranInt = (int)(ran*6)+1;
			System.out.print(ranInt+" ");
			if(i%10==0) System.out.println();
		}
	}
}
