
public class WrapperTest {

	public WrapperTest() {
		// WrapperŬ������ �⺻���������� ������ ��ü�� �����Ű�� Ŭ�����̴�.
		// Byte, Short, Integer, Long
		// Float, Double
		// Boolean
		// Character
		
		int a = 1234;
		Integer i = Integer.valueOf(a); // new Integer(a);
		
		System.out.println(a);
		System.out.println(i);
		
		Object obj = a;	// ����ڽ�
		Object obj2 = i;
		System.out.println(obj);
		System.out.println(obj2);
		
		
		int x = i; // �����ڽ�
		System.out.println(x);
	}

	public static void main(String[] args) {
		new WrapperTest();

	}

}
