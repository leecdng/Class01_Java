import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		// Set 인터페이스 상속 받은 클래스
		// 1. 입력 순서를 유지하지 않는다.
		// 2. 중복데이터를 허용하지 않는다.
		
		double[] data = {12.3, 3.4, 5.6, 12.3, 5.2, 9.1, 9.1, 6.7};
		// 				{12.3, 3.4, 5.6, 5.2, 9.1, 6.7};
		
		HashSet<Double> hs = new HashSet<Double>();
		
		for(double d : data) {
			hs.add(d);
		}
		
		System.out.println("size= "+ hs.size());
		
		Iterator<Double> ii = hs.iterator();
		
		while(ii.hasNext()) { // 객체가 있으면 true, 없으면 false
			Double iiData = ii.next();
			System.out.println(iiData); // 데이터는 다 있지만 순서 없이 출력됨. set의 특징.
		}
		
		
	}

	public static void main(String[] args) {
		new HashSetTest();

	}

}
