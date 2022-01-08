
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}
	public void start() {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(100);
		
		// append() : ���ڿ� �߰�
		sb1.append("Buffer append Test.."); // Buffer append Test..
		sb1.append(123456); // Buffer append Test..123456
		
		// insert() : index��ġ ���� ����
		sb1.insert(5, "(��Ʈ������)"); // Buffe(��Ʈ������)r append Test..123456
		sb1.insert(15, 23235.21544554); // Buffe(��Ʈ������)r a23235.21544554ppend Test..123456
		
		sb1.deleteCharAt(6); // Buffe(Ʈ������)r a23235.21544554ppend Test..123456
		// 6��° ���� ����
		
		sb1.delete(1,4); // Be(Ʈ������)r a23235.21544554ppend Test..123456
		// 1~3��°���� ���� (4�ձ���)
		
		sb1.replace(1, 3, "(�ڹ�)");	// B(�ڹ�)Ʈ������)r a23235.21544554ppend Test..123456
		// 1~2��°����(3�ձ���) ���ڸ� (�ڹ�)�� ��ü�ض�
		
		sb1.reverse(); // 654321..tseT dnepp45544512.53232a r)�۹���Ʈ)����(B
		// ���ڿ��� �Ųٷ� ��ȯ
		
		
		// Ȯ���� ���� Ȯ���ϱ�
		System.out.println("sb1.capacity="+sb1.capacity()); //16byte // ���ڿ��� �߰�(����)�Ǹ� �� �� �辿 ���� Ȯ���� ��
		System.out.println("sb2.capacity="+sb2.capacity()); // 100byte
		System.out.println(sb1);
	}

	public static void main(String[] args) {
		new StringBufferTest();
		

	}

}
