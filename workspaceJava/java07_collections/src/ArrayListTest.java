import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		CollectionData data = new CollectionData();
		List<MemberVO> lst = data.getMember();
		MemberVO vo2 = new MemberVO("ZZZ","��ȹ�Ѱ���","2020-01-02",5000);
		
		lst.add(2, vo2);
		lst.remove(1); // BBBB�� ���� ����� // index�� ����
		// lst.remove(vo2); // ��ü������ ����
		
		// MemberVO vo = lst.get(0); // �ڵ�����ȯ..����. ��� ��ȯ�� �����͸� �� ���� ���� �� ����??? �ϳ��� ����� ��???
		
		for(int i=0; i<lst.size(); i++) {
			MemberVO vo = lst.get(i);
			vo.memberPrint();
		}
		
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
