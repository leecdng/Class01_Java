import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	String list[] = {"JAVA", "Spring", "������������", "JAVA", "�ڹ�", "ORACLE", "������", "ORACLE"};
	
	public TreeSetTest() {
		start();
	}
	public void start() {
		// TreeSet : �Է� ������ �������� �ʴ´�. �ߺ������� ������� ����. �ڵ����� �����Ѵ�.
		TreeSet<String> ts= new TreeSet<String>();
		// TreeSet�� ��ü �߰�
		for( String data : list) {
			ts.add(data);
		}
		
		// ������������ ���ĵǾ� �ִ�. �ߺ������� X
		System.out.println(ts.size()); // 6
		
		Iterator<String> ii = ts.iterator();
		
		while(ii.hasNext()) {
			String d = ii.next();	// ABCD ������������ ��µ�
			System.out.println(d);
		}
		
		// ������������ �����Ͽ� ��ü ��������
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
