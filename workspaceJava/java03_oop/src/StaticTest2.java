
public class StaticTest2 {
	// static 
	// ��������� �������� ���� public static int a =100;
	//					  static int b =200;
	// �޼��� ��ȯ�� ���ʿ� ǥ���Ѵ�.
	//		public static void method(){}
	//		static void method(){}
	
	// ��� ������ ���๮ ǥ�� �� �� ����
	// �ٵ� static{}���� ���๮ ǥ�� �� �� ����!
	// static{}�� �����ڸ޼��� �� static�� ���� �����
	static {
		for(int i=1; i<=10; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	public StaticTest2() {
		System.out.println("StaticTest2() �޼��� �����");
	}
	
	public static void main(String[] args) {
		new StaticTest2();
	}

}
