
// E : element - E ���� �ٸ� �� �ᵵ�� �빮�ڷ� 1����
// K : key
// V : value
public class GenericTest<E> {
	
	private E username;	// private �������� setter getter �޼��� ����???
	
	public GenericTest() {
		
	}
	public GenericTest(E username) {
		this.username=username;
	}
	
	
	public E getUsername() {
		return username;
	}
	
	public void setUsername(E username) {
		this.username = username;
	}
	
	
}
