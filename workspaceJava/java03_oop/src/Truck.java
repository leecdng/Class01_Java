// extends Ű���带 �̿��Ͽ� Ŭ������ ��� �޴´�.
//		   Ŭ������ 1���� ��� ���� �� �ִ�.
public class Truck extends Car {
	int speed = 100;
	public Truck() {
		System.out.println("Truck()�� �����ڸ޼��� ����");
		
		System.out.println("Truck.speed->"+speed);
		super.speedUp();
	}
	
	public Truck(String carName) {
		// ����Ŭ������ ������ �޼��� ȣ��
		super(carName); // thisó�� ���๮ ù ��° �ٿ� ��� ��
		System.out.println("Truck(String)������ ����");
	}
	
	// �������̵�(overriding) : ����Ŭ������ �޼��带 ����Ŭ�������� ������
	//						 ��ȯ��, �޼����, �Ű������� ���� �޼��带 �������ϴ� ��
	public void speedUp() {
		speed += 10;
		if(speed>=SPEED_MAX) {
			speed = SPEED_MAX;
		}
		System.out.println("truck.speed="+speed);
	}
	
	
	
	
	public static void main(String a[]) {
		// ��Ӱ��迡�� ��ü���� �� ����Ŭ������ �����ڰ� ���� ����ǰ�
		// �� ������ ����Ŭ������ �����ڰ� ����ȴ�.
		Truck t = new Truck();
		
		System.out.println("t.speed="+t.speed); // 0
		// ����Ŭ������ �޼��� ȣ��
		t.speedUp(); // 1 -> ����Ŭ�������� �������̵� �Ŀ� ����Ŭ������ ����ż� 110 ���
		t.speedUp(); // 2 // 120
		t.speedDown(); // 1
		// ����Ŭ������ ����Ŭ������ ������ ������ �� �� ���� ������ �� �޼��� ����� 1, 2, 1 �̷��� ���� ��
		
		// ����Ŭ������ �����ڸ� ���������� ȣ���ϱ�
		Truck tt = new Truck("�ҳ�Ÿ");
		System.out.println("tt.carName = "+ tt.carName);
	}

}
