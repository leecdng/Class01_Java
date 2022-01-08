import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	String list[] = {"JAVA", "Spring", "스프링프레임", "JAVA", "자바", "ORACLE", "스프링", "ORACLE"};
	
	public TreeSetTest() {
		start();
	}
	public void start() {
		// TreeSet : 입력 순서를 유지하지 않는다. 중복데이터 허용하지 않음. 자동으로 정렬한다.
		TreeSet<String> ts= new TreeSet<String>();
		// TreeSet에 객체 추가
		for( String data : list) {
			ts.add(data);
		}
		
		// 오름차순으로 정렬되어 있다. 중복데이터 X
		System.out.println(ts.size()); // 6
		
		Iterator<String> ii = ts.iterator();
		
		while(ii.hasNext()) {
			String d = ii.next();	// ABCD 오름차순으로 출력됨
			System.out.println(d);
		}
		
		// 내림차순으로 정렬하여 객체 가져오기
		Iterator<String>iii = ts.descendingIterator();
		while(iii.hasNext()) {
			String d = iii.next();
			System.out.println(d);
		}
		
	}

	public static void main(String[] args) {
		new TreeSetTest();
	}

}
