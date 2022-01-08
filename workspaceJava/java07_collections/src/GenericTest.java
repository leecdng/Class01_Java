
// E : element - E 말고 다른 거 써도됨 대문자로 1글자
// K : key
// V : value
public class GenericTest<E> {
	
	private E username;	// private 변수에는 setter getter 메서드 있음???
	
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
