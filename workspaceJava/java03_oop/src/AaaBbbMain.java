
public class AaaBbbMain {

	public AaaBbbMain() {}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		
		
		
		// ����Ŭ������ ��ü�� �����ϸ� ����Ŭ������ ���Եȴ�.
		AAA a = new BBB();
		a.output(); //��ȣ= 200, ����ó= 010-1234-1234, �̸�hong
		// �޼��� ���ؼ� �����ϸ� ����Ŭ������ ������ �������� �������
		
		System.out.println("b.tel="+b.tel);
		// System.out.println("a.tel="+a.tel); // ���� // B���� �ִ� ����
		// ����Ŭ������ �޼ҵ�� ���� ���������� �޼ҵ带 ��ġ�� ���� ������ ���� �Ұ���
		System.out.println("a.name="+a.name); // hong //A ����Ŭ�������� �ִ� ����
		System.out.println("a.num="+a.num); // 100 // A B �� �� �ִ� ���� ->A�� ������

		
		
		// AAA a = new BBB();
		BBB c = (BBB)a;
		c.output();
		
		Object obj = new BBB();
		BBB d = (BBB)obj;
		d.output();
	}

}
