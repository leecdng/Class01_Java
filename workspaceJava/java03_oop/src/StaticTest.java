
public class StaticTest {
	int num = 1234;
	String name = "ȫ�浿";
	// static : ���� Ŭ������ ��� ��ü���� 1���� �����Ѵ�. (���뺯���� ���)
	static String addr = "������";
	
	public StaticTest() {
		// 
	}
	// �ּҸ� �����ϴ� �޼���
	 void setAddr(String addr) {
		 this.addr = addr;
	 }
	 String getAddr() {
		 return addr;
	 }

}
